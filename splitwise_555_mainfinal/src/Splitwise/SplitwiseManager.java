package Splitwise;

import Expense.Expense;
import Split.Split;
import Users.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitwiseManager {
    private Map<String,Users> users;
    private Map<String,Map<String,Double>> balanceSheet;
    private List<Expense> expenses;

    public SplitwiseManager() {
        this.users = new HashMap<>();
        this.balanceSheet = new HashMap<>();
        this.expenses = new ArrayList<>();
    }

    public void addUsers(Users user) {
        users.put(user.getUserId(), user);
        balanceSheet.put(user.getUserId(), new HashMap<>());
    }


    public void addExpense(Expense expense) {
        Expense updatedExpense = createExpense(expense);
        if(updatedExpense != null) {
            expenses.add(updatedExpense);
            updateBalanceSheet(expense);
        }
    }

    private void updateBalanceSheet(Expense expense) {
        String paidBy = expense.getPaidBy();

        for(Split split : expense.getSplitList()) {
            String paidTo = split.getUserId();
            Map<String,Double> updatesheet = balanceSheet.get(paidBy);
            if(!updatesheet.containsKey(paidTo))
            {
                updatesheet.put(paidTo,0.0);
            }
            updatesheet.put(paidTo,updatesheet.get(paidTo)+split.getAmount());

            updatesheet = balanceSheet.get(paidTo);
            if(!updatesheet.containsKey(paidBy)){
                updatesheet.put(paidBy,0.0);
            }
            updatesheet.put(paidBy,updatesheet.get(paidBy)-split.getAmount());
        }
    }
    /*if user1 give 2000Rs out of which 400 given to user2 and 400 given to user3
     * After Updatebalancesheetafterexpense
     * user1 -> {user2=400,user3=400}
     * user2 -> {user1=-400}
     * user3 -> {user1=-400}
     * user4 -> {}
     */

    private Expense createExpense(Expense expense) {
        switch (expense.getExpenseType()) {
            case percentage:{
                    for(Split split : expense.getSplitList()) {
                        split.setAmount((expense.getAmount() * split.getAmount())/100);
                    }
                    return expense;
            }
            default:{
                return null;
            }
        }
    }

    public void Print() {
        boolean pendingBalance = false;
        for (Map.Entry<String, Map<String,Double>> allbalances : balanceSheet.entrySet()) {
            for(Map.Entry<String,Double> userBalance: allbalances.getValue().entrySet()){
                if(userBalance.getValue() > 0){
                    pendingBalance = true;
                    printBalance(allbalances.getKey(),userBalance.getKey(),userBalance.getValue());
                }
            }
        }
        if(!pendingBalance){
            System.out.println("No Balance");
        }
    }

    public void printBalance(String user1,String user2, Double amount){
        String user1Name = users.get(user1).getUserName();
        String user2Name = users.get(user2).getUserName();
        if(amount < 0){
            System.out.println(user1Name + " ows " + user2Name + " : " + Math.abs(amount));
        }
        else if(amount > 0)
        {
            System.out.println(user2Name + " ows " + user1Name + " : " + Math.abs(amount));
        }
    }
}
