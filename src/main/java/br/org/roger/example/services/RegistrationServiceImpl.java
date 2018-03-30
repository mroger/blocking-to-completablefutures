package br.org.roger.example.services;

import br.org.roger.example.model.Registration;

import java.util.List;
import java.util.Random;

public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public List<Registration> studentRegisteredDisciplines(Object code) {

        Random r = new Random();

        try {
            Thread.sleep(r.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
