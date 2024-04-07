package Pegas.seminar2.task2;

import java.util.UUID;

public class Program {
    public static void main(String[] args) throws IllegalAccessException {
        Employee user = new Employee(UUID.randomUUID(), "Elena", "Joy@bk.com");
        QueryBuilder queryBuilder = new QueryBuilder();
        String query = queryBuilder.buildInsertQuery(user);
        String query1 = queryBuilder.buildSelectQuery(Employee.class, UUID.fromString("779377f9-fa9e-4def-8611-62c090393a3d"));
        String query2 = queryBuilder.buildUpdateQuery(user, UUID.fromString("779377f9-fa9e-4def-8611-62c090393a3d"));
        String query3 = queryBuilder.buildDeleteQuery(user, UUID.fromString("779377f9-fa9e-4def-8611-62c090393a3d"));
        System.out.println(query);
        System.out.println(query1);
        System.out.println(query2);
        System.out.println(query3);
    }
}
