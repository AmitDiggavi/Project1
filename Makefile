

runDataWranglertest: runProgram

runProgram: Book.class BookLoader.class DataWranglerTest.class
	java DataWranglerTest

Book.class: Book.java
	javac Book.java

BookLoader.class: BookLoader.java
	javac BookLoader.java

DataWranglerTest.class: DataWranglerTest.java
	javac DataWranglerTest.java


BackendDeveloperTests: BackendDeveloperTest.class
	java BackendDeveloperTest
BackendDeveloperTest.class:	BackendDeveloperTest.java BookMapperBackend.class
	javac BackendDeveloperTest.java
BookMapperBackend.class: BookMapperBackend.java
	javac BookMapperBackend.java
clean:
	rm *.class

runAlgorithmEngineerTests: AlgorithmEngineerTest.java ISBNValidator.java IterableMap.java
	javac AlgorithmEngineerTest.java ISBNValidator.java IterableMap.java
	java AlgorithmEngineerTest.java
