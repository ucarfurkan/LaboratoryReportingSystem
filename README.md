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


## Projedeki teknik seçimler
Proje içerisinde 6 farklı package bulunyor. Bunlar: Config, Controller, Entities, Helper, Repository ve Service.

### Config
Tek metottan oluşan tek bir sınıfa sahip. MvcConfing.java, addResourceHandlers(ResourceHandlerRegistry registry). Bu metot, istemciye kaynakları sunması için yazılmış ve yolunu belirlemiştir.

### Controller
İçerisinde LabController sınıfına sahip. Bu sınıf, laboratuvar raporlarıyla ilgili olan istekleri (request) işlemek için kullanılıyor. Her biri belirli bir URL'ye eşlenmiş birden fazla metot bulundurmaktadır.

### Entities
Entitites package'ı, içerisinde 5 tane sınıf barındırıyor. Bunlar: Person, LabTechnician, Patient, Report ve SearchTags.
* **Person:** Person sınıfı, bir superclasstır ve @MappedSuperclass anotasyonuyla işaretlenmiştir. Buradaki amaç; sınıfın direkt kendisini veritabanı tablosuna eşlememek, onun yerine superclass olarak tablolara işlenecek olan diğer sınıflara "name","id" gibi değerleri sağlamasıdır.
* **LabTechnician:** LabTechnician, Person sınıfıyla genişletilmiş bir sınıftır. Report sınıfıyla arasında "OneToMany" ilişkisi vardır ve @OneToMany anotasyonu ile işaretlenmiştir. 
* **Patient:** Patient, Person sınıfıyla genişletilmiş bir sınıfıtır. Report sınıfıyla arasında "OneToMany" ilişkisi vardır ve @OneToMany anotasyonu ile işaretlenmiştir.
* **Report:** Report sınıfı, LabTechnician ve Patient sınıflarıyla @ManyToOne ilişkisine sahiptir. Kendine özgü alanları vardır. Report sınıfındaki fileNumber, duplicate olmaması için hastanın kimlik numarası olarak kabul edilmiştir. Eğer bir hastaya ait birden fazla rapor varsa, bu raporların dosya numaraları "identityNo - 1", "identityNo - 2" şeklinde devam etmektedir. Ayrıca her rapor için farklı bir dosya numarası olduğundan, raporlara ait fotoğraflar bu dosya numaralarıyla çağrılır. Bu sebeple her bir rapor için görüntülemek istediğimiz fotoğraf dosyasının adını, o raporun dosya numarası yapmalıyız. Uzantısı JPG veya PNG olabilir. Fotoğraflar, resources/static/images dizininde bulunmaktadır.
* **SearchTags:** SearchTags sınıfı, sadece arama işlemini gerçekleştirdiğimiz sırada kullandığımız bir "template class"tır.

### Helper
Genellikle daha temiz kod yazılmasını sağladığını düşündüğümden projelerde Helper sınıfını oluşturmaktan yanayım. Bu projede sadece bir metottan oluşan bir Helper sınıfı var o da rapor listesinin boş olup olmadığını kontrol ediyor.

### Repository
PersonRepository ve ReportRepository sınıfları mevcut. İki sınıf da JpaRepository<,> sınıfıyla genişletilmiş. Bunun sebebi, gerçekleştirmek istediğimiz operasyonlarda Hibernate kullanmak. 2 ayrı sınıf yerine PersonRepository sınıfı oluşturularak yazılım geliştirme prensiplerine uymaya çalışıldı. Ayrıca, ReportRepository içerisinde native SQL diliyle yazılmış bir filtreleme sorgusu mevcut.

### Service
LabService isimli bir interface'e ve onu implement eden LabServiceImpl sınıfına sahip. LabServiceImpl sınıfında repository sınıfları kullanılarak operasyonların metotları yazılmıştır.

Projede genel olarak Dependency Injection uygulanmaya çalışılmış, sınıflar ve metotlar bağımsızlaştırılmıştır. H2 Database kullanılmasının sebebi, projenin çalıştırılma sürecini hızlandırmaktır. application.properties dosyası tercih edilen veritabanına göre güncellenerek de kullanılabilir.





