# LaboratoryReportingSystem
Laboratory Reporting System is an application with which you can view reports, edit, delete, search, and sort reports by date.

First, you can run the code locally by following these steps:
* Download the project by running "git clone https://github.com/ucarfurkan/LaboratoryReportingSystem.git" in terminal or CMD.
* Move to the downloaded file using the "cd" command.
* Next, create the jar file with the "mvn clean package" command.
* Finally, run the project with the command "java -jar target/LaboratoryReportingSystem.jar".

## In this project, the technologies I used are:
1. Java, Spring Boot
2. Hibernate/JPA
3. H2 Database
4. HTML, CSS
5. Bootstrap
6. Maven
7. JavaScript

After running the project, you must open the "localhost:8080/reports" link in your browser to view it. Since there is no responsive design, I recommend you open the project from the desktop.

## In Laboratory Reporting System, you can:

* Delete reports from the application

![delete](https://user-images.githubusercontent.com/71367001/216006184-565d4d2d-9c90-4016-a223-4b56b815603b.gif)

* Show details of the report

![details](https://user-images.githubusercontent.com/71367001/216006347-7b2c9bd2-02e4-44cd-ae91-4088b40aaf8e.gif)

* Update the existing report

![update](https://user-images.githubusercontent.com/71367001/216006455-5bb01b41-8d92-493f-a3b1-efc3c3e8c298.gif)

* Search reports

![search](https://user-images.githubusercontent.com/71367001/216006722-36c9402e-7814-4cf9-b52c-3c2f8cc71bee.gif)

* Sort reports by date

![sort](https://user-images.githubusercontent.com/71367001/216006786-59fe5589-be52-42bc-842a-fd1beaf75f58.gif)


## Technical Choices in the Project
There are 6 different packages in the project. These are: Config, Controller, Entities, Helper, Repository and Service.

### Config
It has a single class with a single method. MvcConfing.java, addResourceHandlers(ResourceHandlerRegistry registry). This method was written and determined the path to present resources to the client.

### Controller
It has LabController class inside. This class is used to process requests related to lab reports. It contains multiple methods, each mapped to a specific URL.

### Entities
The Entities package contains 5 classes. These are: Person, Lab Technician, Patient, Report, and SearchTags.
* **Person:** The Person class is a superclass and is marked with the @MappedSuperclass annotation. The reason is that the class does not map itself directly to the database table, instead, it provides values such as "name", and "id" to other classes that will be processed into the tables as a superclass.
* **LabTechnician:** Lab Technician is an extended class with the Person class. It has a "One To Many" relationship to the Report class and is marked with the @OneToMany annotation.
* **Patient:** Patient is an extended class with the Person class. It has a "One To Many" relationship to the Report class and is marked with the @OneToMany annotation.
* **Report:** The Report class has a @ManyToOne relationship with the LabTechnician and Patient classes. It has its own fields. The fileNumber in the Report class has been accepted as the patient's identification number to avoid duplicates. If there is more than one report belonging to a patient, the file numbers of these reports continue as "identityNo - 1", "identityNo - 2". Also, since each report has a different file number, the photos of the reports are called with these file numbers. For this reason, for each report, we should make the name of the photo file we want to display is file number of that report. The extension can be JPG or PNG. The photos are located in the resources/static/images directory.
* **SearchTags:** The SearchTags class is a "template class" that we use only when we perform the search.

### Helper
In this project, there is a Helper class with only one method, which checks if the report list is empty.

### Repository
It has PersonRepository and ReportRepository classes. Both classes are extended with the JpaRepository<,> class. This is because we use Hibernate for the operations we want to perform. By creating PersonRepository class instead of 2 separate classes, it tried to comply with software development principles. In addition, there is a filtering query written in the native SQL language in the ReportRepository.

### Service
It has an interface called LabService and the LabServiceImpl class that implements it. Methods of operations are written using repository classes in LabServiceImpl class.

In the project, Dependency Injection was tried to be applied in general, and classes and methods were tried to make independent. The reason for using H2 Database is to speed up the execution of the project. It can also be used by updating the application.properties file according to the preferred database.




