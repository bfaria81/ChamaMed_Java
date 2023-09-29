package ChamadasLeitos.chamadas.Controller;


import ChamadasLeitos.chamadas.Model.M_Interruptor;
import ChamadasLeitos.chamadas.Model.M_Registro;
import ChamadasLeitos.chamadas.Service.S_Interruptor;
import ChamadasLeitos.chamadas.Service.S_Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class C_Interruptor {
    @Autowired
    private S_Interruptor S_Interruptor;

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

}
