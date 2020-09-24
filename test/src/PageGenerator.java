import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PageGenerator {
     static void generateMessages() throws IOException {
        FileReader worm = new FileReader("src/messages.txt");
        Scanner sc = new Scanner(worm);
        String[] tempor;
        FileWriter messageGenerator = new FileWriter("generatedMessageList.html");
        messageGenerator.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <meta charset=\"utf-8\">\n" +
                "        <title>титле</title>\n" +
                "    </head>\n" +
                "    <body>");
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            tempor = s.split(":");
            String sender = tempor[0];
            String receiver = tempor[1];
            String message = tempor[2];
            messageGenerator.write(sender + " пишет " + receiver + ": " + message + "<br>");
        }
        messageGenerator.write(" </body>\n" +
                "</html>");
        messageGenerator.close();
        worm.close();
    }

    static void generateFeed() throws IOException {
        FileReader improvedWorm = new FileReader("src/posts.txt");
        Scanner sc = new Scanner(improvedWorm);
        String[] tempor;
        FileWriter feedGenerator = new FileWriter("generatedFeed.html");
        feedGenerator.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <meta charset=\"utf-8\">\n" +
                "        <title>титле</title>\n" +
                "    </head>\n" +
                "    <body>");
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            tempor = s.split(":");
            String header = tempor[0];
            String description = tempor[1];
            String author = tempor[2];
            String timeOfSending = tempor[3];
            String content = tempor[4];
            feedGenerator.write(header + "<br>" + description + "<br>" + content + "<br>" + "Автор поста: " + author + "<br>" + "Время создания: " + timeOfSending + "<br>");
        }
        feedGenerator.write(" </body>\n" +
                "</html>");
        feedGenerator.close();
        improvedWorm.close();
    }

    static void generateUserPage(long ID) throws IOException {
        FileReader userAnalisator = new FileReader("src/users.txt");
        Scanner sc = new Scanner(userAnalisator);
        String[] tempor;
        FileWriter usersPageGenerator = new FileWriter("userPage.html");
        usersPageGenerator.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <meta charset=\"utf-8\">\n" +
                "        <title>титле</title>\n" +
                "    </head>\n" +
                "    <body>");
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            tempor = s.split(":");
            long foundID = Long.parseLong(tempor[0]);
            if (foundID == ID) {
                usersPageGenerator.write("ID пользователя: " + ID + "<br>" +
                                        "Фамилия: " + tempor[1] + "<br>" +
                                        "Имя: " + tempor[2] + "<br>" +
                                        "Отчество: " + tempor[3] + "<br>" +
                                        "Дата рождения: " + tempor[4] + "<br>" +
                                        "Никнейм: " + tempor[5]);
            }
            else continue;
            usersPageGenerator.write(" </body>\n" +
                    "</html>");
            usersPageGenerator.close();
            userAnalisator.close();
        }
    }

    static void generate404() throws IOException {
        FileWriter generator = null;
        generator = new FileWriter("404.html");
        generator.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <meta charset=\"utf-8\">\n" +
                "        <title>титле</title>\n" +
                "    </head>\n" +
                "    <body>" +
                "чел, тут есть всего три запроса, и один из них пока даже не работает: /messages и /feed, так что, пожалуйста, больше не ошибайся, ладно? проверь капс, раскладку и всё такое, прежде чем писать запросы, окей? договорились\n" +
                " </body>\n" +
                "</html>");
        generator.close();
    }
}
