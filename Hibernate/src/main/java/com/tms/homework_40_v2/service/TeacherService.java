package com.tms.homework_40_v2.service;

import com.tms.homework_40_v2.domain.Course;
import com.tms.homework_40_v2.domain.Teacher;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService extends AbstractTeacherService {

    public void save(Teacher teacher) {
        Session session = getSession();

        List<Course> courses = teacher.getCourses();
        session.save(teacher);

        courses.forEach(session::save);
        courses.forEach(course -> course.setTeacher(teacher));

        closeSession(session);
    }

    public Teacher getTeacher(Integer id) {
        Session session = getSession();

        Teacher teacher = session.find(Teacher.class, id);
        System.out.println("GET TEACHER: " + teacher);

        closeSession(session);
        return teacher;
    }

    public void delete(Integer id) {
        Session session = getSession();

        Teacher teacher = session.find(Teacher.class, id);
        List<Course> courses = teacher.getCourses();
        System.out.println(courses);

        courses.forEach(session::delete);
        session.delete(teacher);

        closeSession(session);
    }
}
