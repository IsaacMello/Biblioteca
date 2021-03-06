package Livros;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Livro 
{
    
    private int pages;
    private int issue;
    private int code;
    private String title;
    private String author;
    private String type;
    private int quantidade;
    private int available;
        
    public void livro(int pages, int issue, int code, String title, String author, String type, 
                int quantity, int available)      // construtor para o objeto livro
    {
        
        this.pages = pages;                 //n�mero de p�ginas passados para o construtor
        this.issue = issue;                 // edi��o do livro
        this.code = code;                   // c�digo do livro
        this.title = title;                 // t�tulo do livro
        this.author = author;               // autor que escreveu o livro
        this.type = type;                   // tipo do livro, texto ou geral
        this.available = available;         // Disponibilidade do livro 
        this.quantidade = quantity;           // Quantidade desse livro
    }

    public void setAvailable(int available)
    {
        this.available = available;
    }

    public int getQuantity()
    {
        return quantidade;
    }

    public int getAvailable()
    {
        return available;
    }

    public String getType()
    {
        return type;
    }
    
    public int getPages()
    {
        return pages;
    }

    public int getIssue()
    {
        return issue;
    }

    public int getCode()
    {
        return code;
    }

    public String getTitle()
    {
        return title;
    }
    
    public String getAuthor() 
    {
        return author;
    }
    
    public void printBook()
    {
        PrintStream pw = new PrintStream(System.out);
            
        pw.println("//--------------------------------------");   
        pw.println("||C�digo: " + this.getCode());
        pw.println("||T�tulo: " + this.getTitle());
        pw.println("||Autor: " + this.getAuthor());
        pw.println("||Edi��o: " + this.getIssue());
        pw.println("||Tipo: " + ((this.getType().equals("T")) ? "Texto" : "Geral"));
        pw.println("||Quantidade de p�ginas: " + this.getPages());
        pw.println("||Quantidade dispon�vel: " + this.getAvailable());
        pw.println("||Quantidade total: " + this.getQuantity());
        pw.println("\\\\--------------------------------------");
    }
    
    public void addFileBook() 
    {
        try
        {
            File fp = new File("livros.csv"); // variavel que 'representara' o arquivo book
            FileWriter fw = new FileWriter(fp, true); // empacotar o file para que possa escrever nele, e adicionar o campo true para indicar append
            PrintWriter pw = new PrintWriter(fw); // cria um PrintWriter que ir� escrever no arquivo

            if(fp.exists() == false) // caso o arquivo nao exista, cria um arquivo
            { 
                System.out.println("NAO EXISTE ARQUIVO");
                fp.createNewFile();
            }
            // ### Escrever os itens do livro aqui nesta linha ### //
            // Comandos que salvam os itens no arquivo
            
            pw.print(this.getCode());
            pw.print(",");
            pw.print(this.getTitle());
            pw.print(",");
            pw.print(this.getAuthor());
            pw.print(",");
            pw.print(this.getIssue());
            pw.print(",");
            pw.print(this.getType());
            pw.print(",");
            pw.print(this.getPages());
            pw.print(",");
            pw.print(this.getAvailable());
            pw.print(",");
            pw.println(this.getQuantity());
            
            // #Termina de gravar os itens no arquivo com uma quebra de linha no final do arquivo# //
            
            pw.close(); 
            fw.close();
        }
        catch(Exception e){
            System.out.println("Algo errado aconteceu D:\n");
        }
    }

    public void setQuantity(int quantity) 
    {
        this.quantidade = quantity;
    }
    
    public boolean compareTo(Livro book) // m�todo para comparar o livro "this" com o livro "book"
    {
        if (this.getPages() != book.getPages())
            return (false);
        
        if (this.getIssue() != book.getIssue())
            return (false);
        
        if (!this.getTitle().equals(book.getTitle()))
            return (false);
        
        if (!this.getAuthor().equals(book.getAuthor()))
            return (false);
        
        if (!this.getType().equals(book.getType()))
            return (false);
        
        return (true);
    }
}