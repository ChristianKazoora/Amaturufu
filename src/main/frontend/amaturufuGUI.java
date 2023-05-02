package main.frontend;

import main.backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static main.backend.game.*;


// Create a class that extends JFrame and implements ActionListener
public class amaturufuGUI extends JFrame implements ActionListener {

    // Create four buttons and four labels
    static JButton button1 = new JButton();
    Timer timer = null;
    static JButton button2 = new JButton();
    static JButton button3 = new JButton();
    static JButton button4 = new JButton();
    JLabel card1 = new JLabel();
    JLabel card2 = new JLabel();
    JLabel card3 = new JLabel();
    JLabel card4 = new JLabel();

    // Create a label and four panels for layout
    JLabel header = new JLabel();
    JPanel west = new JPanel();
    JPanel center = new JPanel();
    JPanel east = new JPanel();
    JPanel footer = new JPanel();

    // Create two panels for displaying cards and trump card
    JPanel iturufuPanel = new JPanel();
    JPanel cards = new JPanel();
    // Create a panel for the game layout
    static JLabel GamePanel1 = new JLabel();
    static JLabel GamePanel2 = new JLabel();

    // Create labels for displaying the trump card

    JLabel iturufuCard = new JLabel();


    // Create a label for displaying the score
    JLabel score;

    // Create two layered panes for displaying the cards of the player and the computer
    static JLabel playerLayerdPane = new JLabel();
    JLayeredPane cpuLayeredPane = new JLayeredPane();

    // Create an ArrayList to store the player's cards
    ArrayList <Card> playerCards = new ArrayList<>();

    JPanel scorePanel;

    public amaturufuGUI() {

        // Set the backgrounds of several JPanels
        header.setBackground(Color.red);
        west.setBackground(Color.YELLOW);
        center = new ImagePanel(new ImageIcon("Cards/SmallPNG/backgroundSM.png").getImage());
        east.setBackground(Color.yellow);
        footer.setBackground(Color.magenta);

        // Set the preferred sizes of several JPanels
        west.setPreferredSize(new Dimension(50,100));
        center.setPreferredSize(new Dimension(50,50));

        east.setPreferredSize(new Dimension(50,100));
        footer.setPreferredSize(new Dimension(100,50));


        // Create a JPanel for the score
        scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        scorePanel.setBackground(Color.magenta);

        // Create a JLabel for the score and set its properties
        score=new JLabel("CPU (0) - (0) Player");
        score.setBackground(Color.magenta);
        score.setHorizontalTextPosition(SwingConstants.CENTER);
        score.setVerticalTextPosition(SwingConstants.CENTER);
        score.setOpaque(true);
        score.setFont(new Font ("Serif",Font.PLAIN,20));
        scorePanel.add(score);

        // Set the properties of the iturufuCard JLabel
        iturufuCard.setPreferredSize(new Dimension( 131, 218));
        iturufuCard.setText("Iturufu");
        iturufuCard.setFont(new Font ("Serif",Font.PLAIN,20));
        iturufuCard.setVerticalTextPosition(JLabel.TOP);
        iturufuCard.setHorizontalTextPosition(JLabel.CENTER);
        iturufuCard.setIconTextGap(-5);

        // Set the preferred size and properties of the playerLayeredPane JLabel
        playerLayerdPane.setPreferredSize(new Dimension(300,215));
        playerLayerdPane.setBounds(100,50,300,215);
        playerLayerdPane.setOpaque(false);

        // Set the properties for the player's cards
        button1.setBounds(10,10,131,200);
        button1.setBorderPainted(false);
        button1.addActionListener(this);

        button2.setBounds(50,10,131,200);
        button2.setBorderPainted(false);
        button2.addActionListener(this);

        button3.setBounds(100,10,131,200);
        button3.setBorderPainted(false);
        button3.addActionListener(this);

        button4.setBounds(150,10,131,200);
        button4.setBorderPainted(false);
        button4.addActionListener(this);

        // Add the player's cards to the player's layered pane
        playerLayerdPane.add(button4, (0));
        playerLayerdPane.add(button3, (1));
        playerLayerdPane.add(button2, (2));
        playerLayerdPane.add(button1, (3));


        // Set the properties for the CPU's layered pane
        cpuLayeredPane.setPreferredSize(new Dimension(380,210));
        cpuLayeredPane.setBounds(0,0,280,210);
        cpuLayeredPane.setBackground(Color.BLACK);
        card1.setBounds(10,10,131,200);
        card2.setBounds(50,10,131,200);
        card3.setBounds(100,10,131,200);
        card4.setBounds(150,10,145,200);

        // Add the CPU's cards to the CPU's layered pane
        cpuLayeredPane.add(card4,(0));
        cpuLayeredPane.add(card3,(1));
        cpuLayeredPane.add(card2,(2));
        cpuLayeredPane.add(card1,(3));


        // Start the game
        new game();

        // Populate the ArrayList with the player's cards
        playerCards.addAll(game.playCards);

        // Store the trump card in a string
        String trumpCard = game.iturufu.toString();

        // Call the playerCardLabler method to set the properties of the player's cards
        PlayerCardLabler(playerCards);

        // Call the iturufu_disp method to set the properties of the trump card
        iturufu_disp(trumpCard);

        // Call the cpuCardLabler method to set the properties of the CPU's cards
        cpuCardLabler(playerCards);

        // Set the properties of the cards JPanel
        cards.setPreferredSize(new Dimension(135,200));
        cards.setOpaque(false);


        // Set the properties of the iturufuPanel JPanel
        iturufuPanel.setPreferredSize(new Dimension(164,230));
        iturufuPanel.setBounds(30,10,160,230);
        iturufuPanel.setOpaque(false);
        iturufuPanel.add(iturufuCard);



        // Set the properties of the GamePanel1 JPanel
        GamePanel1.setBounds(10,10,131,200);
        GamePanel1.setOpaque(false);


        // Set the properties of the GamePanel2 JPanel
        GamePanel2.setBounds(50,10,131,200);
        GamePanel2.setOpaque(false);



        JLayeredPane container = new JLayeredPane();
        container.setPreferredSize(new Dimension(188,230));
        container.setBounds(100,50,300,215);
        container.setOpaque(false);
        container.add(GamePanel1,1);
        container.add(GamePanel2,0);


        // Add the components to the center JPanel

        center.add(cpuLayeredPane);
        center.add(container);
        center.add(iturufuPanel);
        center.add(playerLayerdPane);

        // Set the default close operation, title, and size of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Amaturufu");
        this.setSize(new Dimension(700,580));

        // Add the components to the frame
        this.add(scorePanel,BorderLayout.NORTH);
        this.add(west,BorderLayout.WEST);
        this.add(center,BorderLayout.CENTER);
        this.add(east,BorderLayout.EAST);

        // Make the frame visible
        this.setVisible(true);

    }

    public static void Play(String val) {
        String [] pic = val.split(" ");
        String image = pic[0]+pic[1].charAt(1)+".png";
        Icon card = new ImageIcon("Cards/SmallPNG/"+image);
      //  playedCard2.setIcon(card);
    }
    ImageIcon GetCpuCardIcon(String val){
        // Split the string and assign the winner two characters of the second element to the image
        String [] pic = val.toString().split(" ");
        String image = pic[0]+pic[1].charAt(1)+".png";

        // Set the ImageIcon to the image
        ImageIcon card = new ImageIcon("Cards/SmallPNG/"+image);
        return card;
    }
     void ender(){
        if (game.playCards.equals(game.nullCards) && Loader.cpuCards.equals(game.nullCards))
            if(game.cpuScore()==game.playerScore())
            {
                JOptionPane.showMessageDialog(null, "IT'S A TIE!");
            }
            else if(game.cpuScore()>game.playerScore())
            {
        JOptionPane.showMessageDialog(null, "CPU WINs!");
            }
        else
        {
                JOptionPane.showMessageDialog(null, "PLAYER WINs!");
        }

    }
/**
 *
 * @param e the event to be processed
 */
 @Override
 public void actionPerformed(ActionEvent e) {
     clearAllIcons();
     //setting the stating player cards
     if(e.getSource()==button1){
         //checking if the deck is over and disabling the button after clicking  it
             if(game.deal.Deck.size()==0&&game.playCards.size()<=4){
                 button1.setEnabled(false);
                 try {
                     game.play(0);
                     if(!playerCards.get(0).getCard().equals("1 H")&&!game.CPUreturned.getCard().equals("1 H")) {
                         setGamePanel(button1.getIcon(),GetCpuCardIcon(game.CPUreturned.getCard()));
                     }
                     PlayerCardLabler(game.playCards);

                 }catch (Exception a)
                 {
                     System.out.println("Invalid");
                 }
                 score.setText("CPU ("+game.cpuScore()+") - ("+game.playerScore()+") Player");
                 ender();
                 return;
             }else {
                 game.play(0);
                 setGamePanel(button1.getIcon(),GetCpuCardIcon(game.CPUreturned.getCard()));
                 PlayerCardLabler(game.playCards);

             }
         ender();
     }
     if(e.getSource()==button2){

             if(game.deal.Deck.size()==0&&game.playCards.size()<=4){
                 button2.setEnabled(false);
                 try {

                     game.play(1);
                     if(!playerCards.get(1).getCard().equals("1 H")&&!game.CPUreturned.getCard().equals("1 H")) {
                         setGamePanel(button2.getIcon(),GetCpuCardIcon(game.CPUreturned.getCard()));
                         PlayerCardLabler(game.playCards);

                     }
                 }catch (Exception u)
                 {
                     System.out.println("Invalid");
                 }
                 score.setText("CPU ("+game.cpuScore()+") - ("+game.playerScore()+") Player");
                 ender();
                 return;
             }else {
                 game.play(1);
                 setGamePanel(button2.getIcon(),GetCpuCardIcon(game.CPUreturned.getCard()));
                 PlayerCardLabler(game.playCards);

             }
         ender();
     }
     if(e.getSource()==button3) {
         if (game.deal.Deck.size() == 0 && game.playCards.size() <=4) {
             button3.setEnabled(false);
             try {

                 game.play(2);
                 if(!playerCards.get(2).getCard().equals("1 H")&&!game.CPUreturned.getCard().equals("1 H")) {
                     setGamePanel(button3.getIcon(),GetCpuCardIcon(game.CPUreturned.getCard()));
                     PlayerCardLabler(game.playCards);

                 }
             } catch (Exception i) {
                 System.out.println("Invalid");
             }
             score.setText("CPU ("+game.cpuScore()+") - ("+game.playerScore()+") Player");
             ender();
             return;
         }else {

             game.play(2);
             setGamePanel(button3.getIcon(),GetCpuCardIcon(game.CPUreturned.getCard()));
             PlayerCardLabler(game.playCards);

         }
         ender();
     }
     if(e.getSource()==button4){

             if(game.deal.Deck.size()==0&&game.playCards.size()<=4){
                 button4.setEnabled(false);
                 try {

                     game.play(3);
                     if(!playerCards.get(3).getCard().equals("1 H")&&!game.CPUreturned.getCard().equals("1 H")) {
                         setGamePanel(button4.getIcon(),GetCpuCardIcon(game.CPUreturned.getCard()));
                         PlayerCardLabler(game.playCards);

                     }
                 }catch (Exception o)
                 {
                     System.out.println("Invalid");
                 }
                 score.setText("CPU ("+game.cpuScore()+") - ("+game.playerScore()+") Player");
                 ender();
                 return;
             }else {

                 game.play(3);
                 setGamePanel(button4.getIcon(),GetCpuCardIcon(game.CPUreturned.getCard()));
                 PlayerCardLabler(game.playCards);
             }
         ender();


     }

     score.setText("CPU ("+game.cpuScore()+") - ("+game.playerScore()+") Player");
 }

    private void setGamePanel(Icon played,Icon cpu)
    {

            GamePanel1.setIcon(played);
        if(!winner&&cpuPlayedTwice){

            delayFor3(getIcon(cpuTemp));
            // Create a new timer with 1 seconds delay
            timer = new Timer(1000, e -> {

                GamePanel2.setIcon(cpu);
                timer = null; // Set the timer to null
            });
            timer.setRepeats(false); // Make sure the timer does not repeat
            timer.setDelay(1000);
            timer.start(); // Start the timer
            //clearAllIcons();
        }else {



            // Create a new timer with 1 seconds delay
            timer = new Timer(1000, e -> {
                GamePanel2.setIcon(cpu);
                timer = null; // Set the timer to null
            });
            timer.setRepeats(false); // Make sure the timer does not repeat
            timer.setDelay(1000);
            timer.start(); // Start the timer
            //clearAllIcons();
        }

    }
    private void delayFor3(Icon cpu) {

       GamePanel2.setIcon(cpu);

        //clearAllIcons();
        timer = new Timer(999, e -> {
            clearPlayer();
            GamePanel2.setIcon(cpu);
            timer = null; // Set the timer to null

        });

        timer.setRepeats(false); // Make sure the timer does not repeat
        timer.setDelay(999);
        timer.start(); // Start the timer
        //


    }

    private void clearPlayer()
    {
        GamePanel1.setIcon(null);
    }


    private void clearAllIcons() {
            GamePanel1.setIcon(null);
            GamePanel2.setIcon(null);
    }

        public void PlayerCardLabler(ArrayList<Card> playerCards)
    {
        // Initialize counter and ImageIcon
        int count =0;
        ImageIcon card;

        // Iterate through all elements in the ArrayList
        for (Card val:playerCards)
        {
            {
                // Split the string and assign the winner two characters of the second element to the image
                String[] pic = val.toString().split(" ");
                String image = pic[0] + pic[1].charAt(1) + ".png";

                // Set the ImageIcon to the image
                card = new ImageIcon("Cards/SmallPNG/" + image);

                // Assign the ImageIcon to the corresponding button based on the counter
                if (count == 0) {
                    button1.setIcon(card);
                } else if (count == 1) {
                    button2.setIcon(card);
                } else if (count == 2) {
                    button3.setIcon(card);
                } else {
                    button4.setIcon(card);
                }

                // Increment the counter
                count++;
            }

        }

    }
public Icon getIcon(Card Card)
{
    String[] pic = Card.toString().split(" ");
    String image = pic[0] + pic[1].charAt(1) + ".png";
    Icon card = new ImageIcon("Cards/SmallPNG/" + image);
    return card;
}

    //Method for labeling the CPU's cards with a purple back image
    public void cpuCardLabler(ArrayList<Card> cpuCards) {
        // Start counter at 0
        int count =0;
        // Iterate through the cpuCards ArrayList
        for (Card ignored :cpuCards) {
            // Create a new ImageIcon with a purple_back image
            ImageIcon card= new ImageIcon("Cards/SmallPNG/cyberPunk.png");
            // If the count is 0, set the card1 icon to the card image
            if (count==0) {
                card1.setIcon(card);
                // If the count is 1, set the card2 icon to the card image
            } else if (count==1) {
                card2.setIcon(card);
                // If the count is 2, set the card3 icon to the card image
            } else if (count==2) {
                card3.setIcon(card);
                // If the count is 3, set the card4 icon to the card image
            } else {
                card4.setIcon(card);
            }
            // Increase the counter by 1
            count++;
        }
    }



    // Method to display a specific iturufu card
    public void iturufu_disp(String iturufu) {
        // Extract the winner character and the last two characters from the iturufu string
        String image = iturufu.substring(0,1).trim()+iturufu.substring(2,4).trim()+".png";
        // Create an ImageIcon object with the extracted image name
        ImageIcon card= new ImageIcon("Cards/SmallPNG/"+image);
        // Set the ImageIcon object as the icon of the iturufuCard
        iturufuCard.setIcon(card);
    }

}
