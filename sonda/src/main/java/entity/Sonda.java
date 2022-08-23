package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sonda {
    public enum directions{
        N, S, E, W;

    };

    @Id
    @GeneratedValue
    private Long id;
    private int[] posInicial = new int[2];
    private int[] posAtual = new int[2];
    private directions orientacao;

    public Sonda(Long id, int x, int y, directions orientacao) {
        this.id = id;
        this.orientacao = orientacao;
        this.posInicial = posInicial;
        this.posInicial[0] = x;
        this.posInicial[1] = y;
        this.posAtual = this.posInicial;
    }

    public void moveSonda(){
        switch (this.orientacao){
            case N:
                this.posAtual[1] += 1;
                break;
            case S:
                this.posAtual[1] -= 1;
                break;
            case E:
                this.posAtual[0] -= 1;
                break;
            case W:
                this.posAtual[0] += 1;
                break;
        }
    }

    public directions getOrientacao() {
        return orientacao;
    }

    public void setOrientacao(directions orientacao) {
        this.orientacao = orientacao;
    }

    public String getPosInicial() {
        return posInicial;
    }

    public void setPosInicial(String posInicial) {
        this.posInicial = posInicial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
