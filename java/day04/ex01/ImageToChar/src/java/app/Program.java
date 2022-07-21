package ImageToChar.src.java.app;
import ImageToChar.src.java.logic.*;

public class Program {
    public static void main(String[] args){
        if (args.length != 1)
        {
            System.exit(-1);
        }
        logic log = new logic(args[0]);
        log.print();
    }
}
