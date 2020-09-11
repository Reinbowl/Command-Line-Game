@ECHO OFF

if not exist bin mkdir bin

javac -cp src -Xlint:none -d bin src\Main.java src\action\*.java src\attribute\*.java
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)

java -classpath bin Main

PAUSE