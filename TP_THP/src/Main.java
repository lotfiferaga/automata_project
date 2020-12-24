import java.util.*;

public class Main {
    public static void main(String args[]) {
        // on crée L'APLPHABET de l'automate
        ArrayList<Character> alphabet = new ArrayList<Character>();
        alphabet.add('a');
        alphabet.add('b');

        //on crée LES ETATS de l'automate
        //Etat initial
        Etat etatInitial = new Etat("S0", TypeEtat.ETAT_INITIAL);
        Etat etatIntermediaire = new Etat("S1", TypeEtat.ETAT_INTERMEDIAIRE);
        Etat etatFinal = new Etat("S2", TypeEtat.ETAT_FINAL);

        //on crée les états  de l'automate
        ArrayList<Etat> ensembleEtats = new ArrayList<Etat>();
        ensembleEtats.add(etatInitial);
        ensembleEtats.add(etatIntermediaire);
        ensembleEtats.add(etatFinal);

        //on crée les états  FINAUX de l'automate
        ArrayList<Etat> ensembleEtatsFinaux = new ArrayList<Etat>();
        ensembleEtatsFinaux.add(etatFinal);

        //les instructions de l'automate
        Instruction ins1 = new Instruction(etatInitial, 'a', etatInitial);
        Instruction ins2 = new Instruction(etatInitial, 'a', etatIntermediaire);
        Instruction ins3 = new Instruction(etatIntermediaire, 'b', etatIntermediaire);
        Instruction ins4 = new Instruction(etatIntermediaire, 'b', etatFinal);
        Instruction ins5 = new Instruction(etatFinal, 'c', etatFinal);

        ArrayList<Instruction> ensembleInstructions = new ArrayList<Instruction>();
        ensembleInstructions.add(ins1);
        ensembleInstructions.add(ins2);
        ensembleInstructions.add(ins3);
        ensembleInstructions.add(ins4);
        ensembleInstructions.add(ins5);

        // Automate crÃ©Ã© ....
        Automate automate = new Automate(alphabet, ensembleEtats, etatInitial, ensembleEtatsFinaux, ensembleInstructions);

        System.out.println("Appartient au langage ? = "+ automate.reconnaitMot("accc")+"\n1 : Oui , 0 : Non");

    }
}


