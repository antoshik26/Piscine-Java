public class HenTreadClass extends  Thread {
    private int _count;
    HenTreadClass(int count)
    {
        this._count = count;
    }
    public void run() {
        int i = 0;
        while (i < _count)
        {
            System.out.println("Hen");
            i++;
        }
    }
}
