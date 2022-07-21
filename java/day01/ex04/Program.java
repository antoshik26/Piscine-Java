public class Program {
    public static void main(String[] args) {
        // UserIdsGenerator _userGenerator = new UserIdsGenerator();
        User user1 = new User("Diego", 30);
        User user2 = new User("Gomez", 2000);

        // Transaction transcation1 = new Transaction(user1, user2, 1000);
        System.out.println(user1.toString());
        System.out.println(user2.toString());
        // System.out.println(transcation1.toString());
    }
}
