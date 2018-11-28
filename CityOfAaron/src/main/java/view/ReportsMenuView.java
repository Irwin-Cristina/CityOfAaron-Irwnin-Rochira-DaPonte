package view;

/**
 *
 * @author Andrea
 */
import model.*;
import app.*;
import control.*;
import exceptions.GameControlException;
import java.util.ArrayList;

public class ReportsMenuView extends ViewBase {

    /**
     * Constructor
     */
    public ReportsMenuView() {
    }

    @Override
    protected String getMessage() {
        return "\nReports Menu\n"
                + "------------\n"
                + "A - View the authors of this game\n"
                + "L - View the livestock in the storehouse\n"
                + "P - View the provisions in the storehouse\n"
                + "T - View the tools in the storehouse\n"
                + "B - Back to Game Menu\n";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        // Declare the array to have the number of elements you intend to get from the user.
        String[] inputs = new String[1];

        // the following string is printed to the console by the statement 'System.out.println(prompt)'
        inputs[0] = getUserInput("Select an action from the menu above:");

        // Repeat for each input you need, putting it into its proper slot in the array.
        return inputs;
    }

    /**
     * Perform the action indicated by the user's input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {

        switch (inputs[0].trim().toUpperCase()) {
            case "A":
                    try {
                        reportAuthors();
                    } catch (GameControlException gc) {
                            System.out.println(gc.getMessage());
                    } catch (Throwable te) {
                        System.out.println(te.getMessage());
                        te.printStackTrace();
                    }
                break;
            case "L":
                reportLivestocks();
                break;
            case "P":
                reportProvisions();
                break;
            case "T":
                reportTools();
                break;
            case "B":
                System.out.println("Exiting Report Menu...\n");
                return false;
            default:
                System.out.println("Invalid selection, try again.\n");
        }

        return true;
    }

    // To fulfill the requirements of the rubric (do-while logic + two String methods)
    private void reportAuthors() throws GameControlException {

        // Get authors from the Storehouse 
        Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();
        int i = 0;
        System.out.println("\nLet's get to know the authors:\n");

        // Display the Authors
        do {
            System.out.println(authors[i].getTitle().toUpperCase() + " " + authors[i].getName());
            i++;
        } while (i < authors.length);
        
        /**
        System.out.println("\nFollow the list of male authors:");
        control.StorehouseControl.pickAuthorsByTitle("Mr");

        System.out.println("\nFollow the list of female authors:");
        control.StorehouseControl.pickAuthorsByTitle("Mrs");

        System.out.println("\nFollow the longest author's name");
        control.StorehouseControl.pickAuthorLongestName();

        System.out.println("\nFollow the name of an author randomly chosen by the system");
        control.StorehouseControl.pickAuthorByRandomIndex(GameControl.getRandomValue(0, authors.length-1));
        
        System.out.println("\nFollow the alphabetical list of the authors by using the sort() method");
        control.StorehouseControl.sortAuthorsByName();
        
        System.out.println("\nFollow the alphabetical list of the authors by using the bubble sort method");
        control.StorehouseControl.sortAuthorsByNameAlgorithm();
        */
        
        // LET'S TEST ONE OF THE GAMECONTROLEXCEPTION ERRORS
        System.out.println("\nRaise a GameControlException error when the author is randomly chosen" + 
                           "\nby providing negative values to the getRandomValue function"+
                           "\n---------------------------------------------------------------------");
        control.StorehouseControl.pickAuthorByRandomIndex(GameControl.getRandomValue(0, -1));
        
        /**
        System.out.println("\nRaise a GameControlException error when the author is randomly chosen" + 
                           "\nby providing a higher value which is smaller than the lower one"+
                           "\n---------------------------------------------------------------------");
        control.StorehouseControl.pickAuthorByRandomIndex(GameControl.getRandomValue(5, 2));
        
        System.out.println("\nRaise a GameControlException error when the author is randomly chosen" +
                           "\nby providing a higher value that equals integer type upper limit" +
                           "\n----------------------------------------------------------------------------------");
        control.StorehouseControl.pickAuthorByRandomIndex(GameControl.getRandomValue(0, Integer.MAX_VALUE));
        */
        
        SaveReportView view = new SaveReportView();
        view.displayView();

    }

    private void reportLivestocks() {
        // Get animals from Storehouse
        for (int i = 0; i < CityOfAaron.getCurrentGame().getStorehouse().getAnimals().size(); i++) {
            System.out.println("\nName: " + CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getName()
                    + "\nAge: " + CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getAge()
                    + "\nCondition: " + CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getCondition()
                    + "\nQuantity: " + CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getQuantity());
            pause(2000);
        }

        // List Animals in Alphabetical Order
        System.out.println("\nList Animals in Alphabetical order");
        control.StorehouseControl.sortAnimalbyName();

        for (Animal animal : CityOfAaron.getCurrentGame().getStorehouse().getAnimals()) {
            System.out.println(animal);
        }
        //Filter the Animals in GOOD condition
        System.out.println("\nAnimals in GOOD condition");
        ArrayList<Animal> filteredAnimals = StorehouseControl.filterAnimalbyCondition("GOOD");
        for (Animal animal : filteredAnimals) {
            System.out.println(animal);
        }

        //Sort Animals by age
        System.out.println("\nList Animals by Age, oldest to youngest");
        control.StorehouseControl.sortAnimalbyAge();
        for (Animal animal : CityOfAaron.getCurrentGame().getStorehouse().getAnimals()) {
            System.out.println(animal);
        }

        SaveReportView view = new SaveReportView();
        view.displayView();
    }

    private void reportProvisions() {
        for (int i = 0; i < CityOfAaron.getCurrentGame().getStorehouse().getProvisions().size(); i++) {
            System.out.println("\nName: " + CityOfAaron.getCurrentGame().getStorehouse().getProvisions().get(i).getName()
                    + "\nPerishable: " + CityOfAaron.getCurrentGame().getStorehouse().getProvisions().get(i).getPerishable()
                    + "\nCondition: " + CityOfAaron.getCurrentGame().getStorehouse().getProvisions().get(i).getCondition()
                    + "\nQuantity: " + CityOfAaron.getCurrentGame().getStorehouse().getProvisions().get(i).getQuantity());
            pause(2000);
        }

        SaveReportView view = new SaveReportView();
        view.displayView();
    }

    private void reportTools() {
        for (int i = 0; i < CityOfAaron.getCurrentGame().getStorehouse().getTools().size(); i++) {
            System.out.println("\nName: " + CityOfAaron.getCurrentGame().getStorehouse().getTools().get(i).getName()
                    + "\nCondition: " + CityOfAaron.getCurrentGame().getStorehouse().getTools().get(i).getCondition()
                    + "\nQuantity: " + CityOfAaron.getCurrentGame().getStorehouse().getTools().get(i).getQuantity());
            pause(2000);
        }

        SaveReportView view = new SaveReportView();
        view.displayView();
    }
}
