import java.io.*;
import java.util.Scanner;

public class SendingRequestsToPage {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userReq = reader.readLine();
        switch (userReq) {
            case "/feed":
                generateFeed();
                break;
            case "/messages":
                generateMessages();
                break;
            default:
                generate404();
        }


    }

    private static void generateMessages() throws IOException {
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

    private static void generateFeed() throws IOException {
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
            feedGenerator.write( header+ "<br>" + description + "<br>" + content + "<br>" + "Автор поста: " + author + "<br>" + "Время создания: " + timeOfSending + "<br>");
        }
        feedGenerator.write(" </body>\n" +
                "</html>");
        feedGenerator.close();
        improvedWorm.close();
    }

    private static void generate404() throws IOException {
        FileWriter generator = null;
        try {
            generator = new FileWriter("404.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
