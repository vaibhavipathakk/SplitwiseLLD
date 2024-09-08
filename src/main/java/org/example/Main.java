package org.example;

import java.util.List;
import org.example.enums.ExpenseType;
import org.example.modals.User;
import org.example.services.Splitwise;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("---->>---Splitwise App---<<<----");

        User user1 = new User("mansi");
        User user2 = new User("vishal");
        User user3 = new User("himanshu");
        User user4 = new User("aashika");

        Splitwise splitwise = new Splitwise();
        splitwise.registerUser(user1);
        splitwise.registerUser(user2);
        splitwise.registerUser(user3);
        splitwise.registerUser(user4);

        splitwise.addExpense(user1.getId(), 1000, List.of(user2.getId(), user3.getId(), user4.getId()), ExpenseType.EXACT, List.of(700.0, 200.0, 100.0) );
        splitwise.addExpense(user2.getId(), 1000, List.of(user1.getId(), user3.getId(), user4.getId()), ExpenseType.EQUAL, List.of() );
        splitwise.addExpense(user1.getId(), 100, List.of(user2.getId(), user3.getId(), user4.getId()), ExpenseType.PERCENTAGE, List.of(20.0, 20.0, 60.0) );

        splitwise.displayBalanceOfAllUsers();
        splitwise.displayBalanceOfOneUser(user1.getId());
    }
}