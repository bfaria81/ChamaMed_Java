package ChamadasLeitos.chamadas.Service;

import ChamadasLeitos.chamadas.Model.M_Interruptor;
import ChamadasLeitos.chamadas.Model.M_Registro;
import ChamadasLeitos.chamadas.Repository.R_Interruptor;
import ChamadasLeitos.chamadas.Repository.R_Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class S_Interruptor {
    @Autowired
    private R_Interruptor r_interruptor;

    @Autowired
    private R_Registro r_registro;

    public List<M_Interruptor> listarInterruptores() {
        return r_interruptor.findAll();
    }

    public void alterarEstado(String interruptorNome) {
        Optional<M_Interruptor> interruptorOpt = r_interruptor.findByInterruptor(interruptorNome);

        if (interruptorOpt.isPresent()) {
            M_Interruptor m_interruptor = interruptorOpt.get();
            m_interruptor.setEstado(!m_interruptor.isEstado());
            r_interruptor.save(m_interruptor);

            M_Registro m_registro = new M_Registro();
            m_registro.setAcao(m_interruptor.isEstado() ? "Ligado" : "Desligado");
            m_registro.setData_hora(LocalDateTime.now());
            m_registro.setNome(m_interruptor.getInterruptor());
            r_registro.save(m_registro);
        }
    }
}