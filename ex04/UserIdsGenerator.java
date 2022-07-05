public class UserIdsGenerator
{
    private int Id;
    private static final UserIdsGenerator INSTANCE = new UserIdsGenerator();

    public UserIdsGenerator()
    {
        Id = 0;
    }

    public int generateId()
    {
        Id = Id + 1;
        return(Id);
    }

    public static UserIdsGenerator getInstance()
    {
        return INSTANCE;
    }

}
