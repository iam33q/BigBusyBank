public class dashboard {
    public static void main(String[] args) throws Exception {
        User u = User.login();
        System.out.println("\nhey there " + u.uname);
        //create current account
        // Iris how to add that current account to clients database???
        CurrentAccount.newCurrentAccount();

    }
}
