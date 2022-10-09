runAlgorithmEngineerTests: AlgorithmEngineerTest.java ISBNValidator.java IterableMap.java
	javac AlgorithmEngineerTest.java ISBNValidator.java IterableMap.java
	java AlgorithmEngineerTest.java

runFrontendDeveloperTests: BookMapperFrontend.java FrontendDeveloperTest.java
	javac BookMapperFrontend.java FrontendDeveloperTest.java
	java FrontendDeveloperTest

clean:
	rm *.class
