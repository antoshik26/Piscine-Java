class Program{
	public static void main(String[] args) throws UserNotFoundException{
		
			UsersArrayList userslist = new UsersArrayList();
			User user1 = new User("Diego", 30);
			User user2 = new User("Gomez", 2000);
			// Transaction transcation1 = new Transaction(user1, user2, 1000);
			System.out.println(user1.toString());
			System.out.println(user2.toString());
			userslist.AddUser(user1);
			userslist.AddUser(user2);
			userslist.getUserByIterator(10);
		// finally 
		// {
        //     System.out.println("Inside bloсk finally");
        // }
	}
}