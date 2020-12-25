# automata_project
ceci est un projet sur les automates finis deterministes, 
la reconnaissance des mots et la réduction 
des automate ainsi que le mirroir d'un automate !
dont chaque classe représente l'une des fonctions des automate !
toutes est programmées en JAVA avec l'IDE Eclipse en optant pour 
un paradigme Orienté Objet ;
dont tous les structures de données utilisées dans ce mini-projet 
sont définies dans leurs classes d'utilisation !

# Def 
Les langages sont reconnus par des machines
formelles appelées: automates ou systèmes
reconnaisseurs qui étant donnée un mot sont
capable de dire si c’est mot appartient ou pas à
un langage.
Un automate à états finis (AF) est un modèle d’un
système et de son évolution, c’est-à-dire une
description formelle du système et de la manière
dont il se comporte.

# Classes et fonctionnalités de chaque classe
ci-dessous tous les classes Java qui contient le fonctionnement 
de ce projet

# Etat
déclaration de l'état nom,type, accessible ou co-accessible toute dépend de son 
type !
         
    String nomEtat;
    TypeEtat typeEtat;
    Boolean Access=false;
    Boolean Co_Access=false;
              
# Mirroir 
la classe qui va effectuer le mirroir d'un automate donné et l'affiche en écran !
           
      Autmate auto; 
                    
# TypeEtat 
le type etat définie un ensemble énumeré pour tous les états possible 
pour l'automate .
         
      public enum TypeEtat {
           ETAT_FINAL, ETAT_INITIAL, ETAT_INTERMEDIAIRE;
        }
                        
# Couple

    Etat etatCourant;
    String resteMotAAnalyser;
    
# Instruction 
la forme général d'une instruction est <état du départ ,caractère du transition,état d'arrivé>
            
    Etat etatDepart;
    char lettre;
    Etat etatArrivee;
                   
# Automate 
tous les variables qui vont contenir les composantes d'un automate 
pour qu'on peut les manipuler plus tard. 
                  
    ArrayList<Character> alphabet;
    ArrayList<Etat> ensembleEtats;
    Etat etatInitial;
    ArrayList<Etat> ensembleEtatsFinaux;
    ArrayList<Instruction> ensembleInstructions;
              
ainsi que des méthodes de reconnaissance des mots pour la cohérance 
des résultats.

 # AutomateRED
on définit notre automate RED pour qu'il sera réduit après et on affiche le résultat 
final en mode texte !
            
    Automate RED;
                
 # Deterministe 
Il est défini par un quintuplet A = (Q, X, , q0
, F ),
où :
– Q: est un ensemble fini d’états
– X: est un ensemble fini de symboles (l’alphabet)
– q0  Q: est l’état initial de l’automate
– F  Q: est l’ensemble des états finaux (ou
terminaux) de l’automate.
–  est une application de Q * X dans Q, appelée
fonction de transition de l’automate
      
 # Note 
Vous pouvez l'utiliser comme vous voulez :) 


