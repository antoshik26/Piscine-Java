package ImagesToChar.src.edu.school21.printer.app;
import ImagesToChar.src.edu.school21.printer.logic.logic;

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
