package expensereport;

import java.util.ArrayList;
import java.util.List;

import static expensereport.Expense.Type.BREAKFAST;
import static expensereport.Expense.Type.DINNER;


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
                    isOverage(expense) ? "X" : " ",
                    getName(expense), expense.amount / 100.0));

        }
    }

    private boolean isOverage(Expense expense) {
        return (expense.type == DINNER && expense.amount > 5000)
                || (expense.type == BREAKFAST && expense.amount > 1000);
    }

    private String getName(Expense expense) {
        String name = "TILT";
        switch (expense.type) {
            case DINNER:
                name = "Dinner";
                break;
            case BREAKFAST:
                name = "Breakfast";
                break;
            case CAR_RENTAL:
                name = "Car Rental";
                break;
        }
        return name;
    }

    private void totalsUpExpense() {
        for (Expense expense : expenses) {
            totalUpExpense(expense);
        }
    }

    private void totalUpExpense(Expense expense) {
        if (isMeal(expense))
            mealExpenses += expense.amount;

        total += expense.amount;
    }

    private boolean isMeal(Expense expense) {
        return expense.type == BREAKFAST || expense.type == DINNER;
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
