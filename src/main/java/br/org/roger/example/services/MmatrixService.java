package br.org.roger.example.services;

import br.org.roger.example.model.MMatrix;

import java.util.List;

public interface MmatrixService {

    List<MMatrix> getAllMatrixDisciplines(Object id, Integer nextStudentTerm);

}
