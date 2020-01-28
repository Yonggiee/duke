package command;

import java.io.IOException;
import exception.*;
import main.*;

public abstract class Command{
    // INVALID, delete
    public String[] inputArr;

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException, IOException;
    public abstract boolean isExit();

    public static int findIndex(String s, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    public static String combineString(String[] arr, int start, int end) {
        String ans = "";
        for (int i = start; i < end; i++) {
            ans += arr[i];
            if (i != end - 1) {
                ans += " ";
            }
        }
        return ans;
    }
}