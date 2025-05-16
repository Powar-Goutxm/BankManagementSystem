CREATE DATABASE BankManagementSystem;
USE BankManagementSystem;

SELECT * FROM Account;
SELECT * FROM Customer;
SELECT *  FROM Transaction;


DROP TABLE Customer;
DROP TABLE Account;
DROP TABLE Transaction;


INSERT INTO Account (CustomerID, Account_Type, Card_No, Pin_No)
VALUES ('111', 'Savings', '1234567812345678', '4321');

SELECT * FROM Transaction WHERE Trans_ID = 1;

SELECT Balance FROM Transaction WHERE AccountID = 501 ORDER BY Trans_Id DESC LIMIT 1;

ALTER TABLE Transaction MODIFY COLUMN Pin_No VARCHAR(30);
ALTER TABLE Transaction MODIFY Amount DECIMAL(15,2);

DESCRIBE Account;
