package expensereport;

import java.util.ArrayList;
import java.util.List;

public class ExpenseReport {
    private List<Expense> expenses = new ArrayList<Expense>();
    private int mealExpenses = 0;
    private int total = 0;

    public ExpenseReport() {
    }

    void totalsUpExpense() {
        for (Expense expense : expenses) {
            totalUpExpense(expense);
        }
    }

    void totalUpExpense(Expense expense) {
        if (expense.isMeal())
            mealExpenses += expense.amount;

        total += expense.amount;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public int getMealExpenses() {
        return mealExpenses;
    }

    public int getTotal() {
        return total;
    }
}