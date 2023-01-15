/* Yehuda Dicker
 * ymd2110
 * Game.java - game
 */
import java.util.*;



public class Game {
    


	private Player p;
	private Deck cards;
    private ArrayList<Card> hand;
    private String check;
    private double bankroll;
    private int bets;
    private String yes;
    private double bet;
    private Card temp;
    private ArrayList<Card> tester;
    private Deck deck;
	// you'll probably need some more here
	

	
	public Game(String[] testHand){
		// This constructor is to help test your code.
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace-king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush    
        
        hand = new ArrayList<Card>();

        
        for (String s: testHand){
         
            if(s.substring(0,1).equals("h")){
                temp = new Card(1, Integer.parseInt(s.substring(1)));
            }
            
            else if(s.substring(0,1).equals("d")){
                temp = new Card(2, Integer.parseInt(s.substring(1)));
            }
            
            else if(s.substring(0,1).equals("s")){
                temp = new Card(3, Integer.parseInt(s.substring(1)));
            }
            
            else{
                temp = new Card(4, Integer.parseInt(s.substring(1)));
            }
            
            hand.add(temp);
        }
        
        p = new Player();
        
        for (Card card: hand){
            p.addCard(card);
        }
        cards = new Deck();
        cards.shuffle();
		
	}
	
	public Game(){
		// This no-argument constructor is to actually play a normal game
        
        p = new Player();
        cards = new Deck();
		hand = p.getHand();
        
        cards.shuffle();   

        for (int i = 0; i < 5; i++){
            p.addCard(cards.deal());
            cards.changeTop();
        }
	}
	
    
	public void play() {
		// this method should play the game	
        
        
        
        System.out.println("Here is your hand: " + p.getHand());

        System.out.println("Your bankroll is " + p.getBankroll() + "." + "You may bet 1-5 tokens. Please enter the amount of tokens you would like to bet.");
        Scanner s = new Scanner(System.in);
        bet = s.nextDouble();
        p.bets(bet);
        
        if(bet > p.getBankroll()){
           System.out.println("You do not have enough in your bankroll to bet :(. Thanks for playing. Come again!!");
           System.exit(0);
        }
        
        while(bet > 5 || bet < 1){
            System.out.println("Please enter a valid amount of tokens between 1 and 5.");
            bet = s.nextDouble();
        }
      
        
          
        Collections.sort(p.getHand());
        System.out.println("Here is your hand: " + p.getHand());
        
        
        
        Scanner b = new Scanner(System.in);
        Scanner d = new Scanner(System.in);
        Scanner e = new Scanner(System.in);
        Scanner f = new Scanner(System.in);
        Scanner g = new Scanner(System.in);


        
        System.out.println("Would you like to replace card 1? (yes/no)");
        yes = b.nextLine();   
        if (yes.equals("yes")){
            p.getHand().set(p.getHand().indexOf(p.getHand().get(0)), cards.getCard(6));
        }
        

        
        System.out.println("Would you like to replace card 2? (yes/no)");
        yes = d.nextLine();           
        if (yes.equals("yes")){
            p.getHand().set(p.getHand().indexOf(p.getHand().get(1)), cards.getCard(7));
        }
        

        
        System.out.println("Would you like to replace card 3? (yes/no)");
        yes = e.nextLine();           
        if (yes.equals("yes")){
            p.getHand().set(p.getHand().indexOf(p.getHand().get(2)), cards.getCard(8));
        }


        
        System.out.println("Would you like to replace card 4? (yes/no)");
        yes = f.nextLine();           
        if (yes.equals("yes")){
            p.getHand().set(p.getHand().indexOf(p.getHand().get(3)), cards.getCard(9));
        }

        
        
       System.out.println("Would you like to replace card 5? (yes/no)");
        yes = g.nextLine();           
        if (yes.equals("yes")){

            p.getHand().set(p.getHand().indexOf(p.getHand().get(4)), cards.getCard(10));
       }


        Collections.sort(p.getHand());
        System.out.println("Your new hand is: " + p.getHand());
        System.out.println("Your hand is a " + checkHand(p.getHand()) + ".");
        
       

                   
              String noPair = "no pair";
              String onePair = "one pair";
              String twoPair = "two pair";
              String threeOfaKind = "three of a kind";
              String straight = "straight";
              String flush = "flush";
              String fullHouse = "full house";
              String fourOfakind = "four of a kind";
              String straightFlush = "straight flush";
              String royalFlush = "royal flush";
              
              
              if (check.equals(royalFlush)){
                  p.winnings(250);
              }
              
              else if(check.equals(straightFlush)){
                  p.winnings(50);

              }
        
             
              else if (check.equals(fourOfakind)){
                  p.winnings(25);

              }
              
              else if (check.equals(fullHouse)){
                  p.winnings(6);

              }
              
              else if (check.equals(flush)){
                  p.winnings(5);

              }
              
               else if (check.equals(straight)){
                  p.winnings(4);

              }
        
        
              else if (check.equals(threeOfaKind)){
                  p.winnings(3);

              }
              
               else if (check.equals(twoPair)){
                  p.winnings(2);

              }
              
              else if (check.equals(onePair)){
                  p.winnings(1);

              }  
        
              else if (check.equals(noPair)){
                p.losings(0);
                System.out.println(p.getBankroll());
                  
              }
        
               
        
        
        if (check.equals(noPair)){
            System.out.println("You've lost :(. Your bankroll is now " + p.getBankroll());
        }
        
        else{
            System.out.println("You've won!! Your bankroll is now " + p.getBankroll());
        }
        
        
        System.out.println("Would you like to play again? (yes/no)");
        Scanner c = new Scanner (System.in);
        String newGame = c.nextLine();
        if(newGame.equals("yes")){
            cards.shuffle();

            p.getHand().set(p.getHand().indexOf(p.getHand().get(0)), cards.getCard(0));

            p.getHand().set(p.getHand().indexOf(p.getHand().get(1)), cards.getCard(1));

            p.getHand().set(p.getHand().indexOf(p.getHand().get(2)), cards.getCard(2));

            p.getHand().set(p.getHand().indexOf(p.getHand().get(3)), cards.getCard(3));

            p.getHand().set(p.getHand().indexOf(p.getHand().get(4)), cards.getCard(4));


            
            Collections.sort(p.getHand());
            play();
        }
        else{
            System.out.println("Thanks for playing. Come again!!");
            System.exit(0);
        }
        
    }
        
    
    private void checkNoPair(){
        if (p.getHand().get(0).getRank() != p.getHand().get(2).getRank() &&
                    p.getHand().get(1).getRank() != p.getHand().get(3).getRank() &&
                    p.getHand().get(2).getRank() != p.getHand().get(4).getRank())
            check = "no pair";
    }
    
    private void checkOnePair(){
       for (int i = 0; i < p.getHand().size(); i++){
            for (int j = i +1; j < p.getHand().size(); j++){  
                    if (p.getHand().get(i).getRank() == p.getHand().get(j).getRank()){
                        check = "one pair";          
    }
  }
 }
}
                    
    private void checkTwoPair(){
        if (check == "one pair"){
           if ((p.getHand().get(0).getRank() == p.getHand().get(1).getRank()) && (p.getHand().get(2).getRank() == p.getHand().get(3).getRank() && (p.getHand().get(0).getRank() != p.getHand().get(2).getRank())) ){
               check = "two pair";
           }
            
           else if ((p.getHand().get(1).getRank() == p.getHand().get(2).getRank()) && (p.getHand().get(3).getRank() == p.getHand().get(4).getRank()) && (p.getHand().get(1).getRank() != p.getHand().get(3).getRank())){
               check = "two pair";
           }
            
           else if ((p.getHand().get(0).getRank() == p.getHand().get(1).getRank()) && (p.getHand().get(3).getRank() == p.getHand().get(4).getRank()) && (p.getHand().get(0).getRank() != p.getHand().get(3).getRank())){
               check = "two pair";
           }
            
          else{
               check = "one pair";
           } 
        }             
     }
              
    
    private void checkThreeOfAKind(){
        if (check == "one pair"){
                if (p.getHand().get(0).getRank() == p.getHand().get(2).getRank() ||
                    p.getHand().get(1).getRank() == p.getHand().get(3).getRank() ||
                    p.getHand().get(2).getRank() == p.getHand().get(4).getRank()){
                    check = "three of a kind";
            }
                else{
                  check = "one pair";
                }
        }
    }
 
    
    private void checkFourOfAKind(){
        if (check == "three of a kind"){
                if (p.getHand().get(0).getRank() == p.getHand().get(3).getRank() || 
                    p.getHand().get(1).getRank() == p.getHand().get(4).getRank()){
                    check = "four of a kind";
                }
                else{
                 check = "three of a kind";
               }
            }
        }   
    
    
    private void checkFullHouse(){
        if(((p.getHand().get(0).getRank() == p.getHand().get(1).getRank() && 
             p.getHand().get(1).getRank() == p.getHand().get(2).getRank()) || 
            ((p.getHand().get(2).getRank() == p.getHand().get(3).getRank() && 
              p.getHand().get(3).getRank() == p.getHand().get(4).getRank()) && 
             (p.getHand().get(0).getRank() == p.getHand().get(1).getRank()))) 
            check = "full house";
    }
    
    
    private void checkStraght(){
        if ((p.getHand().get(0).getRank()-p.getHand().get(1).getRank() == -1) && 
            (p.getHand().get(1).getRank()-p.getHand().get(2).getRank() == -1) && 
            (p.getHand().get(2).getRank()-p.getHand().get(3).getRank() == -1) && 
            (p.getHand().get(3).getRank()-p.getHand().get(4).getRank() == -1))
            check = "straight";
    }
	
    
    private void checkFlush(){
        if(p.getHand().get(0).getSuit() == p.getHand().get(1).getSuit() && 
           p.getHand().get(1).getSuit() == p.getHand().get(2).getSuit() && 
           p.getHand().get(2).getSuit() == p.getHand().get(3).getSuit() && 
           p.getHand().get(3).getSuit() == p.getHand().get(4).getSuit())
            check = "flush";
    }

    
    private void checkStraightFlush(){
        if ((p.getHand().get(0).getRank()-p.getHand().get(1).getRank() == -1 && 
             p.getHand().get(0).getSuit() == p.getHand().get(1).getSuit()) && 
            (p.getHand().get(1).getRank()-p.getHand().get(2).getRank() == -1 && 
             p.getHand().get(1).getSuit() == p.getHand().get(2).getSuit()) && 
            (p.getHand().get(2).getRank()-p.getHand().get(3).getRank() == -1 && 
             p.getHand().get(2).getSuit() == p.getHand().get(3).getSuit()) && 
            (p.getHand().get(3).getRank()-p.getHand().get(4).getRank() == -1 && 
             p.getHand().get(3).getSuit() == p.getHand().get(4).getSuit()))      
            check = "straight flush";
        
    }
    
    private void checkRoyalFlush(){
        if((p.getHand().get(0).getRank() == 1 && p.getHand().get(1).getRank() == 10 && 
            p.getHand().get(2).getRank() == 11 && p.getHand().get(3).getRank() == 12 && 
            p.getHand().get(4).getRank() == 13) && (p.getHand().get(0).getSuit() == p.getHand().get(1).getSuit() && 
            p.getHand().get(1).getSuit() == p.getHand().get(2).getSuit() && 
            p.getHand().get(2).getSuit() == p.getHand().get(3).getSuit() && p.getHand().get(3).getSuit() == p.getHand().get(4).getSuit()))
            check = "royal flush";
    }
    
    
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
        
        checkNoPair();
        checkOnePair();
        checkTwoPair();
        checkThreeOfAKind();
        checkFourOfAKind();
        checkFullHouse();
        checkFlush();
        checkStraght();
        checkStraightFlush();
        checkRoyalFlush();
        
    
    return check;
      
    
    } 
        
       
          
   
 }                                 
                                 
	
	
	// you will likely want many more methods here
	// per discussion in class

