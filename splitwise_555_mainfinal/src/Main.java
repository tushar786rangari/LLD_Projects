import Expense.Expense;
import Split.Split;
import Splitwise.SplitwiseManager;
import Users.Users;
import Expense.ExpenseMetaData;
import Expense.ExpenseType;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SplitwiseManager splitwiseManager  = new SplitwiseManager();

        Users user1 = new Users("user1", "uid1", "user1@gmail.com", 1234);
        Users user2 = new Users("user2", "uid2", "user2@gmail.com", 9994);
        Users user3 = new Users("user3", "uid3", "user3@gmail.com", 1554);
        Users user4 = new Users("user4", "uid4", "user4@gmail.com", 5478);

        splitwiseManager.addUsers(user1);
        splitwiseManager.addUsers(user2);
        splitwiseManager.addUsers(user3);
        splitwiseManager.addUsers(user4);

        List<Split> splitList = new ArrayList<>();
        Split split1 = new Split("uid2",20);
        Split split2 = new Split("uid3",20);
        splitList.add(split1);
        splitList.add(split2);

        ExpenseMetaData expenseMetaData = new ExpenseMetaData("Dinner", "comment");
        Expense expense = new Expense("exp1","dinner",expenseMetaData,"24April", user1.getUserId(), ExpenseType.percentage,splitList,
                2000);
        splitwiseManager.addExpense(expense);
        splitwiseManager.Print();
    }
}