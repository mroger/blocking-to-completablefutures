package br.org.roger.example.services;

import br.org.roger.example.model.Registration;

import java.util.List;

public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public List<Registration> studentRegisteredDisciplines(Object code) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
