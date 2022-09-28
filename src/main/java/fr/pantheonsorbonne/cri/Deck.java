package fr.pantheonsorbonne.cri;
import java.util.Random;
import java.util.ArrayList;


public class Deck {


    ArrayList<Card> cards;
    Random draw;

    public  Deck() {
        draw = new Random();
        generateDeck(); // initialisation du tous les combinaisons possibles des cartes
    }

    private void generateDeck() {
        cards = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            for (int j = 2; j < 15; j++) {
                Card card1 = new Card(i, j);
                cards.add(card1);
            }
        }
    }

    public Card[] newRandomHand(){
        Card[] hand = new Card[5];
        int size,j;
        for(int i = 0; i < 5; i++) {
            size = cards.size();
            j = draw.nextInt(size);
            hand[i] = cards.get(j);
            cards.remove(j);

        }
        return hand;
    }
    public Card[] getRandomCards(int n){
        Card[] randomCards = new Card[n];
        int size,j;
        for(int i = 0; i<n; i++) {
            size = cards.size();
            j = draw.nextInt(size);
            randomCards[i] = cards.get(j);
            cards.remove(j);

        }
        return randomCards;

    }

    

    
}
