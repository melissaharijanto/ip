package duke.command;

import duke.Ui;
import duke.exception.DukeException;
import duke.processor.TaskList;
import duke.task.Task;

/**
 * Class that represents the command 'mark'.
 *
 * @author Melissa Anastasia Harijanto
 */
public class MarkCommand extends Command {
    /** The index referring to the task in the taskList. */
    private int taskIndex;

    /**
     * Constructs an instance of 'MarkCommand'.
     *
     * @param taskIndex The index referring to the task in the taskList.
     */
    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Marks a task as done.
     *
     * @param tasks The list of tasks that the user has inputted.
     * @throws DukeException Exceptions exclusive to the duke.Duke bot, thrown when
     *     the user does not input a number, or inputs invalid characters after the
     *     'mark' command.
     */
    @Override
    public void execute(TaskList tasks) throws DukeException {
        try {
            Ui ui = new Ui();
            Task task = tasks.getTask(taskIndex);
            task.markAsDone();
            ui.mark(task);
        } catch (Exception e) {
            throw new DukeException("☹ OOPS!!! The number you are talking about does not exist. "
                    + "\nPerhaps it is not a number at all? Please check again!");
        }
    }
}
