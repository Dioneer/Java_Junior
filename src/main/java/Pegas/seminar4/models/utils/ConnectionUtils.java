package Pegas.seminar4.models.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConnectionUtils {
    private static final Properties PROPERTIES = new Properties();

    static{
        load();
    }

    private static void load(){
        try (InputStream is = ConnectionUtils.class.getClassLoader().getResourceAsStream("application.properties")){
            PROPERTIES.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperties(String key){
        return PROPERTIES.getProperty(key);
    }
}
