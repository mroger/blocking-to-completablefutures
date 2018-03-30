package br.org.roger.example.services;

import br.org.roger.example.model.StudentGroup;

public class StudentGroupServiceImpl implements StudentGroupService {
    @Override
    public StudentGroup getByCodInstAndStudentAr() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new StudentGroup();
    }
}
