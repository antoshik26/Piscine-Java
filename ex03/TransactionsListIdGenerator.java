public class TransactionsListIdGenerator {
    private int Id;
    private static final UserIdsGenerator INSTANCE = new UserIdsGenerator();

    public TransactionsListIdGenerator()
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
