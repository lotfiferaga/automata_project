import java.util.*;

public class Mirroir {
	
	Automate automate;
	
	public Mirroir(Automate automate)
	{
		this.automate=automate;
	}
	
	//méthode pour éffectuer le mirroir 
	public void effectuerMirroir()
	{
		
		//on vérifie si l'automate possède plusieurs etats finaux 
           if(automate.ensembleEtatsFinaux.size()>=2)
           {
			//on crée un etat final avec des transitions spontané
			Etat ef=new Etat("ef",TypeEtat.ETAT_FINAL);
			automate.ensembleEtatsFinaux.clear();
			automate.ensembleEtatsFinaux.add(ef);
			//on effectue les changements dans la liste des etats 
			//Iterator<Etat> it = automate.ensembleEtats.iterator();
			int i=0;
            while(i<automate.ensembleEtats.size())
            {
            	if(automate.ensembleEtats.get(i).typeEtat==TypeEtat.ETAT_FINAL)
            	{
            		automate.ensembleEtats.get(i).typeEtat=TypeEtat.ETAT_INTERMEDIAIRE;
            		Instruction ins=new Instruction(automate.ensembleEtats.get(i),' ',ef);
    				automate.ensembleInstructions.add(ins);
            	}
            	i++;
            }
            automate.ensembleEtats.add(ef);
           }
                        
            //on change les états dans l'ensemble d'états  
           int k=0;
           while(k<automate.ensembleEtats.size())
           {
        	   
        	   if(automate.ensembleEtats.get(k).typeEtat==TypeEtat.ETAT_FINAL)
        	   {
        		   automate.ensembleEtats.get(k).typeEtat=TypeEtat.ETAT_INITIAL;
        	   }
        	   k++;
           }
           //on commence à appliquer les règles de mirroir 
           automate.etatInitial.typeEtat=TypeEtat.ETAT_FINAL;
           int j=0;
           while(j<automate.ensembleEtats.size())
           {
        	   if(automate.ensembleEtats.get(j).typeEtat==TypeEtat.ETAT_INITIAL)
        	   {
        		   automate.etatInitial=automate.ensembleEtats.get(j);
        	   }
        	   j++;
           }
           //on change les états finaux 
		  
           int o=0;
           while(o<automate.ensembleEtats.size())
           {
        	   if(automate.ensembleEtats.get(o).typeEtat==TypeEtat.ETAT_FINAL)
        	   {
        		   automate.ensembleEtatsFinaux.add(automate.ensembleEtats.get(o));
        	   }
        	   o++;
           }
           
           // traitement final
           int p=0;
           while(p<automate.ensembleEtatsFinaux.size())
           {
        	   if(automate.ensembleEtatsFinaux.get(p).typeEtat==TypeEtat.ETAT_INITIAL)
        	   {
        		   automate.ensembleEtatsFinaux.remove(p);
        	   }
        	   p++;
           }
           
           //on inverse les instructions dans l'ensemble 
           ArrayList<Instruction> list=new ArrayList<Instruction>();
           int l=0;
           while(l<automate.ensembleInstructions.size())
           {
        	 //on inverse les instructions 
        	Instruction swapped=new Instruction(automate.ensembleInstructions.get(l).etatArrivee,automate.ensembleInstructions.get(l).lettre,automate.ensembleInstructions.get(l).etatDepart);
        	 //on créé une nouvelle liste des instructions inversée 
        	list.add(swapped); 
        	   l++;
           }
           automate.ensembleInstructions.clear();
           automate.ensembleInstructions.addAll(list);
           	
	}
	
	public void afficher()
	{
		System.out.println("LE MIRROIR DE L'AUTOMATE  ");
		System.out.println("-----------------------------");
		System.out.println("L'ALPHABET DE L'AUTOMATE ");
		Iterator<Character> ch=automate.alphabet.iterator();
		while(ch.hasNext())
		{
			System.out.println(ch.next()+",");
			
		}
		System.out.println("-----------------------------");
		System.out.println("L'Etat initial");
		System.out.println("-----------------------------");
		System.out.println(automate.etatInitial.nomEtat+":"+automate.etatInitial.typeEtat);
		
		System.out.println("-----------------------------");
		System.out.println("Les Etats ");
		System.out.println("-----------------------------");
		int r=0;
		while(r<automate.ensembleEtats.size())
		{
			System.out.println(automate.ensembleEtats.get(r).nomEtat+":"+automate.ensembleEtats.get(r).typeEtat);
            r++;
		}
		System.out.println("-----------------------------");
		System.out.println("Les Etats finaux ");
		System.out.println("-----------------------------");
		int x=0;
		while(x<automate.ensembleEtatsFinaux.size())
		{
			System.out.println(automate.ensembleEtatsFinaux.get(x).nomEtat+":"+automate.ensembleEtatsFinaux.get(x).typeEtat);
            x++;
		}
		System.out.println("-----------------------------");
		System.out.println("Les instructions  ");
		System.out.println("-----------------------------");
		int y=0;
		while(y<automate.ensembleInstructions.size())
		{
			System.out.println(automate.ensembleInstructions.get(y).etatDepart.nomEtat+"."+automate.ensembleInstructions.get(y).lettre+"."+automate.ensembleInstructions.get(y).etatArrivee.nomEtat);
            System.out.println("-->");
			y++;
		}
	}
    
	public static void main(String[] args) {
		//definition de l'automate pour effectuer le mirroir 
		// on crée l'alphabet de l'automate 
		ArrayList<Character> alpha = new ArrayList<Character>();
	    alpha.add('a');
	    alpha.add('b');
	    alpha.add('c');
	    
	    //on crée les états de l'automate 
	    Etat S0=new Etat("S0",TypeEtat.ETAT_INITIAL);  //l'etat initial
	    Etat S1=new Etat("S1",TypeEtat.ETAT_INTERMEDIAIRE);  //etat intermidiare
	    Etat S2=new Etat("S2",TypeEtat.ETAT_INTERMEDIAIRE);  //etat intermidiare 
	    Etat S3=new Etat("S3",TypeEtat.ETAT_INTERMEDIAIRE);   //etat intermidiare 
	    Etat S4=new Etat("S4",TypeEtat.ETAT_INTERMEDIAIRE);
	    Etat Sf=new Etat("Sf",TypeEtat.ETAT_FINAL);   //etat final 
	    
	    //on crée l'ensemble des etats 
	    ArrayList<Etat> ae=new ArrayList<Etat>();  //AE = ensemble des état sde l'automate 
	    //l'ajout des etats dans l'ensemble 
	    ae.add(S0);
	    ae.add(S1);
	    ae.add(S2);
	    ae.add(S3);
	    ae.add(S4);
	    ae.add(Sf);
	    
	    //la liste des états finaux 
	    ArrayList<Etat> fin=new ArrayList<Etat>();
	    fin.add(Sf);
	    
	    //les instructions de l'automate 
        Instruction ins1 = new Instruction(S0, 'a',S1);
        Instruction ins2 = new Instruction(S0, 'b',S3);
        Instruction ins3 = new Instruction(S0, 'c',S4);
        Instruction ins4 = new Instruction(S1, 'a',S1);
        Instruction ins5 = new Instruction(S3, 'b',S3);
        Instruction ins6 = new Instruction(S4, 'c',S4);
        Instruction ins7 = new Instruction(S1, 'b',S2);
        Instruction ins8 = new Instruction(S3, 'a',S2);
        Instruction ins9 = new Instruction(S4, 'c',S2);
        Instruction ins10 = new Instruction(S2, 'a',Sf);

	   //ensemble des instructions I
        ArrayList<Instruction> I=new ArrayList<Instruction>();
        //ajout des instructions dans la liste I 
        I.add(ins1);
        I.add(ins2);
        I.add(ins3);
        I.add(ins4);
        I.add(ins5);
        I.add(ins6);
        I.add(ins7);
        I.add(ins8);
        I.add(ins9);
        I.add(ins10);
        //les paramètres de l'automate 
        ArrayList<Character> alphabet=new ArrayList<Character>();
        ArrayList<Etat> ensembleEtats=new ArrayList<Etat>();
        Etat etatInitial;
        ArrayList<Etat> ensembleEtatsFinaux=new ArrayList<Etat>();
        ArrayList<Instruction> ensembleInstructions=new ArrayList<Instruction>();
        //on définit les paramètres
        alphabet.addAll(alpha);
        ensembleEtats.addAll(ae);
        etatInitial=S0;
        ensembleEtatsFinaux.addAll(fin);
        ensembleInstructions.addAll(I);
        //création de l'automate 
        Automate auto = new Automate(alphabet, ensembleEtats, etatInitial, ensembleEtatsFinaux, ensembleInstructions);
         
        Mirroir m=new Mirroir(auto);
        m.effectuerMirroir();
        m.afficher();        
		System.out.println("***************************");
		System.out.println("     Deuxieme automate      ");
		System.out.println("***************************");

        //deuxieme automate 
        //création de l'alphabet 
        ArrayList<Character> alphab=new ArrayList<Character>();
        alphab.add('a');
        alphab.add('b');
        //on crée les états de l'automate 
	    Etat SI=new Etat("SI",TypeEtat.ETAT_INITIAL);  //l'etat initial
	    Etat Sf1=new Etat("Sf1",TypeEtat.ETAT_FINAL);  //etat intermidiare
	    Etat Sf2=new Etat("Sf2",TypeEtat.ETAT_FINAL);  //etat intermidiare 
	    //création d'ensemble des etats 
	    ArrayList<Etat> etat2=new ArrayList<Etat>();
	    etat2.add(SI);
	    etat2.add(Sf1);
        etat2.add(Sf2);
        //création ensembles des états finaux 
        ArrayList<Etat> f=new ArrayList<Etat>();
        f.add(Sf1);
        f.add(Sf2);
        //création des instructions 
        Instruction in1 = new Instruction(SI, 'a',Sf1);
        Instruction in2 = new Instruction(SI, 'b',Sf2);
        //ensemble des instructions 
        ArrayList<Instruction> in=new ArrayList<Instruction>();
        in.add(in1);
        in.add(in2);
        Automate au = new Automate(alphab, etat2,SI,f,in);
        Mirroir M=new Mirroir(au);
        M.effectuerMirroir();
        M.afficher();

	}

}
