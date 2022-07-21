package Chat.src.java.edu.school21.chat.app;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pas = "password";

        try {
            Connection  connection = DriverManager.getConnection(url, user, pas);
            Statement   statement = connection.createStatement();


            statement.executeUpdate("drop table if exists messages");
            statement.executeUpdate("drop table if exists rooms");
            statement.executeUpdate("drop table if exists User");

            runSqlFile(statement, "schema.sql");
            runSqlFile(statement, "data.sql");

            connection.close();

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void runSqlFile(Statement statement, String file) throws IOException, SQLException {
        InputStream in = Program.class.getClassLoader().getResourceAsStream(file);

        assert in != null;
        Scanner         scanner = new Scanner(in);
        StringBuilder   stringBuffer = new StringBuilder();

        while (scanner.hasNext()) {
            stringBuffer.append(scanner.nextLine());
        }

        String[]        arr = stringBuffer.toString().split(";");

        for (String s : arr) {
            if (!s.trim().equals("")) {
                System.out.println(s.trim().replaceAll("\\s+", " "));
                statement.executeUpdate(s.trim());
            }
        }
    }
}