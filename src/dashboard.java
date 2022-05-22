public class dashboard {
    public static void main(String[] args) throws Exception {
        User u = User.login();
        System.out.println("hey there " + u.uname);
    }
}
