package com.rpgzonewebrest.util;

import java.util.ArrayList;
import java.util.List;

public class Ordenador {
	public static List<Ordenavel> crescente ( List<Ordenavel> entrada ) {
		Ordenavel temp;
		List<Ordenavel> output = new ArrayList<Ordenavel>();
		output.addAll(entrada);
		
	    for(int i = 1 ; i < output.size() ; i++) {
	       for(int j = i; j > 0; j--){
	          if(output.get(j).menorQue( output.get( j - 1 ) ) ){
	             temp = output.get( j );
	             output.set(j, output.get(j - 1));
	             output.set(j - 1, temp);
	          }
	       }
	    }
	    return output;
	 }
	 public static Ordenavel [] decrescente ( Ordenavel [ ] entrada) {
	    Ordenavel temp ;
	    Ordenavel [] saida = entrada.clone();
	    for(int i = 1 ; i < saida.length; i++){
	       for(int j = i ; j > 0 ; j--){
	          if(!saida[ j ].menorQue (saida[ j - 1 ] ) ) {
	             temp = saida[ j ] ;
	             saida [ j ] = saida[ j - 1 ];
	             saida [ j - 1 ] = temp ;
	          }
	       }
	    }
	    return saida ;
	 }
}
