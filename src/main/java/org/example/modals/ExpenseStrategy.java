package org.example.modals;

import java.util.List;

public interface ExpenseStrategy {
    BalanceMapping calculateExpense(double amount, List<String> userIds, List<Double> splitValues);
}
