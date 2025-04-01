package br.com.fiap.checkpoint1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.checkpoint1.dto.PacienteDTO;
import br.com.fiap.checkpoint1.model.Paciente;
import br.com.fiap.checkpoint1.service.PacienteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDTO> criarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteService.createPaciente(dtoToEntity(pacienteDTO));
        return ResponseEntity.status(201).body(entityToDTO(paciente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> atualizarPaciente(@PathVariable int id, @RequestBody PacienteDTO pacienteDTO) {
        Paciente pacienteAtualizado = pacienteService.updatePaciente(id, dtoToEntity(pacienteDTO));
        return pacienteAtualizado != null ? ResponseEntity.ok(entityToDTO(pacienteAtualizado))
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable int id) {
        boolean deletado = pacienteService.deletePaciente(id);
        return deletado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getPacienteById(@PathVariable int id) {
        Paciente paciente = pacienteService.getPacienteById(id);
        return paciente != null ? ResponseEntity.ok(entityToDTO(paciente)) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> getAllPacientes() {
        List<PacienteDTO> pacientes = pacienteService.getAllPacientes()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pacientes);
    }

   
    private Paciente dtoToEntity(PacienteDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setEndereco(dto.getEndereco());
        paciente.setBairro(dto.getBairro());
        paciente.setEmail(dto.getEmail());
        paciente.setTelefoneCompleto(dto.getTelefoneCompleto());
        return paciente;
    }

   
    private PacienteDTO entityToDTO(Paciente paciente) {
        return new PacienteDTO(
                paciente.getNome(),
                paciente.getEndereco(),
                paciente.getBairro(),
                paciente.getEmail(),
                paciente.getTelefoneCompleto());
    }
}
