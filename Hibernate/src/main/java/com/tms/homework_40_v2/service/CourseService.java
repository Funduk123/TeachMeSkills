package com.tms.homework_40_v2.service;

import com.tms.homework_40_v2.domain.Course;
import com.tms.homework_40_v2.domain.Student;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService extends AbstractTeacherService {

    public void save(Student student) {
        Session session = getSession();

        session.save(student);

        closeSession(session);
    }

    public void addToCourse(Student student, Course course) {
        Session session = getSession();

        Course courseById = session.get(Course.class, course.getId());
        Student studentById = session.get(Student.class, student.getId());

        List<Student> students = courseById.getStudents();
        students.add(studentById);

        courseById.setStudents(students);

        closeSession(session);
    }

    public Course getCourse(Integer id) {
        Session session = getSession();

        Course course = session.find(Course.class, id);
        System.out.println("GET COURSE: " + course);

        closeSession(session);
        return course;
    }

    public void deleteFromCourse(Course course, Student student) {
        Session session = getSession();
        if (student.getId() == null) {
            System.out.println("This student is not on the course");
        } else {
            Course courseById = session.get(Course.class, course.getId());
            Student studentById = session.get(Student.class, student.getId());

            List<Student> students = courseById.getStudents();
            students.remove(studentById);
        }

        closeSession(session);
    }

}
