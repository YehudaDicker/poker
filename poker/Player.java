/* Yehuda Dicker
 * ymd2110
 * Player.java - player
 */


import java.util.ArrayList;

public class Player {
	
		
	private ArrayList<Card> hand; // the player's cards
	private double bankroll;
    private double bet;

	// you may choose to use more instance variables
		
	public Player(){		
	// create a player here    
    
    hand = new ArrayList<Card> ();
       
        bankroll = 100;
        bet = 0;
        
	}
    
    
    public ArrayList<Card> getHand(){
        return hand;
    }

	public void addCard(Card c){
	// add the card c to the player's hand
    
    hand.add(c);    
        
	}

	public void removeCard(Card c){
	// remove the card c from the player's hand
  
    hand.remove(c);
    
    }
	
    public void bets(double amt){
    // player makes a bet
    bankroll = bankroll - amt;
    bet = amt;       
        
    }
    
    public void losings(double lost){
        bankroll -= (bet * lost);
    }

    public void winnings(double odds){
    //	adjust bankroll if player wins
    
    bankroll += (bet * odds);    
        
    }
    

    public double getBankroll(){
    // return current balance of bankroll
    
    return bankroll;
        
    }


    // you may wish to use more methods here
}











    


