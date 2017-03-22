package Usuario;

public class Cadastro {

	
	
	UsuariosExistentes acessarUsuarios = new UsuariosExistentes();
	GerarID acessarID = new GerarID();
	public void cadastroUsuarios() {
		

		System.out.println("Nome:" + acessarUsuarios.nome());
		System.out.println("Matricula:" + acessarUsuarios.matricula());
		System.out.println("ID:" + acessarUsuarios.matricula+GerarID.getProximaMatricula());

	}
	
	
}
