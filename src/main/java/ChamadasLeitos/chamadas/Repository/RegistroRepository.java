package ChamadasLeitos.chamadas.Repository;

import ChamadasLeitos.chamadas.Model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
    List<Registro>findAll();
}


