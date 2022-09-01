package com.elo7.testJr.sonda.entity;

import com.elo7.testJr.campo.entity.Campo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sonda")
public class Sonda {
    public enum directions{
        N, S, E, W;
    };

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Campo campo;

    private int posInicialX;
    private int posInicialY;
    private int posAtualX;
    private int posAtualY;
    private directions orientacao;

    /**
     * @Deprecated - JPA Eyes
     */
    @Deprecated
    Sonda() {}

    public Sonda(Long id, int[] pos, directions orientacao) {
        this.id = id;
        this.orientacao = orientacao;
        this.posInicialX = pos[0];
        this.posAtualX = pos[0];
        this.posInicialY = pos[1];
        this.posAtualY = pos[1];
    }

    public void moveSonda(){
        switch (this.orientacao){
            case N:
                this.posAtualY += 1;
                break;
            case S:
                this.posAtualY -= 1;
                break;
            case E:
                this.posAtualX -= 1;
                break;
            case W:
                this.posAtualX += 1;
                break;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int[] getPosInicial() {
        return new int[]{this.posInicialX, this.posInicialY};
    }

    public void setPosInicial(int x, int y) {
        this.posInicialX = x;
        this.posInicialY = y;
    }

    public int[] getPosAtual() {
        return new int[]{this.posAtualX, this.posAtualY};
    }

    public void setPosAtual(int x, int y) {
        this.posAtualX = x;
        this.posAtualY = y;
    }

    public directions getOrientacao() {
        return orientacao;
    }

    public void setOrientacao(directions orientacao) {
        this.orientacao = orientacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sonda sonda)) return false;
        return getId().equals(sonda.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
