package com.sashiri.springdataandjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Anotação Entity JPA serve para dizer que iremos criar uma table ana base de dados
@Entity
public class Carta {

    //Id será criado automáticamente e em nossa base de dados será como a primary key
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 3)
    private String nome;

    @NotNull
    @Size(min = 60)
    private String edicao;

    @NotNull
    @Size(min = 40)
    private String idioma;

    @NotNull
    private boolean foil;

    @NotNull
    @Size(min = 20)
    private double preco;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public boolean isFoil() {
        return foil;
    }

    public void setFoil(boolean foil) {
        this.foil = foil;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}