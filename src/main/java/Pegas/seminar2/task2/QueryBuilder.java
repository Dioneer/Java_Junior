package Pegas.seminar2.task2;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class QueryBuilder {

    public String buildInsertQuery(Object obj) {
        Class<?> clazz = obj.getClass();
        StringBuilder query = new StringBuilder("INSERT INTO ");

        String tableName = Optional.ofNullable(clazz.getAnnotation(Table.class))
                .map(Table::name).orElse(obj.getClass().getName());

        query.append(tableName);

        Field[] fields = clazz.getDeclaredFields();
        String fieldName = Arrays.stream(fields).filter(i -> i.isAnnotationPresent(Column.class))
                .map(i -> i.getAnnotation(Column.class))
                .map(Column::name).collect(Collectors.joining(",", " (", ""));

        for (Field f : fields) {
            f.setAccessible(true);
        }
        query.append(fieldName);

        String fieldValue = Arrays.stream(fields).map(i -> {
            try {
                return i.get(obj);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).map(Object::toString).collect(Collectors.joining(",", ") values (", ")"));

        query.append(fieldValue);

        return query.toString();
    }
    public String buildSelectQuery(Class<?> clazz, UUID primaryKey){
        StringBuilder query = new StringBuilder("Select * from ");

        String tableName = Optional.ofNullable(clazz.getAnnotation(Table.class))
                .map(Table::name).orElse(clazz.getName());
        query.append(tableName);

        Field[] fields = clazz.getDeclaredFields();
        String where = Arrays.stream(fields).filter(i->i.isAnnotationPresent(Column.class))
                .map(i->i.getAnnotation(Column.class))
                .filter(Column::primaryKey)
                .map(Column::name)
                .collect(Collectors.joining( "", " where '", "'= "));
        query.append(where).append(primaryKey);

        return query.toString();
    }
    public String buildUpdateQuery(Object obj, UUID primaryKey) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder query = new StringBuilder("update ");

        String tableName = Optional.ofNullable(clazz.getAnnotation(Table.class))
                .map(Table::name).orElse(clazz.getName());
        query.append(tableName).append(" ");

        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields) {
            if(f.isAnnotationPresent(Column.class)) {
                f.setAccessible(true);
                Column c = f.getAnnotation(Column.class);
                if(c.primaryKey()){
                    continue;
                }
                query.append(c.name()).append(" = '").append(f.get(obj)).append("', ");
            }
        }
        if(query.charAt(query.length()-2)==','){
            query.delete(query.length()-2, query.length());
        }

        String where = Arrays.stream(fields).filter(i->i.isAnnotationPresent(Column.class))
                .map(i->i.getAnnotation(Column.class))
                .filter(Column::primaryKey)
                .map(Column::name)
                .collect(Collectors.joining( "", " where '", "'= "));
        query.append(where).append(primaryKey);

        return query.toString();
    }

    public String buildDeleteQuery(Object obj, UUID primaryKey){
        Class<?> clazz = obj.getClass();
        StringBuilder query = new StringBuilder("delete from ");

        String tableName = Optional.ofNullable(clazz.getAnnotation(Table.class)).map(Table::name)
                .orElse(clazz.getName());
        query.append(tableName);

        Field[] fields = clazz.getDeclaredFields();
        String where = Arrays.stream(fields).filter(i->i.isAnnotationPresent(Column.class))
                .map(i->i.getAnnotation(Column.class))
                .filter(Column::primaryKey)
                .map(Column::name)
                .collect(Collectors.joining(""," where '", "'="));
        query.append(where).append(primaryKey);

        return query.toString();
    }

}
