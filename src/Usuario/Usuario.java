package Usuario;

import java.util.ArrayList;
import java.util.Scanner;

import Menu.Menu;
import classes.Discente;
import controllers.DiscenteController;

public class Usuario {

	DiscenteController acessoDiscente = new DiscenteController();
	Menu acessoMenu= new Menu();
	Scanner ler = new Scanner(System.in);
	ArrayList<Usuario> usuario;
	Discente aux;
	int opcao;

	public void listarUsuarios() {
		ArrayList<Discente> usuario = new ArrayList<Discente>();

		int tamanhoDiscente = acessoDiscente.discentes.size();

		for (int i = 0; i < tamanhoDiscente; i++) {
			aux = acessoDiscente.discentes.get(i);
			usuario.add(aux);
		}

		System.out.println(usuario);

	}

	public Object buscarUsuario() {
		String buscaUsuario = "";

		System.out.println("Insira o nome do usuario a ser busca: ");

		buscaUsuario = ler.nextLine();

		if (buscaUsuario.equals(usuario.contains(buscaUsuario))) {

			System.out.println(usuario);
		}

		else {
			System.out.println("Usuário não encontrado");

			return acessoMenu;
		}
		return buscaUsuario;

	}

	public ArrayList<Usuario> getName() {
		// TODO Auto-generated method stub
		return usuario;
	}

}
