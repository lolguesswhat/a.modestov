package utils;

import com.google.gson.Gson;
import dao.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public final class JsonUtils {

    private static final Gson gson = new Gson();

    public static boolean isStringJson(String jsonInString) {
        try {
            gson.fromJson(jsonInString, Object.class);
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

    public static User getUserFromJson(String path) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Gson().fromJson(bufferedReader, User.class);
    }
}
