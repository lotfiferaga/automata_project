import java.util.*;

public class Automate {
    ArrayList<Character> alphabet;
    ArrayList<Etat> ensembleEtats;
    Etat etatInitial;
    ArrayList<Etat> ensembleEtatsFinaux;
    ArrayList<Instruction> ensembleInstructions;

    public Automate(ArrayList<Character> alphabet, ArrayList<Etat> ensembleEtats, Etat etatInitial, ArrayList<Etat> ensembleEtatsFinaux, ArrayList<Instruction> ensembleInstructions) {
        this.alphabet = alphabet;
        this.ensembleEtats = ensembleEtats;
        this.etatInitial = etatInitial;
        this.ensembleEtatsFinaux = ensembleEtatsFinaux;
        this.ensembleInstructions = ensembleInstructions;

    }
    //Methode qui associe a chaque transition le couple (Etat courant,Reste mot a analyser)//....

    //Methode qui reconnait ou pas un mot par l'automate
    public int reconnaitMot(String mot) {
        String resteMot = mot;
        boolean debut = true;
        boolean stop = false;
        Deque<Couple> pile = new ArrayDeque<>();
        Etat etatCourant = this.etatInitial;

        ArrayList<Instruction> list = new ArrayList<>();

        while (!stop) {
            if (debut) {
                retourneInstruction(this.etatInitial.nomEtat, list, debut, 'b');
                Iterator<Instruction> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Instruction inst = ((Instruction) iterator.next());
                    Couple couple = new Couple(this.etatInitial, resteMot);
                    pile.add(couple);
                    debut = false;
                    etatCourant = this.etatInitial;
                }
            } else {
                while (!pile.isEmpty()) {
                    list.clear();
                    retourneInstruction(etatCourant.nomEtat, list, debut, resteMot.charAt(0));
                    if (list.isEmpty()) {// Y a pas de transition : echec
                        if ((resteMot.equals("")) && (this.ensembleEtatsFinaux.contains(etatCourant))) {
                            return 1;
                        } else {
                            //pile.removeLast();
                        }
                    } else {
                        //pile.removeLast();
                        resteMot = resteMot.substring(1);
                        if ((resteMot.equals("")) && (this.ensembleEtatsFinaux.contains(etatCourant))) {
                            return 1;
                        }
                        Iterator<Instruction> iterator = list.iterator();
                        while (iterator.hasNext()) {
                            Instruction inst = ((Instruction) iterator.next());
                            Couple couple = new Couple(inst.etatDepart, resteMot);
                            pile.add(couple);
                        }
                    }
                    etatCourant = pile.getLast().etatCourant;
                    resteMot = pile.getLast().resteMotAAnalyser;
                    while (resteMot.equals("")) {
                        if (this.ensembleEtatsFinaux.contains(etatCourant)) {
                            return 1;
                        } else {
                            pile.removeLast();
                            etatCourant = pile.getLast().etatCourant;
                            resteMot = pile.getLast().resteMotAAnalyser;
                        }
                    }
                    pile.removeLast();
                }
            }
                if (pile.isEmpty()) stop = true;
        }
        return 0;
    }

    public void retourneInstruction(String etat, ArrayList<Instruction> list, boolean debut,char lettre){
        if (debut)
        {
        Iterator<Instruction> iterator = this.ensembleInstructions.iterator();
        while (iterator.hasNext()) {
            Instruction inst = ((Instruction) iterator.next());
            if ((inst.etatDepart.nomEtat.equals(etat))){//&&(inst.etatDepart.nomEtat.equals(inst.etatArrivee.nomEtat)==false)) {
                list.add(inst);
            }
        }
        }
        else{
            ArrayList<Etat> listeIntermediaire = new ArrayList<>();
            Iterator<Instruction> iterator = this.ensembleInstructions.iterator();
            while (iterator.hasNext()) {
                Instruction inst = ((Instruction) iterator.next());
                if ((inst.etatDepart.nomEtat.equals(etat))&&(inst.lettre==lettre)) {
                    listeIntermediaire.add(inst.etatArrivee);
                }
            }
            Iterator<Instruction> iterator1 = this.ensembleInstructions.iterator();
            while (iterator1.hasNext()) {
                Instruction inst = ((Instruction) iterator1.next());
                if (listeIntermediaire.contains(inst.etatDepart)) {
                    list.add(inst);
                }
            }

                }
            }
    public HashSet<Etat> getEtatArriv(HashSet<Etat> etat,char alpha,ArrayList<Instruction> instruction) {
    	
    	HashSet<Etat> etatReturn = new HashSet<Etat>(); 
    	Iterator<Etat> j= etat.iterator();
    	Etat E = null;
    	while (j.hasNext())
    	{
    		E=j.next();
    	for (int i=0;i<instruction.size();i++) {
    		if ((instruction.get(i).etatDepart.nomEtat ==E.nomEtat)&&(instruction.get(i).lettre==alpha)) {
    		//	etatString+=instruction.get(i).etatArrivee.nomEtat;
    			etatReturn.add(instruction.get(i).etatArrivee);
    		}
    	}
}
        
    	return etatReturn;
    	}
        public String nomEtat (HashSet<Etat> etat) {
        	String etatString="";
        	Iterator<Etat> i= etat.iterator();
        	while (i.hasNext()) {
        		etatString+=i.next().nomEtat;
        	}
        	return etatString;
        }
        /*
        public boolean Compare(HashSet<Etat> hashset1,HashSet<Etat> hashset2) {
        	boolean equal;
        	int cmpt=0;
        	if (hashset1.size()!=hashset2.size()) {
        		return false;
        	}
        	else {
        		Etat etat1 =null;
        		Etat etat2 = null;
        		Iterator it1=hashset1.iterator();
        		Iterator it2=hashset2.iterator();
        		while (it1.hasNext()) {
        			etat1 = (Etat) it1.next();
        			while (it2.hasNext()) {
        				etat2=(Etat)it2.next();
        				if (etat1.nomEtat==etat2.nomEtat) {
        					cmpt++;
        				}
        			}
        		}
        		cmpt++;
            	if ((cmpt>hashset1.size()) && (cmpt>hashset2.size())) {
            		return true;
            	}
            	else return false;
        	}

        }
        */
    }

        


