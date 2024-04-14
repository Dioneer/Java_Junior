package Pegas.seminar4.models.dao;

import Pegas.seminar4.models.enity.Student;
import Pegas.seminar4.models.utils.ConnectionGet;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public final class StudentDAO {
    private static final String useDB = """
            Use studentsDB;
            """;
    private static final String createDB = """
            Create database if not exists studentsDB;
            """;
    private static final String createTable= """
            Create table if not exists students(
            id serial primary key,
            name varchar(255),
            age int
            );
            """;

    private static final String createStudent= """
            insert into students (name, age) values(?,?);
            """;

    private static final String selectAll= """
            select * from students;
            """;
    private static final String updateById= """
            update students set name=?, age=? where id=?;
            """;
    private static final String deleteById= """
            delete from students where id=?;
            """;

    public static void createDatabase(){
        try(Connection con = ConnectionGet.open()){
            PreparedStatement statement = con.prepareStatement(createDB);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void useDatabase(){
        try(Connection con = ConnectionGet.open()){
            PreparedStatement statement = con.prepareStatement(useDB);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createtable(){
        try(Connection con = ConnectionGet.open()){
            PreparedStatement statement = con.prepareStatement(createTable);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createStudent(Student student){
        try(Connection con = ConnectionGet.open()){
            PreparedStatement statement = con.prepareStatement(createStudent, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, student.getName());
            statement.setInt(2,student.getAge());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateStudent(Student student){
        try(Connection con = ConnectionGet.open()){
            PreparedStatement statement = con.prepareStatement(updateById);
            statement.setString(1, student.getName());
            statement.setInt(2,student.getAge());
            statement.setInt(3,student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Collection<Student> selectAll(){
        try(Connection con = ConnectionGet.open()){
            PreparedStatement statement = con.prepareStatement(selectAll);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Student> arr = new ArrayList<>();
            while (resultSet.next()){
                arr.add(buildStudent(resultSet));
            }
            return arr;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteById(int id){
        try(Connection con = ConnectionGet.open()){
            PreparedStatement statement = con.prepareStatement(deleteById);
            statement.setInt(1, id);
            return statement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static Student buildStudent(ResultSet resultSet) throws SQLException {
        return Student.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .age(resultSet.getInt("age"))
                .build();
    }
    private StudentDAO(){}
}
