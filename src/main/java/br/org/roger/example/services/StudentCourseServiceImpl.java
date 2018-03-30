package br.org.roger.example.services;

import br.org.roger.example.model.StudentCourse;

public class StudentCourseServiceImpl implements StudentCourseService {
    @Override
    public StudentCourse getByCodInstAndStudentArAndCourse() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new StudentCourse();
    }
}
