package testeNeuro;




import org.json.JSONException;


public class Test {

	public static void main(String[] args) throws JSONException {
		
		final Model model = new Model();
		model.setPessoas("https://api.myjson.com/bins/1mukr");
		model.setPontos("https://api.myjson.com/bins/32fj1");
		
		Controller controller = new Controller(model);
		


		//List<Pessoa> pessoas = model.getBDPessoas();
		
		/*for(Pessoa p : pessoas){
			System.out.println("Nome: " + p.getNome());
			System.out.println("Idade: " + p.getIdade());
			System.out.println("Pontos dos testes: " + p.getPontosTestes());
			System.out.println("Pontuação final: " + model.getPontos(p) + "\n");
		}*/
		
	}
	
}
