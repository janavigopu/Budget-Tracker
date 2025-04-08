package com.Budget.Tracker;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("\n======BUDGET TRACKER=====");
			System.out.println("1. ADD EXPENSE");
			System.out.println("2. VIEW EXPENSE");
			System.out.println("3. ADD INCOME");
			System.out.println("4. VIEW INCOME");
			System.out.println("5. VIEW NET SAVINGS");
			System.out.println("6. EXIT");
			System.out.print("Choose an option: ");
			
			int choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
			case 1:
				System.out.println("Enter expense category: ");
				String expCategory = scan.nextLine();
				System.out.println("Enter amount: ");
				double expAmount = scan.nextDouble();
				scan.nextLine();
				System.out.print("Enter date (YYY-MM-DD): ");
				String expDate = scan.nextLine();
				
				ExpenseDAO.addExpense(new Expense(expCategory, expAmount, expDate));
				break;
				
			case 2:
				List<Expense> expenses = ExpenseDAO.getExpenses();
				System.out.println("\n------Expense-----");
				for(Expense exp: expenses)
				{
					System.out.println(exp.getCategory()+" - $"+ exp.getAmount() + " - "+exp.getDate());
				}
				break;
				
			case 3: 
				System.out.println("Enter income category: ");
				String incCategory = scan.nextLine();
				System.out.println("Enter amount: ");
				double incAmount = scan.nextDouble();
				scan.nextLine();
				System.out.println("Enter date (YYYY-MM-DD): ");
				String incDate = scan.nextLine();
				
				IncomeDAO.addIncome(new Income(incCategory, incAmount, incDate));
				break;
				
			case 4: 
				List<Income> incomeList = IncomeDAO.getIncome();
				System.out.println("\n---Income---");
				for(Income inc:incomeList) {
					System.out.println(inc.getCategory()+" - $"+ inc.getAmount() + " - " + inc.getDate());
				}
				break;
				
			case 5:
				System.out.println("Net Savings : $"+(IncomeDAO.getTotalIncome() - ExpenseDAO.getTotalExpenses()));
				break;
				
			case 6: 
				System.out.println("Exiting.... Goodbye!");
				System.exit(0);
				break;
				
			default: 
				System.out.println("Invalid choice! Try again.");
			}

		}
	}
}
