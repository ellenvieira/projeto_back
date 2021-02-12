package br.itmnon.itmnon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.itmnon.itmnon.model.Alarme;

// CRUD - Create, Read, Update, Delete
public interface AlarmeRepo extends JpaRepository<Alarme, Long> {
    @Query(value = "select * from itmn_alarme", nativeQuery = true)

    Alarme findByIdAlarme(@Param("id_alarme") int alarme, @Param("nome") String nome, @Param("descricao") String descricao);

}
