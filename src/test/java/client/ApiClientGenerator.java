package client;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import static utils.propertiesReader.ReaderGetter.*;

public class ApiClientGenerator {

    public static <T> T getClient(Class<T> tClass) {
        return Feign
                .builder()
                .contract(new SpringMvcContract())
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.NONE)
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .target(tClass, getConfigsReader().uri());
    }
}
