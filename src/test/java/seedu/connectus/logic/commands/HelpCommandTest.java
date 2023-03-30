package seedu.connectus.logic.commands;

import static seedu.connectus.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.connectus.logic.commands.HelpCommand.SHOWING_HELP_WINDOW;
import static seedu.connectus.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.connectus.model.Model;
import seedu.connectus.model.ModelManager;

public class HelpCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_helpWithoutInput_success() {
        CommandResult expectedCommandResult = new CommandResult(SHOWING_HELP_WINDOW, true, false);
        assertCommandSuccess(new HelpCommand(), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpWithValidInput_success() {
        ListCommand listCommand = new ListCommand();
        CommandResult expectedListCommandResult = new CommandResult("Command usage retrieved!\n"
                + listCommand.MESSAGE_USAGE, false, false);
        assertCommandSuccess(new HelpCommand(listCommand.MESSAGE_USAGE), model, expectedListCommandResult,
                expectedModel);

        ClearCommand clearCommand = new ClearCommand();
        CommandResult expectedClearCommandResult = new CommandResult("Command usage retrieved!\n"
                + clearCommand.MESSAGE_USAGE, false, false);
        assertCommandSuccess(new HelpCommand(clearCommand.MESSAGE_USAGE), model, expectedClearCommandResult,
                expectedModel);

        HelpCommand helpCommand = new HelpCommand("help");
        CommandResult expectedHelpCommandResult = new CommandResult("Command usage retrieved!\n"
                + helpCommand.MESSAGE_USAGE, false, false);
        assertCommandSuccess(new HelpCommand(helpCommand.MESSAGE_USAGE), model, expectedHelpCommandResult,
                expectedModel);
    }
}
