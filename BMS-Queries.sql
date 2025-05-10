CREATE DATABASE BankManagementSystem;
USE BankManagementSystem;

SELECT * FROM Account;
SELECT * FROM Customer;
SELECT *  FROM Transaction;


DROP TABLE Customer;
DROP TABLE Account;
DROP TABLE Transaction;


SELECT * FROM Transaction WHERE Card_No = '233514596301' ORDER BY Trans_id DESC LIMIT 1;

ALTER TABLE Transaction MODIFY COLUMN Pin_No VARCHAR(30);
ALTER TABLE Transaction MODIFY Amount DECIMAL(15,2);