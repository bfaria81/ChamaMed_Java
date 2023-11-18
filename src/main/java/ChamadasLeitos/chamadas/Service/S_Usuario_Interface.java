package ChamadasLeitos.chamadas.Service;

import ChamadasLeitos.chamadas.Model.M_Usuario;
import ChamadasLeitos.chamadas.Repository.R_Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

public interface S_Usuario_Interface {

    List<M_Usuario> getAllUsuario();
    void saveUsuario(M_Usuario m_usuario);
    M_Usuario getUsuarioById(Long id);
    void deleteUsuarioById(Long id);

    List<M_Usuario>getUsuariosInativos();

    List<M_Usuario>getUsuariosAtivos();


}



