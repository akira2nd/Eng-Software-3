package testeNeuro;

public class Controller implements AcessoController{

	private View view;
	private Model model;
	
	public Controller(Model mo){
		this.model = mo;
		view = new View(model, this);
		view.createView();
		
	}
	
	public void voltar(){
		
		model.registerObserver(view);//2
		System.out.println("Aluno anterior");
		//view.desabilitarBotaoAssinar();//3
		view.habilitarBotaoProximo();//3
		
	}
	
	public void proximo(){
		
		model.removeObserver(view);//2
		System.out.println("Próximo aluno");
		//view.desabilitarBotaoCancelar();//3
		view.habilitarBotaoVoltar();//3
		
	}
	
}
