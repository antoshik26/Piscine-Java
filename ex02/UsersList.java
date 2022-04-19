public interface UsersList
{
	public void AddUser(User user);
	public User getUserById(int id);
	public User getUserByIterator(int id);
	public int getCountUser();
}