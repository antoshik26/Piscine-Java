import java.util.Scanner;

public class User
{
	private int _Identifier;
	private String _Name;
	private int _Balance;
	
	public User(int Identifier, String Name, int Balance)
	{
		_Identifier = Identifier;
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
        return _Identifier + " " + _Name + " " + _Balance;
    }
}