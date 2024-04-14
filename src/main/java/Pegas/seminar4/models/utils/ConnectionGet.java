package Pegas.seminar4.models.utils;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionGet {

    private static void connectionDriver(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static {
        connectionDriver();
    }
    @SneakyThrows
    public static Connection open(){
        return DriverManager.getConnection(ConnectionUtils.getProperties("db.url"),
                ConnectionUtils.getProperties("db.user"),
                ConnectionUtils.getProperties("db.password"));
    }
    private ConnectionGet(){}
}
