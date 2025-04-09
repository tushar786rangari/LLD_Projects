package Expense;

import Split.Split;

import java.util.Date;
import java.util.List;

public class Expense {

    private String expenseId;
    private String expenseName;
    private ExpenseMetaData expenseMetaData;
    private String date;
    private String paidBy;
    private ExpenseType expenseType;
    private List<Split> splitList;

    private Integer amount;

    public Expense(String expenseId, String expenseName, ExpenseMetaData expenseMetaData, String date, String paidBy, ExpenseType expenseType, List<Split> splitList, Integer amount) {
        this.expenseId = expenseId;
        this.expenseName = expenseName;
        this.expenseMetaData = expenseMetaData;
        this.date = date;
        this.paidBy = paidBy;
        this.expenseType = expenseType;
        this.splitList = splitList;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public ExpenseMetaData getExpenseMetaData() {
        return expenseMetaData;
    }

    public void setExpenseMetaData(ExpenseMetaData expenseMetaData) {
        this.expenseMetaData = expenseMetaData;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String  date) {
        this.date = date;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    public void setSplitList(List<Split> splitList) {
        this.splitList = splitList;
    }
}
