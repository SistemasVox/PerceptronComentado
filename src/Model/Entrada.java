/*
 * Classe: Entrada do tipo: Entrada = dados.
 * Função: armazenar entradas vão ser processadas pelo Perceptron.
 * Última atualização: v2.1 05/05/2018 15:00
 */
package Model;

public class Entrada {
	
	//Variáveis locais de Entrada.
    private int x1, x2, x3, um, t;
    
// Contrutor Padrão da Classe Entrada.
    public Entrada(int x1, int x2, int x3, int um, int t) {
        super();
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.um = um;
        this.t = t;
    }
//FIM DO CONSTRUTOR PADRÃO DE Entrada.
    
// COMEÇO DAS FUNÇÃO GET de Entrada.
    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getX3() {
        return x3;
    }

    public int getUm() {
        return um;
    }

    public int getT() {
        return t;
    }
// FIM DAS FUNÇÃO GET de Entrada.
}
