//package ChamadasLeitos.chamadas.Controller;
//
//
//import ChamadasLeitos.chamadas.Model.M_Chamada;
//import ChamadasLeitos.chamadas.Repository.R_Chamada;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class C_Chamada {
//
//    @Autowired
//    private R_Chamada r_chamada;
//
//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("pacientes", r_chamada.findAll());
//        return "Chamadas/chamadas";
//    }
//
//    @PostMapping("/toggleLeito")
//    public String toggleLeito(Long pacienteId) {
//        M_Chamada m_chamada = r_chamada.findById(pacienteId).orElse(null);
//        if (m_chamada != null) {
//            m_chamada.setLeito(!m_chamada.isLeito());
//            r_chamada.save(m_chamada);
//        }
//        return "redirect:/";
//    }
//
//    @PostMapping("/toggleEmergencia")
//    public String toggleEmergencia(Long pacienteId) {
//        M_Chamada m_chamada = r_chamada.findById(pacienteId).orElse(null);
//        if (m_chamada != null) {
//            m_chamada.setEmergencia(!m_chamada.isEmergencia());
//            r_chamada.save(m_chamada);
//        }
//        return "redirect:/";
//    }
//
//
//}