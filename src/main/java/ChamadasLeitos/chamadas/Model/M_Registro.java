package ChamadasLeitos.chamadas.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "registro")
public class M_Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String acao;
    private LocalDateTime data_hora;
    private String nome;

    public M_Registro(Long id, String acao, LocalDateTime data_hora, String nome) {
        this.id = id;
        this.acao = acao;
        this.data_hora = data_hora;
        this.nome = nome;
    }

    public M_Registro() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }
}
