package com.elo7.testJr.campo.entity;

import javax.persistence.*;
import java.util.Objects;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity
@Table(name = "campo")
public class Campo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private Long id;
    private int largura;
    private int altura;

    /**
     * @Deprecated - JPA Eyes
     */
    @Deprecated
    Campo() {}

    public Campo(Long id, int altura, int largura){
        this.id = id;
        this.altura = altura;
        this.largura = largura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campo campo)) return false;
        return getId() == campo.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
