README with:
o	Project structure
o	Tech stack
o	How to run
o	Future improvements

Document Your Portfolio Clearly

Include a note in your README or website that the project was built using a third-party demo site.

Mention the tool used, the tested features, and the test objective.

Provide screenshots or screen recordings of your working tests.

Archive Project Videos

Create short demo videos (screen recording with voiceover or captions).

Upload to YouTube (unlisted) or include in your portfolio.

This way, you can still demonstrate your skills even if the site is gone.

Host Your Own Test Site (Recommended for Long-Term Stability)

Use a React/Node.js or Spring Boot app with basic forms and pages.

Host it on AWS, GitHub Pages, or a local server.

This gives you full control over the testing environment.

Use Docker or Local Setup Copies

Some projects like OrangeHRM provide Docker containers or downloadable versions.

You can run them locally and keep the environment consistent.

Treat Public Demo Sites as Short-Term Showcases

Use them mainly for skill demonstration in your learning or job-seeking phase.

Plan for migrating test cases to your own mock apps over time.




Project for testing My personal portfolio website. 
Tested with Selenium + TestNG + Maven + Java
Environments: 2; Development and production
Test Environment urls can be changed from '\src\test\resources\config-dev.properties' or  '\src\test\resources\config-prod.properties' files

Project uploaded to github: https://github.com/shejutik/WebAutomation

Running tests using maven and testng.xml file:
Have to install TestNG from Help > Eclipse Marketplace or Help> Install New Software... 
Right click on testng.xml > Run As > TestNG Suite
mvn clean test -DsuiteXmlFile=testng.xml