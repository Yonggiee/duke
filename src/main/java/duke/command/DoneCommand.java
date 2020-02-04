package duke.command;

import duke.main.Constant;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.exception.UnableToSaveException;

public class DoneCommand extends Command {
    public DoneCommand(String[] inputArr) {
        this.inputArr = inputArr;
    }

    /**
     * This method marks the task specified in inputArr as done/completed and saves
     * changes into storage. Ui sends a reply to the user, stating checking done is
     * successful.
     * 
     * @param tasks   Existing Tasklist
     * @param ui      Ui for user interaction
     * @param storage Storage to save tasks in local storage
     * @throws UnableToSaveException If unable to save to storage.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws UnableToSaveException {
        int taskNo = Integer.parseInt(inputArr[1]) - 1;
        tasks.setDone(taskNo);
        storage.saveToSave(tasks);
        return ui.reply("Okcan, I mark this task as done:\n  " + Constant.SPACE + tasks.getTask(taskNo));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}