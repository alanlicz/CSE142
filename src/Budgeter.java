// Alan Li
// 01/26/2020
// CSE142
// TA: Eric Koegler
// Assignment #3
//
// This program will output a cafe wall illusion image
import java.util.*;


public class Budgeter {

    // Define how many days in a month
    public static final int DAYS = 31;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        welcomeMessage();
        double totalIncome = getIncome(console);
        double totalExpense = getExpense(console);
        double netIncome = totalIncome - totalExpense;
        double dailyIncome = totalIncome / DAYS;
        double dailyExpense = totalExpense / DAYS;
        printMessage(netIncome, dailyIncome, dailyExpense, totalIncome, totalExpense);
    }

    // Print out a welcome message at the beginning of the output console
    public static void welcomeMessage() {
        System.out.println("This program asks for your monthly income and");
        System.out.println("expenses, then tells you your net monthly income.");
        System.out.println();
    }

    // Calculate the total expense or income
    public static double calculation(Scanner console, String type){
        int count = console.nextInt();
        double sum = 0;
        for (int i = 1; i <= count; i++) {
            System.out.printf("    Next %s amount? $", type);
            double amount = console.nextDouble();
            sum = sum + amount;
        }
        return sum;
    }
    // Allow user type their income entries and calculate the total income
    public static double getIncome(Scanner console) {
        System.out.print("How many categories of income? ");
        return calculation(console, "income");
    }

    // Allow user type their expense either by daily or monthly, then calculate the total expense
    public static double getExpense(Scanner console) {
        System.out.println();
        System.out.print("Enter 1) monthly or 2) daily expenses? ");
        int choice = console.nextInt();
        System.out.print("How many categories of expense? ");
        double result;
        if (choice == 1) {
            result = calculation(console, "expense");
        }
        else{
            result = calculation(console, "expense") * DAYS;
        }
        return result;
    }

    // Print out the total expenses and income as long as which category does the user fall into
    // (saver or spender) double netIncome -variable that used to calculate the netIncome according
    // to the total income and expense
    // double dailyIncome -variable that used to calculate daily income for output
    // double dailyExpense -variable that used to calculate daily expense for output
    // double totalIncome -variable that used to calculate the total income
    // double totalExpense -variable that used to calculate the total expense
    public static void printMessage(double netIncome, double dailyIncome, double dailyExpense,
                                    double totalIncome, double totalExpense){
        System.out.println();
        System.out.printf("Total income = $%.2f ($%.2f/day)\n", totalIncome, dailyIncome);
        System.out.printf("Total expenses = $%.2f ($%.2f/day)\n", totalExpense, dailyExpense);
        System.out.println();
        if (netIncome > 0){
            System.out.printf("You earned $%.2f more than you spent this month.\n", netIncome);
            if (netIncome > 250) {
                System.out.println("You're a big saver.");
                System.out.println("Are you saving money for the new PlayStation?");
            }
            else{
                System.out.println("You're a saver.");
                System.out.println("Not too bad, keep it up.");
            }
        }
        else {
            System.out.printf("You spent $%.2f more than you earned this month.\n", 0-netIncome);
            if (netIncome > -250){
                System.out.println("You're a spender.");
                System.out.println("You need to keep an eye on your wallet!");
            }
            else{
                System.out.println("You're a big spender.");
                System.out.println("I DECLARE BANKRUPTCY!!!(Did you get it?)");
            }
        }
    }
}