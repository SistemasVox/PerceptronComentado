/*
 * Classe: vwPerceptron do tipo: View = Janela.
 * Função: Apresentar a janela principal/incial para o Usuário.
 * Última atualização: v2.3 07/06/2018 15:00
 */
package View;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import Model.Linha;
import Model.Perceptron;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class vwPerceptron extends JFrame {

    private static final long serialVersionUID = 1L;// Exigido pelo Eclipse.
    private JPanel contentPane; // Janela do vwPerceptron.
    private JTable table = new JTable();// Tebela do vwPerceptron.
    private JTextField txtAlfa;// Texto do Botão Alfa.
    private JTextField txtTeta;// Texto do Botão Teta.
    private JScrollPane scrollPane = new JScrollPane();// Barra de rolagem da Tabela de Épocas. 
    private static DefaultTableModel model;// Tabela de Épocas.
    private JTextField txtW1;// Texto do Peso 1. 
    private JTextField txtW2;// Texto do Peso 2. 
    private JTextField txtW3;// Texto do Peso 3. 
    private JTextField txtB;// // Texto do Deta. 
    int cont = 0;// Contador resposável por reiniciar o programa
    static vwPerceptron vwPer = new vwPerceptron();// Objeto do tipo vwPerceptron

    // Método Princiapal da Classe vwPerceptron
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    vwPer.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
// FIM DO Método Princiapal da Classe vwPerceptron.
    
// Contrutor Padrão da Classe vwPerceptron, aqui se da valores padrão para criar um objeto do tipo vwPerceptron.
    public vwPerceptron() {
    	//Design da Classe vwPerceptron, imagem de ícone e título.
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspace\\Perceptron\\img\\a.png"));// ÍCONE DO vwPerceptron
        setTitle("A.I. - Intelig\u00EAncia Artificial Perceptron");// TÚTILO DO vwPerceptron
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Se clicar no X da janela o Programa fecha.
        setBounds(100, 100, 742, 477);// Tamanho da Janela do vwPerceptron.
        
        contentPane = new JPanel();//  Criando um Objeto da Janela do vwPerceptron.
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// Definindo o tamanho da Borda da Janela vwPerceptron.
        setContentPane(contentPane);// Colocando a Janela no Painel.
        contentPane.setLayout(null);// Colocando o Layout NULLO.
        scrollPane.setBounds(10, 97, 706, 331);// Difinindo o Tamanho do scrollPane = TABELA DE ÉPOCAS.
        contentPane.add(scrollPane);// Colocando a scrollPane no Painel.
        
        table.setToolTipText("Tabela de \u00C9pocas");// Definindo uma descrição para a TABELA DE ÉPOCAS.
        table.setColumnSelectionAllowed(true);// Permitindo que selecione TODAS AS COLUNAS DA TABELA DE ÉPOCAS.
        table.setCellSelectionEnabled(true);// Permitindo que selecione TODAS AS LINHAS DA TABELA DE ÉPOCAS.
        table.setSurrendersFocusOnKeystroke(true);// Permitindo que selecione TODAS AS LINHAS DA TABELA DE ÉPOCAS.
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));// Definindo o Tipo de Letra FONTE da TABELA DE ÉPOCAS.
        scrollPane.setViewportView(table);// Colocando a TABELA dentro do SCROLLPANE
        scrollPane.setVisible(false);// Ocultando a Tabela até que se click no botão CALCULAR.
        
        JLabel lblSistemasVox = new JLabel("Sistema VOX");// Criando a LOGO Principal do Proframa.
        lblSistemasVox.setToolTipText("Ver mais informa\u00E7\u00F5es do Software");// Definindo uma descrição para a LOGO.
        // Criando um Evento para quando clicar na LOGO.
        lblSistemasVox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                vwAbout ab = new vwAbout();// Criando um Objeto do tipo About.
                ab.setVisible(true);// Tornando a JANELA About VISÍVEL.
            }
        });
        lblSistemasVox.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 39));// Definindo o Tipo de Letra FONTE da LOGO.
        lblSistemasVox.setHorizontalAlignment(SwingConstants.CENTER);// Definindo a Letra para ser Centralizada.
        lblSistemasVox.setBounds(282, 0, 338, 98);// Definindo TAMANHO da LOGO.
        contentPane.add(lblSistemasVox);// Colocando a LOGO no PAINEL = JANELA.
        
        JLabel lblTeta = new JLabel("\u03B8 =");// Criando o TEXTO do Teta.
        lblTeta.setToolTipText("Valor de Teta:  θήτα,  thḗta. [Limiar]");
        lblTeta.setEnabled(false);// Desabilitando a seleção do mesmo.
        lblTeta.setFont(new Font("Tahoma", Font.BOLD, 14));// Definindo o Tipo de Letra FONTE.
        lblTeta.setBounds(10, 64, 38, 22);// Definindo TAMANHO
        contentPane.add(lblTeta);// Colocando a Teta no PAINEL = JANELA.
        
        JLabel lblAlfa = new JLabel("~ =");// Criando o TEXTO do Alfa.
        lblAlfa.setToolTipText("Valor de Alfa άλφα");
        lblAlfa.setEnabled(false);// Desabilitando a seleção do mesmo.
        lblAlfa.setFont(new Font("Tahoma", Font.BOLD, 14));// Definindo o Tipo de Letra
        lblAlfa.setBounds(10, 42, 38, 22);// Definindo TAMANHO
        contentPane.add(lblAlfa);// Colocando a Alfa no PAINEL = JANELA.
        
        txtAlfa = new JTextField();// Criando o CAMPO DO TEXTO do Alfa.
        txtAlfa.setToolTipText("Valor de Alfa άλφα");// Definindo uma descrição para Alfa.
        txtAlfa.setText("1");// Pré definindo um valor para Alfa.
        txtAlfa.setHorizontalAlignment(SwingConstants.CENTER);// Definindo a Letra para ser Centralizada.
        txtAlfa.setFont(new Font("Tahoma", Font.BOLD, 13));// Definindo o Tipo de Letra FONTE.
        txtAlfa.setBounds(43, 45, 38, 20);// Definindo TAMANHO
        contentPane.add(txtAlfa);// Colocando a Alfa no PAINEL = JANELA.
        txtAlfa.setColumns(10);// Definindo o TAMANHO dessa coluna.
        
        txtTeta = new JTextField();// Criando o CAMPO DO TEXTO do Teta.
        txtTeta.setToolTipText("Valor de Teta:  θήτα,  thḗta. [Limiar]");// Definindo uma descrição para Teta.
        txtTeta.setText("0.2");// Pré definindo um valor para Teta.
        txtTeta.setHorizontalAlignment(SwingConstants.CENTER);// Definindo a Letra para ser Centralizada.
        txtTeta.setFont(new Font("Tahoma", Font.BOLD, 13));// Definindo o Tipo de Letra FONTE.
        txtTeta.setColumns(10);// Definindo o TAMANHO dessa coluna.
        txtTeta.setBounds(43, 66, 38, 20);// Definindo TAMANHO
        contentPane.add(txtTeta);// Colocando a Teta no PAINEL = JANELA.
        
        //Criando o BOTÃO CALCULAR.
        JButton btnCalcular = new JButton("Calcular");//Criando um Objeto do TIPO BOTÃO.
        btnCalcular.setToolTipText("Calcular épocas.");// Definindo uma descrição para BOTÃO.
     // Criando um Evento para quando clicar no BOTÃO.
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (cont > 0) {
                	//Chamar a função restart_Perceptron(), se cont > 0 ou seja, se já foi executado uma vez.
                    restart_Perceptron();
                } else {
                	//Preencher as Tabela, ou seja, criar a Épocas, basicamente fazer todo o processo do Perceptron.
                    populaTabela();
                    //Incrementar o cont para reiniciar o programa quando clicar no BOTÃO CALCULAR.
                    cont++;
                    //Tornar da Tabela VISÍVEL AO USUÁRIO.
                    scrollPane.setVisible(true);
                    //DESABILITAR o campo do Alfa.
                    txtAlfa.setEditable(false);
                    //DESABILITAR o campo do Alfa. 
                    txtTeta.setEditable(false);
                    //Trocar o TEXTO do BOTÃO de CALCULAR para REINICIAR.
                    btnCalcular.setText("Reiniciar");
                    //Trocar da DESCRIÇÃO do BOTÃO de CALCULAR.
                    btnCalcular.setToolTipText("Reiniciar Perceptron?");
                }
            }
        });
        btnCalcular.setBounds(627, 66, 89, 23);// Definindo TAMANHO
        contentPane.add(btnCalcular);// Colocando a BOTÃO no PAINEL = JANELA.
        
        JLabel lblW_1 = new JLabel("W\u00B9 = ");// Criando o TEXTO do W¹=. (PESO 1).
        lblW_1.setFont(new Font("Tahoma", Font.BOLD, 14));// Definindo o Tipo de Letra FONTE.
        lblW_1.setEnabled(false);// Desabilitando a seleção do mesmo.
        lblW_1.setBounds(91, 42, 49, 22);// Definindo TAMANHO
        contentPane.add(lblW_1);// Colocando TEXTO "W¹=" no PAINEL = JANELA.
        
        txtW1 = new JTextField();// Criando o CAMPO DO TEXTO do  W¹=. (PESO 1).
        txtW1.setToolTipText("Valor de Peso 1");// Definindo uma descrição para W¹.
        txtW1.setText("?");// Pré definindo um valor para W¹.
        txtW1.setHorizontalAlignment(SwingConstants.CENTER);// Definindo a Letra para ser Centralizada.
        txtW1.setFont(new Font("Tahoma", Font.BOLD, 13));// Definindo o Tipo de Letra FONTE.
        txtW1.setEditable(false);// Desabilitando a seleção do mesmo.
        txtW1.setColumns(10);// Definindo o TAMANHO dessa coluna.
        txtW1.setBounds(138, 42, 38, 20);// Definindo TAMANHO
        contentPane.add(txtW1);// Colocando CAMPO DO TEXTO do W¹ no PAINEL = JANELA.
        
        JLabel lblW_2 = new JLabel("W\u00B2 =");// Criando o TEXTO do W2=. (PESO 2).
        lblW_2.setFont(new Font("Tahoma", Font.BOLD, 14));// Definindo o Tipo de Letra FONTE.
        lblW_2.setEnabled(false);// Desabilitando a seleção do mesmo
        lblW_2.setBounds(91, 64, 49, 22);// Definindo o Tipo de Letra FONTE.
        contentPane.add(lblW_2);// Colocando TEXTO "W²=" no PAINEL = JANELA.
        
        txtW2 = new JTextField();// Criando o CAMPO DO TEXTO do  W²=. (PESO 2).
        txtW2.setToolTipText("Peso 2");// Definindo uma descrição para W².
        txtW2.setText("?");// Pré definindo um valor para W².
        txtW2.setHorizontalAlignment(SwingConstants.CENTER);// Definindo a Letra para ser Centralizada.
        txtW2.setFont(new Font("Tahoma", Font.BOLD, 13));// Definindo o Tipo de Letra FONTE.
        txtW2.setEditable(false);// Desabilitando a seleção do mesmo.
        txtW2.setColumns(10);// Definindo o TAMANHO dessa coluna.
        txtW2.setBounds(138, 63, 38, 20);// Definindo TAMANHO
        contentPane.add(txtW2);// Colocando CAMPO DO TEXTO do W² no PAINEL = JANELA.
        
        JLabel lblW_3 = new JLabel("W\u00B3 =");// Criando o TEXTO do W3=. (PESO 3).
        lblW_3.setHorizontalAlignment(SwingConstants.LEFT);// Definindo a Letra para ser Centralizada.
        lblW_3.setFont(new Font("Tahoma", Font.BOLD, 14));// Definindo o Tipo de Letra FONTE.
        lblW_3.setEnabled(false);// Desabilitando a seleção do mesmo
        lblW_3.setBounds(186, 42, 49, 22);// Definindo TAMANHO
        contentPane.add(lblW_3);// Colocando TEXTO "W³=" no PAINEL = JANELA.
        
        txtW3 = new JTextField();// Criando o CAMPO DO TEXTO do  W³=. (PESO 3).
        txtW3.setToolTipText("Valor de Peso 3");// Definindo uma descrição para W³.
        txtW3.setText("?");// Pré definindo um valor para W3.
        txtW3.setHorizontalAlignment(SwingConstants.CENTER);// Definindo a Letra para ser Centralizada.
        txtW3.setFont(new Font("Tahoma", Font.BOLD, 13));// Definindo o Tipo de Letra FONTE.
        txtW3.setEditable(false);// Desabilitando a seleção do mesmo
        txtW3.setColumns(10);// Definindo o TAMANHO dessa coluna.
        txtW3.setBounds(234, 44, 38, 20);// Definindo TAMANHO
        contentPane.add(txtW3);// Colocando CAMPO DO TEXTO do W³ no PAINEL = JANELA.
        
        JLabel lblB = new JLabel("b =");// Criando o TEXTO do BETA.
        lblB.setHorizontalAlignment(SwingConstants.CENTER);// Definindo a Letra para ser Centralizada.
        lblB.setFont(new Font("Tahoma", Font.BOLD, 14));// Definindo o Tipo de Letra FONTE.
        lblB.setEnabled(false);// Desabilitando a seleção do mesmo
        lblB.setBounds(186, 61, 49, 22);// Definindo TAMANHO
        contentPane.add(lblB);// Colocando TEXTO BETA no PAINEL = JANELA.
        
        txtB = new JTextField();// Criando o CAMPO DO TEXTO BETA.
        txtB.setToolTipText("Valor de Beta");// Definindo uma descrição para BETA.
        txtB.setText("?");// Pré definindo um valor para BETA.
        txtB.setHorizontalAlignment(SwingConstants.CENTER);// Definindo a Letra para ser Centralizada.
        txtB.setFont(new Font("Tahoma", Font.BOLD, 13));// Definindo o Tipo de Letra FONTE.
        txtB.setEditable(false);// Desabilitando a seleção do mesmo
        txtB.setColumns(10);// Definindo o TAMANHO dessa coluna.
        txtB.setBounds(234, 66, 38, 20);// Definindo TAMANHO
        contentPane.add(txtB);// Colocando CAMPO DO TEXTO do BETA no PAINEL = JANELA.
        
        JLabel lblV = new JLabel("V: 2.3");// Definindo texto para Versão do SOFTWARE.
        lblV.setToolTipText("Versão do Software");;// Definindo uma descrição para Versão do SOFTWARE.
        lblV.setEnabled(false);// Desabilitando a seleção do mesmo
        lblV.setHorizontalAlignment(SwingConstants.RIGHT);// Definindo a Letra para ser Centralizada.
        lblV.setBounds(670, 11, 46, 14);// Definindo o TAMANHO
        contentPane.add(lblV);contentPane.add(lblB);// Colocando TEXTO Versão do Software no PAINEL = JANELA.
    }
////////////////////////////// FIM DO CONSTRUTOR PADRÃO DE vwPerceptron. ////////////////////////////////////
    
////////////////////////////// COMEÇO DAS FUNÇÃO DE vwPerceptron. //////////////////////////////////////////   
    //Função VOID responsável por reinicar o programa.
    protected void restart_Perceptron() {
    	//Fechar Janela vwPerceptron.
        vwPer.dispose();
        //Criar nova Janela vwPerceptron.
        vwPer = new vwPerceptron();
        //Tornar nova Janela vwPerceptron VISÍVEL AO USUÁRIO.
        vwPer.setVisible(true);
        //Zerar Contador de REINICIALIZAÇÃO.
        cont = 0;
    }
    
    //PRINCIPAL FUNÇÃO DO PROGRAMA, Responsável por Criar/Calcular tudo.
    private void populaTabela() {
    	//Criação da Tabela de Épocas, Difinindo descrição das colunas.
        table.setModel(model = new DefaultTableModel(new Object[][]{}, new String[]{"X1", "X2 ", "X3 ", "1", "T", "Yent = (X1*W1) + (X2*W2) + (X3*W3) + b", "Y", "W1", "W2", "W3", "b", "\u0394W1", "\u0394W2", "\u0394W3", "\u0394b"}));
        //Criação de um Objeto de tipo Perceptron.
        Perceptron per = new Perceptron(Double.parseDouble(txtTeta.getText().replaceAll(",", ".")), Double.parseDouble(txtAlfa.getText().replaceAll(",", ".")));
        //Cada objeto do Perceptron tem uma lista de Linhas das colunas, aqui estou pegando essa lista.
        ArrayList<Linha> linhas = per.getLinhas();
        //Definindo para a contagem de Épocas começar em 1. Não em Zero.
        int epocas = 1;
        //Criando a primeira linha da TABELA DE ÉPOCAS.
        model.addRow(new Object[]{" ", " ", " ", " ", " ", "By: Marcelo V, Marcelo F, Vladir.", " ", " ", " ", " ", " ", " ", " ", " "});
        model.addRow(new Object[]{"---", "---", "---", "---", "---", epocas + "º Época", "---", "---", "---", "---", "---", "---", "---", "---", "---"});
        //PREENCHER TODA A TABELA DE ÉPOCAS COM AS LINHAS de [ArrayList<Linha> linhas = per.getLinhas();]
        for (int i = 0; i < linhas.size(); i++) {
            if (i > 0 && i % 8 == 0) {
                epocas++;
                model.addRow(new Object[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "});
                model.addRow(new Object[]{"---", "---", "---", "---", "---", epocas + "º Época", "---", "---", "---", "---", "---", "---", "---", "---", "---"});
            }
            model.addRow(new Object[]{linhas.get(i).getX1(), linhas.get(i).getX2(), linhas.get(i).getX3(), linhas.get(i).getUm(), linhas.get(i).getT(), linhas.get(i).getYent(), linhas.get(i).getY(), linhas.get(i).getW1(), linhas.get(i).getW2(), linhas.get(i).getW3(), linhas.get(i).getB(), linhas.get(i).getVw1(), linhas.get(i).getVw2(), linhas.get(i).getVw3(), linhas.get(i).getVb()});
        }
        //Preenchendo o valor final de Beta na janela de vwPerceptron
        txtB.setText(String.valueOf(linhas.get(linhas.size() - 1).getB()));
        //Preenchendo o valor final de PESO 1 na janela de vwPerceptron
        txtW1.setText(String.valueOf(linhas.get(linhas.size() - 1).getW1()));
        //Preenchendo o valor final de PESO 2 na janela de vwPerceptron
        txtW2.setText(String.valueOf(linhas.get(linhas.size() - 1).getW2()));
        //Preenchendo o valor final de PESO 3 na janela de vwPerceptron
        txtW3.setText(String.valueOf(linhas.get(linhas.size() - 1).getW3()));
        
        //Definindo que a 5º Coluna, Yent deve ter tamanho maior que todas.
        table.getColumnModel().getColumn(5).setPreferredWidth(250);
        table.getColumnModel().getColumn(5).setMinWidth(250);
        
        //Definindo que todas as linhas da tabela deve ter conteúdo centralizado.
        table.setDefaultRenderer(Object.class, new CellRenderer());
    }
//////////////////////////////FIM DAS FUNÇÃO DE vwPerceptron. //////////////////////////////////////////   
}
//Classe responsável por centralizar conteúdos da TABELA DE ÉPOCAS.
class CellRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    public CellRenderer() {
        super();
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.setHorizontalAlignment(CENTER);
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
