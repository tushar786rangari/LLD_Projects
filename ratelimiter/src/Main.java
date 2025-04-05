import ApiRateLimiter.ApiRateLimiter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        ApiRateLimiter apiRateLimiter = new ApiRateLimiter(5,10000);
//        String user = "user";
//        String user2 = "user2";
//        for(int i=0;i<10;i++)
//        {
//            if(apiRateLimiter.allowRequest(user2))
//                System.out.println("allowRequest");
//            else
//                System.out.println("denyRequest");
//        }
//    }
//}
public class Main {
    public static void main(String[] args) {
        ApiRateLimiter rateLimiter = new ApiRateLimiter(5, 2); // 5 max tokens, 2 tokens added per second

        String user = "user1";
        for (int i = 0; i < 10; i++) {
            boolean allowed = rateLimiter.allowRequest(user);
            System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed ✅" : "Blocked ❌"));

//            try {
//                TimeUnit.MILLISECONDS.sleep(300); // Simulate request frequency
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}