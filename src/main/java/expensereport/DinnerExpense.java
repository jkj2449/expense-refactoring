package expensereport;

public class DinnerExpense extends Expense {
    public DinnerExpense(int amount) {
        super(Type.DINNER, amount);
    }

    @Override
    public boolean isOverage() {
        return amount > 5000;
    }

    @Override
    public String getName() {
        return "Dinner";
    }

    @Override
    public boolean isMeal() {
        return true;
    }
}
