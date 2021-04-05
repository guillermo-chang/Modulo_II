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
import mx.init.escuela.DAO.participanteDAO;

@RestController
@RequestMapping("api/participante")
public class participanteRest {
	
	@Autowired
	private participanteDAO ParticipanteDAO;

	@GetMapping
	public ResponseEntity<List<participante>> getAllParticipante(){
		List<participante> participantes = ParticipanteDAO.findAll();
		return ResponseEntity.ok(participantes);
	}
	
	@RequestMapping(value="{participanteId}") ///api/participante/{participanteID}
	public ResponseEntity<participante> getByIdParticipante(@PathVariable("participanteId") Integer participanteId){
		Optional<participante> optionalparticipante =ParticipanteDAO.findById(participanteId);
		
		if (optionalparticipante.isPresent()) {
			return ResponseEntity.ok(optionalparticipante.get());
		}else {
			return ResponseEntity.notFound().build();
		}		
	}


	@PostMapping
	public ResponseEntity<participante> postParticipante(@RequestBody participante participante){
		participante newparticipante = ParticipanteDAO.save(participante);
		return ResponseEntity.ok(newparticipante);		
	}
	
	@DeleteMapping(value="{participanteId}")
	public ResponseEntity<Void> deleteParticipante(@PathVariable("participanteId") Integer participanteId){
		Optional<participante> optionalparticipante =ParticipanteDAO.findById(participanteId);
		
		if (optionalparticipante.isPresent()) {
			ParticipanteDAO.deleteById(participanteId);
			return ResponseEntity.ok(null);			
		}else {
			return ResponseEntity.notFound().build();
		}		
	}
	
	@PutMapping
	public ResponseEntity<participante> putParticipante(@RequestBody participante participante){
		Optional<participante> optionalparticipante =ParticipanteDAO.findById(participante.getIdParticipante());
		
		if (optionalparticipante.isPresent()) {
			participante updateparticipante = optionalparticipante.get();
			updateparticipante.setNombre(participante.getNombre());
			updateparticipante.setEmail(participante.getEmail());
			updateparticipante.setObservaciones(participante.getObservaciones());
			updateparticipante.setFkidTurma(participante.getFkidTurma());
			ParticipanteDAO.save(updateparticipante);
			return ResponseEntity.ok(updateparticipante);
		}else {
			return ResponseEntity.notFound().build();
		}		
	}
	
}

