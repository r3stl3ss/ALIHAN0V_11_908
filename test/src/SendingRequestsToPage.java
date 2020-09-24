import java.io.*;
import java.util.regex.*;

public class SendingRequestsToPage {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userReq = reader.readLine();
        switch (userReq) {
            case "/feed":
                PageGenerator.generateFeed();
                break;
            case "/messages":
                PageGenerator.generateMessages();
                break;
            default:
                if (userReq.matches("/id/.")) {
                    long userID = Long.parseLong(userReq.substring(4)); // по какой-то причине парсер не работает, выкидывает ошибку( кто-нибудь может объяснить, в чём дело? а остальной функционал вроде как написан верно
                    PageGenerator.generateUserPage(userID);
                }
                else {
                    PageGenerator.generate404();
                }
        }
    }
}
