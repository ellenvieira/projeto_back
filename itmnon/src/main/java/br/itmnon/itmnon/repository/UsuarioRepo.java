package br.itmnon.itmnon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.itmnon.itmnon.model.Usuario;

// CRUD - Create, Read, Update, Delete
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    @Query(value = "select * from itmn_usuario where (racf = :racf or email = :email) and senha = :senha", nativeQuery = true)

    Usuario findByRacf(@Param("racf") String racf, @Param("email") String email, @Param("senha") String senha);


    public Usuario findByEmailOrRacf(String email, String racf);

}