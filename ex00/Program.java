class Program{
	public static void main(String[] args){
		User user1 = new User(1, "Diego", 30);
		User user2 = new User(2, "Gomez", 2000);
		Transaction transcation1 = new Transaction(user1, user2, 1000);
		System.out.println(user1.toString());
		System.out.println(user2.toString());
		System.out.println(transcation1.toString());
	}
}