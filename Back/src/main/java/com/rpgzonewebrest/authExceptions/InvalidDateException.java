package com.rpgzonewebrest.authExceptions;

public class InvalidDateException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6184416280443181937L;

	public InvalidDateException(int parteOfDate){
	      super("Data inválida parte da data " + parteOfDate + " !!!");
	}
}
