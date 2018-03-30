package br.org.roger.example.services;

import br.org.roger.example.model.MMatrix;

import java.util.ArrayList;
import java.util.List;

public class MmatrixServiceImpl implements MmatrixService {
    @Override
    public List<MMatrix> getAllMatrixDisciplines(Object id, Integer nextStudentTerm) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
