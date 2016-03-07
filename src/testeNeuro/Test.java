package testeNeuro;


import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONException;


public class Test {

	public static void main(String[] args) throws JSONException {
		
		Model model = new Model();
		model.setPessoas("https://api.myjson.com/bins/1mukr");
		model.setPontos("https://api.myjson.com/bins/32fj1");

		List<Pessoa> pessoas = model.getBDPessoas();
		
		
		Controller controller = new Controller(model);
		
		

        model.setMeasurements(pessoas.get(0));
		 
	      
		/*for(Pessoa p : pessoas){
			System.out.println("Nome: " + p.getNome());
			System.out.println("Idade: " + p.getIdade());
			System.out.println("Pontos dos testes: " + p.getPontosTestes());
			System.out.println("Pontuação final: " + model.getPontos(p) + "\n");
		}*/
		
	}
	
}
