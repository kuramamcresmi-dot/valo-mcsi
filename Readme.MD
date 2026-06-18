# KuramaMC Valorant Core 🎮
*Minecraft 1.20.3 için geliştirilmiş, en kapsamlı Valorant tabanlı oyun motoru.*

[![Versiyon](https://img.shields.io/badge/versiyon-1.0.0-blue.svg)]()
[![Durum](https://img.shields.io/badge/durum-geliştiriliyor-yellow.svg)]()
[![API](https://img.shields.io/badge/api-PaperMC-orange.svg)]()

---

## 📖 Genel Bakış
**KuramaMC Valorant Core**, Minecraft sunucuları için sıfırdan geliştirilmiş, yüksek performanslı bir oyun modu motorudur. Amacımız, oyuncuların hiçbir mod indirmesine gerek kalmadan (Server-Side), Valorant'ın o rekabetçi dinamiklerini, ajan yeteneklerini ve "Kurama" (Spike) sistemini Minecraft'a en akıcı şekilde taşımaktır.

## 🚀 Temel Teknik Özellikler
*   **Paket Tabanlı Savaş:** `ProtocolLib` entegrasyonu ile sıfır gecikmeli vuruş kayıt sistemi.
*   **Durum Makinesi (FSM):** Tur tabanlı oyun mekanikleri (Lobi -> Satın Alma -> Tur -> Sonuç).
*   **Özel Kimlik Sistemi:** GUI tabanlı kayıt ekranı, etiket (tag) yönetimi ve ajan seçimi.
*   **Kurama (Spike) Mekaniği:** Sadece belirlenen bölgelere kurulabilen, stratejik oyun döngüsü.
*   **Temiz Mimari:** Modüler yapı sayesinde kolay geliştirilebilir, ölçeklenebilir kod tabanı.

## 🛠️ Teknik Altyapı
- **Dil:** Java 17
- **Çerçeve:** Paper API (1.20.3)
- **Ağ:** ProtocolLib (Paket yakalama ve işleme)
- **Yapı Aracı:** Maven

## 📋 Kurulum
1. Sunucunuzun **Paper 1.20.3** sürümünde çalıştığından emin olun.
2. [ProtocolLib](https://github.com/dmulloy2/ProtocolLib) eklentisini sunucunuzun `/plugins` klasörüne atın.
3. Derlediğiniz `ValorantCore.jar` dosyasını `plugins/` klasörüne yükleyin.
4. Sunucuyu yeniden başlatın.

## 🏗️ Mimari Tasarım
Proje, katı bir **Yönetici-Servis** modeliyle yönetilir:
- **GameManager:** Oyunun tüm yaşam döngüsünü ve turları orkestre eder.
- **AbilityManager:** Ajan yeteneklerini (Jett, Phoenix, Sage, Sova, Reyna) yönetir.
- **ShopManager:** Ekonomi sistemini ve satın alma arayüzünü yönetir.

## 🤝 Katkıda Bulunma
KuramaMC ekibi olarak bu projeyi açık bir şekilde geliştiriyoruz. Hata bildirimi veya önerileriniz için [Issues](https://github.com/KULLANICI_ADIN/REPO_ADIN/issues) kısmını kullanabilirsiniz.

---
*Geliştirici: Shiva | KuramaMC*
