package br.itmnon.itmnon.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.itmnon.itmnon.model.Evento;

public interface EventoRepo extends CrudRepository<Evento, Integer> {
    @Query(value = "select * from itmn_evento where (LocalDate between :dt1 and :dt2) ", nativeQuery = true)

    Evento findByStartDateBetween (@Param("dt1") Date dt1, @Param("dt2") Date dt2);


/*     mostra tudo:
select itmn_equipamento.hostname, itmn_alarme.nome, itmn_evento.data_evt from itmn_evento
inner join itmn_equipamento
on (itmn_equipamento.id_equip = itmn_evento.id_equip)
inner join itmn_alarme
on (itmn_alarme.id_alarme = itmn_evento.id_alarme);

mostra por período
select itmn_equipamento.hostname, itmn_alarme.nome, itmn_evento.data_evt from itmn_evento
inner join itmn_equipamento
on (itmn_equipamento.id_equip = itmn_evento.id_equip)
inner join itmn_alarme
on (itmn_alarme.id_alarme = itmn_evento.id_alarme)
and itmn_evento.data_evt between '2020-04-24' and '2020-04-24' */
}
