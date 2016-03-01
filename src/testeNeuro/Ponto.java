package testeNeuro;

import java.util.HashMap;
import java.util.Map;

public class Ponto {
	private Integer idade;
	private Map<String, Integer> pontuacao = new HashMap<String, Integer>();
	
	public Ponto(Integer idade, Map<String, Integer> pontuacao){
		this.idade = idade;
		this.pontuacao = pontuacao;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Map<String, Integer> getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Map<String, Integer> pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	
}
