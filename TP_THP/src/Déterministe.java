import java.util.*;
public class Déterministe {
 Automate automate;
 static Scanner scanner=new Scanner(System.in);
 static Scanner read=new Scanner(System.in);
 static Scanner lire=new Scanner(System.in);
 

 public void rendreDeterministe(Automate automate) {
	 
 }
 
 
 
 
 
 
 
public static void main(String [] args) 
{
ArrayList<Etat> ensembleEtat = new ArrayList<Etat>();
ArrayList<Character> alphabet = new ArrayList <Character>();
ArrayList<Etat> etatFinaux = new ArrayList<Etat>();
ArrayList<Instruction> Instruction = new ArrayList<Instruction>();


//------------------le nombre des etats--------------------------------------//
	int nbEtat;
	System.out.println("LE Nombre Des Etats");
	nbEtat = scanner.nextInt();
	System.out.println("--------------------------------------");
	System.out.println("Ensemble Des Etats Est :");
	for (int i=0;i<nbEtat;i++) 
	{
		Etat S = new Etat ("S"+Integer.toString(i),TypeEtat.ETAT_INTERMEDIAIRE);
		ensembleEtat.add(S);		
		System.out.print("S"+Integer.toString(i)+"|");
		
	}
	   //------------------------------------------------------------------------------//
	
	   //-------------------definir etat initiale-----------------------------------//
	ensembleEtat.get(0).SetType(TypeEtat.ETAT_INITIAL);
	System.out.println("");
	System.out.println("--------------------------------------");
	System.out.println("S0 est l'etat initial");
	System.out.println("--------------------------------------");
	   //------------------------------------------------------------------------------//
	
	   //-----------------------definir les etats finaux------------------------------//
	System.out.println("Definir les etats finaux : (ecrire le numéro de l'état)");
	boolean fin=false;
	int nE;
	
	while (!(fin)) {
		nE=scanner.nextInt();
		if (nE == -1) {
			fin=!fin;
		}
		else {
		etatFinaux.add(ensembleEtat.get(nE));
		ensembleEtat.get(nE).SetType(TypeEtat.ETAT_FINAL);
		System.out.println(ensembleEtat.get(nE).nomEtat+" Est un etat final");
		System.out.println("Ecrire -1 Pour arreter");
		
		     }
	}
	   //------------------------------------------------------------------------------//
	
	//---------------------------Definir l'alphabet-----------------------------------//
	String Alphabet;
	System.out.println("Ecrire lensemble de l'alphabet");
	Alphabet = read.nextLine();
	System.out.println("l'ensemble de l'alphabet est ");
	for (int j=0;j<=Alphabet.length()-1;j++) {
		alphabet.add(Alphabet.charAt(j));
		System.out.print(Alphabet.charAt(j)+("|"));
	}
   //------------------------------------------------------------------------------//
 //---------------------------Definir les instructions-----------------------------------//
    System.out.println(" ");
	System.out.println("Definir les instructions: Format (nEtatDepart.Alphabet.nEtatD'arrivé) ex : 1.a.2");
	 //------------------------------------------------------------------------------//
   String Instructions;
   int cmpt=0;
   char alphabetchar =' ';
   Instructions = lire.nextLine();
   Etat Q = null;
   Etat QQ = null;
 
   for (int k=0;k<Instructions.length();k++) {
	   if ((k % 2) == 0) 
	   {
		   cmpt++;
		  if (cmpt == 1) {
			  Q=ensembleEtat.get(Character.getNumericValue(Instructions.charAt(k)));
		  }
		  if (cmpt == 2) {
			  alphabetchar = Instructions.charAt(k);
		  }
		  if (cmpt == 3) {
			  cmpt=0;
			  QQ=ensembleEtat.get(Character.getNumericValue(Instructions.charAt(k)));
			  Instruction instruction = new Instruction(Q,alphabetchar,QQ);
			  Instruction.add(instruction);
			  System.out.println(Q.nomEtat+"|"+alphabetchar+"|"+QQ.nomEtat);
			
		  }
		  
		   }
	   }
  
   //------------------------------------------------------------------------------//
    Automate automate = new Automate(alphabet,ensembleEtat,ensembleEtat.get(0),etatFinaux,Instruction);
    /*
    HashSet<Etat> hashset=new HashSet<Etat>();
    hashset.add(ensembleEtat.get(0));
    System.out.println(automate.nomEtat(automate.getEtatArriv(hashset,'a', Instruction)));
   */
   ArrayList<HashSet<Etat>> tableFirstRow = new ArrayList<HashSet<Etat>>();
     HashSet<Etat> row = new HashSet<Etat>();
     row.add(ensembleEtat.get(0));
     tableFirstRow.add(row);

    // row.removeAll(row);
  boolean notequal=true;
  
     for (int k=0;k<tableFirstRow.size();k++) {
    	
    	 
       for (int i=0;i<alphabet.size();i++) {
    	//   HashSet<Etat>tempHashset=new HashSet<Etat>();
    	  // tempHashset.addAll(automate.getEtatArriv(tableFirstRow.get(k),alphabet.get(i), Instruction));
    	   
    	   for (int l=0;l<tableFirstRow.size();l++) {
    		   //testing if it's equalt to any list in the arraylist
    		 //  if (tableFirstRow.get(l).equals(tempHashset)){
    		  // if (automate.Compare(tableFirstRow.get(l), automate.getEtatArriv(tableFirstRow.get(k),alphabet.get(i), Instruction))) {
    		   if ((automate.nomEtat(tableFirstRow.get(l)).equals(automate.nomEtat(automate.getEtatArriv(tableFirstRow.get(k),alphabet.get(i), Instruction))))) {
    			   notequal=false;
    		   }   
    	   }
    	   //System.out.println(notequal);
    	   System.out.print(automate.nomEtat(tableFirstRow.get(k))+"=>");
    	   System.out.print(alphabet.get(i)+"=>");
    	   System.out.println(automate.nomEtat(automate.getEtatArriv(tableFirstRow.get(k),alphabet.get(i), Instruction)));

    	   if (notequal) {
    		   
    		//  System.out.println(automate.nomEtat(automate.getEtatArriv(tableFirstRow.get(k),alphabet.get(i), Instruction)));
    	   tableFirstRow.add(automate.getEtatArriv(tableFirstRow.get(k),alphabet.get(i), Instruction));
    	   
    	   } 	
    	   notequal=true;
       }
     
       
      
     }
    
     System.out.print(tableFirstRow.size());
   
   }

                                     }
	



