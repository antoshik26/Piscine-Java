package edu.school21.chat.app;

import edu.school21.chat.models.Messages;
import edu.school21.chat.repositories.Db_connection;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MassagesRepositoryJdbcImpl;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try {
            initDb();
            String url = "jdbc:postgresql://localhost/test";
            Properties props = new Properties();
            props.setProperty("user","postgres");
            props.setProperty("password","1");
            props.setProperty("ssl","true");
            Db_connection connect = new Db_connection(url, props);
            MessagesRepository  messagesRepository = new MassagesRepositoryJdbcImpl(connect);
            System.out.println("Enter a message ID");

            int id = (new Scanner(System.in)).nextInt();

            messagesRepository.findById(id).ifPresent(msg -> System.out.println(msg.toString()));
        } catch (InputMismatchException e) {
            System.err.println("no long value");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initDb() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pas = "1";

        Connection  connection = DriverManager.getConnection(url, user, pas);
        Statement   statement = connection.createStatement();

        statement.executeUpdate("drop table if exists messages");
        statement.executeUpdate("drop table if exists chatrooms");
        statement.executeUpdate("drop table if exists users");

        runSqlFile(statement, "schema.sql");
        runSqlFile(statement, "data.sql");

        connection.close();
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