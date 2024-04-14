package Pegas.seminar4.task2;

import Pegas.seminar4.task2.utils.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import Pegas.seminar4.models.enity.Student;

public class Program {
    public static void main(String[] args) {
//        /**
//         * selectById
//         */
//       try (SessionFactory sessionFactory = HibernateConnection.buildSessionFactory();
//            Session session = sessionFactory.openSession()){
//            session.beginTransaction();
//            Student student = session.get(Student.class, 2);
//           System.out.println(student);
//            session.getTransaction().commit();
//       }
//        /**
//         * create
//         */
//        try (SessionFactory sessionFactory = HibernateConnection.buildSessionFactory();
//             Session session = sessionFactory.openSession()){
//            session.beginTransaction();
//            Student student = Student.builder()
//                    .age(44)
//                    .name("Igor")
//                    .build();
//            session.persist(student);
//            session.getTransaction().commit();
//        }
//        /**
//         * uodate
//         */
//        try (SessionFactory sessionFactory = HibernateConnection.buildSessionFactory();
//             Session session = sessionFactory.openSession()){
//            session.beginTransaction();
//            Student student = session.get(Student.class, 14);
//            student.setName("Trorin");
//            session.persist(student);
//            session.getTransaction().commit();
//        }
//        /**
//         * delete
//         */
//        try (SessionFactory sessionFactory = HibernateConnection.buildSessionFactory();
//             Session session = sessionFactory.openSession()){
//            session.beginTransaction();
//            Student student = session.get(Student.class, 11);
//            session.remove(student);
//            session.getTransaction().commit();
//        }
    }

}
