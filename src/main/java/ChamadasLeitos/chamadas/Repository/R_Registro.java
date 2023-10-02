package ChamadasLeitos.chamadas.Repository;

import ChamadasLeitos.chamadas.Model.M_Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface R_Registro extends JpaRepository<M_Registro, Long> {
    List<M_Registro>findAll();
}


