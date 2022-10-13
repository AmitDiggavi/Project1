run: compileAll
	@java BookMapper
	@$(MAKE) clean # silently clean up after run

runTests: runDataWranglerTests runAlgorithmEngineerTests runFrontendDeveloperTests runBackendDeveloperTests
	@$(MAKE) clean # silently clean up after tests

compileAll: BookMapper.java Book.java BookLoader.java BookMapperBackend.java BookMapperFrontend.java ISBNValidator.java IterableMap.java
	@javac BookMapper.java Book.java BookLoader.java BookMapperBackend.java BookMapperFrontend.java ISBNValidator.java IterableMap.java

runDataWranglerTests: Book.java BookLoader.java DataWranglerTest.java
	@javac BookLoader.java Book.java DataWranglerTest.java
	@java DataWranglerTest

runBackendDeveloperTests: BackendDeveloperTest.java BookMapperBackend.java
	@javac BackendDeveloperTest.java BookMapperBackend.java
	@java BackendDeveloperTest

runAlgorithmEngineerTests: AlgorithmEngineerTest.java ISBNValidator.java IterableMap.java
	@javac AlgorithmEngineerTest.java ISBNValidator.java IterableMap.java
	@java AlgorithmEngineerTest.java

runFrontendDeveloperTests: BookMapperFrontend.java FrontendDeveloperTest.java
	@javac BookMapperFrontend.java FrontendDeveloperTest.java
	@java FrontendDeveloperTest

clean:
	@rm *.class
