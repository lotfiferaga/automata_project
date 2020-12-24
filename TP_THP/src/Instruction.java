public class Instruction {
    Etat etatDepart;
    char lettre;
    Etat etatArrivee;



    public Instruction(Etat etatDepart, char lettre, Etat etatArrivee) {
        this.etatDepart = etatDepart;
        this.lettre = lettre;
        this.etatArrivee = etatArrivee;
    }
    //Khorsi : Empty arguments constructor
    public Instruction() {
    	
    }

}
