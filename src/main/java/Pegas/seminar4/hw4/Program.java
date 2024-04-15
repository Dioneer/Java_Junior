package Pegas.seminar4.hw4;

import Pegas.seminar4.hw4.entity.Course;
import Pegas.seminar4.hw4.utils.HibernateConnectionUtil;
import jakarta.persistence.LockModeType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.management.Query;
import java.time.LocalTime;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        /**
         * create
         */
        try(SessionFactory sessionFactory = HibernateConnectionUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.createNativeQuery("SET TRANSACTION READ ONLY;");
            Course course = Course.builder()
                    .title("Literature")
                    .duration(LocalTime.parse("02:00:00"))
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
            Integer id=3;
            var cd = session.getCriteriaBuilder();
            var criteria = cd.createQuery(Course.class);
            var course = criteria.from(Course.class);
            criteria.select(course).where(cd.equal(course.get("id"), id));
            List<Course> arr = session.createQuery(criteria).list();
            for (Course i: arr){
                i.setTitle("Java");
            }
            session.getTransaction().commit();
        }
        try(SessionFactory sessionFactory = HibernateConnectionUtil.buildSessionFactory();
            Session session = sessionFactory.openSession();Session session1 = sessionFactory.openSession()){
            session.beginTransaction();
            session1.beginTransaction();

            Course course = session.find(Course.class, 2, LockModeType.OPTIMISTIC);
            course.setTitle("PHP");

            Course course1 = session1.find(Course.class, 2, LockModeType.OPTIMISTIC);
            course1.setTitle("Kotlin");

            session.getTransaction().commit();
            session1.getTransaction().commit();
        }
        /**
         * read
         */
        try(SessionFactory sessionFactory = HibernateConnectionUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            String title = "Java";
            var course = session.createQuery("""
                            select c from Course c
                             where c.title=:title
                            """)
                    .setParameter("title", title)
                    .list();
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
