# KuramaMC Valorant Core 🎮
*The most advanced Valorant-inspired game engine for Minecraft 1.20.3*

[![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)]()
[![Build](https://img.shields.io/badge/build-passing-brightgreen.svg)]()
[![API](https://img.shields.io/badge/api-PaperMC-orange.svg)]()

---

## 📖 Overview
**KuramaMC Valorant Core**, Minecraft sunucuları için sıfırdan geliştirilmiş, yüksek performanslı bir oyun modu motorudur. Amacımız, mod gerektirmeyen (Server-Side) bir yapıda, Valorant'ın o kendine has rekabetçi dinamiklerini Minecraft'a taşımaktır.

## 🚀 Key Technical Features
*   **Packet-Based Combat:** `ProtocolLib` entegrasyonu ile sıfır gecikmeli mermi vuruş hesaplamaları.
*   **State Machine (FSM):** Tur tabanlı oyun mekanikleri için ölçeklenebilir durum yönetimi.
*   **Clean Architecture:** Modüler yapı sayesinde kolay geliştirilebilir ve debug edilebilir kod bloğu.
*   **Custom Shop System:** Inventory API ile tamamen özelleştirilebilir Valorant satın alma arayüzü.

## 🛠️ Tech Stack
- **Language:** Java 17
- **Framework:** Paper API (1.20.3)
- **Networking:** ProtocolLib (Packet Interception)
- **Build Tool:** Maven

## 📋 Installation
1. Ensure your server is running **Paper 1.20.3**.
2. Install [ProtocolLib](https://github.com/dmulloy2/ProtocolLib) in your `/plugins` folder.
3. Drop `ValorantCore.jar` into your plugins folder.
4. Restart the server.

## 🏗️ Architecture Design
The project follows a strict **Manager-Service** pattern.
- **GameManager:** Orchestrates the entire lifecycle of a round.
- **AbilityManager:** Handles agent-specific skills via functional interfaces.
- **WeaponEngine:** Uses `RayTrace` with custom drop-off and recoil algorithms.

## 🤝 Contributing
Contributions are highly welcome! Please check our [Contribution Guidelines](CONTRIBUTING.md) before opening a Pull Request.

---
*Developed by Vadaa for KuramaMC and allowed servers.*
