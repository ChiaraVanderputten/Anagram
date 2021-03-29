package it.polito.tdp.anagram.model;

import java.util.List;

public class Anagram {
	
	public List <String> anagrammi (String parola){
		
		permuta("",parola,0); //LANCIA la ricostruzione
		return null;
		
	}
                              //per ricordarci a che livello siamo, rappresenta la 
	                         //dimensione della soluzione parziale
	                        //livello iniziale 0, devono conoscere la soluzione parziale
	                       //e quali sono le lettere anccora rimaste, da considerare
	                      //parziale = stringa che contiene l'anagramma incompleto
	                     //lettere = le lettere della parola inizlae che ancora non abbiamo usato
	private void permuta (String parziale,String lettere, int livello) {
		
		if(lettere.length()==0) { //il caso terminale è quando non ho più lettere
			
			//la soluzione parziale è anche una soluzione completa!!
			System.out.println(parziale);
			
		}else {
			//fai ricorsione
			//genera sottoproblemi == una lettera (un sigolo carattere) di 'lettere'
			
			for(int pos=0; pos < lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos) ;
				
				String nuovaParziale = parziale + tentativo;               //aggiorno la soluzione parziale
				String nuoveLettere = lettere.substring(0, pos)+ lettere.substring(pos+1);//togli il carattere pos da lettere;
					
						permuta(nuovaParziale, nuoveLettere, livello+1);   //finito
				
				//Backtracking (IN QUESTO CASO NON CI SERVE PERCHE' CREO 2 NUOVE STRING ALTRIMENTI
				//DOVEVO RIMETTERLA APPOSTO ALLA FINE DEL FOR, TUTTE LE VARIABILI DEVONO ESSERE UGUALI A PRIMA
				//SENZA AVERE I RESIDUI DEI TENTAIVI PRECEDENTI CHE INQUININO I SUCCESSIVI)
				//rimetti a posto ' parziale ' 
				//rimetti a posto lettere
			}
			
		}
	}
	
	
	
}
