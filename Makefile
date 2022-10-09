runAlgorithmEngineerTests: AlgorithmEngineerTest.java ISBNValidator.java IterableMap.java
	javac AlgorithmEngineerTest.java ISBNValidator.java IterableMap.java
	java AlgorithmEngineerTest.java
	@$(call clean)

clean = rm *.class
