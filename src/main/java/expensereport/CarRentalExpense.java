package expensereport;

public class CarRentalExpense extends Expense {
    public CarRentalExpense(int amount) {
        super(Type.CAR_RENTAL, amount);
    }

    @Override
    public boolean isOverage() {
        return false;
    }

    @Override
    public String getName() {
        return "Car Rental";
    }

    @Override
    public boolean isMeal() {
        return false;
    }
}
