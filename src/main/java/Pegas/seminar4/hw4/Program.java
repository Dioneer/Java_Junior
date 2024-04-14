package Pegas.seminar4.hw4;

import Pegas.seminar4.hw4.entity.Course;
import Pegas.seminar4.hw4.utils.HibernateConnectionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalTime;

public class Program {
    public static void main(String[] args) {
        /**
         * create
         */
        try(SessionFactory sessionFactory = HibernateConnectionUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Course course = Course.builder()
                    .title("Chemistry")
                    .duration(LocalTime.of(2,15, 0))
                    .build();
            session.persist(course);
            session.getTransaction().commit();
        }
        /**
         * update
         */
        try(SessionFactory sessionFactory = HibernateConnectionUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Course course = session.get(Course.class, 3);
            course.setTitle("Java");
            session.update(course);
            session.getTransaction().commit();
        }
        /**
         * read
         */
        try(SessionFactory sessionFactory = HibernateConnectionUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Course course = session.get(Course.class, 3);
            System.out.println(course);
            session.getTransaction().commit();
        }
        /**
         * delete
         */
        try(SessionFactory sessionFactory = HibernateConnectionUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Course course = session.get(Course.class, 4);
            session.remove(course);
            session.getTransaction().commit();
        }
    }
}
