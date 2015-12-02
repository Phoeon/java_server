@echo off
set jarDir="lib"
IF NOT EXIST %jarDir% MD %jarDir%
jar cvfm %jarDir%/server.jar MANIFEST.MF -C bin/ .
echo server.jar file packed successfully at dirctory lib/