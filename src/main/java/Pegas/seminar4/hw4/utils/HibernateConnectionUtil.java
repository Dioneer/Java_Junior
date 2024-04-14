package Pegas.seminar4.hw4.utils;

import Pegas.seminar4.hw4.converter.DateConverter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnectionUtil {
    public static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAttributeConverter(DateConverter.class, true);
        return configuration.buildSessionFactory();
    }
}
