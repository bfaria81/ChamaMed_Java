package ChamadasLeitos.chamadas.Service;

import ChamadasLeitos.chamadas.Model.Registro;
import ChamadasLeitos.chamadas.Repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistroService {
    @Autowired
    private RegistroRepository registroRepository;

    public void salvarRegistro(Registro registro) {
        registroRepository.save(registro);
    }

    public List<Registro> listarTodosRegistros() {
        return registroRepository.findAll();
    }
}
