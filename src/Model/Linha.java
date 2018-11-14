/*
 * Classe: Linha do tipo: Linha = dados.
 * Função: armazenar todas as linhas que compoe a TABELA DE ÉPOCAS.
 * Última atualização: v2.1 05/05/2018 15:00
 */
package Model;

public class Linha {
	
	//Variáveis locais de Linha.
    private double x1, x2, x3, t, y, w1, w2, w3, b, vw1, vw2, vw3, vb, um;
    private String yent;
    
 // Contrutor Padrão da Classe Linha.
    public Linha(double x1, double x2, double x3, double um, double t, String yent, double y, double w1, double w2, double w3, double b, double vw1, double vw2, double vw3, double vb) {
        super();
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.t = t;
        this.y = y;
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
        this.b = b;
        this.vw1 = vw1;
        this.vw2 = vw2;
        this.vw3 = vw3;
        this.vb = vb;
        this.um = um;
        this.yent = yent;
    }
 //FIM DO CONSTRUTOR PADRÃO DE Linha.
    
// COMEÇO DAS FUNÇÃO GET de Linha.
    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getX3() {
        return x3;
    }

    public double getT() {
        return t;
    }

    public double getY() {
        return y;
    }

    public double getW1() {
        return w1;
    }

    public double getW2() {
        return w2;
    }

    public double getW3() {
        return w3;
    }

    public double getB() {
        return b;
    }

    public double getVw1() {
        return vw1;
    }

    public double getVw2() {
        return vw2;
    }

    public double getVw3() {
        return vw3;
    }

    public double getVb() {
        return vb;
    }

    public double getUm() {
        return um;
    }

    public String getYent() {
        return yent;
    }
 // FIM DAS FUNÇÃO GET de Entrada.
    
    //Sobreescrita do método toString(), só é útil em caso de testes de linha.
    @Override
    public String toString() {
        return "Linha: " + x1 + " " + x2 + " " + " " + x3 + um + " " + t + " (" + yent
                + ") " + y + " " + w1 + " " + w2 + " " + w3 + " " + b + " " + vw1 + " "
                + vw2 + " " + vb + ".";
    }
}
