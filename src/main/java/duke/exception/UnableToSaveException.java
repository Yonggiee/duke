package duke.exception;

import duke.main.Constant;

public class UnableToSaveException extends DukeException {

    @Override
    public String toString() {
        return "☹ I CAN'T SAVE! Are you sure it's the right location";
    }
}
