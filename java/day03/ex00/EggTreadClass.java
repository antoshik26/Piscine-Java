public class EggTreadClass extends  Thread{
    private int _count;
    EggTreadClass(int count)
    {
       this._count = count;
    }

    public void run() {
        int i = 0;
        while (i < _count)
        {
            System.out.println("Egg");
            i++;
        }
    }
}
