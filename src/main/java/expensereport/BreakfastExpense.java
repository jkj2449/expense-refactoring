package expensereport;

public class BreakfastExpense extends Expense {
    public BreakfastExpense(int amount) {
        super(Type.BREAKFAST, amount);
    }

    @Override
    public boolean isOverage() {
        return amount > 1000;
    }

    @Override
    public String getName() {
        return "Breakfast";
    }

    @Override
    public boolean isMeal() {
        return true;
    }
}
