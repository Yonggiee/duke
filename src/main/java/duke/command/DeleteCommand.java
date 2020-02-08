package duke.command;

import duke.exception.NoNumberDeleteException;
import duke.exception.NoSuchTaskException;
import duke.exception.UnableToSaveException;
import duke.main.Constant;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

public class DeleteCommand extends Command {
    public DeleteCommand(String[] inputArr) {
        this.inputArr = inputArr;
    }

    /**
     * This method deletes the task specified in inputArr and saves changes into
     * storage. Ui sends a reply to the user, stating delete is successful.
     * 
     * @param tasks   Existing Tasklist
     * @param ui      Ui for user interaction
     * @param storage Storage to save tasks in local storage
     * @return reply to user the task has been deleted
     * @throws NoNumberDeleteException If task number to be deleted is not
     *                                 specified.
     * @throws UnableToSaveException   If unable to save to storage.
     * @throws NoSuchDeleteException   If task to be deleted does not exist.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage)
            throws NoNumberDeleteException, NoSuchTaskException, UnableToSaveException {
        if (inputArr.length < 2) {
            throw new NoNumberDeleteException();
        } 
        int taskToDelete = Integer.parseInt(inputArr[1]);
        if (taskToDelete > tasks.size()) {
            throw new NoSuchTaskException();
        } 
        String whichTaskDelete = tasks.getTask(taskToDelete - 1).toString();
        tasks.removeTask(taskToDelete - 1);
        storage.saveToSave(tasks);
        return ui.reply("Okcan. I will remove this task:\n" + Constant.SPACE + "  " + whichTaskDelete + "\n"
                + Constant.SPACE + "But you still have " + tasks.size() + " task(s) in the list.");
    }

    @Override
    public boolean isExit() {
        return false;
    }
}