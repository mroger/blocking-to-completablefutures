package br.org.roger.example.services;

import br.org.roger.example.model.StudentCourse;

import java.util.Random;

public class StudentCourseServiceImpl implements StudentCourseService {
    @Override
    public StudentCourse getByCodInstAndStudentArAndCourse() {

        Random r = new Random();

        try {
            Thread.sleep(r.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new StudentCourse();
    }
}
