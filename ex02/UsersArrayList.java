public class UsersArrayList implements UsersList
{
	private int count;
	private User []userslist;
	private int compasity;

	public UsersArrayList()
	{
		userslist = new User[10];
		count = 0;
	}

	public void AddUser(User user)
	{

		if (count == userslist.length)
		{
			User []userslist_2 = new User[count * 2];
			int i = 0;
			while (i < count)
			{
				userslist_2[i] = userslist[i];
				i++;
			}
			userslist = userslist_2;
		}
		userslist[count] = user;
		// userslist[count].toString();
		count++;
	}

	public User getUserByIterator(int id)
	{
		try
		{
			if (id > count)
			{
				throw new UserNotFoundException("User not found.");
			}
		}
		catch(UserNotFoundException e)
		{
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		return (userslist[id]);
	}

	public User getUserById(int id)
	{
		int i = 0;
		while (i < count)
		{
			if (userslist[i].getIdentifier() == id)
				break;
			i++;
		}
		try
		{	
			if (id <= 0)
				throw new UserNotFoundException("User not found.");
			if (i == count && userslist[i].getIdentifier() != id)
				throw new UserNotFoundException("User not found.");
			
		}
		catch(UserNotFoundException e)
		{
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		return (userslist[i]);
	}

	public int getCountUser()
	{
		return (count);
	}

}