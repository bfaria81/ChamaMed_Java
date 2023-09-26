package ChamadasLeitos.chamadas.Service;

import ChamadasLeitos.chamadas.Model.Interruptor;
import ChamadasLeitos.chamadas.Model.Registro;
import ChamadasLeitos.chamadas.Repository.InterruptorRepository;
import ChamadasLeitos.chamadas.Repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InterruptorService {
    @Autowired
    private InterruptorRepository interruptorRepository;

    @Autowired
    private RegistroRepository registroRepository;

    public List<Interruptor> listarInterruptores() {
        return interruptorRepository.findAll();
    }

    public void alterarEstado(String interruptorNome) {
        Optional<Interruptor> interruptorOpt = interruptorRepository.findByInterruptor(interruptorNome);

        if (interruptorOpt.isPresent()) {
            Interruptor interruptor = interruptorOpt.get();
            interruptor.setEstado(!interruptor.isEstado());
            interruptorRepository.save(interruptor);

            Registro registro = new Registro();
            registro.setAcao(interruptor.isEstado() ? "Ligado" : "Desligado");
            registro.setData_hora(LocalDateTime.now());
            registroRepository.save(registro);
        }
    }
}
