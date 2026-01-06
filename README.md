# 99 Bottles of OOP (Kotlin)

This repo contains a Kotlin-ized version of the [99 Bottles of OOP](https://sandimetz.com/99bottles) Initial Exercise (Appendix A).

To get started, clone this repo and install dependencies. If you're using IntelliJ, syncing the Gradle project should do it. The repo uses Java 21, so if you run into any SDK issues, using the Java 21 installation on your machine (temurin-21) is a safe bet. 

Create a new branch: `solutions/[your-name]`. Open [BottlesTest.kt](src/test/kotlin/BottlesTest.kt) and run the test suite. 

Work TDD-style to make each test pass in order:
- Run the tests and look at the failure
- Write just enough code to address the failure
- Repeat until the test passes (along with all prior tests)
- Un-skip the next test by removing the `@Disabled` annotation 

Repeat until all tests are passing.
