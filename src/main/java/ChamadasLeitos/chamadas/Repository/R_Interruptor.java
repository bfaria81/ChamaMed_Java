package ChamadasLeitos.chamadas.Repository;

import ChamadasLeitos.chamadas.Model.M_Interruptor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface R_Interruptor extends JpaRepository<M_Interruptor, Long> {
    Optional<M_Interruptor> findByInterruptor(String interruptor);

    List<M_Interruptor> findAllByAtivoTrue();
    List<M_Interruptor> findByAtivoFalse();

    Page<M_Interruptor>findAll(Specification<M_Interruptor>mInterruptorSpecification, Pageable pageable);
}

