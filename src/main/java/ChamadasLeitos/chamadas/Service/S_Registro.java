package ChamadasLeitos.chamadas.Service;

import ChamadasLeitos.chamadas.Model.M_Registro;
import ChamadasLeitos.chamadas.Repository.R_Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Registro {
    @Autowired
    private R_Registro r_registro;

    public void salvarRegistro(M_Registro m_registro) {
        r_registro.save(m_registro);
    }

    public List<M_Registro> listarTodosRegistros() {
        return r_registro.findAll();
    }
}
