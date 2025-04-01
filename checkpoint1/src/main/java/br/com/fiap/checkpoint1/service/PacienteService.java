package br.com.fiap.checkpoint1.service;

import org.springframework.stereotype.Service;


import br.com.fiap.checkpoint1.model.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    private List<Paciente> pacientes = new ArrayList<>();
    private Long idCounter = 1L;

    public Paciente createPaciente(Paciente dto) {
        Paciente paciente = new Paciente();
        paciente.setId(idCounter++);
        paciente.setNome(dto.getNome());
        paciente.setBairro(dto.getBairro());
        paciente.setEmail(dto.getEmail());
        paciente.setTelefoneCompleto(dto.getTelefoneCompleto());
        pacientes.add(paciente);
        return paciente;
    }

    public Paciente updatePaciente(int id, Paciente pacienteAtualizado) {
        for (Paciente p : pacientes) {
            if (p.getId() == id) {
                p.setNome(pacienteAtualizado.getNome());
                p.setEndereco(pacienteAtualizado.getEndereco());
                p.setBairro(pacienteAtualizado.getBairro());
                p.setEmail(pacienteAtualizado.getEmail());
                p.setTelefoneCompleto(pacienteAtualizado.getTelefoneCompleto());
                return p;
            }
        }
        return null;
    }

    public boolean deletePaciente(int id) {
        return pacientes.removeIf(p -> p.getId() == id);
    }

    public Paciente getPacienteById(int id) {
        Optional<Paciente> paciente = pacientes.stream().filter(p -> p.getId() == id).findFirst();
        return paciente.orElse(null);
    }

    public List<Paciente> getAllPacientes() {
        return pacientes;
    }
}
