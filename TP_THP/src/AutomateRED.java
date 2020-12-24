import java.util.ArrayList;

public class AutomateRED {
	Automate RED;
	
	public AutomateRED(Automate RED)
	{
		this.RED=RED;
	}
	
	public void afficher()
	{
		//affichage de l'alphabet 
		System.out.println("--------------------");
		System.out.println("----   alphabet ----");
		System.out.println("--------------------");
		int i=0;
		while(i<RED.alphabet.size())
		{
			System.out.println(RED.alphabet.get(i));
			i++;
		}
		
		System.out.println("--------------------");
		System.out.println("-  Etat Initial ----");
		System.out.println("--------------------");
		System.out.println(RED.etatInitial.nomEtat+":"+RED.etatInitial.typeEtat);
		System.out.println("--------------------");
		System.out.println("  Ensemble des etats");
		System.out.println("--------------------");
	    int j=0;
	    while(j<RED.ensembleEtats.size())
	    {
	    	System.out.println(RED.ensembleEtats.get(j).nomEtat+":"+RED.ensembleEtats.get(j).typeEtat);
	    	if(RED.ensembleEtats.get(j).Access)
	    	{
	    		System.out.println("Etat Accessible ");
	    	} else {
	    		System.out.println("Etat Non Accessible ");
	    	}
	    	
	    	if(RED.ensembleEtats.get(j).Co_Access)
	    	{
	    		System.out.println("Etat CO-Accessible ");
	    	} else {
	    		System.out.println("Etat Non CO-Accessible ");
	    	}
	    	
	    	j++;
	    }
	    
	    System.out.println("--------------------");
		System.out.println("-  Etat Final   ----");
		System.out.println("--------------------");
	    int k=0;
	    while(k<RED.ensembleEtatsFinaux.size())
	    {
	    	System.out.println(RED.ensembleEtatsFinaux.get(k).nomEtat+":"+RED.ensembleEtatsFinaux.get(k).typeEtat);
            k++;
	    }
	    
	    System.out.println("--------------------");
		System.out.println("-  Instructions ----");
		System.out.println("--------------------");
		int l=0;
		while(l<RED.ensembleInstructions.size())
		{
			System.out.println(RED.ensembleInstructions.get(l).etatDepart.nomEtat+"."+RED.ensembleInstructions.get(l).lettre+"."+RED.ensembleInstructions.get(l).etatArrivee.nomEtat);
		    System.out.println("-->");
			l++;
		}
	
	}
	
	public void reduire()
	{
		// on parcours les instructions pour verifier l'accessibilité des etat 
		int i=0;
		while(i<RED.ensembleInstructions.size())
		{
			if(RED.ensembleInstructions.get(i).etatDepart.getAccess())
			{
				RED.ensembleInstructions.get(i).etatArrivee.setAccess(true);
			} 
			else {
				RED.ensembleInstructions.get(i).etatArrivee.setAccess(false);
			}
			
			if(RED.ensembleInstructions.get(i).etatArrivee.getCo_Access())
			{
				RED.ensembleInstructions.get(i).etatDepart.setCo_Access(true);
			} 
			else {
				RED.ensembleInstructions.get(i).etatDepart.setCo_Access(false);
			}
				i++;
		} 
	}

	public static void main(String[] args) {
        //premier automate de test 
		//definition de l'automate pour effectuer le mirroir 
		// on crée l'alphabet de l'automate 
		ArrayList<Character> alpha = new ArrayList<Character>();
	    alpha.add('a');
		alpha.add('b');
	    alpha.add('c');
	    alpha.add('d');
			    
	    //on crée les états de l'automate 
		Etat S0=new Etat("S0",TypeEtat.ETAT_INITIAL);  //l'etat initial
		Etat S1=new Etat("S1",TypeEtat.ETAT_INTERMEDIAIRE);  //etat intermidiare
	    Etat S2=new Etat("S2",TypeEtat.ETAT_INTERMEDIAIRE);  //etat intermidiare 
		Etat S3=new Etat("S3",TypeEtat.ETAT_FINAL);   //etat intermidiare 
	    Etat S4=new Etat("S4",TypeEtat.ETAT_INTERMEDIAIRE);
	    Etat S5=new Etat("S5",TypeEtat.ETAT_INTERMEDIAIRE);
	    Etat S6=new Etat("S6",TypeEtat.ETAT_FINAL); // etat final
	    Etat S7=new Etat("S7",TypeEtat.ETAT_INTERMEDIAIRE);
	    //les états finaux 
	    ArrayList<Etat> ff=new ArrayList<Etat>();
	    ff.add(S6);
	    ff.add(S3);
	    //on définit l'accessibilité des etats 
	    S0.setAccess(true);    // l'etat initial accessible 
	    S6.setCo_Access(true);  // etat final aussi 
	    S3.setCo_Access(true);  // l'etat final est co-accessible
	    //on crée l'ensemble des etats 
	    ArrayList<Etat> ae=new ArrayList<Etat>();  //AE = ensemble des état sde l'automate 
	    ae.add(S0);
	    ae.add(S1);
	    ae.add(S2);
	    ae.add(S3);
	    ae.add(S4);
	    ae.add(S5);
	    ae.add(S6);
	    ae.add(S7);

	    //l'ensemble d'instruction
	    ArrayList<Instruction> ins=new ArrayList<Instruction>();
	     
	    //on définit les instructions 
	    Instruction ins1=new Instruction(S0,'a',S1);
	    Instruction ins2=new Instruction(S1,'a',S3);
	    Instruction ins3=new Instruction(S1,'b',S2);
	    Instruction ins4=new Instruction(S5,'b',S0);
	    Instruction ins5=new Instruction(S5,'d',S1);
	    Instruction ins6=new Instruction(S4,'c',S1);
	    Instruction ins7=new Instruction(S6,'c',S4);
	    Instruction ins8=new Instruction(S7,'d',S7);
         
	    //on remplit l'ensemble des instruction 
	    ins.add(ins1);
	    ins.add(ins2);
	    ins.add(ins3);
	    ins.add(ins4);
	    ins.add(ins5);
	    ins.add(ins6);
	    ins.add(ins7);
	    ins.add(ins8);
	    
	    //creation de l'automate 
        Automate au = new Automate(alpha,ae,S0,ff,ins);
        
        AutomateRED rep=new AutomateRED(au);
        rep.reduire();
        rep.afficher();
        	    
		
	}

}
