package Pegas.seminar4.hw4.dao;

import Pegas.seminar4.hw4.entity.Course;
import jakarta.persistence.EntityManager;

public class UserDao extends BaseRepository<Integer, Course>{
    public UserDao(EntityManager entityManager) {
        super(Course.class, entityManager);
    }

}
