package br.org.roger.example.services;

public class StudentTermServiceImpl implements StudentTermService {

    @Override
    public Integer nextTerm(Integer cod) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return cod;
    }
}
