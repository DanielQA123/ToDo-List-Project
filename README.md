# To-Do-List-Project

Test Coverage: 95% on src/main/java
- (This is excluding the coverage of integration testing)

---
#Project Description

This repository is to show the creation of a basic To-Do List web app, by using the learning material from week 1-7 from QA Academy. To develop a To-Do List Web Application that has a working frontend and backend with full use of the CRUD functionality when connected to a local SQL database. 
Where the code is tested using methods such as JUnit, Intergration and Selenium testing. This README file will give you the material to download the required software needed for the project, 
some notes about the types of test conducted for the project and any other useful information.


---
## Getting Started

The instructions below will help you get a version of this project up and running in a local environment or on your local machine for developing and testing purposes. 
See the prequisites and the deployment section for further details about the live environment and any other related info about the project.


1. **You can fork and clone this repository to a folder on your local computer.**  
2. **Open the project in your SpringBoot IDE as a Maven project/Spring project.** 
3. ** You will need to open Postman and type the local host URL for the command you want to test to see if it works.**
4. ** You will need to open a localhost URL to test the database connection (i.e. localost:8080/h2) or change the jdbc URL in the application properties class in the src/main/resources folder to connect the database on a GCP or another SQL host.** 

---
### Prerequisites

The information below are the required software needed to host this project on your local environment/machine, With links and resources to their URL to download the software. 
Check the download section of the README, to install the neccessary software by following the weblinks. 

The required software:

- Version Control System: git  
- GitHub Account 
- Java (Version 14 or 14.01)
- Eclipse IDE
- SpringBoot 
- Postman 
- Visual Studio Code 
- Maven 
- Google Cloud Platform with SQL (or MySQL workbench)


---
### Downloads

  - Version control system: 
    * [Git](https://git-scm.com/downloads)


  - GitHub Account: 
    * [GitHub](https://github.com/)


  - Java: 
    * [Java](https://www.java.com/en/download/)


  - Eclipse IDE:
    * [Eclipse IDE](https://www.eclipse.org/downloads/)


  - Maven:
    * [Maven](https://maven.apache.org/index.html) 


  - SpringBoot Tools 4 for Eclipse:
    * [SpringBoot](https://spring.io/tools) 


  - Postman:
    * [Postman](https://www.postman.com/downloads/) 


  - Visual Studio Code:
    * [Visual Studio Code](https://code.visualstudio.com/) 


  - Google Cloud Platform for SQL:
    * [SQL on Google Platform](https://console.cloud.google.com/) 


  - SQL for Local Host:
    * [MySQLWorkbench](https://dev.mysql.com/downloads/workbench/) 


---
### Installation

This section gives a list of instructions that are needed to download the software to get a devlopment environment running, which are listed in the prerequisites section of the README. 


1. After forking and cloning this repo. On SpringBoot go on **File, Import, Existing Spring Project** 
2. Open the project once you browse the root directory and select the required folder/project.  
3. After selecting the folder, click finish or next. Then the project should be downloading on SpringBoot IDE. Once the download has been done, click on the pom.xml file 
and change the artifact id. Then select the folder again and right click it and press Maven, then the update and wait for the project to build.
4. Click on the SpringBoot dashboard, so you can the run the specific project you want. After selecting run on the console you should see "hello World" with the date and time meaning the local host tom cat server is set up.
5. Change the jdbc URL to your local database or google cloud platform depending on your preference. 
6. Open Postman and test if you can fetch the API's correctly before moving on.


---
## Testing 

 - **What is Testing**:
    - Testing helps us test the functionality of a code to determine how well it works in a working environment. 
    - Its important because it increases the quality of the delivered code. This means code is less likely to break when in use.
    - For this project a JUnit test with mockito test, integration system test and Selenium test were conducted. 
    

1. **JUnit Testing**:
    - A JUnit test allows us to test some aspects of our code, to test the functionality of the code. 
    - It's mainly used to identify defects early, to solve the issue quickly. 
    - Unit testing is mainly used to test coverage. 


2. **Integration Testing/Integration System Testing**:
    - Integration testing tests the behaviour in the whole system. To check if it works as it intends, reducing the need for manual tests. 
    - Essentially check if each part of the code interacts with each other. 

3. **Selenium Testing**:
    - Selenium is a tool that allows used automated web browsers for tetsing purposes. Therefore it provides an interface through a web driver. 
    - Selenium testing helps us tests the code related to the user. You could say it's similar to acceptance testing. 
    - Acceptance testing is in regards to test the user needs and requirements in relation to the frontend. 

See testing deployment, for instructions when conducting tests. 

---
## Testing Deployment
 
 - For **JUnit** testing each of the classes has a test class which can be run in according to the src/main/java file.
 - To run the tests, click on the class you want to test in the src/test/java. Then **right click it and run as a JUnit test**


 - For individual testing i.e. **integration testing** The controller is the main thing being tested to see if information is pulled from the repo and services classes. 
 
---
## Further Contribution

Please feel free to contribute by adding new templates to this project:

1. Fork it (<https://github.com/DanielQA123/ToDo-List-Project>)
2. Create a new feature branch, remember to branch out of master/main (`git checkout -b <feature branch name>`)
3. Add these changes to your staging area (`git add .`)
4. Commit your changes (`git commit -m 'Add something'`)
5. Push to the branch (`git push origin <feature branch name>`)
6. Create a new Pull Request
7. Selenium/Acceptance testing see if it meets the requirements for the user.
8. Coding style test i.e. SonarQube. This helps test the viabillity with our whole source code.


---
## Deployment

For a quick depolyment of the project on the command line interface (CLI): 

1. ** Open a terminal on your local machine, using the git bash command** 
2. ** In the terminal use, the command mvn clean package to get clear old files and build a new file** 
3. ** You should get a war file similar to a jar file, which can be deployed othe CLI**
4. ** Open the command line and type the war file artifact name into the command line to test if it works**



---
## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


---
## Authors

Daniel Ahuchogu

---
### References

- **Choose an open source license**. Github. Available at: https://choosealicense.com/
- **Getting started with writing and formatting on Github**. Github. Available at: https://help.github.com/articles/getting-started-with-writing-and-formatting-on-github/


---
## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

## Acknowledgments
* Alan Davis 
* Savannah Vaithilingam


---
