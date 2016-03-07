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
	
	public Controller(Model mo){
		this.model = mo;
		alunos = mo.getBDPessoas();
		aluno = alunos.get(index);
		max = alunos.size() - 1;
		
		view = new View(aluno, this);
		view.createView();
		
	}
	
	public void voltar(){
		model.removeObserver(view);//2
		index = index - 1;
		aluno = alunos.get(index);
		view.update(aluno);
		
		System.out.println(aluno.getNome());
		System.out.println("Aluno anterior");
		//view.desabilitarBotaoAssinar();//3
		view.habilitarBotaoProximo();//3
		
	}
	
	public void proximo(){
		model.removeObserver(view);//2
		index = index + 1;
		aluno = alunos.get(index);
		view.update(aluno);
		
		System.out.println(aluno.getNome());
		System.out.println("Próximo aluno");
		//view.desabilitarBotaoCancelar();//3
		view.habilitarBotaoVoltar();//3
		
	}
	
}
