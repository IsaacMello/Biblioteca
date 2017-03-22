package Usuario;

import java.util.Scanner;

public class Acesso {
	
	private static String login="", senha="";
	
	Scanner ler = new Scanner(System.in);
	
	
	public String login(){
		
		System.out.println("Insira o login: ");			
		login = ler.nextLine();
		return login;
	}
	
	
	public String senha(){
				
		System.out.println("Insira a senha: ");
		senha = ler.nextLine();
		return senha;
	}
	
	

}
