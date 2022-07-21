import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        if (args.length < 2)
        {
            System.exit(-1);
        }
        try {
            int j = 0;
            FileReader FileReader1 = new FileReader(args[1]);
            FileReader FileReader2 = new FileReader(args[2]);
            FileWriter fileWriter = new FileWriter("dictionary.txt");
            BufferedReader FileBufferedRead1 = new BufferedReader(FileReader1);
            BufferedReader FileBufferedRead2 = new BufferedReader(FileReader2);
            String line1 = FileBufferedRead1.readLine();
            String line2 = FileBufferedRead2.readLine();
            Vector<Integer> FileVector1 = new Vector<Integer>();
            Vector<Integer> FileVector2 = new Vector<Integer>();
            List<String> splitFile1 = Arrays.asList(line1.split(" "));
            List<String> splitFile2 = Arrays.asList(line2.split(" "));
            Set<String> dict = new HashSet<String>();
            dict.addAll(splitFile1);
            dict.addAll(splitFile2);
            for (String word : dict)
            {
                FileVector1.add(Collections.frequency(splitFile1, word));
                FileVector2.add(Collections.frequency(splitFile2, word));
            }
            int numerator = 0;
            for (int i = 0; i < dict.size(); i++)
                numerator += (FileVector1.get(i) * FileVector2.get(i));
            double denominator;
            int denominator1 = 0;
            int denominator2 = 0;
            for (Integer n : FileVector1)
                denominator1 += n * n;
            for (Integer n : FileVector2)
                denominator2 += n * n;
            denominator = Math.sqrt(denominator1) * Math.sqrt(denominator2);
            System.out.println(denominator);
            FileReader2.close();
            FileReader1.close();
        }
        catch (Exception e)
        {

        }
        finally {

        }
    }
}
