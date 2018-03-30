package br.org.roger.example.services;

import br.org.roger.example.model.Registration;

import java.util.List;

public interface RegistrationService {

    List<Registration> studentRegisteredDisciplines(Object code);

}
