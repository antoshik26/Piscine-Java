import java.util.Scanner;

public class User
{
	private int _Identifier;
	private String _Name;
	private int _Balance;

	public User()
	{}

	public User(int Identifier, String Name, int Balance)
	{
		_Identifier = Identifier;
		_Name = Name;
		if (Balance < 0)
			_Balance = 0;
		else
			_Balance = Balance;
	}
	
}