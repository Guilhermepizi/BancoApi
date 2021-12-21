package br.com.service.banco.advisor;

public class EntityNotFoundException  extends RuntimeException{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String message){
        super(message);
    }
}
