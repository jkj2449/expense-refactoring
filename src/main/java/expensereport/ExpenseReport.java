package expensereport;

import java.util.ArrayList;
import java.util.List;


public class ExpenseReport {
    private List<Expense> expenses = new ArrayList<Expense>();
    private int mealExpenses = 0;
    private int total = 0;
    private ReportPrinter printer;

    public void printReport(ReportPrinter printer) {
        this.printer = printer;

        totalsUpExpense();
        printExpensesAndTotals();
    }

    private void printExpensesAndTotals() {
        printHeader();
        printExpenses();
        printTotals();
    }

    private void printExpenses() {
        for (Expense expense : expenses) {
            printer.print(String.format("%s\t%s\t$%.02f\n",
                    expense.isOverage() ? "X" : " ",
                    expense.getName(), expense.amount / 100.0));

        }
    }

    private void totalsUpExpense() {
        for (Expense expense : expenses) {
            totalUpExpense(expense);
        }
    }

    private void totalUpExpense(Expense expense) {
        if (expense.isMeal())
            mealExpenses += expense.amount;

        total += expense.amount;
    }

    private void printTotals() {
        printer.print(String.format("\nMeal expenses $%.02f", mealExpenses / 100.0));
        printer.print(String.format("\nTotal $%.02f", total / 100.0));
    }

    private void printHeader() {
        printer.print("Expenses " + getDate() + "\n");
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    private String getDate() {
        return "9/12/2002";
    }
}
