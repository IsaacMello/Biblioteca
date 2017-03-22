package Usuario;

import java.util.Scanner;

public class Usuario {
	static int opcao;
	static String nomeBusca = "";
	static Scanner ler = new Scanner(System.in);
	
	static Cadastro acessoCadastro = new Cadastro();

	public static void main(String args[]) {		

		

		System.out.println("1 - Cadastrar usuário: ");
		System.out.println("2 - Alterar cadastro de usuário: ");
		System.out.println("3 - Sair: ");

		opcao = ler.nextInt();

		if (opcao == 1) {
			acessoCadastro.cadastroUsuarios();
		}

		else if (opcao == 2) {
			
		}

		else {
			System.out.println("Opção inválida!!");
		}
	}

	
	
	

}
