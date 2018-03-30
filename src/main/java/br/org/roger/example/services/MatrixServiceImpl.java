package br.org.roger.example.services;

import br.org.roger.example.model.Matrix;

import java.util.Random;

public class MatrixServiceImpl implements MatrixService {

    @Override
    public Matrix getMatrixById(Object matrixId) {

        Random r = new Random();

        try {
            Thread.sleep(r.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Matrix();
    }

}
