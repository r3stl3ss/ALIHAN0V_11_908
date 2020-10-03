package Services;

import Model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginService {
    static List<User> userList = new ArrayList<>();
    static {
        userList.add(new User("testuser","test"));
        userList.add(new User("coolnickname","alsocoolpassword"));
    }
    public boolean login(String username, String password){
        User userCandidate = new User(username, password);
        for(User user: userList){
            if(user.equals(userCandidate)) return true;
        }
        return false;
    }
}