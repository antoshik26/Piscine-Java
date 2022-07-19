import java.util.LinkedList;
import java.util.UUID;

public class TransactionsService {
    private  UserLinkedList _ListUser;

    private class IllegalTransactionException extends Exception {
        private IllegalTransactionException(String errorMessage) {
            super(errorMessage);
        }
    }
    public TransactionsService()
    {
        _ListUser = new UserLinkedList();
    }

    public void UserADD(User newUser)
    {
        _ListUser.UserLinkedListADD(newUser);
    }

    public int get_balans(int id)
    {
        return _ListUser.UserLinkedListFind(id).getBalance();
    }

    public int AddTransaction(int IdFirst, int IdSecond, int Transfer_amount)
    {
        try {
            Transaction first = new Transaction(_ListUser.UserLinkedListFind(IdFirst), _ListUser.UserLinkedListFind(IdSecond), Transfer_amount);
            Transaction second = new Transaction(_ListUser.UserLinkedListFind(IdSecond), _ListUser.UserLinkedListFind(IdFirst), Transfer_amount);

            //if () exception
            //else
            _ListUser.UserLinkedListFind(IdFirst).get_TransactionList().AddTransactions(first);
            _ListUser.UserLinkedListFind(IdSecond).get_TransactionList().AddTransactions(second);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return (0);
    }

    public int RemoveTransaction(int id, UUID uuid)
    {
        if (_ListUser.UserLinkedListFind(id).get_TransactionList().DeleteTransactions((uuid)) == -1)
            return (-1);
        return (0);
    }

    public Transaction[] TransactionsUsers(int id)
    {
        return _ListUser.UserLinkedListFind(id).get_TransactionList().toArray();
    }

    public LinkedList<Transaction> correctnessTransaction()
    {
        LinkedList<Transaction> ListIncorrectTransaction = new LinkedList<Transaction>();

        return (ListIncorrectTransaction);
    }

    public UserLinkedList get_ListUser() {
        return _ListUser;
    }

}
