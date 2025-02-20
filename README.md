# 🎉 Event Management System  

![Contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg)

📌 This repository contains the implementation of an **Event Management System** using **Spring Boot**. The system allows users to **create, view, and delete events**, as well as **manage categories and tags**. The application follows **SOLID principles**, **Layered Architecture**, and **Clean Code** principles to ensure maintainability and scalability.

---

## 📖 Table of Contents  
- [📌 About](#-about)  
- [🚀 Features](#-features)  
- [💻 How to Use](#-how-to-use)  
- [🔹 How the Application Works](#-how-the-application-works)  
- [ℹ️ More Information about Implementation](#ℹ️-more-information-about-implementation)  

---

## 📌 About  

This **Event Management System** allows users to **create, delete, and manage events**, along with their associated **categories and tags**. Users can also **view all existing events, categories, and tags**.  

### Core Features:
- **Spring Boot** framework for easy backend development.
- **Spring MVC** for handling web requests.
- **Spring Data JPA** for database management.
- **Thymeleaf** templating engine for rendering the UI.

---

## 🚀 Features  

### 📅 **Event Management**  
✔️ View all events  
✔️ Create new events  
✔️ Delete events  

### 📂 **Category Management**  
✔️ View all categories  
✔️ Create new categories  

### 🏷️ **Tag Management**  
✔️ View all tags  
✔️ Create new tags  

### 📜 **Event Creation Details**  
✔️ Add event name  
✔️ Add event description  
✔️ Add organizer email  
✔️ Select an event category  

---

## 💻 How to Use  

```sh
git clone https://github.com/barnamelisa/SpringWebApp.git
cd SpringWebApp
```

---

## 🔹 How the Application Works

-   **Events**: Users can create events by providing a name, description, organizer email, and selecting a category. They can also view and delete events.
-   **Categories**: Users can see all available categories and create new ones.
-   **Tags**: Users can view and create tags that can be assigned to events.

---

## ℹ️ More Information about Implementation

This application follows best practices in software development:

-   **Spring Boot**: Used for quick setup and streamlined backend development.

-   **Spring MVC**: Implements the Model-View-Controller (MVC) pattern to separate business logic, data, and UI.

-   **Spring Data JPA**: Handles database interactions and simplifies CRUD operations.

-   **Thymeleaf**: Provides a dynamic frontend by rendering views with data from the backend.

-   **Password Hashing**: User passwords are securely hashed using BCrypt to enhance security.

-   **MySQL Database**:  Stores all event-related data. The system automatically creates tables such as events, categories, and tags.