package expensereport;

public abstract class Expense {
    public enum Type {DINNER, BREAKFAST, CAR_RENTAL};

    public Type type;
    public int amount;

    public Expense(Type type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public abstract boolean isOverage();

    public abstract String getName();

    public abstract boolean isMeal();
}
