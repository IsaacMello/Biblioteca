package Usuario;

public class Cadastro {

	
	UsuariosExistentes acessarUsuarios = new UsuariosExistentes();

	public void cadastroUsuarios() {
		

		System.out.println("Nome:" + acessarUsuarios.nome());
		System.out.println("Matricula:" + acessarUsuarios.matricula());

	}

}
