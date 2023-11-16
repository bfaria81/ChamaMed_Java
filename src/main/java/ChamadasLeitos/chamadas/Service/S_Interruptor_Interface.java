package ChamadasLeitos.chamadas.Service;

import ChamadasLeitos.chamadas.Model.M_Interruptor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface S_Interruptor_Interface {

   List<M_Interruptor> getAllInterruptor();

 List<M_Interruptor> getInterruptoresInativos();

 void saveInterruptor(M_Interruptor m_interruptor);
    M_Interruptor getInterruptorById(Long id);
    void deleteInterruptorById(Long id);

    List<M_Interruptor>getInterruptoresAtivos();

    Page<M_Interruptor>findPaginatedInterruptor(int pageNo, int pageSize, String sortField, String sortDirection);

}
