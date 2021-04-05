package mx.init.escuela.DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.init.escuela.entity.turma;

public interface turmaDAO extends JpaRepository<turma, Integer >  {

}
