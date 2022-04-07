/**
 * @author Izukend
 * @since 03/04/2022, 14:19
 */
import java.util.ArrayList;
public class Clan {

    //Atrribut
    private ArrayList<Guerrier>elements;
    private String nom;

    //Constructeurs
    public Clan(String nom){
        this.nom=nom;
        ArrayList<Guerrier> elements = new ArrayList<>();
    }
    public Clan(){
        ArrayList<Guerrier> elements = new ArrayList<>();
    }

    //Les méthodes
    public void ajouter(Guerrier Asta){
        elements.add(Asta);
    }
    public void vieillir(){
        for(Guerrier guerrier : elements){
            if(guerrier.estVivant()){
                guerrier.vieillir();
            }
        }
    }
    public boolean estDecime(){
        for(Guerrier guerrier : elements){
            if(guerrier.estMort()){
                return true;
            }
        }
        return false;
    }

    //Partie a faire vérifier
    public ArrayList<Guerrier> guerriersValides(){
        ArrayList<Guerrier> pasfaible = new ArrayList<>();
        for(Guerrier guerriers : elements){
            if(!(guerriers.estFaible())){
                pasfaible.add(guerriers);
            }
        }
        return pasfaible;
    }

    //Partie a faire vérifier
    public ArrayList<Guerrier> nettoyer(){
        ArrayList<Guerrier> supr= new ArrayList<>();
        for(Guerrier guerriers : elements){
            if(guerriers.estMort()){
                supr.add(guerriers);
            }
        }
        return supr;
    }

    public String affichage(){
        String string = new String();
        for(Guerrier guerriers : this.elements){
            string += guerriers.affichage();
        }
        return "||/|/|";
    }

    //Méthode toString
    @Override
    public String toString() {
        return "Clan{" +
                "elements=" + elements +
                ", nom='" + nom + '\'' +
                '}';
    }
}
