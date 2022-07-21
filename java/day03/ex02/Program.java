import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Program {
    private static int sumthread = 0;
    public static void main(String[] args)
    {
        if (args.length != 2 || !args[0].startsWith("--arraySize=")) {
            throw new NumberFormatException();
        }
        int size = Integer.parseInt(args[0].substring(8));
        if (size < 0) {
            throw new NumberFormatException();
        }
        if (args.length != 2 || !args[1].startsWith("--threadCount=")) {
            throw new NumberFormatException();
        }
        int count = Integer.parseInt(args[0].substring(8));

        if (count < 0) {
            throw new NumberFormatException();
        }
        List<Thread> ThreadList = new ArrayList<Thread>();
        List<Integer> MassIntList = new ArrayList<Integer>();
        Random rand = new Random();
        int i = 0;
        while (i < size) {
            MassIntList.add(rand.nextInt(1000 - 1000) - 1000);
            i++;
        }
        int sum2 = 0;
        while (i < size)
        {
            sum2 = sum2 + MassIntList.get(i);
            i++;
        }
        System.out.println("Sum: " + sum2);
        i = 0;
        int	mod = (int) Math.ceil((double)size / count);
        while (i < count) {
            int indexStart = i * mod;
            int indexEnd = Math.min((i + 1) * mod, size);
            List<Integer> newArray = new ArrayList(MassIntList.subList(indexStart, indexEnd));
            Thread newThread = new CalculatorThreadClass(newArray, i, indexStart,indexEnd);
            ThreadList.add(newThread);
            i++;
        }
        i = 0;
        for (Thread c : ThreadList ) {
            c.start();
        }
        try {
            for (Thread c : ThreadList ) {
                c.join();
            }
        }
        catch (Exception e){

        }
        System.out.println("Sum by threads: " + sumthread);
    }
    public static synchronized void AddSum(int sum){
        sumthread = sumthread + sum;
    }
}
