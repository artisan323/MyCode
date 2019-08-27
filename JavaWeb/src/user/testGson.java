package user;

import com.google.gson.Gson;

public class testGson {
    public static void main(String[] args) {
        user u = new user(1, "da", "sda");
        Gson g = new Gson();
        String s = g.toJson(u);
        System.out.println(s);
    }
}
