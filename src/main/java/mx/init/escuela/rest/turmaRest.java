package mx.init.escuela.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.init.escuela.entity.participante;
import mx.init.escuela.entity.turma;
import mx.init.escuela.DAO.turmaDAO;

@RestController
@RequestMapping("api/turma")
public class turmaRest {
	
	@Autowired
	private turmaDAO TurmaDAO;

	@GetMapping
	public ResponseEntity<List<turma>> getAllTurma(){
		List<turma> turma = TurmaDAO.findAll();
		return ResponseEntity.ok(turma);
	}
	
	@RequestMapping(value="{turmaId}") ///api/turma/{turmaID}
	public ResponseEntity<turma> getByIdTurma(@PathVariable("turmaId") Integer turmaId){
		Optional<turma> optionalturma = TurmaDAO.findById(turmaId);
		
		if (optionalturma.isPresent()) {
			return ResponseEntity.ok(optionalturma.get());
		}else {
			return ResponseEntity.notFound().build();
		}		
	}

	
	
}
