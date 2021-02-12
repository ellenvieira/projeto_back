package br.itmnon.itmnon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itmn_equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equip", nullable = false, unique = true)
    private int id;

    @Column(name = "hostname", nullable = false)
    private String hostname;

    @Column(name = "ipaddr", nullable = false)
    private String ipaddr;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return ipaddr;
    }

    public void setIp(String ipaddr) {
        this.ipaddr = ipaddr;
    }
    
}
