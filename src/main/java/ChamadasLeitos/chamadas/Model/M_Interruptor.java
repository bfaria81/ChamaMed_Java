package ChamadasLeitos.chamadas.Model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.ResponseBody;

@Entity
@Table(name = "interruptor")
public class M_Interruptor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String interruptor;
    private boolean estado;
    private String setor;


//    public M_Interruptor() {
//
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInterruptor() {
        return interruptor;
    }

    public void setInterruptor(String interruptor) {
        this.interruptor = interruptor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
