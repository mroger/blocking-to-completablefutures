package br.org.roger.example;

import br.org.roger.example.services.DisciplineService;
import br.org.roger.example.services.DisciplineServiceImpl;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        DisciplineService disciplineService = new DisciplineServiceImpl();

        long start = System.currentTimeMillis();

        disciplineService.dependencyDisciplines();

        long finish = System.currentTimeMillis();

        System.out.println("Time elapsed: " + (finish - start) / 1000.0 + " s");
    }

}
