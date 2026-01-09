# 🎫 Customer Service Ticket Management System (Java)

Bu proje, bir yardım masasının (help desk) çalışma prensiplerini simüle eden kapsamlı bir **Müşteri Hizmetleri Destek Bileti Yönetim Sistemi**'dir. Uygulama, Java'nın yerleşik veri yapılarını kullanmak yerine; Queue, Deque ve Priority Queue gibi yapıların generic (genel) olarak sıfırdan uygulanması üzerine kurulmuştur.

---

### 🌟 Temel Özellikler

* 
**🏗️ Özel Veri Yapıları:** Java'nın hazır kütüphaneleri kullanılmadan `Queue`, `Deque` ve `PriorityQueue` yapıları generic olarak `LinkedList` tabanlı gerçeklenmiştir.


* **⚖️ Öncelik Bazlı Çözümleme:** Destek biletleri; High (Yüksek), Medium (Orta) ve Low (Düşük) öncelik seviyelerine göre işlenir.


* 
**🔄 FIFO Prensibi:** Aynı öncelik seviyesindeki biletler, geliş sırasına göre (İlk giren ilk çıkar) çözümlenir.


* 
**🔍 Gelişmiş Sıralama ve Filtreleme:** Bekleyen biletler önceliğe veya tarihe göre; tamamlanan biletler ise müşteri adına göre artan/azalan düzende sıralanabilir.


* 
**📂 CSV Komut İşleyici:** Sistem, komutları bir CSV dosyasından okuyarak otomatik olarak yürütür.



---

### 📊 Veri Yapıları Mimarisi

Sistem, biletleri yönetmek için hiyerarşik bir yapı kullanır:

1. 
**Priority Queue:** İçerisinde üç ayrı `Queue` (Yüksek, Orta, Düşük) barındırarak biletleri kategorize eder.


2. 
**Generic Deque:** Çift uçlu kuyruk yapısı ile listenin her iki ucundan işlem yapılmasına olanak tanır.


3. 
**Ticket History:** Çözümlenen biletleri `GenericHistory` sınıfı altında bir `LinkedList` içinde saklar.



---

### 📂 Proje Bileşenleri

| Sınıf | Görevi |
| --- | --- |
| `Ticket` | Müşteri adı, sorun açıklaması, öncelik ve varış zamanı bilgilerini tutar.

 |
| `PriorityQueue<T>` | Üç dahili kuyruk kullanarak biletleri önceliklerine göre yönetir.

 |
| `GenericHistory<T>` | Çözümlenmiş bilet geçmişini yönetir ve sıralı görüntüleme sunar.

 |
| `CommandProcessor` | CSV'den gelen `new`, `resolve`, `display`, `history` komutlarını yürütür.

 |
| `FileIO` | CSV dosyasını okur ve komut nesnelerine dönüştürür.

 |

---

### 🛠️ Kurulum ve Kullanım

1. 
**Hazırlık:** Java projenizi Eclipse veya tercih ettiğiniz bir IDE'ye aktarın.


2. 
**Veri Dosyası:** Komutların bulunduğu CSV dosyasını `Files/sample.csv` dizinine yerleştirin (Göreceli yol kullanımı zorunludur).


3. 
**Karakter Kodlaması:** Türkçe karakterlerin düzgün görünmesi için proje kodlamasını **UTF-8** olarak ayarlayın.


4. **Derleme ve Çalıştırma:**
```bash
javac Main.java
java Main

```



---

### 📝 Örnek CSV Komutları ve Çıktı

**Giriş (CSV):** 

```csv
new, John Doe, Internet not working, High
new, Jane Smith, Payment issue, Low
resolve
display, priority
history

```

**Beklenen Çıktı:** 

```text
Adding Ticket: John Doe - Internet not working [High Priority]
Resolved: John Doe - Internet not working [High]
Displaying Active Tickets (By Priority)
1. Jane Smith - Payment issue [Low]
Resolved Ticket History (Sorted by Customer Name)
1. John Doe - Internet not working [High]

```

---

> [!IMPORTANT]
> Bu proje **CENG112 Data Structures** dersi ödevi kapsamında geliştirilmiştir. Proje dosyalarının `G05_CENG112_HW2` formatında adlandırılması ve teslim edilmesi gerekmektedir.
> 
> 

