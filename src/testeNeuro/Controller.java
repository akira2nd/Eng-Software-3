package testeNeuro;

import java.util.List;

public class Controller implements AcessoController{

	private View view;
	private Model model;
	private Pessoa aluno;
	private List<Pessoa> alunos;
	private Integer index = 0;
	private Integer max;
	private Integer min = 0;
	
	public Controller(Model model){
		this.model = model;
		alunos = model.getBDPessoas();
		aluno = alunos.get(index);
		max = alunos.size() - 1;
		
		view = new View(aluno, this);
		this.model.registerObserver(view);
		view.createView();
		
		
	}
	
	public void voltar(){
		index = index - 1;
		aluno = alunos.get(index);
		model.setMeasurements(aluno);
		
		System.out.println(aluno.getNome());
		System.out.println("Aluno anterior");
		
		view.habilitarBotaoProximo();
		if(index == 0) view.desabilitarBotaoVoltar();
		
	}
	
	public void proximo(){
		index = index + 1;
		aluno = alunos.get(index);
		model.setMeasurements(aluno);
		
		System.out.println(aluno.getNome());
		System.out.println("Próximo aluno");
		
		view.habilitarBotaoVoltar();
		if(index == max) view.desabilitarBotaoProximo();
		
	}
	
}
