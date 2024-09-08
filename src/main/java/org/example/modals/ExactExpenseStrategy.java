package org.example.modals;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ExactExpenseStrategy implements ExpenseStrategy {
    private final double amount;

    public ExactExpenseStrategy(double amount) {
        this.amount = amount;
    }

    @Override
    public BalanceMapping calculateExpense(double amount, List<String> userIds, List<Double> splitValues) {

        int n = userIds.size();
        double sum = 0;
        for ( double val : splitValues ) {
            sum += val;
        }
        if ( sum != amount ) {
            throw new RuntimeException("Split values are incorrect.");
        }

        BalanceMapping balanceMapping = new BalanceMapping();
        for (int i = 0; i < n; ++i ) {
            Balance balance = new Balance(splitValues.get(i));
            balanceMapping.setBalanceMap(userIds.get(i), balance);
        }
        return balanceMapping;
    }
}
