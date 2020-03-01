package expensereport;

import static expensereport.Expense.Type.BREAKFAST;
import static expensereport.Expense.Type.DINNER;

public class Expense {



    public enum Type {DINNER, BREAKFAST, CAR_RENTAL};

    public Type type;
    public int amount;

    public Expense(Type type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public boolean isOverage() {
        return (type == DINNER && amount > 5000)
                || (type == BREAKFAST && amount > 1000);
    }

    public String getName() {
        String name = "TILT";
        switch (type) {
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

    public boolean isMeal() {
        return type == BREAKFAST || type == DINNER;
    }
}
