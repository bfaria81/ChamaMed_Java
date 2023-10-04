package ChamadasLeitos.chamadas.Service;

import ChamadasLeitos.chamadas.Model.M_Interruptor;
import ChamadasLeitos.chamadas.Repository.R_Interruptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class S_Interruptor_Implements implements S_Interruptor_Interface {

    @Autowired
    private R_Interruptor r_interruptor;

    @Override
    public List<M_Interruptor> getAllInterruptor(){return r_interruptor.findAll();}

    @Override
    public void saveInterruptor(M_Interruptor m_interruptor){
        r_interruptor.save(m_interruptor);
    }

    @Override
    public M_Interruptor getInterruptorById(Long id){
        Optional<M_Interruptor> optional = r_interruptor.findById((long) id);
        M_Interruptor m_interruptor = null;
        if(optional.isPresent()){
            m_interruptor = optional.get();
        } else {
            throw new RuntimeException("Interruptor não encontrado para o ID :: " + id);
        }
        return m_interruptor;
    }

    @Override
    public void deleteInterruptorById(Long id) {this.r_interruptor.deleteById((long)id);}

    @Override
    public Page<M_Interruptor> findPaginatedInterruptor(int pageNo, int pageSize, String sortField, String sortDirection){
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.r_interruptor.findAll(pageable);
    }

}
