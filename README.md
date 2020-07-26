## cucumber demo

### task list

- BDD (Behaviour-Driven Development)
- Cucumber is a tool supports BDD
    - reads executable specifications written in plain text and validates that the software does what those specifications say
- use Cucumber simply (JVM)
    - configure Cucumber dependencies and task in Gradle 
    - create `.feature` file in `src/test/resources/` directory
    - configure directory of defined steps in `build.gradle`
    - create java file of defined steps
    - transform scenario description to code
    - implement the logic of scenario, let scenario to pass
    - write multiple scenarios
    - implement the all logic, and let scenarios to pass
    - simply multiple same scenarios by scenario outline and variables
- browser automation - selenium
- how to use
    - add dependencies selenium-java, selenium-chrome-driver
    - install [ChromeDriver](https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver)
    - WebDriver request and assert result
    - screenshot and generate report by cucumber
    
    
### References
[Cucumber 10 minutes tutorial](https://cucumber.io/docs/guides/9-minute-tutorial/)