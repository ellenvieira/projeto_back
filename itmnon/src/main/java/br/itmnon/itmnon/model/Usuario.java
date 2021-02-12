package br.itmnon.itmnon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // classe será amazenada no banco de dados
@Table(name = "itmn_usuario") // criará o nome da table
public class Usuario {

    @Id // Indica chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica sequence
    @Column(name = "id_usuario") // nome da coluna no bd
    private Long id;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "racf", length = 10, nullable = false, unique = true)
    private String racf;

    @Column(name = "email", length = 60, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", length = 100, nullable = false, unique = true)
    private String senha;

    @Column(name = "status", length = 100, nullable = false, unique = true)
    private String status;

    @Column(name="link_foto", length=200)
	private String linkFoto;

    public Usuario ()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRacf() {
        return racf;
    }

    public void setRacf(String racf) {
        this.racf = racf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

}