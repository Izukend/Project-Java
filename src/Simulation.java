/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Izukend
 */
public class Simulation {
    
    public int Simuler(int n) {
        Clan monClan = new Clan("monClan") ;
        Guerrier g ;
        for (int i = 0; i < n; i++) {
            g = new Guerrier() ;
            monClan.ajouter(g) ;
        }
        
        while (!monClan.estDecime()) {
            monClan.vieillir() ;
        }
        return monClan.lePlusVieux() ;
    }
    
    public int Simuler10() {
        Clan monClan = new Clan("monClan") ;
        Guerrier g ;
        for (int i = 0; i < 10; i++) {
            g = new Guerrier() ;
            monClan.ajouter(g) ;
        }
        
        while (!monClan.estDecime()) {
            monClan.vieillir() ;
        }
        return monClan.lePlusVieux() ;
    }
    
    public double Simuler20() {
        Clan monClan = new Clan("monClan") ;
        Guerrier g ;
        for (int i = 0; i < 10; i++) {
            g = new Guerrier() ;
            monClan.ajouter(g) ;
        }
        
        while (!monClan.estDecime()) {
            monClan.vieillir() ;
        }
        
        double ageMoyen = 0.0 ;
        for (int i = 0; i < monClan.getElements().size(); i++) {
            ageMoyen += monClan.getElements().get(i).getAge() ;
        }
        ageMoyen = ageMoyen / monClan.getElements().size() ;
        return ageMoyen ;
        
    }
    
}
