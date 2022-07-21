

public class Program {
    public static void main(String[] args)
    {
        //if (args.length == 0) {
        //    System.exit(-1);
        //}
        Thread egs = new EggTreadClass(100);
        Thread hen = new HenTreadClass(100);
        egs.start();
        hen.start();
        try {
            egs.join();
            hen.join();
        }
        catch (Exception e)
        {

        }
        int i = 0;
        while (i < 50)
        {
            System.out.println("HUMAN");
            i++;
        }
    }
}
