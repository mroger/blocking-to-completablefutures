package br.org.roger.example.services;

import br.org.roger.example.model.StudentGroup;

import java.util.Random;

public class StudentGroupServiceImpl implements StudentGroupService {
    @Override
    public StudentGroup getByCodInstAndStudentAr() {

        Random r = new Random();

        try {
            Thread.sleep(r.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new StudentGroup();
    }
}
