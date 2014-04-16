package gamecontrollers.turn;

//TODO [Kevin][Will]
import gamecontrollers.commands.GameplayActionCommand;
import java.util.Stack;

public class PlanningController {
    private Stack<GameplayActionCommand> plannedMoves;
    private TurnState turnState;

    private PlanningController(){

    }

    public Stack<GameplayActionCommand> getPlannedMoves(){
        return plannedMoves;
    }

    public void planCommand(GameplayActionCommand c){
        plannedMoves.push(c);
    }

    public void cancelCommand(){
        plannedMoves.pop();
    }

    public void clearPlannedCommands(){
        plannedMoves.removeAllElements();
    }
}
