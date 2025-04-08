package com.Budget.Tracker;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO {
	public static void addIncome(Income income) {
		String query = "INSERT INTO income (category, amount, date) VALUES(?,?,?)";
		try(Connection con = Database.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setString(1, income.getCategory());
			pstmt.setDouble(2, income.getAmount());
			pstmt.setString(3, income.getDate());
			pstmt.executeUpdate();
			System.out.println("Income added successfully!!");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static List<Income> getIncome(){
		List<Income> incomeList = new ArrayList<Income>();
		String query = "SELECT * FROM income";
		try(Connection con = Database.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				incomeList.add(new Income(
						rs.getString("category"),
						rs.getDouble("amount"),
						rs.getString("date")
				));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return incomeList;
	}
	public static double getTotalIncome()
	{
		String query = "SELECT SUM(amount) AS Total FROM income";
		try(Connection con = Database.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query)){
			if(rs.next()) {
				return rs.getDouble("total");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0.0;
	}
}
