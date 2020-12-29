javac -d bin -sourcepath src -cp resources\libs\* src\mmtr\klyuev\dictionary\*
java -cp resources\libs\*;bin mmtr.klyuev.dictionary.Dictionary
pause