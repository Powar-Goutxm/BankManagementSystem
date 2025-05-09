USE BankManagementSystem;
CREATE TABLE Login (Form_No VARCHAR(20),Card_NO VARCHAR(30),Pin_No VARCHAR(10));
SELECT * FROM Login;

CREATE TABLE Signup (Formno VARCHAR(20), Name VARCHAR(20) , Father_Name VARCHAR(20), Mother_Name VARCHAR(20), Date_Of_Birth VARCHAR(20) , Gender VARCHAR(10), Email VARCHAR(50), Marital_Status VARCHAR(20) , Locality VARCHAR(50) , City VARCHAR(25) , State VARCHAR(25) , Pin_Code VARCHAR(20));
SELECT * FROM Signup;

CREATE TABLE Signuptwo (Formno VARCHAR(20) , Religion VARCHAR(20) , Category VARCHAR(20), Income VARCHAR(30), Education VARCHAR(20) , Occuption VARCHAR(30) , ExisitingAccount VARCHAR(20));
SELECT * FROM Signuptwo;

CREATE TABLE Signupthree (Formno VARCHAR(20), Account_Type VARCHAR(40), Card_NO VARCHAR(20) ,Pin_No VARCHAR(20));
SELECT * FROM Signupthree;

CREATE TABLE  Transaction (Trans_Id INT PRIMARY KEY AUTO_INCREMENT, Card_No VARCHAR(50), Pin_No VARCHAR(50) ,Trans_Date VARCHAR(80),Trans_Type VARCHAR(40) ,Amount DECIMAL(15,2), Balance DECIMAL(15,2));
SELECT * FROM Transaction;
