USE BankManagementSystem;

SELECT * FROM Login;
SELECT * FROM Signup;
SELECT * FROM SignupTwo;
SELECT * FROM SignupThree;
SELECT *  FROM Transaction;



DROP TABLE Login;
DROP TABLE Signup;
DROP TABLE SignupTwo;
DROP TABLE SignupThree;
DROP TABLE Transaction;


SELECT * FROM Transaction WHERE Card_No = '233514596301' ORDER BY Trans_id DESC LIMIT 1;

ALTER TABLE Transaction MODIFY COLUMN Pin_No VARCHAR(30);
ALTER TABLE Transaction MODIFY Amount DECIMAL(15,2);