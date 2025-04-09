package Split;

public class Split {

    private String userId;
    private Integer amount;

    public Split(String userId,Integer amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userId = userName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
