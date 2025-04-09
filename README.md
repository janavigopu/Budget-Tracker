<h1 align="center">💰 Budget Tracker App</h1>
<p align="center">Track your income & expenses with a clean Java + JDBC console app!</p>

---

## ✨ Overview

A minimalist **Budget Tracker** application built with pure **Java** and **JDBC**.  
No frameworks, just clean and simple code to help you practice Java, database connectivity, and structured programming.

> 💡 Perfect for beginners who want to understand **Java-MySQL integration** from scratch.

---

## 🚀 Features

✅ Add & View **Expenses**  
✅ Add & View **Income**  
✅ Generate Budget **Reports** (Income, Expenses, Balance)  
✅ Console-based user interface  
✅ Uses **MySQL + JDBC** (no frameworks!)  

---

## 🛠 Tech Stack

| Tech       | Description                      |
|------------|----------------------------------|
| 🧠 Java     | Core logic and object handling   |
| 🛢 MySQL    | Database storage for income/expenses |
| 🔌 JDBC     | Java Database Connectivity       |
| 💻 Console  | Interactive CLI menu             |

---

## 🧾 Database Schema

### 📂 `expenses` Table
```sql
CREATE TABLE income (
  id INT AUTO_INCREMENT PRIMARY KEY,
  source VARCHAR(100),
  amount DOUBLE,
  date DATE
);

CREATE TABLE expenses (
  id INT AUTO_INCREMENT PRIMARY KEY,
  category VARCHAR(100),
  amount DOUBLE,
  date DATE
);
```
---
### 🧪 Sample Output
===== Budget Tracker =====

1. Add Expense
2. View Expenses
3. Add Income
4. View Income
5. Generate Report
6. Exit

Enter your choice: 5

=== Budget Report ===

Total Income: $5000.00

Total Expenses: $1500.00

Net Balance: $3500.00

---
### 🧰 How to Run
1. Clone this repo:
```git clone https://github.com/janavigopu/BudgetTracker.git```
2. Open in Eclipse or your favorite IDE
3. Update DB credentials in Database.java:
```
private static final String USER = "your_mysql_user";

private static final String PASSWORD = "your_mysql_password";
```

5. Create DB tables using the SQL provided above or in setup.sql.
6. Run Main.java and start tracking!

---
### 💡 Future Ideas

🗑️ Delete & Update income/expenses

📅 Monthly filters for reports

📊 Export to CSV for offline tracking

🖥️ GUI version using JavaFX or Swing

---
### 🤝 Contribution

Found a bug? Got an idea? Feel free to fork and open a PR!

Let’s build better budgeting together 💪

---
### 📬 Contact
Made with ☕ by Janavi G

🔗 [LinkedIn](https://www.linkedin.com/in/janavig/)

🌐 [GitHub](https://github.com/janavigopu/BudgetTracker)

📧 [Mail](janavi02mca@gmail.com)

---
### 📄 License

MIT License © 2025 — Free to use & modify!
