import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        LinkedList<SignatureClass> ListSignature = new LinkedList<SignatureClass>();
        int key = 0;
        SignatureClass struct;
        Scanner in = new Scanner(System.in);
            try {
                FileInputStream FileSignature = new FileInputStream("signature.txt");
                FileOutputStream FileRezulte = new FileOutputStream("rezulte.txt");
                String line = "";
                String name = "";
                byte[] buf;
                int read;
                do {
                    read = FileSignature.read();
                    if ((char) read == '\n') {
                        buf = line.getBytes(StandardCharsets.UTF_8);
                        SignatureClass signature = new SignatureClass(name, buf);
                        ListSignature.add(signature);
                        line = "";
                        continue;
                    } else {
                        if ((char) read == ',') {
                            name = line;
                            line = "";
                            continue;
                        }
                        line = line + (char) read;
                    }

                }
                while (read != -1);
                FileSignature.close();
                Iterator<SignatureClass> current = ListSignature.iterator();
                while (true) {
                    line = in.nextLine();
                    if (line.equals("42")) {
                        break;
                    }
                    FileSignature = new FileInputStream(line);
                    byte[] buffer = new byte[8];
                    FileSignature.read(buffer);
                    while (current.hasNext()) {
                        struct = current.next();
                        if (struct.get_SignatureValue() == buffer) // переделать
                        {
                            FileRezulte.write(struct.get_SignatureName().getBytes());
                            FileRezulte.write('\n');
                            key = 1;
                            break;
                        }
                    }
                    if (key == 0) {
                        FileRezulte.write("UNDEFINED".getBytes());
                    }
                    key = 0;
                    FileSignature.close();
                }
                FileRezulte.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
    }
}
