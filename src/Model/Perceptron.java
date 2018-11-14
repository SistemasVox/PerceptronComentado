/*
 * Classe: Perceptron do tipo: Perceptron = processamento de dados.
 * Função: Classe com os métodos mais importantes, para o processamento de dados e conclusão de resultados.
 * Última atualização: v2.1 05/05/2018 15:00
 */
package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Perceptron {
	
	//Variáveis locais de Perceptron
    private double teta;// Sempre o usuário pode mudar o valor
    private double alfa;// Sempre o usuário pode mudar o valor
    
    //Basicamente as mais importantes, e são as colunas da tabela de épocas.
    private double x1, x2, x3, um, t, resul_yent, y, w1, w2, w3, b, vw1, vw2, vw3, vb;
    private String yent = "";
    
    //Auxiliares Calcular as VARIAÇÕES.
    private double w1Old;// Variação de PESO 1
    private double w2Old;// Variação de PESO 2
    private double w3Old;// Variação de PESO 3
    private double bOld;// Variação de BETA
    
    // Lista de Linhas da tabela de épocas.
    private ArrayList<Linha> linhasTemp = new ArrayList<Linha>();//Armazena sempre a última época para saber se as variações pararam.
    private ArrayList<Linha> linhas = new ArrayList<Linha>();//Armazenamento TOTAL de TODAS AS LINHAS.
    
    //Lista de entradas, no caso são 2³
    private ArrayList<Entrada> entradas = new ArrayList<Entrada>();
    
    //Contadora de épocas.
    private int cont;

 // Contrutor Padrão da Classe Perceptron, aqui se da valores padrão para criar um objeto do tipo Perceptron.    
    public Perceptron(double teta, double alfa) {
    	
        this.teta = teta;// Valor recebido de outra classe.
        this.alfa = alfa;// Valor recebido de outra classe.
        
        resul_yent = 0;//Resultado sempre de YENT.
        y = 0;//Resultado de Y.
        w1 = 0;//Resultado de PESO 1.
        w2 = 0;//Resultado de PESO 2.
        w3 = 0;//Resultado de PESO 3.
        b = 0;//Resultado de BETA.
        vw1 = 0;//Resultado da VARIAÇÃO de PESO 1.
        vw2 = 0;//Resultado da VARIAÇÃO de PESO 2.
        vw3 = 0;//Resultado da VARIAÇÃO de PESO 3.
        vb = 0;//Resultado da VARIAÇÃO de BETA.
        
        //Adcionando as entradas 2³
        entradas.add(new Entrada(1, 1, 1, 1, 1));
        entradas.add(new Entrada(1, 1, 0, 1, -1));
        entradas.add(new Entrada(1, 0, 1, 1, -1));
        entradas.add(new Entrada(1, 0, 0, 1, -1));
        entradas.add(new Entrada(0, 1, 1, 1, -1));
        entradas.add(new Entrada(0, 1, 0, 1, -1));
        entradas.add(new Entrada(0, 0, 1, 1, -1));
        entradas.add(new Entrada(0, 0, 0, 1, -1));
        
        //Chamando a função encontrarEpocas(); para encontrar TODAS AS ÉPOCAS.
        encontrarEpocas();
    }
    
    //Função PRINCIPAL, VOID, Encontrar todas as ÉPOCAS, PRINCIPAL LOOP do PROBLEMA.
    private void encontrarEpocas() {
        do {
            for (int i = 0; i < entradas.size(); i++) {
                x1 = entradas.get(i).getX1();//Pegar o valor de entrada(i) colocar em X1.
                x2 = entradas.get(i).getX2();//Pegar o valor de entrada(i) colocar em X2.
                x3 = entradas.get(i).getX3();//Pegar o valor de entrada(i) colocar em X3.
                um = entradas.get(i).getUm();//Pegar o valor de entrada(i) colocar em um.
                t = entradas.get(i).getT();//Pegar o valor de entrada(i) colocar em T.
                
                resul_yent = ((x1 * w1) + (x2 * w2) + (x3 * w3) + b);//Calcular o valor de YENT.
                //Montar Equação de YENT (String).
                yent = x1 + "*" + w1 + " + " + x2 + "*" + w2 + " + " + x3 + "*" + w3 + " + " + b + " = " + resul_yent;
                
                y = y();//Calcular valor de y usando função y();
                w1Old = w1;//Armazenar valor antigo de w1 (peso 1).
                w2Old = w2;//Armazenar valor antigo de w2 (peso 2).
                w3Old = w3;//Armazenar valor antigo de w3 (peso 3).
                bOld = b;//Armazenar valor antigo de BETA.
                
                w1 = wI(y, t, w1, x1);//Calcular novo valor de w1 (peso 1).
                w2 = wI(y, t, w2, x2);//Calcular novo valor de w2 (peso 2).
                w3 = wI(y, t, w3, x3);//Calcular novo valor de w3 (peso 3).
                b = b(y, t);//Calcular novo valor de BETA.
                vw1 = w1 - w1Old;//Calcular a variação de w1 (peso 1).
                vw2 = w2 - w2Old;//Calcular a variação de w2 (peso 2).
                vw3 = w3 - w3Old;//Calcular a variação de w3 (peso 3).
                vb = b - bOld;//Calcular a variação de BETA.
                
                //Criar nova linha com todos os valores calculados (adcionar nova linha, a lista de linhas).
                linhas.add(new Linha(x1, x2, x3, um, t, yent, y, w1, w2, w3, b, vw1, vw2, vw3, vb));
                //Lista TEMP (auxiliar) utilizada para verificar variações de cada época.
                linhasTemp.add(new Linha(x1, x2, x3, um, t, yent, y, w1, w2, w3, b, vw1, vw2, vw3, vb));
            }
            //Incrementação de todas as épocas encontradas.
            cont++;
        } while (variacao(linhasTemp));//Enquanto houver variações repetir todo o processo.
        //Passando sempre a lista_temp de linha axiliar, que contém sempre a última época.
        //Exibir mensagens de quantas épocas foram encontradas. Após sair do LOOP.
        JOptionPane.showMessageDialog(null, cont + " épocas encontradas.");
    }
    
    //Função y, mais difícil que ser montada no projeto.
    private int y() {
        if (resul_yent >= teta) {
            return 1;
        } else if (resul_yent <= (teta * -1)) {
            return -1;
        } else {
            return 0;
        }
    }
    
    //Função responsável por calcular sempre o valor de beta.
    private double b(double y, double t) {
        if (y != t) {
            return b + (alfa * t);
        } else {
            return b;
        }
    }
    
    //Função responsável por sempre calcular os pesos, 1, 2 e 3.
    private double wI(double y, double t, double w, double x) {
        if (y != t) {
            return (w + (alfa * x * t));
        } else {
            return w;
        }
    }
    
    //Função responsável por verificar se a última Época contém variações ou não.
    private static boolean variacao(ArrayList<Linha> linhasTemp) {
        for (int i = 0; i < linhasTemp.size();) {
        	//IF veririca se há variações nos Pesos: 1, 2 e 3, e Beta.
            if (linhasTemp.get(i).getVw1() != 0 || linhasTemp.get(i).getVw2() != 0 || linhasTemp.get(i).getVw3() != 0 || linhasTemp.get(i).getVb() != 0) {
                linhasTemp.clear();// se encontra variações, apagar contéudo de linhasTemp = ÚLTIMA ÉPOCA, e retornar verdadeiro.
                return true;
            } else {
                return false;//Vai retornar falso, só quando não houver variações, e fechará o LOOP While.
            }
        }
        return false;
    }
    
    //Função responsável por retornar a lista de linhas encontradas, usada pela classe vwPerceptron. Linha: 254.
    public ArrayList<Linha> getLinhas() {
        return linhas;
    }
}
