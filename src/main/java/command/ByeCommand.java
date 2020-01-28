package command;

import main.*;
import exception.*;

public class ByeCommand extends Command{
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        ui.goodBye();
    }
    @Override
    public boolean isExit(){
        return true;
    }
}