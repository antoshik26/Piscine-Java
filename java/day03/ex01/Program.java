public class Program {
    static boolean Flag = false;
    public static void main(String[] args)
    {
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            throw new NumberFormatException();
        }

        int count = Integer.parseInt(args[0].substring(8));

        if (count < 0) {
            throw new NumberFormatException();
        }
        Object obj = new Object();
        Thread egs = new EggThreadClass(count, obj);
        Thread hen = new HenThreadClass(count, obj);
        egs.start();
        hen.start();
    }
    public static synchronized boolean isFlag()
    {
        return (Flag);
    }

    public static synchronized void setFlag(boolean flag) {
        Program.Flag = flag;
    }
}
