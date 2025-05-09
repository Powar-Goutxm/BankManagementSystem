![Java](https://img.shields.io/badge/Language-Java-blue)
![GitHub Repo Size](https://img.shields.io/github/repo-size/Powar-Goutxm/BankManagementSystem)
![GitHub Last Commit](https://img.shields.io/github/last-commit/Powar-Goutxm/BankManagementSystem)
![License](https://img.shields.io/badge/License-Open--Source-green)

# 🏦 Bank Management System

A simple Bank Management System made using **Java Swing** and **MySQL**, allowing users to create accounts, deposit money, withdraw funds, and view transaction history.

---

## 📸 Screenshots

### 🔐 Login Screen
![Login](screenshots/login.png)

### 💰 Deposit 
![Deposit](screenshots/deposit.png)

### 💸 Withdrawal
![Withdrawal](screenshots/withdrawal.png)

### 💳 Balance Enquiry
![Balance](screenshots/balance.png)

### 🧾 Mini Statement
![MiniStatement](screenshots/ministatement.png)

### 🔄 Transactions
![Transactions](screenshots/transactions.png)

### 🔢 PIN Change
![PinChange](screenshots/pinchange.png)

### 📝 Sign Up (Step 1)
![SignUp1](screenshots/signup1.png)

### ✏️ Sign Up (Step 2)
![SignUp2](screenshots/signup2.png)

### ✅ Sign Up (Step 3)
![SignUp3](screenshots/signup3.png)

---

## 📌 Features

- Create new bank accounts
- Deposit and withdraw money
- Check account balance
- View transaction history
- User-friendly interface with Java Swing
- MySQL Database integration

---

## 🛠️ Tech Stack

- **Java (Swing for GUI)**
- **MySQL**
- **JDBC (Java Database Connectivity)**

---

## 📂 Project Structure
BankManagementSystem/
│
├── dist/
│
├── nbproject/
│
├── src/
│   ├── 🔌 connection.java       → Handles database connections
│   ├── 🔐 Login.java            → User login screen
│   ├── 💰 Deposit.java          → Deposit money functionality
│   ├── 💸 Withdraw.java         → Withdraw money functionality
│   ├── 📊 BalanceEnquiry.java   → Check account balance
│   ├── 📜 MiniStatement.java    → Shows recent transaction history
│   ├── 📝 Signup.java           → New account signup form
│   ├── 🔄 Transaction.java      → Transaction record handler (if you have this)
│   └── ... (other Java files)
│
├── 📄 .gitignore
├── 📑 BMS Queries.sql          → Example SQL queries
├── 🗄️ BMS Schema.sql            → Database schema definition
├── ⚙️ build.xml
├── 📜 manifest.mf
└── 📖 README.md


---

## 🚀 Getting Started

### 📌 Prerequisites:
- Java JDK installed
- MySQL Server installed
- A Java IDE (like NetBeans or IntelliJ)

---

### 📌 Setup Instructions:
1. Clone this repository:
   ```bash
   git clone https://github.com/Powar-Goutxm/BankManagementSystem.git

2. Import the project into your IDE.

3. Create the database:

    Run BMS Schema.sql to create the database and tables.

    Run BMS Queries.sql for some sample queries (if needed).

4. Update your connection.java file with your MySQL credentials.

5. Build and run the project.   

---

### 🌱 Future Improvements
- Implement password encryption
- Add user account management
- Introduce transaction filtering and search
- Deploy as a desktop installer

---

### 📃 License
- This project is open-source and available under the MIT License.

---

### 🤝 Connect with Me
- GitHub: Powar-Goutxm
- LinkedIn: www.linkedin.com/in/goutam-powar