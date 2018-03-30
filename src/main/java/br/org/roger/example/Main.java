package br.org.roger.example;

import br.org.roger.example.services.DisciplineService;
import br.org.roger.example.services.DisciplineServiceImpl;

public class Main {

    public static void main(String[] args) {

        DisciplineService disciplineService = new DisciplineServiceImpl();

        long start = System.currentTimeMillis();

        disciplineService.retornaDisciplinasDependencia();

        long finish = System.currentTimeMillis();

        System.out.println("Time elapsed: " + (finish - start) / 1000.0 + " s");
    }

}
