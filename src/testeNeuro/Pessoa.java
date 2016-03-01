package testeNeuro;

import java.util.List;

public class Pessoa {
	private String nome;
	private int idade;
	private List<Integer> pontosTestes;
	
	public Pessoa(String nome, int idade, List<Integer> pontuacao){
		this.nome = nome;
		this.idade = idade;
		this.pontosTestes = pontuacao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public List<Integer> getPontosTestes() {
		return pontosTestes;
	}
	public void getPontosTestes(List<Integer> pontuacao) {
		this.pontosTestes = pontuacao;
	}
	
	public Integer getTotal(){
		Integer total = 0;
		for(Integer p: pontosTestes){
			total += p;
		}
		return total;
	}
	
	
	
	
}
