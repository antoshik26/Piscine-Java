import java.util.Scanner;
import java.util.UUID;
import java.util.Enumeration;

public class Transaction
{
	private enum Transfer_category{
		debet, credit
	}

	private UUID _uuid;
	private User _Recipient;
	private User _Sender;
	private Transfer_category _Transfer_category;
	private int _Transfer_amount;

	public Transaction(User Recipient, User Sender, int Transfer_amount)
	{
		_uuid = UUID.randomUUID();
		_Recipient = Recipient;
		_Sender = Sender;
		if (Recipient.getIdentifier() == Sender.getIdentifier() || Transfer_amount == 0)
		{
			System.out.print("IllegalArgument");
			System.exit(-1);
		}
		if (Transfer_amount > 0)
		{
			_Transfer_category = Transfer_category.debet;
			if (Transfer_amount <  Recipient.getBalance())
			{
				System.out.print("IllegalArgument");
				System.exit(-1);
			}
		}
		else
		{
			_Transfer_category = Transfer_category.credit;
			if (Transfer_amount <  Sender.getBalance())
			{
				System.out.print("IllegalArgument");
				System.exit(-1);
			}
		}
		_Transfer_amount = Transfer_amount;
	}

	public String toString()
    {
        return _uuid + " " + _Recipient.getIdentifier() + " " + _Sender.getIdentifier() + " " + _Transfer_category + " " + _Transfer_amount;
    }

	// public int make_a_transaction()
	// {
	// 	if (_Recipient.getIdentifier() == _Sender.getIdentifier())
	// 	{
	// 		System.out.print("Человек не может сделать превод себе");
	// 		return (-1);
	// 	}
	// 	if (_Transfer_category == "debet" || _Transfer_category == "credit")
	// 	{
	// 		if (_Transfer_category == "debet")
	// 		{
				
	// 		}
	// 		else
	// 		{

	// 		}
	// 	}
	// 	else
	// 	{
	// 		System.out.print("Неизвестный перевод");
	// 		return (-1);
	// 	}
		
	// 	return (1);
	// }

}