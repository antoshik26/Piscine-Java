import java.util.Scanner;
import java.util.UUID;

public class User
{
    private int _Identifier;
    private String _Name;
    private int _Balance;
    private TransactionsList _TransactionList;

    public User(String Name, int Balance)
    {
        _Identifier = UserIdsGenerator.getInstance().generateId();
        _Name = Name;
        if (Balance < 0)
            _Balance = 0;
        else
            _Balance = Balance;
    }

    public int getIdentifier()
    {
        return (_Identifier);
    }

    public String getName()
    {
        return (_Name);
    }

    public void setName(String Name)
    {
        Name = _Name;
    }

    public int getBalance()
    {
        return (_Balance);
    }

    public void setBalance(int Balance)
    {
        _Balance = Balance;
    }

    public String toString()
    {
        return (_Identifier + " " + _Name + " " + _Balance);
    }

    public void AddNewTransaction(Transaction newTransaction)
    {
        _TransactionList.AddTransactions(newTransaction);
    }

    public void DeleteTransaction(UUID uuid)
    {
        _TransactionList.DeleteTransactions(uuid);
    }

    public Transaction[] toArray()
    {
        return (_TransactionList.toArray());
    }

    public int get_Identifier() {
        return _Identifier;
    }

    public TransactionsList get_TransactionList() {
        return _TransactionList;
    }
}