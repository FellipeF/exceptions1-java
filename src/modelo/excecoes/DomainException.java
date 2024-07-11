package modelo.excecoes;

public class DomainException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    
    //Possibilidade de instanciar a exceção personalizada passando uma mensagem para ela
    public DomainException(String msg)
    {
        super(msg);
    }
    
}
