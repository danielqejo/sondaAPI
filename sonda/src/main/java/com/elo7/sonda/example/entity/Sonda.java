package com.elo7.sonda.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sonda {
    public enum directions{
        N, S, E, W;
    };

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private int posInicial;
    private int posAtual;
    private directions orientacao;

    /**
     * @Deprecated - JPA Eyes
     */
    @Deprecated
    Sonda() {}

    public Sonda(Long id, int pos, directions orientacao) {
        this.id = id;
        this.orientacao = orientacao;
        this.posInicial = posInicial;
        this.posInicial = pos;
        this.posAtual = this.posInicial;
    }

    public void moveSonda(){
        switch (this.orientacao){
            case N:
                this.posAtual += 1;
                break;
            case S:
                this.posAtual -= 1;
                break;
//            case E:
//                this.posAtual[0] -= 1;
//                break;
//            case W:
//                this.posAtual[0] += 1;
//                break;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPosInicial() {
        return posInicial;
    }

    public void setPosInicial(int posInicial) {
        this.posInicial = posInicial;
    }

    public int getPosAtual() {
        return posAtual;
    }

    public void setPosAtual(int posAtual) {
        this.posAtual = posAtual;
    }

    public directions getOrientacao() {
        return orientacao;
    }

    public void setOrientacao(directions orientacao) {
        this.orientacao = orientacao;
    }
}
