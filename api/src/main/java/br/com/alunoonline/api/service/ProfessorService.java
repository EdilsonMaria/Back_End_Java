package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public void create(Professor professor) {
        professorRepository.save(professor);
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Optional<Professor> findById(Long id) {
        return professorRepository.findById(id);
    }

    public void update(Long id, Professor professor) {
        Optional<Professor> professorFronDb = findById(id);
        if (professorFronDb.isEmpty()) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }

        Professor professorUpdated = professorFronDb.get();

        professorUpdated.setName(professor.getName());
        professorUpdated.setEmail(professor.getEmail());

        professorRepository.save(professorUpdated);
    }

    public void deleteById(Long id) { //DeleteById siguinifica dizer que vamos deletar pelo usurio, dessa forma o parametro adotado sera sempre o numero do ID
        professorRepository.deleteById(id);
    }





}
