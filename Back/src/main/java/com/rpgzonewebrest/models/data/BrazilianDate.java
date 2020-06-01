package com.rpgzonewebrest.models.data;

import com.rpgzonewebrest.authExceptions.InvalidDateException;

public class BrazilianDate  extends Date{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BrazilianDate(int ano, int mes, int dia) throws InvalidDateException {
    	super(ano, mes, dia);
    }
	public BrazilianDate() {  }
   
    @Override
    public String formatoData(){
       String mes = (this.getMes() < 10) ? "0" + this.getMes() : Integer.toString(this.getMes());
       return this.getDia() + "/" + mes + "/" + this.getAno();
    }
    @Override
    public boolean equals(Object obj){
    	BrazilianDate date = ( (BrazilianDate) obj );
    		if( date.getDia() == this.getDia() && date.getMes() == this.getMes() && date.getAno() == this.getAno() ){
    			return true;
    		}
    	return false;
    }
}
