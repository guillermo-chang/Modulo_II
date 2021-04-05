package mx.init.escuela.DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.init.escuela.entity.participante;

public interface participanteDAO extends JpaRepository<participante, Integer > {

}