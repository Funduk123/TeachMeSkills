package com.tms.homework_40_v2;

import com.tms.homework_40_v2.domain.*;
import com.tms.homework_40_v2.service.CourseService;
import com.tms.homework_40_v2.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.tms.homework_40_v2");
        TeacherService teacherService = context.getBean(TeacherService.class);
        CourseService courseService = context.getBean(CourseService.class);

        Course course1 = new Course("Spring");
        Course course2 = new Course("Hibernate");
        Course course3 = new Course("Math");
        Course course4 = new Course("Info");
        Course course5 = new Course("Bio");
        Course course6 = new Course("Him");


        Teacher teacher1 = Teacher.builder()
                .firstName("Sergey")
                .secondName("Makarov")
                .practice(true)
                .role(Role.CORRESPONDENCE)
                .beginLesson(new Date())
                .address(new Address("Vitebsk", "street1", 1, 1))
                .courses(List.of(course1, course2))
                .build();

        Teacher teacher2 = Teacher.builder()
                .firstName("Danila")
                .secondName("Rebkovets")
                .practice(true)
                .role(Role.FULL_TIME)
                .beginLesson(new Date())
                .address(new Address("Brest", "street2", 2, 2))
                .courses(List.of(course3, course4))
                .build();

        Teacher teacher3 = Teacher.builder()
                .firstName("Alesya")
                .secondName("Vasyukevich")
                .practice(false)
                .role(Role.FULL_TIME)
                .beginLesson(new Date())
                .address(new Address("Minsk", "street3", 3, 3))
                .courses(List.of(course5, course6))
                .build();

        teacherService.save(teacher1);
        teacherService.save(teacher2);
        teacherService.save(teacher3);

        System.out.println("-------------------------------------------------------------------");

        Student student1 = Student.builder()
                .firstName("qwe")
                .secondName("asd")
                .courses(List.of(course1))
                .role(Role.FULL_TIME)
                .build();

        Student student2 = Student.builder()
                .firstName("qwe")
                .secondName("asd")
                .courses(List.of(course1))
                .role(Role.FULL_TIME)
                .build();

        courseService.save(student1);
        courseService.save(student2);

        courseService.addToCourse(student1, course1);
        courseService.addToCourse(student2, course1);

        courseService.addToCourse(student1, course2);
        courseService.addToCourse(student2, course2);

        System.out.println("-------------------------------------------------------------------");

        Course course = courseService.getCourse(1);

        courseService.deleteFromCourse(course1, student2);

        Teacher teacher = teacherService.getTeacher(1);

        teacherService.delete(1);
    }
}
