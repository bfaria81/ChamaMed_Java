package ChamadasLeitos.chamadas.Service;


import ChamadasLeitos.chamadas.Model.M_Resposta;
import ChamadasLeitos.chamadas.Model.M_Usuario;
import ChamadasLeitos.chamadas.Repository.R_Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class S_Usuario_Implements implements S_Usuario_Interface{

    @Autowired
    private static R_Usuario r_usuario;

    public S_Usuario_Implements(R_Usuario r_usuario){this.r_usuario = r_usuario;}

    @Override
    public List<M_Usuario> getAllUsuario(){return r_usuario.findAll();}

    @Override
    public void saveUsuario(M_Usuario m_usuario){
        r_usuario.save(m_usuario);
    }

    @Override
    public M_Usuario getUsuarioById(Long id){
        Optional<M_Usuario> optional = r_usuario.findById((long) id);
        M_Usuario m_usuario = null;
        if(optional.isPresent()){
            m_usuario = optional.get();
        } else {
            throw new RuntimeException("Usuario não encontrado para o ID :: " + id);
        }
        return m_usuario;
    }

    @Override
    public void deleteUsuarioById(Long id) {this.r_usuario.deleteById((long)id);}

    @Override
    public Page<M_Usuario> findPaginatedUsuario(int pageNo, int pageSize, String sortField, String sortDirection){
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.r_usuario.findAll(pageable);
    }


    public static M_Usuario validaLogin(String matricula, String senha){
        matricula = S_Generico.limparNumero(matricula);

        if(S_Generico.campoVazio(matricula)){
            return null;
        } else if(S_Generico.campoVazio(senha)){
            return null;
        }
        return r_usuario.findByMatriculaESenha(Long.parseLong(matricula), senha);
    }

    public static M_Resposta cadastrarUsuario(String nome, String matricula, String cargo) {
        boolean podeSalvar = true;
        String mensagem = "";

        matricula = S_Generico.limparNumero(matricula);

        if (S_Generico.campoVazio(nome)) {
            podeSalvar = false;
            mensagem += "O Nome do usuário precisa ser informado !<br/>";
        }

        if (S_Generico.campoVazio(matricula)) {
            podeSalvar = false;
            mensagem += "O número do matrícula precisa ser informado !";
        }

        if (S_Generico.campoVazio(cargo)) {
            podeSalvar = false;
            mensagem += "O cargo precisa ser selecionado !";
        }


        if (podeSalvar) {
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setNome(nome);
            m_usuario.setMatricula(Long.parseLong(matricula));
            m_usuario.setCargo(Long.parseLong(cargo));
            m_usuario.setAtivo(true);
            m_usuario.setSenha(S_GeradorDeSenha.geradorDeSenha(5,3,2));

            try {
                r_usuario.save(m_usuario);
                mensagem += "Usuário cadastrado com Sucesso !";
            } catch (DataIntegrityViolationException e) {
                mensagem += "Erro ao cadastrar o Usuário no banco de dados: !";
                podeSalvar = false;
            }
        }
        M_Resposta m_resposta = new M_Resposta(podeSalvar, mensagem);
        return m_resposta;
    }








}
