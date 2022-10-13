run: BookMapper.class Book.class BookLoader.class BookMapperBackend.class BookMapperFrontend.java ISBNValidator.java IterableMap.java
	@java BookMapper

runTests: runDataWranglerTests runAlgorithmEngineerTests runFrontendDeveloperTests runBackendDeveloperTests
	@$(MAKE) clean

runDataWranglerTests: Book.class BookLoader.class DataWranglerTest.class
	@java DataWranglerTest

BookMapper.class: BookMapper.java
	@javac BookMapper.java


Book.class: Book.java
	@javac Book.java

BookLoader.class: BookLoader.java
	@javac BookLoader.java

DataWranglerTest.class: DataWranglerTest.java
	@javac DataWranglerTest.java


runBackendDeveloperTests: BackendDeveloperTest.class
	@java BackendDeveloperTest
BackendDeveloperTest.class:	BackendDeveloperTest.java BookMapperBackend.class
	@javac BackendDeveloperTest.java
BookMapperBackend.class: BookMapperBackend.java
	@javac BookMapperBackend.java

runAlgorithmEngineerTests: AlgorithmEngineerTest.java ISBNValidator.java IterableMap.java
	@javac AlgorithmEngineerTest.java ISBNValidator.java IterableMap.java
	@java AlgorithmEngineerTest.java

runFrontendDeveloperTests: BookMapperFrontend.java FrontendDeveloperTest.java
	@javac BookMapperFrontend.java FrontendDeveloperTest.java
	@java FrontendDeveloperTest

clean:
	rm *.class
