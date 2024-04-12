package Pegas.lection4.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionUtil {
    private static final Properties PROPERTIES = new Properties();

    private static void loadProperties(){
        try(InputStream is = ConnectionUtil.class.getClassLoader().getResourceAsStream("application.properties")){
            PROPERTIES.load(is);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    static{
        loadProperties();
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }
}