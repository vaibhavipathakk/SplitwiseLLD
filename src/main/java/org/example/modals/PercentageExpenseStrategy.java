package org.example.modals;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PercentageExpenseStrategy implements ExpenseStrategy {
    private final double amount;


    public PercentageExpenseStrategy(double amount) {
        this.amount = amount;
    }

    @Override
    public BalanceMapping calculateExpense(double amount, List<String> userIds, List<Double> splitValues) {
        int n = userIds.size();
        double sum = 0;
        for ( double val : splitValues ) {
            sum += val;
        }
        if ( sum != 100 ) {
            throw new RuntimeException("Split percentage values are incorrect.");
        }

        BalanceMapping balanceMapping = new BalanceMapping();
        for (int i = 0; i < n; ++i ) {
            double newOweAmount = (amount*(splitValues.get(i)/100));
            Balance balance = new Balance(newOweAmount);
            balanceMapping.setBalanceMap(userIds.get(i), balance);
        }
        return balanceMapping;
    }
}
