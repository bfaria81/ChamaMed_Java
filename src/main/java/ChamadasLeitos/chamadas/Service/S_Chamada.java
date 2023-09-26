//package ChamadasLeitos.chamadas.Service;
//
//import ChamadasLeitos.chamadas.Model.M_Chamada;
//import ChamadasLeitos.chamadas.Repository.R_Chamada;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class S_Chamada {
//
//    private final R_Chamada r_chamada;
//
//    @Autowired
//    public S_Chamada(R_Chamada r_chamada) {
//        this.r_chamada = r_chamada;
//    }
//
//    public List<M_Chamada> findAllPacientes() {
//        return r_chamada.findAll();
//    }
//
//    public Optional<M_Chamada> findPacienteById(Long id) {
//        return r_chamada.findById(id);
//    }
//
//    public M_Chamada savePaciente(M_Chamada m_chamada) {
//        return r_chamada.save(m_chamada);
//    }
//
//    public void toggleLeito(Long pacienteId) {
//        Optional<M_Chamada> pacienteOptional = r_chamada.findById(pacienteId);
//        pacienteOptional.ifPresent(paciente -> {
//            paciente.setLeito(!paciente.isLeito());
//            r_chamada.save(paciente);
//        });
//    }
//
//    public void toggleEmergencia(Long pacienteId) {
//        Optional<M_Chamada> pacienteOptional = r_chamada.findById(pacienteId);
//        pacienteOptional.ifPresent(paciente -> {
//            paciente.setEmergencia(!paciente.isEmergencia());
//            r_chamada.save(paciente);
//        });
//    }
//}