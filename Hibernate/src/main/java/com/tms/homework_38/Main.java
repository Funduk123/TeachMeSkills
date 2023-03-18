package com.tms.homework_38;

import com.tms.homework_38.domain.Address;
import com.tms.homework_38.domain.Course;
import com.tms.homework_38.domain.Teacher;
import com.tms.homework_38.service.TeacherService;
import com.tms.homework_38.domain.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.tms.homework_38");
        TeacherService teacherService = context.getBean(TeacherService.class);

        Teacher teacher1 = Teacher.builder()
                .firstName("Sergey")
                .secondName("Makarov")
                .practice(true)
                .role(Role.CORRESPONDENCE)
                .beginLesson(new Date())
                .address(new Address("Vitebsk", "street1", 1, 1))
                .course(new Course("Java"))
                .build();

        Teacher teacher2 = Teacher.builder()
                .firstName("Danila")
                .secondName("Rebkovets")
                .practice(true)
                .role(Role.FULL_TIME)
                .beginLesson(new Date())
                .address(new Address("Brest", "street2", 2, 2))
                .course(new Course("Mathematics"))
                .build();

        Teacher teacher3 = Teacher.builder()
                .firstName("Alesya")
                .secondName("Vasyukevich")
                .practice(false)
                .role(Role.FULL_TIME)
                .beginLesson(new Date())
                .address(new Address("Minsk", "street3", 3, 3))
                .course(new Course("Chemistry"))
                .build();

        teacherService.save(teacher1);
        teacherService.save(teacher2);
        teacherService.save(teacher3);

        System.out.println("-------------------------------------------------------------------");

        Teacher getTeacher = teacherService.getTeacher(2);
        System.out.println("GET TEACHER: " + getTeacher);

        Course getCourse = teacherService.getCourse(2);
        System.out.println("GET COURSE: " + getCourse);

        teacherService.delete(1);
    }
}
