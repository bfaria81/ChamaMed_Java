package ChamadasLeitos.chamadas.Controller;


import ChamadasLeitos.chamadas.Model.Interruptor;
import ChamadasLeitos.chamadas.Model.Registro;
import ChamadasLeitos.chamadas.Repository.InterruptorRepository;
import ChamadasLeitos.chamadas.Service.InterruptorService;
import ChamadasLeitos.chamadas.Service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class InterruptorController {
    @Autowired
    private InterruptorService interruptorService;

    @Autowired
    private RegistroService registroService;

    @GetMapping("/")
    public String listarInterruptores(Model model) {
        List<Interruptor> interruptores = interruptorService.listarInterruptores();
        model.addAttribute("interruptores", interruptores);
        model.addAttribute("modoSimulacao", true); // Defina como 'false' quando a comunicação com o Arduino estiver estabelecida.
        return "index";
    }

    @GetMapping("/chamados")
    public String paginaSecundaria(Model model) {
        List<Interruptor> interruptores = interruptorService.listarInterruptores();
        model.addAttribute("interruptores", interruptores);
        return "/chamados";
    }

    @PostMapping("/")
    public String alterarEstado(@RequestParam String interruptorNome) {
        interruptorService.alterarEstado(interruptorNome);

        Registro registro = new Registro();

        registro.setData_hora(LocalDateTime.now());
//        registroService.salvarRegistro(registro);

        return "redirect:/";
    }

    @GetMapping("/relatorio")
    public String exibirRelatorio(Model model) {
        // Aqui você deve buscar todos os registros do serviço
        List<Registro> registros = registroService.listarTodosRegistros();
        model.addAttribute("registros", registros);
        return "/relatorio"; // Nome do arquivo HTML da página de relatório
    }

}
