package utils;

import com.google.gson.Gson;
import feign.Response;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public final class JsonUtils {

    private static final Gson gson = new Gson();

    public static boolean isBodyJson(String jsonInString) {
        try {
            gson.fromJson(jsonInString, Object.class);
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

    public static <T> T getPojoFromFile(String path, Class<T> tClass) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert bufferedReader != null;
        return new Gson().fromJson(bufferedReader, tClass);
    }

    public static <T> T getPojo(Response response, Class<T> tClass) {
        T list = null;
        try {
            list = gson.fromJson(IOUtils.toString(response.body().asInputStream(), StandardCharsets.UTF_8), tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <T> List<T> getListOfPojo(Response response, Class<T[]> tClass) {
        T[] list = null;
        try {
            list = gson.fromJson(IOUtils.toString(response.body().asInputStream(), StandardCharsets.UTF_8), tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Arrays.asList(list);
    }
}
