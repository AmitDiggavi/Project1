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

