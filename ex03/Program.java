import java.util.UUID;

class Program{
    public static void main(String[] args){
        User user1 = new User("Nif-Nif", 1000);
        User user2 = new User("Nuf-Nuf", 5000);
        User user3 = new User("Naf-Naf", 30000);
        TransactionsList transactions = new TransactionsList();
        for (int i = 1; i < 6; i++) {
            Transaction transact = new Transaction(user2, user3, -100 * i);
            transactions.AddTransactions(transact);
            transact = new Transaction(user3, user2, 100 * i);
            transactions.AddTransactions(transact);
            user2.AddNewTransaction(transact);
            transact = new Transaction(user1, user2, -5 * i);
            transactions.AddTransactions(transact);
            user2.AddNewTransaction(transact);
            transact = new Transaction(user2, user1, 5 * i);
            transactions.AddTransactions(transact);
        }
        System.out.println(" -- All Transactions -- ");
        for (Transaction t : transactions.toArray()) {
            System.out.println(t.toString());
        }
        System.out.println(" -- Transactions of Nuf-Nuf -- ");
        for (Transaction t : user2.toArray()) {
            System.out.println(t.toString());
        }
        transactions.DeleteTransactions(transactions.toArray()[0].get_uuid());
        transactions.DeleteTransactions(transactions.toArray()[0].get_uuid());
        System.out.println(" -- All Transactions after deletion -- ");
        for (Transaction t : transactions.toArray()) {
            System.out.println(t.toString());
        }
        transactions.DeleteTransactions(UUID.randomUUID());
    }
}
