package Biblioteca;

import java.util.Scanner;

import Livros.Livro;
import Usuario.Usuario;
import Emprestimo.Emprestimo;

public class Biblioteca {

	public Biblioteca() {

		int opcao;

		Scanner ler = new Scanner(System.in);
		Usuario acessoUsuario = new Usuario();
		Emprestimo acessoEmprestimo = new Emprestimo();
		Livro acessoLivro = new Livro();

		try {

			System.out.println("BIBLIOTECA");
			System.out.println("1 - Listar todos os usuarios");
			System.out.println("2 - Buscar Usuario");
			System.out.println("3 - Listar todos os livros");
			System.out.println("4 - Buscar livro");
			System.out.println("5 - Emprestimo");

			opcao = ler.nextInt();

			if (opcao == 1) {

				acessoUsuario.listarUsuarios();

			}

			else if (opcao == 2) {
				acessoUsuario.buscarUsuario();
			}

			else if (opcao == 3) {
				String author = null;
				int pages = 0;
				int quantity = 0;
				int issue = 0;
				String title = null;
				int available = 0;
				String type = null;
				acessoLivro.livro(pages, issue, hashCode(), title, author, type, quantity, available);
			}

			else if (opcao == 4) {
				acessoLivro.getTitle();
			}

			else if (opcao == 5) {
				String dateMax = null;
				int codeBook = 0;
				String dateBorrow = null;
				String dateReturn = null;
				int codeUser = 0;
				boolean returned = false;

				acessoEmprestimo.emprestimo(hashCode(), codeUser, codeBook, returned, dateBorrow, dateReturn, dateMax);
			}

		}

		catch (Exception e) {
			System.out.println("Opcão Inválida");
		}

	}
}