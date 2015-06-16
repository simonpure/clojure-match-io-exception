# match

This fails to compile when there are more than 13 matches.

```
match.core> (compile 'match.core)
CompilerException java.io.IOException: File name too long, compiling:(match/core.clj:10:3)
```

```
$ java -version
java version "1.7.0_79"
OpenJDK Runtime Environment (IcedTea 2.5.5) (7u79-2.5.5-0ubuntu0.14.04.2)
OpenJDK 64-Bit Server VM (build 24.79-b02, mixed mode)
```

```
$ lein version
Leiningen 2.5.1 on Java 1.7.0_79 OpenJDK 64-Bit Server VM
```

```
$ cat /etc/*-release
DISTRIB_ID=Ubuntu
DISTRIB_RELEASE=14.04
DISTRIB_CODENAME=trusty
DISTRIB_DESCRIPTION="Ubuntu 14.04.2 LTS"
NAME="Ubuntu"
VERSION="14.04.2 LTS, Trusty Tahr"
ID=ubuntu
ID_LIKE=debian
PRETTY_NAME="Ubuntu 14.04.2 LTS"
VERSION_ID="14.04"
HOME_URL="http://www.ubuntu.com/"
SUPPORT_URL="http://help.ubuntu.com/"
BUG_REPORT_URL="http://bugs.launchpad.net/ubuntu/"
```

```
$ uname -a
Linux 7siech 3.13.0-51-generic #84-Ubuntu SMP Wed Apr 15 12:08:34 UTC 2015 x86_64 x86_64 x86_64 GNU/Linux
```

# solution
It turns out this is due to a known limitation with ecryptfs and you most likely have an encrypted home directory. The only workaround really is to build in a directory that has no encryption.

Details about this feature/bug here: https://bugs.launchpad.net/ecryptfs/+bug/344878

# quick workaround
A quick way is to create a file system in a file, mount it and build from there.

```
# create 20MB
dd if=/dev/zero of=unecryptfs bs=1024 count=20480
mkfs -t ext4 unecryptfs
mkdir /media/unecrypt
mount -o loop unecryptfs /media/unecrypt
```


## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
