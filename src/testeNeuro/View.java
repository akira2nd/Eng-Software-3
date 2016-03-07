package testeNeuro;


import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import java.util.List;

public class View implements ActionListener, Observer {
	private Model model;
	private AcessoController controller; //polimorfismo
	private Pessoa aluno;
	private List<Pessoa> alunos;
	
	JFrame frame;
	
	JPanel panelBotoes;
	JPanel panelPontos;
	JPanel panelNome;
	JPanel panelDados;
	
	JLabel labelPontos;
	JLabel labelNome;
	
	JButton voltar;
	JButton proximo;
	
	public View(Model mo, AcessoController co) {
		this.model = mo;
		this.controller = co;
		this.alunos = mo.getBDPessoas();
		this.aluno = alunos.get(0);
	}
	
	
	public void createView(){
		
		frame = new JFrame("Estação Meteorológica");
		panelBotoes = new JPanel();
		panelDados = new JPanel();
		panelNome = new JPanel();
		panelPontos = new JPanel();
		
		voltar = new JButton("Voltar Aluno");
		proximo = new JButton("Proximo Aluno");
		
		labelNome = new JLabel();
		labelPontos = new JLabel();
		
		
		voltar.addActionListener(this);
		proximo.addActionListener(this);
		
		panelBotoes.add(voltar);
		panelBotoes.add(proximo);
		
		panelNome.add(labelNome);
		panelPontos.add(labelPontos);
		

		panelDados.add(panelNome);
		panelDados.add(panelPontos);
		
		frame.getContentPane().add(BorderLayout.SOUTH, panelBotoes);
		frame.getContentPane().add(BorderLayout.CENTER, panelDados);
		
		labelNome.setText(aluno.getNome());
		labelPontos.setText(aluno.getPontosTestes().toString());
		
		
		frame.setSize(300, 150);
		frame.setVisible(true);
		
	}

	public void update(Pessoa aluno) {
        this.aluno = aluno;
        
		display();
	}

	public void display() {
		
		labelNome.setText(aluno.getNome());
		labelPontos.setText(aluno.getPontosTestes().toString());
		
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
