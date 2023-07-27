import java.util.*;
public class unoGame{
    private static final int initial_hands=7;
    private static final int num_players=2;
    private static List<String> deck;
    private static List<String> discardedcards;
    private static List<List<String> >hands;  //2d array because there exist two hands which also have an array of cards

    private static String d_color;
    private static String d_value;
    private static int current_player;

    private static List<String> generate_deck(){
        List<String> deck=new ArrayList<>();
        String[] colors={"RED","GREEN","BLUE","YELLOW"};
        String[] values={"0","1","2","3","4","5","6","7","8","9","skip","reverse","draw2"};
        int size_colors=4;
        int size_values=13;
        for(int i=0;i<size_colors;i++){
            for(int j=0;j<size_values;j++){
                deck.add(colors[i]+" "+values[j]);
            }
            for(int j=1;j<size_values;j++){
                deck.add(colors[i]+" "+values[j]);
            }
        }
        return deck;
    }
    private static String random_color(){
        String[] colors={"RED","GREEN","BLUE","YELLOW"};
        Random r =new Random();
        int i =r.nextInt(colors.length);
        return colors[i];
    }
    private static String random_value(){
        String[] values={"0","1","2","3","4","5","6","7","8","9","skip","reverse","draw2"}; 
        Random r =new Random();
        int i =r.nextInt(values.length);
        return values[i];
    }
    private static void base(){
        deck=generate_deck();
        discardedcards=new ArrayList<>();
        hands=new ArrayList<>();        // instantiated the two arrays
        d_color=random_color();
        d_value=random_value();
        discardedcards.add(d_color+" "+d_value);
        deck.remove(d_color+" "+d_value);    
    }
    private static String draw_card(){
        Random random= new Random();
        int i=random.nextInt(deck.size());
        return deck.remove(i);
    }
    private static void distribute_cards(){
        for(int i=0;i<num_players;i++){
            List<String> hand=new ArrayList<>();
            for(int j=0;j<initial_hands;j++){
                hand.add(draw_card());
            }
            hands.add(hand);
        }
    }
    private static void displayGameState(){
        System.out.println();
        System.out.println("current card : "+d_color+" "+d_value);
        System.out.println("Your Cards : "+hands.get(0));
        //System.out.println("comp's hand: " + hands.get(1));
        System.out.println();
    }
    private static void playerTurn(){
        System.out.println("It's your turn.");
        boolean valid=false;
        Scanner sc=new Scanner(System.in);

        while(!valid){
            System.out.println();
            System.out.print("Enter the position of the card to play or 'draw' to draw a card :");
            String input=sc.nextLine();
            

            if(input.equals("draw")){
                String drawncard=draw_card();
                hands.get(0).add(drawncard);
                System.out.println("You drew : "+drawncard);
                current_player=1;
                return;
            }
            try{
                int index =Integer.parseInt(input);
                String card=hands.get(0).get(index);
                String[] parts=card.split(" ");
                if(parts[0].equals(d_color)||parts[1].equals(d_value)){
                    d_color=parts[0];
                    d_value=parts[1];
                    hands.get(0).remove(index);
                    discardedcards.add(card);
                    valid=true;
                    current_player=1;
                    if(parts[1].equals("reverse")){
                        current_player=0;
                    }
                    else if(parts[1].equals("draw2")){
                        String drawnCard1=draw_card();
                        hands.get(1).add(drawnCard1);
                        System.out.println("computer picked "+drawnCard1);
                        String drawnCard2=draw_card();
                        hands.get(1).add(drawnCard2);
                        System.out.println("computer picked "+drawnCard2);
                    }
                    else if(parts[1].equals("skip")){
                        current_player=0;
                    }
                    break;
                }
                else{
                        System.out.println("invalid move. Try again.");
                    }
            }
            catch (NumberFormatException|IndexOutOfBoundsException e){
                System.out.println("invalid input. try again.");
            }
        }
        
    }

    private static void computerTurn(){
        System.out.println("It's the computer's turn. ");
        boolean valid=false;
        List<String> computerHand=hands.get(1);
        for(int i=0;i<computerHand.size();i++){
            String card=computerHand.get(i);
            String[] parts=card.split(" ");
            if(parts[0].equals(d_color)||parts[1].equals(d_value)){
                    d_color=parts[0];
                    d_value=parts[1];
                    hands.get(1).remove(i);
                    discardedcards.add(card);
                    valid=true;
                    current_player=0;
                    if(parts[1].equals("reverse")){
                        current_player=1;   
                    }
                    else if(parts[1].equals("draw2")){
                            String drawnCard1=draw_card();
                            hands.get(0).add(drawnCard1);
                            System.out.println("you picked "+drawnCard1);
                            String drawnCard2=draw_card();
                            hands.get(0).add(drawnCard2);
                            System.out.println("you picked "+drawnCard2);
                        
                    }
                    else if(parts[1].equals("skip")){
                        current_player=1;
                    }
                    break;
                } 
                
            }
        if(!valid){
        String drawnCard=draw_card();
        hands.get(1).add(drawnCard);
        System.out.println("the computer drew a card.");
        current_player=0;
        }
            
    }
    private static boolean isGameOver(){
        if(hands.get(0).isEmpty()){
            System.out.println("!!! YOU WON !!!");
            return true;
        }
        if(hands.get(1).isEmpty()){
            System.out.println("!!! UH OH YOU LOST !!!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        base();
        distribute_cards();
        System.out.println("welcome to uno game!");
        System.out.println();
        while(true){
            displayGameState();
            if(current_player==0){
                playerTurn();
            }
            else{
                computerTurn();
            }
            if(isGameOver()){
                break;
            }
        }
    }
}