/* Yehuda Dicker
 * ymd2110
 * Card.java - card
 */


public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
	
	public Card(int s, int r){
		//make a card with suit s and value v
        suit = s;
        rank = r;       
	}
        
	
	public int compareTo(Card c){
		// use this method to compare cards so they 
		// may be easily sorted        
        
        if (getRank() > c.getRank())
            return 1;
        
        else if(getRank() == c.getRank()){
            if (getSuit() > c.getSuit())
                return 1;
            if (getSuit() < c.getSuit())
                return -1;
                
            else
                return 0;
            
        }
        
        else
            return -1;
	}
	
	public String toString(){
		// use this method to easily print a Card object
        
        String rankString = "";
        
       

        if (rank == 11){
            rankString = "Jack";
        }
        
        else if(rank == 12){
            rankString = "Queen";
        }
        
        else if(rank ==13){
            rankString = "King";
        }
        
        else if (rank == 1){
            rankString = "Ace";
        }
        
        else{
            rankString = String.valueOf(rank);
        }
        
        String suitString = "";
        
        if (suit == 1){
            suitString = "Hearts";
        }
        
        else if (suit == 2){
            suitString = "Diamonds";
        }
        
        else if (suit == 3){
            suitString = "Spades";
        }
        
        else {
            suitString = "Clubs";
        }
       
       return rankString + " of " + suitString ;
	}
	// add some more methods here if needed

    
    public int getRank(){
        
        return rank;
    }
    
    
    public int getSuit(){

        return suit;
    }
}
