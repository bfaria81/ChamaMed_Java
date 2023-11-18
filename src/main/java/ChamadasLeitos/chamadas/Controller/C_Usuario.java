package ChamadasLeitos.chamadas.Controller;


import ChamadasLeitos.chamadas.Model.M_Resposta;
import ChamadasLeitos.chamadas.Model.M_Usuario;
import ChamadasLeitos.chamadas.Service.S_Usuario_Implements;
import ChamadasLeitos.chamadas.Service.S_Usuario_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
    @Controller
    public class C_Usuario {
    @Autowired
    private S_Usuario_Interface s_usuario_interface;

    private boolean mostrarInativos = false;


    @GetMapping("/showUsuario")
    public String viewHomePageUsuario(Model model) {
    List<M_Usuario> usuariosList = s_usuario_interface.getAllUsuario();
    model.addAttribute("usuariosList", usuariosList);
    return "Usuario/usuario";
}

    @GetMapping("/showUsuarioAtivo")
    public String viewHomePageUsuarioInativo(Model model){
        List<M_Usuario> usuariosList = s_usuario_interface.getUsuariosAtivos();
        model.addAttribute("usuariosList", usuariosList);
        return"Usuario/usuario_ativo";
    }



    @GetMapping("/mostrarInativos")
    public String mostrarInativos() {
        mostrarInativos = true;
        return "redirect:/showUsuario";
    }

    @GetMapping("/mostrarAtivos")
    public String mostrarAtivos() {
        mostrarInativos = false;
        return "redirect:/showUsuarioAtivo";
    }


    @GetMapping("/showNewUsuarioForm")
    public String showNewUsuarioForm(Model model){
        M_Usuario m_usuario = new M_Usuario();
        model.addAttribute("usuario", m_usuario);
        return "New_Usuario/new_usuario";
    }


    @PostMapping("/saveUsuario")
    public String saveUsuario(@RequestParam("nome") String nome,
                              @RequestParam("matricula")  String matricula,
                              @RequestParam("cargo")  String cargo,
                              RedirectAttributes redirectAttributes){
        M_Resposta m_resposta = S_Usuario_Implements.cadastrarUsuario(nome, matricula, cargo);
        if (m_resposta.getStatus()){
            redirectAttributes.addFlashAttribute("mensagem", m_resposta.getMensagem());
            return "redirect:/showUsuarioAtivo";
        } else {
            redirectAttributes.addFlashAttribute("mensagem", m_resposta.getMensagem());
            redirectAttributes.addFlashAttribute("nome", nome);
            redirectAttributes.addFlashAttribute("matricula", matricula);
            redirectAttributes.addFlashAttribute("cargo", cargo);
            return "redirect:/showNewUsuarioForm";
        }
    }

    @GetMapping("/showFormForUpdateUsuario/{id}")
    public String showFormForUpdateUsuario(@PathVariable(value = "id")long id, Model model){
        M_Usuario m_usuario = s_usuario_interface.getUsuarioById(id);

        if(m_usuario != null){
            model.addAttribute("usuario", m_usuario);
            return "Update_Usuario/update_usuario";

        } else {
            return "redirect:/showUsuarioAtivo";
        }
    }

    @PostMapping("/updateUsuario/{id}")
    public String updateUsuario(@PathVariable(value = "id") long id,
                                @RequestParam String nome,
                                @RequestParam Long matricula,
                                @RequestParam Long cargo){
        M_Usuario usuarioExistente = s_usuario_interface.getUsuarioById(id);

        if (usuarioExistente != null){
            usuarioExistente.setNome(nome);
            usuarioExistente.setMatricula(matricula);
            usuarioExistente.setCargo(cargo);

            s_usuario_interface.saveUsuario(usuarioExistente);

            return "redirect:/showUsuarioAtivo";

        } else {
            return "ID não encontrado";
        }
    }

    @GetMapping("/deleteUsuario/{id}")
    public String deleteUsuario(@PathVariable (value = "id")long id){
        this.s_usuario_interface.deleteUsuarioById((Long)id);
        return "redirect:/showUsuario";
    }


    @GetMapping("/inativarUsuario/{id}")
    public String inativarUsuario(@PathVariable(value = "id") long id) {
        M_Usuario usuario = s_usuario_interface.getUsuarioById(id);

        if (usuario != null) {
            // Inative o usuário atualizando o status para false
            usuario.setAtivo(false);
            s_usuario_interface.saveUsuario(usuario);
        }

        return "redirect:/showUsuarioAtivo";
    }

    @GetMapping("/ativarUsuario/{id}")
    public String ativarUsuario(@PathVariable(value = "id") long id) {
        M_Usuario usuario = s_usuario_interface.getUsuarioById(id);

        if (usuario != null) {
            // Ative o usuário atualizando o status para true
            usuario.setAtivo(true);
            s_usuario_interface.saveUsuario(usuario);
        }

        return "redirect:/showUsuarioAtivo";
    }


}
