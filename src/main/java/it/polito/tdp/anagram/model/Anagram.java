package it.polito.tdp.anagram.model;

import java.util.ArrayList;
import java.util.List;

public class Anagram {
	
	public List <String> anagrammi (String parola){
		
		List <String> risultato = new ArrayList<>(); //o potevo metterlo nella classe al di fuori dei metodi -> più comodo e veloce
		                                            //ma un po meno strutturato
		
		permuta("",parola,0, risultato); //LANCIA la ricostruzione
		
		 //prima di returnarla dovrei cancellare le parole non valide leggendo il dizionario
		// il problema di trovare tutti gli anagrammi lo lascio a permuta
	   //oppure lo faccio prima di aggiungere -> piu intelligente perchè non ha sneso togliere cose da aggiungere
	  //però complico permuta perchè devo dargli l'accesso al dizionario e la cosa si complica, non cambia molto nell'efficienza, 
	 //il numero di volte in cui cercherei nel dizionario è lo stesso
	//terza soluzione -> durante la ricorsione controlliamo che il prefisso creato parziale sia presente nel dizionario, magari già
   //il parziale non esiste come aqz che non esiste nel dizionario
		//qua taglio solo le foglie dell'albero cioè quando ormai trovato le soluzuini finali
		
		return risultato;
	}
                              //per ricordarci a che livello siamo, rappresenta la 
	                         //dimensione della soluzione parziale
	                        //livello iniziale 0, devono conoscere la soluzione parziale
	                       //e quali sono le lettere anccora rimaste, da considerare
	                      //parziale = stringa che contiene l'anagramma incompleto
	                     //lettere = le lettere della parola inizlae che ancora non abbiamo usato
	private void permuta (String parziale,String lettere, int livello, List <String> risultato) {
		
		if(lettere.length()==0) { //il caso terminale è quando non ho più lettere
			
			//la soluzione parziale è anche una soluzione completa!!
			 //System.out.println(parziale);
			//if(parziale è una parola valida?) -> aggiungi alla lista
			//mi serve un luogo in cui salvare le parziali così che anagrammi() sappia dove trovarle
			
			risultato.add(parziale);
			
		}else {
			//fai ricorsione
			//genera sottoproblemi == una lettera (un sigolo carattere) di 'lettere'
			
			for(int pos=0; pos < lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos) ;
				
				String nuovaParziale = parziale + tentativo;               //aggiorno la soluzione parziale
				String nuoveLettere = lettere.substring(0, pos)+ lettere.substring(pos+1);//togli il carattere pos da lettere;
					
				//qua potrei controllare se la nuova parziale è un prefisso valido di almeno una parola nel dizionario
				//if(nuovoParziale è un prefisso valido di almeno una parola nel dizionario)
				//es car -> carrello, carro -> va bene e vado avanti aggiungendo altre lettere, aqz non esiste invece
				//combinazioni che non hanno senso -> taglio un intero ramo, ma la ricerca è lunga quindi dipende quanto è vantaggioso
				//per dog probabilmente non lo è perchè ci sono pochi anagrammi
				//potrei anche volere controllare che non si formino anagrammi doppi prima di inserirli in un set che li elimina così da 
				//non compiere iterazioni inutili
				
						permuta(nuovaParziale, nuoveLettere, livello+1, risultato);   //finito
				
						//qua è dove quadagno il tempo perchè taglio i rami in anticipo prima di iterare
						
				//Backtracking (IN QUESTO CASO NON CI SERVE PERCHE' CREO 2 NUOVE STRING ALTRIMENTI
				//DOVEVO RIMETTERLA APPOSTO ALLA FINE DEL FOR, TUTTE LE VARIABILI DEVONO ESSERE UGUALI A PRIMA
				//SENZA AVERE I RESIDUI DEI TENTAIVI PRECEDENTI CHE INQUININO I SUCCESSIVI)
				//rimetti a posto ' parziale ' 
				//rimetti a posto lettere
			}
			
		}
	}
	
	
	
}
