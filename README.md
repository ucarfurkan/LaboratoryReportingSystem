# LaboratoryReportingSystem
Laboratory Reporting System, raporları görüntüleyebileceğin, düzenleyebileceğin, silebileceğin, arama yapabileceğin ve tarihe göre sıralayabileceğin bir uygulamadır.

İlk olarak, kodu localde şu adımları takip ederek çalıştırabilirsiniz:
* Terminal veya CMD'de "git clone https://github.com/ucarfurkan/LaboratoryReportingSystem.git" komutunu çalıştırarak, proje dosyalarını indirin.
* İndirdiğiniz dosyaya "cd" komutunu kullanarak girin.
* Ardından, "mvn clean package" komutu ile jar dosyasının oluşturulmasını sağlayın.
* Son olarak, "java -jar target/LaboratoryReportingSystem.jar" komutu ile projeyi çalıştırın.

## Projede kullanılan teknolojiler:
1. Java, Spring Boot
2. Hibernate/JPA
3. H2 Database
4. HTML, CSS
5. Bootstrap
6. Maven
7. JavaScript (Sadece bir işlev)

Projeyi çalıştırdıktan sonra, görüntülemek için "localhost:8080/reports" bağlantısını tarayıcınızda açmalısınız.

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
* **Report:** Rapor sınıfı, LabTechnician ve Patient sınıflarıyla @ManyToOne ilişkisine sahiptir. Kendine özgü alanları vardır. Rapor sınıfındaki fileNumber, duplicate olmaması için hastanın kimlik numarası olarak kabul edilmiştir. Eğer bir hastaya ait birden fazla rapor varsa, bu raporların dosya numaraları "identityNo - 1", "identityNo - 2" şeklinde devam etmektedir. Ayrıca her rapor için farklı bir dosya numarası olduğundan, raporlara ait fotoğraflar bu dosya numaralarıyla çağrılır. Bu sayede her rapor için görüntülemek istediğimiz fotoğrafın adını, o raporun dosya numarası yapmalıyız. Uzantısı JPG veya PNG olabilir. Fotoğraflar, resources/static/images dizininde bulunmaktadır.
* **SearchTags:** SearchTags sınıfı, sadece arama işlemini gerçekleştirdiğimiz sırada kullandığımız bir "template class"tır.

### Helper
Genellikle daha temiz kod yazılmasını sağladığını düşündüğümden projelerde Helper sınıfını oluşturmaktan yanayım. Bu projede sadece bir metottan oluşan bir Helper sınıfı var o da rapor listesinin boş olup olmadığını kontrol ediyor.

### Repository
PersonRepository ve ReportRepository sınıfları mevcut. İki sınıf da JpaRepository<,> sınıfıyla genişletilmiş. Bunun sebebi, gerçekleştirmek istediğimiz operasyonlarda Hibernate kullanmak. 2 ayrı sınıf yerine PersonRepository sınıfı oluşturularak yazılım geliştirme prensiplerine uymaya çalışıldı. Ayrıca, ReportRepository içerisinde native SQL diliyle yazılmış bir filtreleme sorgusu mevcut.

### Service
LabService isimli bir interface'e ve onu implement eden LabServiceImpl sınıfına sahip. LabServiceImpl sınıfında repository sınıfları kullanılarak operasyonların metotları yazılmıştır.

Projede genel olarak Dependency Injection uygulanmaya çalışılmış, snıflar ve metotlar bağımsızlaştırılmıştır. H2 Database kullanılmasının sebebi, projenin çalıştırılma sürecini hızlandırmaktır. application.properties dosyası tercih edilen veritabanına göre güncellenerek de kullanılabilir.





