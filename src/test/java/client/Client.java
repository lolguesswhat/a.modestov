package client;

import adapter.JSONPlaceholder;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import static utils.propertiesReader.ReaderGetter.*;

public class Client {

    public static JSONPlaceholder runFeign() {
        return Feign
                .builder()
                .contract(new SpringMvcContract())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .target(JSONPlaceholder.class, getConfigsReader().uri());
    }
}
