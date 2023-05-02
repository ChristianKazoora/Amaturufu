package main.backend;

public class Card {
    //Variable for card getValue
    String card;
    //variable for suit
    String suit;



    /**
    * Constructer for the Card class it takes in the card as the getValue and the suite
    * @param card
    * @param suit
    */
    public Card(String card,String suit)
    {
        //saving the cars getValue
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
     * @return then returns the numeric getValue
     */
    public int getValue()
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
        //Checking if card is a "1" to return a MaxInt
        else if(card.equals("1"))
        {
            return Integer.MAX_VALUE;
        }
        //Checking if card is a "0" to return a MinInt
        else if(card.equals("0"))
        {
            return Integer.MIN_VALUE;
        }
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
        return getValue()==(other.getValue()) && suit.equals(other.suit);
    }

 
}
