package br.gov.ba.sde.sace.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class UsuarioInexistenteException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public UsuarioInexistenteException(){
		super("Usuário não cadastrado");
	}

}
