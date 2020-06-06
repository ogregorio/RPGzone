package com.rpgzonewebrest.models.data;

import java.io.Serializable;

import com.rpgzonewebrest.authExceptions.InvalidDateException;

public abstract class Date implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ano = 0;
	private int mes = 0;
	private int dia = 0;
	private String dayOfWeek = "";
	private int [] calendario = {};
	private static final int [] CALENDARIO_GREGORIANO_NORMAL = {31,28,31,30,31,30,31,31,30,31,30,31};
	private static final int []  CALENDARIO_GREGORIANO_BISEXTO = {31,29,31,30,31,30,31,31,30,31,30,31};
   
	public void setAno(int ano) throws InvalidDateException {
		if(ano < 1800 || ano > 2025 ){//depois colocar mais q 2020
         throw new InvalidDateException(ano);
      }
      else{
         this.ano = ano;
      }
	}
	
	public void setMes(int mes) throws InvalidDateException {
		if(mes < 1 || mes > 12){
         throw new InvalidDateException(mes);
      }
      else{
         this.mes = mes;
      }
	}
	
	public void setDia(int dia) throws InvalidDateException {
		this.setCalendario();
		if(dia < 1 || dia > this.calendario[this.getMes() - 1]){
         throw new InvalidDateException(dia);
      }
      else{
         this.dia = dia;
      }
	}
	
	public void setCalendario() {
		if(this.eAnoBisexto()) {
			this.calendario = CALENDARIO_GREGORIANO_BISEXTO;
			return;
		}
		this.calendario = CALENDARIO_GREGORIANO_NORMAL;
	}
	
	public int getDia() {
		return this.dia;
	}
	public int getMes() {
		return this.mes;
	}
	public int getAno() {
		return this.ano;
	}
	
	public int diasNoMes() {
		return this.calendario[this.getMes() - 1];
	}
	
	public String decideDia(int j) {
		switch (j) {
          case 0:
            return "Sábado";
          case 1:
            return "Domingo";
          case 2:
            return "Segunda";
          case 3:
            return "Terça";
          case 4:
            return "Quarta";
          case 5:
            return "Quinta";
          case 6:
            return "Sexta";
          default:
            return "Erro ao tentar retornar o dia da semana";
		}
	}
	
	public String diaDaSemana() {
		int a = ((12 - this.getMes()) / 10);
		int b = this.getAno() - a;
		int c = this.getMes() + (12 * a);
		int d = b / 100;
		int e = d / 4;
		int f = 2 - d + e;
		int g = (int) (365.25 * b);
		int h = (int) (30.6001 * (c + 1));
		int i = (int) ((f + g) + (h + this.getDia()) + 5);
		int j = (int) (i % 7); 
		return decideDia(j);
	}
	
	
	public boolean eAnoBisexto() {
		int i = this.getAno();
		return ((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0);
	}
	
	public boolean dadosValidos() {
		if(this.getAno() == 0 || this.getMes() == 0 || this.getDia() == 0)
			return false;
		return true;
	}
	
    public Date(int ano, int mes, int dia) throws InvalidDateException {
    	this.setAno(ano);
    	this.setMes(mes);
		this.setDia(dia);
		System.out.println("date ano mes e dia " + this.dia + " / " + this.mes + " / " + this.ano );
		this.setDayOfWeek( this.diaDaSemana() );
    }
    public Date() {  }
    
    public abstract String formatoData();
    
    @Override
    public String toString(){
      return "Data numérica : " + this.formatoData();
    }
    
    

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	} 
}
