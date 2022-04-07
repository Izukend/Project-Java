import java.util.ArrayList;
import java.util.Random;

/**
 * @author Izukend
 * @since 03/04/2022, 15:01
 */
public class App {
    public static void main(String[] args){
        Guerrier g1 = new Guerrier("Jean-Eude");
        Guerrier g2 = new Guerrier("Michel");
        Guerrier g3= new Guerrier();
        System.out.println(g3);

        /**for (int i=0; i<3;i++){
            g1.vieillir();
            System.out.println(g1.toString());
            g2.vieillir();
            System.out.println(g2.toString());
        }

        //Tant que les guerriers g1 et g2 ne sont pas faible les afficher
        while(!g1.estFaible()&&!g2.estFaible()){
            System.out.println(g1.toString());
            System.out.println(g2.toString());
        }
        g1.combattre(g2);
        System.out.println(g1);

        //Boucle pour permettre a g1 de vieillir si il est vivant
        while(g1.estVivant()){
            g1.vieillir();
        }
        System.out.println(g1);*/

        //Partie création et test de clan de Guerrier
        Clan cl1= new Clan();
        System.out.println(cl1);

        //Création d'un clan de guerriers et les fait vieillir jusqu'à la mort
        ArrayList<Guerrier> Clan_bushi = new ArrayList<>();
        Clan_bushi.add(g1);
        Clan_bushi.add(g2);
        for(Guerrier vieillirclan : Clan_bushi){
            if(vieillirclan.estVivant()){
                vieillirclan.vieillir();
            }
        }

    }
    public static void combattreAMort() {
        Clan clan1 = new Clan("Clan 1") ;
        Clan clan2 = new Clan("Clan 2") ;
        Guerrier g_1 ;
        Guerrier g_2 ;
        // On jour avec 10 guerriers dans chaque clan
        for (int i = 0; i < 10; i++) {
            g_1 = new Guerrier() ;
            g_2 = new Guerrier() ;
            clan1.ajouter(g_1) ;
            clan1.ajouter(g_2) ;
        }
        ArrayList<Guerrier> net_clan1 ;
        ArrayList<Guerrier> net_clan2 ;
        Guerrier g1 ;
        Guerrier g2 ;
        Random r = new Random() ;
        while ( (!clan1.estDecime()) | (!clan2.estDecime()) ) {
            net_clan1 = clan1.nettoyer() ;
            net_clan2 = clan2.nettoyer() ;
            int n1 = 0 + r.nextInt(net_clan1.size() - 0) ;
            int n2 = 0 + r.nextInt(net_clan2.size() - 0) ;
            g1 = net_clan1.get(n1) ;
            g2 = net_clan2.get(n2) ;
            g1.combattre(g2) ;
            clan1.vieillir() ;
            clan2.vieillir() ;
        }
    }
}
