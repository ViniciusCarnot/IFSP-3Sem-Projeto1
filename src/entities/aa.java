package entities;

public class aa extends Funcionario {
	
public void imprimirFuncionariosResponsaveisPorProjetosEmAndamento(Projeto vetorProjeto[], Integer tamVetorProjeto) {
		
		for(int i=0; i < tamVetorProjeto && vetorProjeto[i] != null; i++) {
			vetorProjeto[i].getData_inicio();
		}
		
	}
	
}
