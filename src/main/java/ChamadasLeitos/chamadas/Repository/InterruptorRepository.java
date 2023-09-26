package ChamadasLeitos.chamadas.Repository;

import ChamadasLeitos.chamadas.Model.Interruptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterruptorRepository extends JpaRepository<Interruptor, Long> {
    Optional<Interruptor> findByInterruptor(String interruptor);
}

