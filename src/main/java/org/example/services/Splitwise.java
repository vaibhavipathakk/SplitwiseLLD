package org.example.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.enums.ExpenseType;
import org.example.modals.BalanceMapping;
import org.example.modals.ExpenseStrategy;
import org.example.modals.ExpenseFactory;
import org.example.modals.User;

public class Splitwise {
    private final Map<String, BalanceMapping> userBalanceMappingMap;

    public Splitwise() {
        this.userBalanceMappingMap = new HashMap<>();
    }

    // register users
    public void registerUser(User user) {
        // store in MySQL Database
        if (!userBalanceMappingMap.containsKey(user.getId())) {
            userBalanceMappingMap.put(user.getId(), new BalanceMapping());
        }
//        else {
//            throw exception - user has already been registered.
//        }

    }

    public void addExpense(String userPaid, double amount, List<String> userIds, ExpenseType expenseType, List<Double> splitValues){

        ExpenseStrategy expenseStrategy = ExpenseFactory.getExpenseObject(expenseType, amount);
        BalanceMapping oweUserBalanceMapping = expenseStrategy.calculateExpense(amount, userIds, splitValues);

        if (userBalanceMappingMap.containsKey(userPaid)) {
            userBalanceMappingMap.get(userPaid).updateBalanceMap(oweUserBalanceMapping);

        }

    }


    // display balance of all users
    public void displayBalanceOfAllUsers() {
        System.out.println("---Balance of all Users---");
        userBalanceMappingMap.forEach((id, balanceMapping) -> {
            balanceMapping.getBalanceMap().forEach((oweUserId, balance) -> {
                System.out.println("User-"+ id + " owes to User-" + oweUserId + " : " + balance.getAmount());
            });
        });
    }

    // display balance of one user
    public void displayBalanceOfOneUser(String userId) {
        System.out.println("---Balance of " + userId + "---");
        userBalanceMappingMap.get(userId).getBalanceMap().forEach((oweUserId, balance) -> {
            System.out.println("User-"+ userId + " owes to User-" + oweUserId + " : " + balance.getAmount());
        });
    }



}
