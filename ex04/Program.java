import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        TransactionsService transactionsService = new TransactionsService();

        transactionsService.UserADD(new User("John", 10000));
        transactionsService.UserADD(new User("Mike", 2000));
        transactionsService.UserADD(new User("Eva", 5000));
        transactionsService.UserADD(new User("Nancey", 0));

        System.out.println(" -- User list before transactions -- ");
        for (int i = 1; i < transactionsService.get_ListUser().getSize() + 1; i++) {
            System.out.println(transactionsService.get_ListUser().UserLinkedListFind(i));
        }

        transactionsService.AddTransaction(1, 2, 500);
        transactionsService.AddTransaction(2, 3, 1000);
        transactionsService.AddTransaction(3, 2, 200);
        transactionsService.AddTransaction(3, 1, -300);
//        transactionsService.createTransaction(4, 12, 200);

        System.out.println("\n -- Transactions of John -- ");
        if (transactionsService.TransactionsUsers(1) != null) {
            for (Transaction t : transactionsService.TransactionsUsers(1)) {
                System.out.println(t.toString());
            }
        }
        //Delete first transaction of John
        UUID idToDelete = transactionsService.get_ListUser().UserLinkedListFind(1).get_TransactionList().toArray()[0].get_uuid();
        System.out.println(idToDelete);
        transactionsService.RemoveTransaction(1, idToDelete);

        System.out.println("\n -- Transactions of John -- ");
        if (transactionsService.TransactionsUsers(1) != null) {
            for (Transaction t : transactionsService.TransactionsUsers(1)) {
                System.out.println(t.toString());
            }
        }
        System.out.println(" -- Transactions of Mike -- ");
        if (transactionsService.TransactionsUsers(2) != null) {
            for (Transaction t : transactionsService.TransactionsUsers(2)) {
                System.out.println(t.toString());
            }
        }
        System.out.println(" -- Transactions of Eva -- ");
        if (transactionsService.TransactionsUsers(1) != null) {
            for (Transaction t : transactionsService.TransactionsUsers(3)) {
                System.out.println(t.toString());
            }
        }
        System.out.println(" -- Transactions of Nancey -- ");
        if (transactionsService.TransactionsUsers(2) != null) {
            for (Transaction t : transactionsService.TransactionsUsers(3)) {
                System.out.println(t.toString());
            }
        }
        System.out.println("\n -- User list after transactions -- ");
        for (int i = 1; i < transactionsService.get_ListUser().getSize() + 1; i++) {
            System.out.println(transactionsService.get_ListUser().UserLinkedListFind(i));
        }
    }
}
