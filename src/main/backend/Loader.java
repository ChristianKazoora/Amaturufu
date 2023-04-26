package main.backend;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Loader implements Iterator<Card> {
    public static ArrayList<Card> Deck = new ArrayList<Card>();
    public ArrayList<Card> playerCards = new ArrayList<Card>();
    public static ArrayList<Card> cpuCards = new ArrayList<Card>();
    Card iturufu;

    Loader() {
        File allCards = new File("src/main/allCards.csv");
        Scanner in = null;

        try {
            in = new Scanner(allCards);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
//must be 36 cards minus
        while (in.hasNextLine()) {
            String[] card = in.nextLine().split(",");
            Deck.add(new Card(card[0].trim(), card[1]));
        }
        Collections.shuffle(Deck);
    }

    @Override
    public boolean hasNext() {
        if (!(Deck.isEmpty())) {
            return true;
        }
        return false;
    }

    @Override
    public Card next() {
        Collections.shuffle(Deck);
        int count = 0;
        Card current = Deck.remove(count);
        count++;
        return current;
    }

    public Card iturufu() {
        int rand = (int) (Math.random() * (35 - 0 + 1) + 0);
        iturufu = Deck.get(rand);
        return iturufu;
    }

    public void toAString() {
        for (int i = 0; i < Deck.size(); i++) {
            System.out.println(Deck.get(i).getCard());
        }

    }

    public void startingPick() {
        for (int i = 0; i < 4; i++) {
            this.playerCards.add(i, Deck.remove(i));
        }
        for (int i = 0; i < 4; i++) {
            cpuCards.add(i, Deck.remove(i));
        }

    }

    public void cpuPick1() {
        if (Deck != null) {
            cpuCards.add(Deck.remove(0));
        }
    }

    public void playerPick1() {
        if (Deck != null) {
            playerCards.add(Deck.remove(0));

        }
    }

    public void playerPick1(int clicked) {
        if (Deck != null) {
            playerCards.add(clicked, Deck.remove(0));

        }
    }

}
