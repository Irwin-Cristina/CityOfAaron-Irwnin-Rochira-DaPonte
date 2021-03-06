
package view;
import app.CityOfAaron;
import control.*;
import exceptions.GameControlException;
        
/**
 *
 * @author team Irwin - DaPonte - Rochira
 */
public class NewGameView extends ViewBase{
    /**
     * Constructor
     */
    public NewGameView(){
        
    }
   @Override 
   protected String getMessage() {
      return "Starting a new game...\n\n";
   }

    /**
     * Get the set of inputs from the user.
     * @return 
     */
   @Override
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];
        
        // the following string is printed to the console by the statement 'System.out.println(prompt)'
        // included in the getUserInput method (line 82)
        inputs[0] = getUserInput("Please enter your name, or press 'Enter' to return to the main menu:", true);
        
        // Repeat for each input you need, putting it into its proper slot in the array.
        
        return inputs;
    }
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs){
        
        if ( inputs[0] == null || inputs[0].equals("") ) {
            ErrorView.display(this.getClass().getName(),"No player name entered. Returning to the Main menu...");
            return false; 
        }

        String playerName = inputs[0];
        
        try {
            CityOfAaron.setCurrentGame(GameControl.createNewGame(playerName));
        } catch (GameControlException gc) {
            ErrorView.display(this.getClass().getName(),gc.getMessage());
        }
        
        console.println("\nWelcome to the game " + CityOfAaron.getCurrentGame().getPlayer().getName() + ". Everything is ready to start your reign.\n\nYou currently have: \n"
                            + CityOfAaron.getCurrentGame().getAcresOwned() + " acres\n"
                            + CityOfAaron.getCurrentGame().getWheatInStorage()+ " bushels of wheat\n"
                            + CityOfAaron.getCurrentGame().getCurrentPopulation() + " people in your city");
        
        pause(3000);
        
        GameMenuView view = new GameMenuView();
        view.displayView();
         
        // to interrupt the loop of displayView method
        return false;
    }    
}    
