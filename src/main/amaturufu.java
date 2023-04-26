package main;

//import amaturufu.BackEnd.*;
import main.backend.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class amaturufu {
    static Card iturufu;
    static ArrayList <Card> playCards;
    static Deck deal;

    public  int getAllPlayerWins() {
        return allPlayerWins;
    }

    public  int getAllCpuWins() {
        return allCpuWins;
    }

    static int allPlayerWins;
    static int allCpuWins;





    public static void main(String[] args) {
        //new GUI();

        deal  = new Deck();
        iturufu = deal.iturufu();
        playCards = deal.playerCards;
        deal.startingPick();
        Stack<Card> playerWins = new Stack<>();
        Stack<Card> cpuWins = new Stack<>();
        Card playedCard = null;
        Card cpuCard = null;



        //true if player played first and false otherwise
        boolean first = true;

        /**
         *

        System.out.println("----------");
        System.out.println("Original Deck");
        System.out.println("----------");

        for(int i =0;i<deal.Deck.size();i++)
        {
        System.out.println(deal.Deck.get(i).getCard()+" "+i);
        }
         */
        System.out.println("----------");

        System.out.println("----------");
        System.out.println("Iturufu");
        System.out.println("----------");
        // deal.startingPick();
        System.out.println(iturufu.getCard());

        outterloop:
        while (playCards.size() != 0 && playCards.size()!= 0) {

            if (first == true) {
                for (int z = 0; z < 10; ) {
                    try {
                        playedCard = thePlay(iturufu);
                        break;
                    } catch (Exception e) {
                        //e.printStackTrace();aq
                        Exception End = new EndException("The END");
                        Exception invalid=new InvalidIn("Invalid");
                        if (!(e.getLocalizedMessage().equals(End.getLocalizedMessage()))||e.getLocalizedMessage().equals(invalid)) {
                            System.out.println("Not in current Card Selection");
                        } else {//if (e.getLocalizedMessage().equals(End)) {
                            break outterloop;

                        }


                    }
                }
                try {
                    cpuCard = theCpuPlay(deal, iturufu);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    cpuCard = theCpuPlay(deal, iturufu);
                } catch (InterruptedException e1) {

                    e1.printStackTrace();
                }
                for (int z = 0; z < 10; ) {
                    try {
                        playedCard = thePlay(iturufu);
                        break;
                    } catch (Exception e) {
                        //e.printStackTrace();
                        Exception End = new EndException("The END");
                        Exception invalid=new InvalidIn("Invalid");
                        if (!(e.getLocalizedMessage().equals(End.getLocalizedMessage()))||e.getLocalizedMessage().equals(invalid)) {
                            System.out.println("Not in current Card Selection");
                        } else {//if (e.getLocalizedMessage().equals(End)) {
                            break outterloop;

                        }

                    }
                }
            }


//checking to see if cpu, iturufu and player suites are not the same
            if (!(playedCard.getSuite().equals(iturufu.getSuite())) && !(cpuCard.getSuite().equals(iturufu.getSuite()))) {
                //if not the same check to see if the cpu and player cards are also not the same
                if (!(playedCard.getSuite().equals(cpuCard.getSuite()))) {
                    // frist who players wins

                    if (first) {
                        playerWins.push(playedCard);
                        playerWins.push(cpuCard);
                        allPlayerWins+=playedCard.value();
                        allPlayerWins+=cpuCard.value();
                /*
                System.out.println("\n----------");
                System.out.println("Player Wins");
                System.out.println(playerWins);
                System.out.println("----------\n");
                **/
                    } else if (first == false) {
                        cpuWins.push(playedCard);
                        cpuWins.push(cpuCard);
                        allCpuWins+=playedCard.value();
                        allCpuWins+=cpuCard.value();
                /*
                System.out.println("----------");
                System.out.println("CPU Wins");
                System.out.println(cpuWins);
                System.out.println("----------");
                **/
                    }
               /*
               if(deal.Deck!=(null)){
               deal.cpuPick1();
            }
               if(deal.Deck!=(null)){
                deal.playerPick1();
               }
               **/
                } else {
                    //check the play and cpu suits , if they match we check for the value of the card
                    if (playedCard.value() > cpuCard.value()) {
                        //player wins
                        first = true;
                        playerWins.push(playedCard);
                        playerWins.push(cpuCard);
                        allPlayerWins+=playedCard.value();
                        allPlayerWins+=cpuCard.value();
                        //  firstPlay=true;
              /*
                if(deal.Deck!=(null)){
                    deal.cpuPick1();
                }
                    if(deal.Deck!=(null)){
                     deal.playerPick1();
                    }
                    
                System.out.println("----------");
                System.out.println("Player Wins");
                System.out.println(playerWins);
                System.out.println("----------");
                **/
                    } else {
                        //cpu wins
                        first = false;
                        cpuWins.push(playedCard);
                        cpuWins.push(cpuCard);
                        allCpuWins+=playedCard.value();
                        allCpuWins+=cpuCard.value();
                        // firstPlay=false;
            /*
                if(deal.Deck!=(null)){
                    deal.cpuPick1();
                }
                    if(deal.Deck!=(null)){
                     deal.playerPick1();
                    }
                    
                System.out.println("----------");
                System.out.println("CPU Wins");
                System.out.println(cpuWins);
                System.out.println("----------");
                **/
                    }
                }
            } else {
                //if player suit is the same as the iturufu but diffrent from cpu
                if (playedCard.getSuite().equals(iturufu.getSuite())) {
                    first = true;
                    playerWins.push(playedCard);
                    playerWins.push(cpuCard);
                    allPlayerWins+=playedCard.value();
                    allPlayerWins+=cpuCard.value();
            /*
            System.out.println("----------");
            System.out.println("Player Wins");
            System.out.println(playerWins);
            System.out.println("----------");
            **/
                }
                if (cpuCard.getSuite().equals(iturufu.getSuite())) {
                    //cpu wins
                    first = false;
                    cpuWins.push(playedCard);
                    cpuWins.push(cpuCard);
                    allCpuWins+=playedCard.value();
                    allCpuWins+=cpuCard.value();
                    /*
                    System.out.println("----------");
                    System.out.println("CPU Wins");
                    System.out.println(cpuWins);
                    System.out.println("----------");
                    **/
                }
                // frist who plays wins
                else if (first) {
                    playerWins.push(playedCard);
                    playerWins.push(cpuCard);
                    allPlayerWins+=playedCard.value();
                    allPlayerWins+=cpuCard.value();
             /*
             System.out.println("----------");
             System.out.println("Player Wins");
             System.out.println(playerWins);
             System.out.println("----------");
             **/
                } else if (first == false) {
                    cpuWins.push(playedCard);
                    cpuWins.push(cpuCard);
                    allCpuWins+=playedCard.value();
                    allCpuWins+=cpuCard.value();
             /*
             System.out.println("----------");
             System.out.println("CPU Wins");
             System.out.println(cpuWins);
             System.out.println("----------");
             **/
                }
                /*
            if(deal.Deck!=(null)){
                deal.cpuPick1();
            }
                if(deal.Deck!=(null)){
                 deal.playerPick1();
                }
                **/
            }


        }
        System.out.println("----------");
        System.out.println("Player Wins");
        System.out.println("----------");
        int pCount = 0;
        for (Card wins : playerWins) {
            System.out.println(wins.getCard());
            pCount += wins.value();
        }


        System.out.println("----------");
        System.out.println("CPU Wins");
        System.out.println("----------");
        int cpuCount = 0;
        for (Card Cwins : cpuWins) {
            System.out.println(Cwins.getCard());
            cpuCount += Cwins.value();
        }
        System.out.println("---------------------");
        System.out.println("Player Score " + pCount);
        System.out.println("---------------------");
        System.out.println("CPU Score " + cpuCount);
        System.out.println("---------------------");


        if (pCount > cpuCount) {
            System.out.println("---------------------");
            System.out.println("PLAYER WINS");
            System.out.println("---------------------");
        } else if(pCount < cpuCount){
            System.out.println("---------------------");
            System.out.println("CPU Wins");
            System.out.println("---------------------");
        }else
        {
            System.out.println("---------------------");
            System.out.println("IT'S A TIE");
            System.out.println("---------------------");
        }

        System.out.println("----------");
        System.out.println("Final Deck");
        System.out.println("----------");

        for (Card dec : deal.Deck) {
            System.out.println(dec.getCard());
        }

    }


    public static Card thePlay(Card iturufu) throws Exception {
        Card inputed;
        Scanner in = new Scanner(System.in);
        System.out.println("----------");
        System.out.println("Player Cards");
        System.out.println("----------");
        int v = 1;
            for (int i = 0; i <playCards.size(); i++) {

                System.out.println(v + ". " + playCards.get(i).getCard());
                v++;

            }

            System.out.println("\nPlay A card");
            String inputer = in.next();
            if (!(inputer.equals("q"))) {
                int input = Integer.parseInt(inputer);

                if (input > 0 && input <= 4) {
                  /*
                     if(deal.playerCards==null)
                    {
                        inputed=iturufu;
                    }else
                       **/
                    inputed =playCards.remove(input - 1);
                    //if(deal.playerCards.size()==0)
                    //{
                      //  deal.playerPick1();
                    //}
                    if(deal.Deck.size()!=0){
                    deal.playerPick1();
                }
                
                System.out.println("------------------");
                System.out.println("Played Card: " +  " " + inputed.getCard());
                    TimeUnit.SECONDS.sleep( 2);
                return inputed;

            } else {
                    throw new InvalidIn("Invalid");
            }
   }else

   {
            throw new EndException("The END");
   }
}


    public static Card theCpuPlay(Deck deal,Card iturufu) throws InterruptedException {
        Card returned;

        System.out.println("\n------------------");
        System.out.println("CPU Cards");
        System.out.println("----------");
        for (int p = 0; p < deal.cpuCards.size(); p++) {
            System.out.println(deal.cpuCards.get(p).getCard());
        }



        System.out.println("----------");
        System.out.println("CPU Playing");
        System.out.println("----------");
        TimeUnit.SECONDS.sleep( 2);

        Cpu cpu = new Cpu(deal.cpuCards);
        returned = cpu.play();

        //if(deal.cpuCards.size()==0)
        //{
         //   deal.cpuPick1();
        //}

        if(deal.Deck.size()!=0){
        deal.cpuPick1();
        }
                /*
            }else if(deal.cpuCards==null)
            {
                CPUreturned=iturufu;
            }
            **/
            System.out.println(returned.getCard());

           return returned;
        
        
        
    }
}