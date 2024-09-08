package org.example.modals;

import org.example.enums.ExpenseType;

public class ExpenseFactory {
    public static ExpenseStrategy getExpenseObject(ExpenseType expenseType, double amount) {
        switch (expenseType) {
            case EXACT -> {
                return new ExactExpenseStrategy(amount);
            }
            case PERCENTAGE -> {
                return new PercentageExpenseStrategy(amount);
            }
            default -> {
                return new EqualExpenseStrategy(amount);
            }
        }
    }
}
