package Pegas.lection4.util;

import java.sql.*;

public class Start {
    private static final String drop_db = """
                Drop schema if exists `test`;
                """;
    private static final String create_db = """
                Create schema if not exists `test`;
                """;
    private static final String create_table = """
                Create table if not exists `test`.`table`(`id` serial primary key,`firstname` varchar(45), `lastname` varchar(50));
                """;
    private static final String insert_table = """
               insert into `test`.`table`(`firstname`, `lastname`) values(?,?);
                """;
    private static final String select_table = """
               select `firstname` from `test`.`table` where `id`=?;
                """;
    public void createMethod(){
        try(Connection con = ConnectionDriver.open()){
            PreparedStatement statement1 = con.prepareStatement(drop_db);
            PreparedStatement statement2 = con.prepareStatement(create_db);
            PreparedStatement statement3 = con.prepareStatement(create_table);
            statement1.execute();
            statement2.execute();
            statement3.execute();
        }catch (SQLException q){
            throw new RuntimeException(q);
        }
    }
    public void updateMethod(){
        try(Connection con = ConnectionDriver.open()){
            PreparedStatement statement = con.prepareStatement(insert_table, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, "Sidorr");
            statement.setString(2, "Sidorovv");
            statement.executeUpdate();
        }catch (SQLException q){
            throw new RuntimeException(q);
        }
    }
    public void selectMethod(){
        try(Connection con = ConnectionDriver.open()){
            PreparedStatement statement = con.prepareStatement(select_table);
            statement.setLong(1, 5L);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("firstname"));
            }
        }catch (SQLException q){
            throw new RuntimeException(q);
        }
    }
}

