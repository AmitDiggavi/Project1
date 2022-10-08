
runDataWranglertest: runProgram

runProgram: Book.class BookLoader.class DataWranglerTest.class
	java DataWranglerTest

Book.class: Book.java
	javac Book.java

BookLoader.class: BookLoader.java
	javac BookLoader.java

DataWranglerTest.class: DataWranglerTest.java
	javac DataWranglerTest.java

clean: 
	rm *.class
