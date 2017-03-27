package Emprestimo;

import Livros.Livro;
import Usuario.Usuario;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Emprestimo 
{
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Objeto para a data do sistema
    
    private int code;                       // c�digo do empr�st�mo
    private int codeUser;                   // c�digo do usu�rio
    private int codeBook;                   // c�digo do livro
    private boolean returned;               // vari�vel para verificar a devolu��o do livro
    private Calendar dateBorrow;            // Ir� armazenar a data de empr�stimo
    private Calendar dateReturn;            // Ir� armazenar a data de devolu��o
    private Calendar dateMax;               // Ir� armazenar a data m�xima de devolu��o

    
    public void emprestimo(int code, int codeUser, int codeBook, boolean returned, 
            String dateBorrow, String dateReturn, String dateMax)   // Construtor para a classe de empr�stimo
    {
        String[] date;                      // String para armazenar a data
        
        this.code = code;                   // Armazena o c�digo de empr�stimo
        this.codeUser = codeUser;           // Armazena o c�digo do usu�rio
        this.codeBook = codeBook;           // Armazena o c�digo do livro 
        this.returned = returned;           // Verifica a devolu��o do livro 'true' devolvido e 'false' para pend�ncia na devolu��o
        
        date = dateBorrow.split("/");       // Divis�o com barras da data armazenada na vari�vel date
        
        this.dateBorrow = new GregorianCalendar     // Ir� pegar a data  de empr�stimo
        (
                Integer.parseInt(date[2]), 
                Integer.parseInt(date[1]) - 1, Integer.parseInt(date[0])
        );
        
        date = dateReturn.split("/");       // Divis�o com barras da data armazenada na vari�vel date
        
        this.dateReturn = new GregorianCalendar   // Ir� pegar a data de devolu��o
        (
                Integer.parseInt(date[2]), 
                Integer.parseInt(date[1]) - 1, Integer.parseInt(date[0])
        );
        
        date = dateMax.split("/");                 // Divis�o com barras da data armazenada na vari�vel date
        
        this.dateMax = new GregorianCalendar(      //  Ir� armazenar a data m�xima de devolu��o dependendo do tipo do usu�rio
                Integer.parseInt(date[2]), 
                Integer.parseInt(date[1]) - 1, Integer.parseInt(date[0])
        );
    }
    // Getters e setters da classe de empr�stimos //
    
    public Calendar getDateMax()
    {
        return dateMax;
    }

    public void setDateMax(Calendar dateMax)
    {
        this.dateMax = dateMax;
    }
    
    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public int getCodeUser()
    {
        return codeUser;
    }

    public void setCodeUser(int codeUser)
    {
        this.codeUser = codeUser;
    }

    public int getCodeBook()
    {
        return codeBook;
    }

    public void setCodeBook(int codeBook)
    {
        this.codeBook = codeBook;
    }

    public boolean isReturned()
    {
        return returned;
    }

    public void setReturned(boolean returned)
    {
        this.returned = returned;
    }

    public Calendar getDateBorrow()
    {
        return dateBorrow;
    }

    public void setDateBorrow(Calendar dateBorrow)
    {
        this.dateBorrow = dateBorrow;
    }

    public Calendar getDateReturn()
    {
        return dateReturn;
    }

    public void setDateReturn(Calendar dateReturn)
    {
        this.dateReturn = dateReturn;
    }
    
    public void printBorrowing(Usuario user, Livro book)   //M�todo que ir� imprimir na sa�da todas as especifica��es do usu�rio
    {
        PrintStream pw = new PrintStream(System.out);
        
        pw.println("//--------------------------------------");   
        pw.println("||C�digo: " + this.getCode());
        
        if (user != null)
            pw.println("||Nome do usu�rio: " + user.getName());
        
        if (book != null)
            pw.println("||Nome do Livro: " + book.getTitle());
        
        pw.println("||Foi devolvido: " + (this.isReturned() ? "Sim" : "N�o"));
        pw.println("||Data de empr�stimo: " + dateFormat.format(dateBorrow.getTime()));
        
        if (this.isReturned())
            pw.println("||Data de devolu��o: " + dateFormat.format(dateReturn.getTime()));
        
        pw.println("||Data m�xima de devolu��o: " + dateFormat.format(dateMax.getTime()));
        pw.println("\\\\--------------------------------------");
    }
    
    public void addFileBorrowing()  //m�todo que ir� armazenar no arquivo a situa��o de empr�stimo do usu�rio
    {
        try 
        {
            File fp = new File("emprestimos.csv");
            FileWriter fw = new FileWriter(fp, true);
            PrintWriter pw = new PrintWriter(fw); // cria um PrintWriter que ir� escrever no arquivo

            if(fp.exists() == false)
            { // caso o arquivo nao exista, cria um arquivo
                fp.createNewFile();
            }
            
            // Comandos que salvam os dados no arquivo, observe que ap�s a adi��o de uma parte do livro � adicionada uma v�rgula para separa-los

            pw.print(this.getCode());
            pw.print(",");
            pw.print(this.getCodeUser());
            pw.print(",");
            pw.print(this.getCodeBook());
            pw.print(",");
            pw.print(this.isReturned());
            pw.print(",");
            pw.print(dateFormat.format(this.getDateBorrow().getTime()));
            pw.print(",");
            pw.print(dateFormat.format(this.getDateReturn().getTime()));
            pw.print(",");
            pw.println(dateFormat.format(this.getDateMax().getTime()));

            // #Termina de gravar os itens no arquivo com uma quebra de linha no final do arquivo# //
            
            pw.close(); 
            fw.close();
        }
        catch(Exception e){
            System.out.println("Alguma coisa estranha aconteceu\n");
        }
    }
}