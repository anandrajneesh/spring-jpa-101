package com.gluecoders.databasesqlexample.runners;

import com.gluecoders.databasesqlexample.dao.CourseDao;
import com.gluecoders.databasesqlexample.dao.StudentDao;
import com.gluecoders.databasesqlexample.models.Course;
import com.gluecoders.databasesqlexample.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class SimpleManyToManyExampleRunner implements CommandLineRunner {

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private StudentDao studentDao;

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student();
        student1.setName("xx");

        Student student2 = new Student();
        student2.setName("yy");

        Course physics = new Course();
        physics.setName("physics");
        Course biology = new Course();
        biology.setName("biology");
        Course chemistry = new Course();
        chemistry.setName("chemistry");
        Course maths = new Course();
        maths.setName("maths");

        courseDao.save(physics);
        courseDao.save(maths);
        courseDao.save(chemistry);
        courseDao.save(biology);

        studentDao.save(student1);
        studentDao.save(student2);

        if(student1.getLikedCourses() == null){
            student1.setLikedCourses(new HashSet<>());
        }
        student1.getLikedCourses().add(physics);
        student1.getLikedCourses().add(maths);

        if(student2.getLikedCourses() == null){
            student2.setLikedCourses(new HashSet<>());
        }
        student2.getLikedCourses().add(chemistry);
        student2.getLikedCourses().add(biology);

        studentDao.save(student1);
        studentDao.save(student2);

        Student xx = studentDao.findById(student1.getId()).get();
        xx.getLikedCourses().forEach(course -> System.out.println(xx.getName()+" likes "+ course.getName()));

        Student yy = studentDao.findById(student2.getId()).get();
        yy.getLikedCourses().forEach(course -> System.out.println(yy.getName()+" likes "+ course.getName()));
    }
}
