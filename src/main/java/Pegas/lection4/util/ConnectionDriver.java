package Pegas.lection4.util;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDriver {

    private static void connectionDriver(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static{
        connectionDriver();
    }

    @SneakyThrows
    public static Connection open() {
        return DriverManager.getConnection(ConnectionUtil.get("db.url"),
                ConnectionUtil.get("db.user"),
                ConnectionUtil.get("db.password"));
    }

    private ConnectionDriver(){}
}
