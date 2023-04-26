package main.backend;

public class Card {
    //Variable for card value
    String card=null;
    //variable for suit
    String suit=null;



    /**
    * Constructer for the Card class it takes in the card as the value and the suite 
    * @param card
    * @param suit
    */
    public Card(String card,String suit)
    {
        //saving the cars value
        this.card=card;
        this.suit=suit;
    }
   /**
    * @return the current card as String
    */
    public  String getCard()
    {
        return this.card+" "+this.suit;
    }
    /** 
     * @return the current suite as String
     */

    public  String getSuite()
    {
        return this.suit;
    }
    /**
     * @return just the card name with no suite
     */
    public String getCardName()
    {
        return card;
    }
    /**
     * @return then returns the numeric value
     */
    public int value()
    {
        //Checking if card is an "A" to return a maximum of 11 
        if(card.equals("A"))
        {
            return 11;
        }
        //Checking if card is a "7" to return a 10 
        else if(card.equals("7"))
        {
            return 10;
        }
        //Checking if card is a "K" to return a 4
        else if (card.equals("K"))
        {
            return  4;
        }
        //Checking if card is a "J" to return a 3
        else if (card.equals("J"))
        {
            return 3;
        }
        //Checking if card is a "Q" to return a 2
        else if (card.equals("Q"))
        {
            return 2;
        }
        //Checking if card is a "3,4,5,6" to return a 0
        else if(card.equals("3")||card.equals("4")||card.equals("5")||card.equals("6"))
        {
            return 0;
        }
        //unreachable return 
        return 1;
    }
    @Override
    public String toString() {
        return card +" "+ suit;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        Card other = (Card) obj;
        return value()==(other.value()) && suit.equals(other.suit);
    }
 
}