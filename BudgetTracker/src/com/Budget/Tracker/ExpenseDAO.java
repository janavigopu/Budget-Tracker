package com.Budget.Tracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {
	//add Expenses
	public static void addExpense(Expense expense) {
		String query = "INSERT INTO expenses(category, amount, date) VALUES(?,?,?)";
		try(Connection con = Database.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query))
		{
			pstmt.setString(1, expense.getCategory());
			pstmt.setDouble(2, expense.getAmount());
			pstmt.setString(3, expense.getDate());
			pstmt.executeUpdate();
			System.out.println("Expense added successfully!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//get Expenses
	public static List<Expense> getExpenses(){
		List<Expense> expenseList = new ArrayList<>();
		String query = "SELECT * FROM expenses";
		try(Connection con = Database.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query)){
			while(rs.next()) {
				expenseList.add(new Expense(
						rs.getString("category"),
						rs.getDouble("amount"),
						rs.getString("date")
				));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return expenseList;
	}
	
		//get Total Expenses
	public static double getTotalExpenses() {
		String query = "SELECT SUM(amount) AS total FROM expenses";
		try(Connection con = Database.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query)){
			if(rs.next())
			{
				return rs.getDouble("total");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0.0;
	}
}
