package fr.pantheonsorbonne.cri;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Player {
    static Scanner sc=new Scanner(System.in);
    private String name;
    public Card[] hand;

    public Player( String unNom){
        this.name=unNom;
    }
    
    
    
    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public void addCard(Card[] carte){
        int j = 0;
        for(int i=0;i<hand.length;i++){
            if(hand[i]==null){
                hand[i]=carte[j];
                j++;
            }
        }
    }

    public Card[] getCardsToDiscard() {
        System.out.println(name + " sil vous plais, cartes echanger (0-5):");
        System.out.println(getHandString());
        int ech=sc.nextInt();
        Card[] discard=new Card[ech];
        for(int i=0;i<ech;i++){
            System.out.println("Position carte echange (1-5): ");
            int num=sc.nextInt();
            for(int j=0;j<hand.length;j++){
                if(j+1==num){
                    hand[j] = null;
                    discard[i]=hand[j];
                }
            }
        }
        return discard;
    }

    // public static int jeux(Card[] cards){
    //     int countMax=1;
    //     for(int i=0;i<cards.length;i++){
    //         int count=1;
    //         for(int j=i+1;j<cards.length;j++){
    //             if(cards[i].equals(cards[j])){
    //                 count++;
    //             }
    //         }
    //         if(count>countMax){
    //             countMax=count;
    //         }
    //     }
    //     if(countMax==4)
    //         return 4;
    //     if(countMax==3)
    //         return 3;
    //     if(countMax==2)
    //         return 2;
    //     else
    //         return 0;
    // }

    private List<Integer> findLargestPair() {
        int pairs = 1;
        int card = 0;
        for (int i = 0; i < hand.length; i++) {
            int currentCard = hand[i].getRawValue();
            int currentPair = 1;
            for (int j = i + 1; j < hand.length; j++) {
                if (currentCard == hand[j].getRawValue()) {
                    currentPair++;
                }
            }
            if (currentPair > pairs) {
                pairs = Math.max(pairs, currentPair);
                card = currentCard;
            } else if (currentPair == pairs) {
                card = Math.max(card, currentCard);
            }
        }
        return Arrays.asList(pairs, card);
    }

    public boolean beats(Player joueur) {
        List<Integer> p1 = findLargestPair();
        List<Integer> p2 = joueur.findLargestPair();
        return p1.get(0) > p2.get(0) || (p1.get(0).equals(p2.get(0)) && p1.get(1) > p2.get(1));
    }

    public String getHandString() {
        return Arrays.toString(hand);
    }

    @Override
    public String toString() {
        return name;
    }

}
