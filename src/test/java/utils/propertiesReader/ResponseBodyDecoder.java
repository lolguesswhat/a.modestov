package utils.propertiesReader;

import feign.Response;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ResponseBodyDecoder {
    public static String decode(Response response) {
        String str = null;
        try {
            str = IOUtils.toString(response.body().asInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
