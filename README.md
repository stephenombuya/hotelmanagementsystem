# Hotel Management System

A hotel management system built using **Spring Boot** and **MySQL**. This application helps manage guest reservations, room bookings, billing, and other core operations of a hotel.

## Features

- **Guest Management**: Allows for managing guest information (name, email).
- **Room Management**: Provides room availability and reservation details, including room type (Single, Double, Suite).
- **Reservation System**: Handles guest reservations for rooms, check-in, and check-out.
- **Billing System**: Generates bills for guests, tracks payment status, and updates payment details.
- **JPA/Hibernate Integration**: Uses Java Persistence API (JPA) and Hibernate for database interaction with MySQL.

## Technologies Used

- **Spring Boot**: The primary framework for building the application.
- **Spring Data JPA**: For working with relational databases using JPA (Java Persistence API).
- **MySQL**: A relational database used to store application data.
- **Spring Boot Starter Web**: For building RESTful web services.
- **Spring Boot Starter Security**: Optional, for adding security features like authentication and authorization.
- **Thymeleaf**: For rendering HTML templates if needed.
- **JUnit 5**: For unit and integration testing.

## Requirements

- **Java 11+** (Ensure Java 11 or later is installed on your machine).
- **MySQL Database**: The project uses MySQL for persistence. Set up a MySQL instance on your machine or use a hosted MySQL service.
- **Maven**: The project uses Maven for dependency management and building.

## Setting Up the Project

### 1. Clone the repository

```bash
git clone https://github.com/stephenombuya/hotelmanagementsystem/tree/main
cd hotel-management-system
```

### 2. Set Up MySQL Database

- Create a new MySQL database for the project (e.g., hotel_management_system).
- Update the application.properties file with your MySQL connection details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_management_system
spring.datasource.username=root
spring.datasource.password=root_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

### 3. Build and Run the Project

 **Using Maven**
- Run the following command to build and run the application:

```bash
mvn spring-boot:run
```
- This will start the Spring Boot application on the default port `8080`.

 **Running Tests**
- To run the unit tests, execute the following command:

```bash
mvn test
```

### 4. Accessing the Application

- Once the application is running, you can access it in your browser at:

```bash
http://localhost:8080
```


### **Database Schema**
The project uses the following tables in MySQL:

- **Room**: Stores room details like room number, type (Single, Double, Suite), and availability.
- **Guest**: Stores guest details such as name and email.
- **Reservation**: Stores reservation details, including guest, room, check-in, and check-out dates.
- **Bill**: Stores billing details, including the amount and payment status.



### **API Endpoints**
Here are some of the key endpoints exposed by the application:

- **GET** /api/guests - Get all guests.
- **POST** /api/guests - Create a new guest.
- **GET** /api/rooms - Get all available rooms.
- **POST** /api/rooms - Create a new room.
- **POST** /api/reservations - Make a new reservation.
- **GET** /api/bills - Get all bills.
- **POST** /api/bills - Create a new bill.


### **Contributing**
If you'd like to contribute to this project, feel free to fork the repository, make changes, and submit a pull request. Please ensure that you follow the coding standards and write unit tests for new features or fixes.


### **License**
This project is licensed under the Apache 2.0 License - see the `LICENSE` file for details.


