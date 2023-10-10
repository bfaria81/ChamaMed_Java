package ChamadasLeitos.chamadas.Repository;

import ChamadasLeitos.chamadas.Model.M_Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface R_Usuario extends JpaRepository<M_Usuario, Long> {
    Optional<M_Usuario> findByNome(String nome);

    Page<M_Usuario>findAll(Specification<M_Usuario>mUsuarioSpecification, Pageable pageable);

    @Query(value = "SELECT * FROM usuario WHERE matricula = :matricula and senha = :senha", nativeQuery = true)
    M_Usuario findByMatriculaESenha(@Param("matricula")Long matricula, @Param("senha")String senha);
}