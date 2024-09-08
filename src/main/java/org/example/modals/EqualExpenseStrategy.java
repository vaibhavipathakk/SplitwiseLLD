package org.example.modals;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EqualExpenseStrategy implements ExpenseStrategy {

    private final double amount;

    public EqualExpenseStrategy(double amount) {
        this.amount = amount;
    }

    @Override
    public BalanceMapping calculateExpense(double amount, List<String> userIds, List<Double> splitValues) {
        int noOfUsers = userIds.size();
        amount = amount/noOfUsers;
        BalanceMapping balanceMapping = new BalanceMapping();
        for (String id : userIds) {
            balanceMapping.setBalanceMap(id, new Balance(amount));
        }
        return balanceMapping;
    }
}
