package fr.pantheonsorbonne.cri;

public class Card {

    public enum Suite {
        TREFLE, COEUR, CARREAU, PIQUE;
    }
    private Suite suite;
    private String value;
    private int rawValue;
   
    public Card(int s, int v) { // nous avons considerer un packet complet de 2-10, Jack, Queen, King, Ace
        this.suite = Suite.values()[s - 1];
        if(v >= 2 && v <= 10) {
            this.value=String.valueOf(v);
        } else if(v == 11) {
            this.value = "JACK";
        }  else if(v == 12) {
            this.value = "QUEEN";
        }  else if(v == 13) {
            this.value = "KING";
        }  else if(v == 14) {
            this.value = "ACE";
        }
        this.rawValue = v;
    }

    public int getRawValue() {
        return rawValue;
    }
    
    @Override // pour n'avoir pas d'adresses a l'ecran
    public String toString() {
        return  value + " " + suite.toString() ; 
    }
}
