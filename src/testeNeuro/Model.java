package testeNeuro;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Model {
	private Connection con = new Connection();
	private List<Pessoa> pessoas;
	private List<Ponto> pontos;
	
	
	public Integer getPontos(Pessoa aluno) throws JSONException{
		Integer pontuacaoFinal = 0;
		List<Ponto> tabelaPontos = this.pontos;
		Integer pontoAluno = aluno.getTotal();
		
		if(aluno.getIdade() == 11){
			if(aluno.getTotal() < 9) pontoAluno = 9;
			pontuacaoFinal = tabelaPontos.get(0).getPontuacao().get(pontoAluno.toString());
			
		} else if(aluno.getIdade() == 12){
			if(aluno.getTotal() < 13) pontoAluno = 13;
			pontuacaoFinal = (tabelaPontos.get(1).getPontuacao()).get(pontoAluno.toString());
			
		} else if(aluno.getIdade() == 13){
			if(aluno.getTotal() < 9) pontoAluno = 9;
			pontuacaoFinal = tabelaPontos.get(2).getPontuacao().get(pontoAluno.toString());
		
		} else if(aluno.getIdade() == 14){
			if(aluno.getTotal() < 5) pontoAluno = 5;
			pontuacaoFinal = tabelaPontos.get(3).getPontuacao().get(pontoAluno.toString());
		
		} else {
			if(aluno.getTotal() < 23) pontoAluno = 23;
			pontuacaoFinal = (tabelaPontos.get(4).getPontuacao()).get(pontoAluno.toString());
		}
		
		return pontuacaoFinal;
	}
	
	
	
	/**
	 * Recebe a URL do JSON como parâmentro, chama um método para retornar a string do mesmo e transforma em um JSONArray.
	 * Atribui uma lista de Pontos ao atributo pontos da classe.
	 * @param URL do JSON
	 * @throws JSONException
	 */
	public void setPontos(String url) throws JSONException{
        List<Ponto> listaPontos = new LinkedList<Ponto>();
        JSONArray json = new JSONArray(con.getData(url));
        
        try {
            for (int i = 0; i < json.length(); i++) {
                JSONObject obj = json.getJSONObject(i);
                
                Map<String, Integer> pontuacao = new HashMap<String, Integer>();
                JSONArray pontos = (JSONArray)obj.getJSONArray("score");
                
                if (pontos != null) { 
                   int len = pontos.length();
                   for (int cont=0;cont<len;cont++){ 
                	   pontuacao.put((pontos.get(cont)).toString().split(":")[0], Integer.parseInt((pontos.get(cont)).toString().split(":")[1]));
                   } 
                } 
                listaPontos.add(new Ponto(obj.getInt("idade"), pontuacao));
            }

        } catch (JSONException e) {
            // handle exception
        }

        this.pontos = listaPontos;

	 }
	 
	public List<Ponto> getBDPontos(){
		return pontos;
	}
	 

	
	/**
	 * Recebe a URL do JSON como parâmentro, chama um método para retornar a string do mesmo e transforma em um JSONArray.
	 * Atribui uma lista de Pessoas ao atributo pessoas da classe
	 * @param URL do JSON
	 * @throws JSONException
	 */
	 public void setPessoas(String url) throws JSONException{		
        List<Pessoa> listaPessoas =  new LinkedList<Pessoa>();
        
        JSONArray json = new JSONArray(con.getData(url));

        try {

            for (int i = 0; i < json.length(); i++) {
                JSONObject obj = json.getJSONObject(i);
                
                ArrayList<Integer> pontuacao = new ArrayList<Integer>();     
                JSONArray jsonArray = (JSONArray)obj.getJSONArray("pontuacao"); 
                if (jsonArray != null) { 
                   int len = jsonArray.length();
                   for (int cont=0;cont<len;cont++){ 
                	   pontuacao.add((Integer) jsonArray.get(cont));
                   } 
                } 
                listaPessoas.add(new Pessoa(obj.getString("nome"), obj.getInt("idade"), pontuacao));
            }

        } catch (JSONException e) {
            // handle exception
        }

        this.pessoas = listaPessoas;

    }
 
 
	public List<Pessoa> getBDPessoas(){
		return pessoas;
	}
}
