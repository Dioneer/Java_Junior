package Pegas.seminar4.hw4;

import Pegas.seminar4.hw4.dao.UserDao;
import Pegas.seminar4.hw4.entity.Course;
import Pegas.seminar4.hw4.utils.HibernateConnectionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.reflect.Proxy;
import java.time.LocalTime;

public class QueryForBaseRepository {
    public static void main(String[] args) {
             /**
             * read by id
             */
            try (SessionFactory sessionFactory = HibernateConnectionUtil.buildSessionFactory()){
                Session session = (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(),
                        new Class[]{Session.class}, (proxy, method, args1) -> method.invoke(sessionFactory.getCurrentSession(), args1));

                session.beginTransaction();
                UserDao userDao = new UserDao(session);
                userDao.findById(1).ifPresent(System.out::println);
                userDao.findAll().forEach(System.out::println);
                userDao.delete(2);
                Course course = Course.builder()
                        .title("C#")
                        .duration(LocalTime.parse("02:15:00"))
                        .build();
                userDao.save(course);
                session.getTransaction().commit();
            }
        }
    }
