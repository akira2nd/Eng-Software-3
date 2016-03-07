package testeNeuro;


import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import java.util.List;

public class View implements ActionListener, Observer {
	private AcessoController controller; //polimorfismo
	private Pessoa aluno;
	
	JFrame frame;
	
	JPanel panelBotoes;
	JPanel panelNome;
	JPanel panelPontos;
	JPanel panelPontuacaoFinal;
	JPanel panelDados;
	
	JLabel labelNome;
	JLabel labelPontos;
	JLabel labelPontuacaoFinal;
	JLabel textNome;
	JLabel textPontos;
	JLabel textPontuacaoFinal;
	
	JButton voltar;
	JButton proximo;
	
	public View(Pessoa aluno, AcessoController controller) {
		this.aluno = aluno;
		this.controller = controller;
	}
	
	
	public void createView(){
		
		frame = new JFrame("Estação Meteorológica");
		panelBotoes = new JPanel();
		panelDados = new JPanel();
		panelNome = new JPanel();
		panelPontos = new JPanel();
		panelPontuacaoFinal = new JPanel();
		
		voltar = new JButton("Voltar Aluno");
		proximo = new JButton("Proximo Aluno");
		
		labelNome = new JLabel();
		labelPontos = new JLabel();
		labelPontuacaoFinal = new JLabel();
		textNome = new JLabel("Nome: ");
		textPontos = new JLabel("Pontuação: ");
		textPontuacaoFinal = new JLabel("Pontuação final: ");
		
		
		voltar.addActionListener(this);
		proximo.addActionListener(this);
		
		panelBotoes.add(voltar);
		panelBotoes.add(proximo);

		panelNome.add(textNome);
		panelNome.add(labelNome);
		panelPontos.add(textPontos);
		panelPontos.add(labelPontos);
		panelPontuacaoFinal.add(textPontuacaoFinal);
		panelPontuacaoFinal.add(labelPontuacaoFinal);
		

		panelDados.add(panelNome);
		panelDados.add(panelPontos);
		panelDados.add(panelPontuacaoFinal);
		
		frame.getContentPane().add(BorderLayout.SOUTH, panelBotoes);
		frame.getContentPane().add(BorderLayout.CENTER, panelDados);
		
		labelNome.setText(aluno.getNome());
		labelPontos.setText(aluno.getPontosTestes().toString());
		labelPontuacaoFinal.setText(aluno.getTotal().toString());
		
		desabilitarBotaoVoltar();
		
		
		frame.setSize(300, 200);
		frame.setVisible(true);
		
	}

	public void update(Pessoa aluno) {
        this.aluno = aluno;
        System.out.println("view: " + this.aluno.getNome());
		display();
	}

	public void display() {
		labelNome.setText(aluno.getNome());
		labelPontos.setText(aluno.getPontosTestes().toString());
		labelPontuacaoFinal.setText(aluno.getTotal().toString());
		
	}
	
	
	public void actionPerformed(ActionEvent event){
		if (event.getSource() == voltar){//1
				controller.voltar();
		}
		if (event.getSource() == proximo){//1
				controller.proximo();
		}
	}
	
	
	public void habilitarBotaoVoltar(){
		voltar.setEnabled(true);
		
	}
	
	public void desabilitarBotaoVoltar(){
		voltar.setEnabled(false);
		
	}
	
	public void habilitarBotaoProximo(){
		proximo.setEnabled(true);
		
	}
	
	public void desabilitarBotaoProximo(){
		proximo.setEnabled(false);
		
	}
	
	
}
