package Pegas.seminar4.task1;

import Pegas.seminar4.models.enity.Student;
import Pegas.seminar4.models.dao.StudentDAO;
import Pegas.seminar4.models.utils.StudentsFactory;

import java.util.Collection;

public class Program {
    public static void main(String[] args) {
//        StudentDAO.createDatabase();
//        StudentDAO.useDatabase();
//        /**
//         * create
//         */
//        for (int i = 0; i < 7; i++) {
//            Student student = StudentsFactory.create();
//            StudentDAO.createStudent(student);
//        }
//        /**
//         * select
//         */
//        Collection<Student> arr = StudentDAO.selectAll();
//        System.out.println(arr);
//        /**
//         * update
//         */
//        for (Student i: arr){
//            StudentsFactory.updateAge(i);
//            StudentsFactory.updateName(i);
//            StudentDAO.updateStudent(i);
//        }
        /**
         * delete
         */
        System.out.println(StudentDAO.deleteById(1));
    }
}
