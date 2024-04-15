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
                    .duration(LocalTime.parse("03:15:00"))
                    .build();
            session.persist(course);
            session.close();
            session.getTransaction().commit();
        }
        /**
         * update
         */
        try(SessionFactory sessionFactory = HibernateConnectionUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Course course = session.get(Course.class, 7);
            course.setTitle("Java");
//            session.clear();
            session.getTransaction().commit();
        }
        /**
         * read
         */
        try(SessionFactory sessionFactory = HibernateConnectionUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            var course = session.createQuery("select c from Course c where c.id=11").list();
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
