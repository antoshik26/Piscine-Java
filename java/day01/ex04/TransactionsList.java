import java.util.LinkedList;
import java.util.UUID;

public class TransactionsList {
    private TransactionsLinkedList ListTransaction;
    private class TransactionNotFoundException extends Exception {
        private TransactionNotFoundException(String errorMessage) {
            super(errorMessage);
        }
    }
    public TransactionsList()
    {
    }

    public void AddTransactions(Transaction newTransaction)
    {
        ListTransaction.TransactionsLinkedListADD(newTransaction);
    }

    public int DeleteTransactions(UUID uuid)
    {
        try {
            if (ListTransaction.remove(uuid) == true)
            {
                throw new TransactionNotFoundException(uuid.toString() + "not found.");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        finally {
            System.exit(-1);
        }
        return (0);
    }

    public  Transaction[] toArray()
    {
        return ListTransaction.toArray();
    }

    public TransactionsLinkedList getListTransaction() {
        return ListTransaction;
    }
}
