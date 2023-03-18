package com.tms.homework_38.service;

import com.tms.homework_38.domain.Course;
import com.tms.homework_38.domain.Teacher;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService extends AbstractTeacherService {

    private final SessionFactory factory;

    public void save(Teacher teacher) {
        Session session = getSession();

        session.save(teacher);

        Course course = teacher.getCourse();
        course.setTeacher(teacher);

        session.save(course);

        System.out.println("-------------------------");
        System.out.println("TEACHER WAS SAVED");
        System.out.println("-------------------------");

        closeSession(session);
    }

    public Teacher getTeacher(Integer id) {
        Session session = getSession();

        Teacher teacher = session.find(Teacher.class, id);

        closeSession(session);

        return teacher;
    }

    public void delete(Integer id) {
        Session session = getSession();

        Teacher teacher = session.find(Teacher.class, id);
        Course course = session.find(Course.class, id);
        session.delete(teacher);
        session.delete(course);

        System.out.println("-------------------------");
        System.out.println("TEACHER " + teacher.getId() + " WAS DELETE");
        System.out.println("-------------------------");

        closeSession(session);
    }

    public Course getCourse(Integer id) {
        Session session = getSession();

        Course course = session.find(Course.class, id);

        closeSession(session);

        return course;
    }

}
