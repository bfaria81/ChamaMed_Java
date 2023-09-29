package ChamadasLeitos.chamadas.Repository;

import ChamadasLeitos.chamadas.Model.M_Interruptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface R_Interruptor extends JpaRepository<M_Interruptor, Long> {
    Optional<M_Interruptor> findByInterruptor(String interruptor);
}

