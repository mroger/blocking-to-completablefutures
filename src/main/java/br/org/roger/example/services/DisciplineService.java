package br.org.roger.example.services;

import br.org.roger.example.model.Discipline;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface DisciplineService {

    List<Discipline> dependencyDisciplines() throws ExecutionException, InterruptedException;

}
