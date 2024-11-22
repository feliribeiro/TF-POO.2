package Aplicacao;

import Dados.CadastroDrone;
import Dados.DronePessoal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formJanelaCadastroDrone {
    private JPanel Painel;
    private JButton botaoVoltar;
    private JButton botaoConfirmar;
    private JTextField txtCodigo;
    private JTextField txtCustoFixo;
    private JTextField txtAutonomia;
    private JTextField txtqtdMaxima;
    private JButton botaoMostrar;
    private JButton botaoLimpar;
    private JComboBox opcoesDrone;
    private JLabel tipoDeDrone;
    private JanelaCadastroDrone janelaCadastroDrone;

    public formJanelaCadastroDrone(JanelaCadastroDrone janelaCadastroDrone) {
        CadastroDrone cd = new CadastroDrone();

        this.janelaCadastroDrone = janelaCadastroDrone;
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCadastroDrone.setVisible(false);
            }
        });
        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpaField();
            }
        });
        botaoMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,cd.mostraDrones());
            }
        });
        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (cd.eRepetido(Integer.parseInt(txtCodigo.getText()))){
                    JOptionPane.showMessageDialog(null, "Este codigo já foi utilizado no cadastro de outro drone."+"\n");
                    limpaField();
                } else {

                    try {
                        int codigo = Integer.parseInt(txtCodigo.getText());
                        double custoFixo = Double.parseDouble(txtCustoFixo.getText());
                        double autonomia = Double.parseDouble(txtAutonomia.getText());
                        int qtdMaxima = Integer.parseInt(txtqtdMaxima.getText());
                        cd.addDrone(new DronePessoal(codigo, custoFixo, autonomia, qtdMaxima));
                        JOptionPane.showMessageDialog(null,"Código do Drone: " + txtCodigo.getText() + "\n" +
                                "Custo Fixo: " + txtCustoFixo.getText() + "\n" +
                                "Autonomia: " + txtAutonomia.getText() + "\n" +
                                "Quantidade Máxima de Pessoas: " + txtqtdMaxima.getText() + "\n");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erro de formatação: Digite números válidos.");
                        limpaField();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar drone: " + ex.getMessage());
                        limpaField();
                    }
                }
            }
        });
    }
    public JPanel getPainel() {
        return Painel;
    }

    public void limpaField(){
        txtCustoFixo.setText("");
        txtAutonomia.setText("");
        txtqtdMaxima.setText("");
        txtCodigo.setText("");
    }
}
