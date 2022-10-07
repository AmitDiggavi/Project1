runTests: BackendDeveloperTest.class
	java BackendDeveloperTest
BackendDeveloperTest.class:	BackendDeveloperTest.java BookMapperBackend.class
	javac BackendDeveloperTest.java
BookMapperBackend.class: BookMapperBackend.java
	javac BookMapperBackend.java
clean:
	rm *.class

