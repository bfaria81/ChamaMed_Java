package ChamadasLeitos.chamadas.Controller;


import ChamadasLeitos.chamadas.Model.M_Interruptor;
import ChamadasLeitos.chamadas.Model.M_Registro;
import ChamadasLeitos.chamadas.Service.S_Interruptor;
import ChamadasLeitos.chamadas.Service.S_Interruptor_Implements;
import ChamadasLeitos.chamadas.Service.S_Interruptor_Interface;
import ChamadasLeitos.chamadas.Service.S_Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class C_Interruptor {

    @Autowired
    private S_Interruptor S_Interruptor;

    @Autowired
    private S_Interruptor_Implements s_interruptor_implements;

    @Autowired
    private S_Interruptor_Interface s_interruptor_interface;

    @Autowired
    private S_Registro s_registro;

    @GetMapping("/")
    public String listarInterruptores(Model model) {
        List<M_Interruptor> interruptores = S_Interruptor.listarInterruptores();
        model.addAttribute("interruptores", interruptores);
        model.addAttribute("modoSimulacao", true); // Defina como 'false' quando a comunicação com o Arduino estiver estabelecida.
        return "index";
    }

    @GetMapping("/chamados")
    public String paginaSecundaria(Model model) {
        List<M_Interruptor> interruptores = S_Interruptor.listarInterruptores();
        model.addAttribute("interruptores", interruptores);
        return "/chamados";
    }

    @PostMapping("/")
    public String alterarEstado(@RequestParam String interruptorNome) {
        S_Interruptor.alterarEstado(interruptorNome);

        M_Registro M_Registro = new M_Registro();

        M_Registro.setData_hora(LocalDateTime.now());
//        s_registro.salvarRegistro(M_Registro);

        return "redirect:/";
    }

    @GetMapping("/relatorio")
    public String exibirRelatorio(Model model) {
        // Aqui você deve buscar todos os registros do serviço
        List<M_Registro> registros = s_registro.listarTodosRegistros();
        model.addAttribute("registros", registros);
        return "/relatorio"; // Nome do arquivo HTML da página de relatório
    }

    @GetMapping("/showInterruptor")
    public String viewHomePageInterruptor(Model model){
        return findPaginatedInterruptor(1,"interruptor","asc", model);
    }

    @GetMapping("/showNewInterruptorForm")
    public String showNewEpiForm(Model model){
        M_Interruptor m_interruptor = new M_Interruptor();
        model.addAttribute("interruptor", m_interruptor);
        return "New_Interruptor/new_interruptor";
    }

    @PostMapping("/saveInterruptor")
    public String saveInterruptor(@ModelAttribute("interruptor") M_Interruptor m_interruptor){

        s_interruptor_interface.saveInterruptor(m_interruptor);
        return "redirect:/showInterruptor";
    }

    @GetMapping("/showFormForUpdateInterruptor/{id}")
    public String showFormForUpdateInterruptor(@PathVariable(value = "id")long id, Model model){
        M_Interruptor m_interruptor = s_interruptor_interface.getInterruptorById((Long)id);
        model.addAttribute("interruptor", m_interruptor);
        return "Update_Interruptor/update_interruptor";
    }

    @GetMapping("/deleteInterruptor/{id}")
    public String deleteInterruptor(@PathVariable (value = "id")long id){
        this.s_interruptor_interface.deleteInterruptorById((Long)id);
        return "redirect:/showInterruptor";
    }

    @GetMapping("/pageInterruptor/{pageNo}")
    public String findPaginatedInterruptor(@PathVariable (value = "pageNo") int pageNo,
                                           @RequestParam("sortField") String sortField,
                                           @RequestParam("sortDir")String sortDir,
                                           Model model){
        int pageSize = 10;

        Page<M_Interruptor> pageInterruptor = s_interruptor_interface.findPaginatedInterruptor(pageNo, pageSize, sortField, sortDir);
        List<M_Interruptor>listInterruptor = pageInterruptor.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", pageInterruptor.getTotalPages());
        model.addAttribute("totalItems", pageInterruptor.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listInterruptor", listInterruptor);
        return "Interruptor/interruptor";
    }



}
