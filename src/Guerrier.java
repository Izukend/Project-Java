/**
 * @author Izukend
 * @since 03/04/2022, 14:18
 */

//Continuer a partir de la 2.1
import java.util.Random;

public class Guerrier {
    // Attributs d'un Guerrier
    private String nom;
    private int age;
    private int force;
    private int exp;
    private int etat_sante;
    // Attribut commun à tous les Guerriers (variable de classe)
    private static int nb = 0 ; // Nombre total de Guerriers créés

    // Constantes
    private final static int FORCE_MIN = 1, FORCE_MAX = 5,
            SANTE_MIN = 0, SANTE_MAX = 100, LIMITE_FAIBLESSE = 40,
            IMPACT_BLESSURE = -10, // Perte de santé pour un combat perdu
            GAIN_EXPERIENCE = 1, // Gain d'expérience pour un combat remporté
            EXPERIENCE_MIN = 0, EXPERIENCE_MAX = 10,
            AGE_MIN_DEPART = 20, AGE_MAX_DEPART = 50,
            LIMITE_JEUNESSE = 30, LIMITE_VIEILLESSE = 50,
            CHANCE_MAX = 10,
            DELTA_ETAT_RENF = 5,	// Un guerrier dont l'état de santé s'améliore gagne ce nombre d'unité
            DELTA_ETAT_AFFAIBL = -7; // Un guerrier dont l'état de santé se détériore perd ce nombre d'unité
    private static final double CHANCE_RENF_JEUNE_SAIN = 0.6, // Un guerrier jeune et sain possède 60% de chance d'améliorer son état
            CHANCE_RENF_JEUNE_FAIBLE = 0.5,
            CHANCE_RENF_ADULTE_SAIN = 0.7,
            CHANCE_RENF_ADULTE_FAIBLE = 0.6,
            CHANCE_RENF_VIEUX_SAIN = 0.4,
            CHANCE_RENF_VIEUX_FAIBLE = 0.2;

    // Constructeur
    /* TODO-1 Initialisation aléatoire des attributs.
     * Incrémentez l'attribut nb pour compter le nombre de guerriers créés
     */
    public Guerrier(String nom){
        this.nom= nom;
        this.force = entierAleatoire(FORCE_MIN,FORCE_MAX);
        this.etat_sante= entierAleatoire(LIMITE_FAIBLESSE , SANTE_MAX);
        this.age= entierAleatoire(AGE_MIN_DEPART, AGE_MAX_DEPART);
        this.exp= EXPERIENCE_MIN;

    }
    // TODO-2 Constructeur sans paramètre
    public Guerrier(){
        this.nom= "Anonyme-"+ nb;
    }

    /************ Méthodes **************/
    // Getteurs de niveau 1
    // TODO getForce et getExperience
    public int getForce() {
        return force;
    }
    public int getExp(){
        return exp;
    }
    // Getteurs de niveau 2
    // TODO-1 estMort et estVivant
    public boolean estMort(){
        if (etat_sante==SANTE_MIN){
            return true;
        }
        return false;
    }
    public boolean estVivant(){
        if (etat_sante>SANTE_MIN){
            return true;
        }
        return false;
    }
    // TODO-2 estFaible
    public boolean estFaible(){
        if(etat_sante<LIMITE_FAIBLESSE){
            return true;
        }
        return false;
    }
    // TODO-3 estJeune, estVieux, estAdulte
    public boolean estJeune(){
        if(age<30){
            return true;
        }
        return false;
    }
    public boolean estVieux(){
        if(age>50){
            return true;
        }
        return false;
    }
    public boolean estAdulte(){
        if(!estVieux()&&!estJeune()){
            return true;
        }
        return false;
    }
    // Setteurs de niveau 1
    // TODO modifierExperience et modifierSante
    public void modifierExperience(int n){
        int gain_exp = exp +n ;
    }
    public void modifierSante(int n){
        int blessure= etat_sante +n;
    }
    // Setteurs de niveau 2

    // TODO-1 vieillir
    public void vieillir(){
        if(this.estVivant()){
            age ++;
            this.evoluer();
        }
    }
    // TODO-2 combattre
    public void combattre(Guerrier adversaire){
        int résultat= (this.exp - adversaire.exp) + (this.force - adversaire.force)+ entierAleatoire(-CHANCE_MAX, CHANCE_MAX);
        if(résultat<0){
            adversaire.modifierExperience(GAIN_EXPERIENCE);
            this.modifierSante(IMPACT_BLESSURE);
        }else{
            this.modifierExperience(GAIN_EXPERIENCE);
            adversaire.modifierSante(IMPACT_BLESSURE);
        }
    }
    // Autres
    public void evoluer() {
        int delta = 0 ;
        if(this.estJeune()) {
            if(!this.estFaible()) {
                if(chance(CHANCE_RENF_JEUNE_SAIN)) {
                    delta = DELTA_ETAT_RENF;
                } else {
                    delta= DELTA_ETAT_AFFAIBL;
                }
            } else {
                if(chance(CHANCE_RENF_JEUNE_FAIBLE)) {
                    delta = DELTA_ETAT_RENF;
                } else {
                    delta= DELTA_ETAT_AFFAIBL;
                }
            }
        }
        if(this.estAdulte()) {
            if(!this.estFaible()) {
                if(chance(CHANCE_RENF_ADULTE_SAIN)) {
                    delta = DELTA_ETAT_RENF;
                } else {
                    delta= DELTA_ETAT_AFFAIBL;
                }
            } else {
                if(chance(CHANCE_RENF_ADULTE_FAIBLE)) {
                    delta = DELTA_ETAT_RENF;
                } else {
                    delta= DELTA_ETAT_AFFAIBL;
                }
            }
        }
        if(this.estVieux()) {
            if(!this.estFaible()) {
                if(chance(CHANCE_RENF_VIEUX_SAIN)) {
                    delta = DELTA_ETAT_RENF;
                } else {
                    delta= DELTA_ETAT_AFFAIBL;
                }
            } else {
                if(chance(CHANCE_RENF_VIEUX_FAIBLE)) {
                    delta = DELTA_ETAT_RENF;
                } else {
                    delta= DELTA_ETAT_AFFAIBL ;
                }
            }
        }
        this.modifierSante(delta) ;
    }



    /*********** Préparation à l'affichage  : méthode toString ******************/
    // TODO-1 toString
    public String toString() {
        if (estVivant() &! estFaible()){
            if (estJeune()){
                return "Guerrier{" +
                        "nom=" + nom +
                        ", age=" + age +
                        ", force=" + force +
                        ", sante=" + etat_sante +
                        ", experience=" + exp +
                        ", jeune" +
                        ", en bonne santé"+'}';
            }
            if(estVieux()){
                return "Guerrier{" +
                        "nom=" + nom +
                        ", age=" + age +
                        ", force=" + force +
                        ", sante=" + etat_sante +
                        ", experience=" + exp +
                        ", vieux" +
                        ", en bonne santé"+'}';
            }
            if(estAdulte()){
                return "Guerrier{" +
                        "nom=" + nom +
                        ", age=" + age +
                        ", force=" + force +
                        ", sante=" + etat_sante +
                        ", experience=" + exp +
                        ", adulte" +
                        ", en bonne santé"+'}';
            }
        }
        if (estVivant() && estFaible()){
            if (estJeune()){
                return "Guerrier{" +
                        "nom=" + nom +
                        ", age=" + age +
                        ", force=" + force +
                        ", sante=" + etat_sante +
                        ", experience=" + exp +
                        ", jeune" +
                        ", en bonne santé"+'}';
            }
            if(estVieux()){
                return "Guerrier{" +
                        "nom=" + nom +
                        ", age=" + age +
                        ", force=" + force +
                        ", sante=" + etat_sante +
                        ", experience=" + exp +
                        ", vieux" +
                        ", en bonne santé"+'}';
            }
            if(estAdulte()){
                return "Guerrier{" +
                        "nom=" + nom +
                        ", age=" + age +
                        ", force=" + force +
                        ", sante=" + etat_sante +
                        ", experience=" + exp +
                        ", adulte" +
                        ", en bonne santé"+'}';
            }
        }
        if (estJeune()){
            return "Guerrier{" +
                    "nom=" + nom +
                    ", age=" + age +
                    ", force=" + force +
                    ", sante=" + etat_sante +
                    ", experience=" + exp +
                    ", jeune" +
                    ", en bonne santé"+'}';
        }
        if(estVieux()){
            return "Guerrier{" +
                    "nom=" + nom +
                    ", age=" + age +
                    ", force=" + force +
                    ", sante=" + etat_sante +
                    ", experience=" + exp +
                    ", vieux" +
                    ", en bonne santé"+'}';
        }
        return "Guerrier{" +
                "nom=" + nom +
                ", age=" + age +
                ", force=" + force +
                ", sante=" + etat_sante +
                ", experience=" + exp +
                ", adulte" +
                ", en bonne santé"+'}';

    }


    // TODO-2 affichage
    //A revoir avant de rendre le TEA
    public String affichage(){
        if(estFaible()){
            return "/";
        }if(!estFaible()){
            return "|";
        }
        return "Pas de guerrier existant";
    }

    /************ Outils locaux (private) **********************/
    private static boolean chance(double x) {
        return Math.random()<x;
    }
    private int entierAleatoire(int min, int max) {
        return (int)(min+(max+1-min)*Math.random());
    }
}
