runFrontendDeveloperTests: BookMapperFrontend.java FrontendDeveloperTest.java
	javac BookMapperFrontend.java FrontendDeveloperTest.java
	java FrontendDeveloperTest

clean:
	rm *.class
