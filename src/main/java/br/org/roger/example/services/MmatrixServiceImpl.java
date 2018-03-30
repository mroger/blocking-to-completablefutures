package br.org.roger.example.services;

import br.org.roger.example.model.MMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MmatrixServiceImpl implements MmatrixService {
    @Override
    public List<MMatrix> getAllMatrixDisciplines(Object id) {

        Random r = new Random();

        try {
            Thread.sleep(r.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
