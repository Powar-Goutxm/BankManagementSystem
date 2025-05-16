CREATE DATABASE BankManagementSystem;

-- Use Bank Management System Database
USE BankManagementSystem;

CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY AUTO_INCREMENT,
    Form_No VARCHAR(20),
    Name VARCHAR(50),
    Father_Name VARCHAR(50),
    Mother_Name VARCHAR(50),
    Date_Of_Birth VARCHAR(50),
    Gender VARCHAR(10),
    Email VARCHAR(50),
    Marital_Status VARCHAR(20),
    Locality VARCHAR(50),
    City VARCHAR(25),
    State VARCHAR(25),
    Pin_Code VARCHAR(10),
    Religion VARCHAR(20),
    Category VARCHAR(20),
    Income VARCHAR(30),
    Education VARCHAR(50),
    Occupation VARCHAR(50),
    ExistingAccount VARCHAR(20)
)AUTO_INCREMENT = 111;

CREATE TABLE Account (
    AccountID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID INT,
    Account_Type VARCHAR(40),
    Card_No VARCHAR(20) UNIQUE,
    Pin_No VARCHAR(20),
    Account_Status VARCHAR(20),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID))
    AUTO_INCREMENT = 501;
;

CREATE TABLE Transaction (
    Trans_ID INT PRIMARY KEY AUTO_INCREMENT,
    AccountID INT,
    Trans_Date VARCHAR(50),
    Trans_Type VARCHAR(40),
    Amount DECIMAL(15,2),
    Balance DECIMAL(15,2),
    FOREIGN KEY (AccountID) REFERENCES Account(AccountID)
);

