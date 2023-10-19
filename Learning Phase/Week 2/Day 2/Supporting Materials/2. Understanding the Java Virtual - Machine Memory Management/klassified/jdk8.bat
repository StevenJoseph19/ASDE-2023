@echo off
set path=C:\Program Files\Java\jdk1.8.0_202\bin;%path%
java -version
java -Xmx512M -jar target/klassified-1.0-SNAPSHOT.jar server src/main/resources/klassified.yml
pause
exit