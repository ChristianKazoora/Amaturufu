package main.backend;

import java.util.ArrayList;
import java.util.Stack;

public class game {
    public static Deck deal;
    public static boolean winner = true;
    static boolean playedFirst;
    public static Card CPUreturned;
    public static Card iturufu;
    public static ArrayList<Card> playCards;
    public static ArrayList<Card> nullCards=new ArrayList<>();
    static int allPlayerWins;
    public static int allCpuWins;
    public static Stack<Card> playerWins = new Stack<>();
    public static Stack<Card> cpuWins = new Stack<>();
    public static boolean cpuPlayedTwice = false;
    static Card clickedCard= null;
    static Card cpuCard = null;


    public game() {
        deal  = new Deck();
        iturufu = deal.iturufu();
        playCards = deal.playerCards;
        deal.startingPick();
        Card nullCard = new Card("1", "\tH");
        nullCards.add(0,nullCard);nullCards.add(1,nullCard);nullCards.add(2,nullCard);nullCards.add(3,nullCard);

    }
    public static Card clicked(int clicked) {
        Card playedCard = null;

        //try play with player winner
            //played card
            playedCard = playCards.get(clicked);
            thePlay(clicked);

        return playedCard;
    }
    private static Card cpuPlay() {
        Card cpuCard = null;
        try
        {
            cpuCard = theCpuPlay(deal, iturufu);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cpuCard;
    }
    public static Card playerTemp;
    public static Card cpuTemp;

    public static void play(int clicked) {

      do
      {
          //player plays first
          if (winner &&!cpuPlayedTwice) {
              playedFirst = true;
              clickedCard = clicked(clicked);
              cpuCard = cpuPlay();
              wins(clickedCard, cpuCard);
              cpuPlayedTwice = false;
          }
            //cpu plays first
          else if(!winner &&!cpuPlayedTwice){
              playedFirst = false;
               cpuTemp = cpuCard;
               playerTemp = clickedCard;
              cpuCard = cpuPlay();
              cpuPlayedTwice = true;
          }
          // cpu already played first
            else if(!winner && cpuPlayedTwice){
                clickedCard = clicked(clicked);
                wins(clickedCard, cpuCard);
                cpuPlayedTwice = false;
            }
      }
        while(!winner &&!cpuPlayedTwice&&!playCards.equals(nullCards) && !Loader.cpuCards.equals(nullCards));
        if (playCards.equals(nullCards) && deal.cpuCards.equals(nullCards))
        {
            ender();
        }

    }


    public static void wins(Card playedCard, Card cpuCard)
    {
        //checking to see if cpu, iturufu and played suites are not the same
        if (!(playedCard.getSuite().equals(iturufu.getSuite())) && !(cpuCard.getSuite().equals(iturufu.getSuite()))) {
            //if not the same to the iturufu, we check to see if the cpu and player cards are the same
            if ((playedCard.getSuite().equals(cpuCard.getSuite()))) {
                // if both suits are the same but different from the iturufu suite we check for the getValue of the card
                if (playedCard.getValue()>cpuCard.getValue()) {
                    winner = true;
                    playerWins.push(playedCard);
                    playerWins.push(cpuCard);
                    allPlayerWins += playedCard.getValue();
                    allPlayerWins += cpuCard.getValue();
                    System.out.println("Umukinyi arayariye");
                }else if(playedCard.getValue()<cpuCard.getValue()){
                    winner = false;
                    cpuWins.push(playedCard);
                    cpuWins.push(cpuCard);
                    allCpuWins += playedCard.getValue();
                    allCpuWins += cpuCard.getValue();
                    System.out.println("Machine irayariye");
                }else
                {
                    //if both suits are the same and the values are the same
                    if(playedFirst)
                    {
                        winner = true;
                        playerWins.push(playedCard);
                        playerWins.push(cpuCard);
                        allPlayerWins += playedCard.getValue();
                        allPlayerWins += cpuCard.getValue();
                        System.out.println("Umukinyi arayariye");
                    }
                    else
                    {
                        winner = false;
                        cpuWins.push(playedCard);
                        cpuWins.push(cpuCard);
                        allCpuWins += playedCard.getValue();
                        allCpuWins += cpuCard.getValue();
                        System.out.println("Machine irayariye");
                    }
                }

            } else {
                // if the played card suit does not equal the next played suit and none suits equal the iturufu suit the one who played winner wins

                if (playedFirst) {
                    //player wins
                    winner = true;
                    playerWins.push(playedCard);
                    playerWins.push(cpuCard);
                    allPlayerWins += playedCard.getValue();
                    allPlayerWins += cpuCard.getValue();
                    System.out.println("Umukinyi arayariye");


                } else {
                    //cpu wins
                    winner = false;
                    cpuWins.push(playedCard);
                    cpuWins.push(cpuCard);
                    allCpuWins += playedCard.getValue();
                    allCpuWins += cpuCard.getValue();
                    System.out.println("Machine irayariye");
                }
            }
        } else {
            // if both cpu and player suits are the same as the iturufu suit
            if (playedCard.suit.equals(iturufu.suit) && cpuCard.suit.equals(iturufu.suit))
            {
                //if both suits are the same but with different values
                if(playedCard.getValue()>cpuCard.getValue())
                {
                    winner = true;
                    playerWins.push(playedCard);
                    playerWins.push(cpuCard);
                    allPlayerWins += playedCard.getValue();
                    allPlayerWins += cpuCard.getValue();
                    System.out.println("Umukinyi arayariye");
                }
                else
                {
                    winner = false;
                    cpuWins.push(playedCard);
                    cpuWins.push(cpuCard);
                    allCpuWins += playedCard.getValue();
                    allCpuWins += cpuCard.getValue();
                    System.out.println("Machine irayariye");
                }
            }
            //if player suit is the same as the iturufu but diffrent from cpu
            else if (playedCard.suit.equals(iturufu.suit)) {
                winner = true;
                playerWins.push(playedCard);
                playerWins.push(cpuCard);
                allPlayerWins += playedCard.getValue();
                allPlayerWins += cpuCard.getValue();
                System.out.println("Umukinyi arayariye");


            }
            else{
                //cpu wins
                winner = false;
                cpuWins.push(playedCard);
                cpuWins.push(cpuCard);
                allCpuWins += playedCard.getValue();
                allCpuWins += cpuCard.getValue();
                System.out.println("Machine irayariye");
            }
        }
    }


    public static void ender() {


        int pCount=allPlayerWins;
        int cpuCount=allCpuWins;


        System.out.println("----------");
        System.out.println("Player Wins");
        System.out.println("----------");

        int pCounter =0;
        for (Card wins : playerWins) {
            System.out.println(wins.getCard()+" - "+wins.getValue());
            pCounter = pCounter+ wins.getValue();
        }
        System.out.println("pScore- "+ pCounter);


        System.out.println("----------");
        System.out.println("CPU Wins");
        System.out.println("----------");

        int cpuCounter =0;
        for (Card Cwins : cpuWins) {
            System.out.println(Cwins.getCard()+" - "+Cwins.getValue());
            cpuCounter = cpuCounter+ Cwins.getValue();
        }
        System.out.println("cpuScore- "+ cpuCounter);
        if(pCount >cpuCount)

        {
            System.out.println("---------------------");
            System.out.println("PLAYER WINS");
            System.out.println("---------------------");
        } else if(pCount<cpuCount)

        {
            System.out.println("---------------------");
            System.out.println("CPU Wins");
            System.out.println("---------------------");
        }else

        {
            System.out.println("---------------------");
            System.out.println("IT'S A TIE");
            System.out.println("---------------------");
        }
    }
    public static int playerScore()
    {
        return allPlayerWins;
    }
    public static int cpuScore()
    {
        return allCpuWins;
    }

    public static void cpuCards(){
        System.out.println("CPU Cards");
        System.out.println("----------");
        for (int p = 0; p < deal.cpuCards.size(); p++) {
            System.out.println(deal.cpuCards.get(p).getCard());
        }
        System.out.println("\n------------------------------------------------------------------------");
    }

    public static void thePlay(int clicked) {



        System.out.println("Player Played: "+playCards.get(clicked));
        System.out.println("------------------------------");
        if (deal.Deck.size()==0) {
            playCards.set(clicked, new Card("1", "\tH"));
        }
        else {
            playCards.remove(clicked);
            deal.playerPick1(clicked);
        }


    }


    public static Card theCpuPlay(Deck deal, Card iturufu) throws InterruptedException {
        Cpu cpu = new Cpu(deal.cpuCards);

        if(winner&&!cpuPlayedTwice)
        {
            CPUreturned = cpu.play(iturufu,clickedCard);
        }else
        {
            CPUreturned = cpu.play(iturufu,null);
        }

        if (deal.Deck.size() != 0) {
            deal.cpuPick1();
        }

        System.out.println("------------------------------");
        System.out.print("CPU Play: ");
        System.out.println(CPUreturned.getCard());
        System.out.println("------------------------------");

        return CPUreturned;
    }

}