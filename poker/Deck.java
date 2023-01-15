/* Yehuda Dicker
 * ymd2110
 * Deck.java - deck
 */

import java.util.*;

public class Deck {
	
	private Card[] cards;  
    private int rank;
    private int suit;
	private int top; // the index of the top of the deck
    
	
	public Deck(){
		// make a 52 card deck here
        
        suit = 1;
        rank = 1;
                
        cards = new Card[52];
        
        for (int i = 0; i < 52; i++){
            
           Card firstCard = new Card(suit, rank);

           cards[i] = firstCard;
            
            suit ++;
            rank ++;
            
         if (suit == 5){
             suit = 1;
         }
         
         if (rank == 14){
             rank = 1;
         }  
            
        }
        
	}
    
    
   public Card getCard (int position) {
       return cards[position];
   }
      
	
	public void shuffle(){
		// shuffle the deck here
        
        Random ranshuffle = new Random();
        
        for (int i = 0; i < cards.length; i++){
            
            int ranCard = ranshuffle.nextInt(cards.length);
            
            Card temp = cards[i];
            
            cards [i] = cards [ranCard];
            
            cards [ranCard] = temp;
        }
        
	}
	
	public Card deal(){
		// deal the top card in the deck
       
        return cards[top];        
        
	}
    
    public void changeTop(){
   
        if (top < 52){
            top++;
        }
        
        else{
            top = 51;
        }
        
    }
    
	
	// add more methods here if needed

}
