package br.org.roger.example.services;

import br.org.roger.example.model.Matrix;

public class MatrixServiceImpl implements MatrixService {

    @Override
    public Matrix getMatrixById(Object matrixId) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Matrix();
    }

}
