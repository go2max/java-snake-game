package gamecontrollers.commandcreator;

import gamecontrollers.Response;
import view.commands.Command;

/**
 * Created by jorgep on 4/14/14.
 */
public class MoveDeveloperController extends DeveloperCommandCreator {

    /*
      This method will return the constructed command
   */
    public Command getCommand(){

        throw new UnsupportedOperationException();

        return null;
    }

    /*
        This method will return the AP cost of the command that would
        be required to perform the command
     */
    public int getCost(){
        return 0;
    }

    /*

     */
    public Response checkPossible(){
        return null;
    }
}
