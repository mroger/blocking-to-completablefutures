package br.org.roger.example.services;

import java.util.Random;

public class StudentTermServiceImpl implements StudentTermService {
    @Override
    public Integer nextTerm(Object cod) {

        Random r = new Random();

        try {
            Thread.sleep(r.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
