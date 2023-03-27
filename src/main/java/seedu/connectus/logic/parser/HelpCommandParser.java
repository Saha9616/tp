package seedu.connectus.logic.parser;

import static seedu.connectus.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.HashMap;
import java.util.Map;

import seedu.connectus.logic.commands.AddCommand;
import seedu.connectus.logic.commands.AddTagToPersonCommand;
import seedu.connectus.logic.commands.ClearCommand;
import seedu.connectus.logic.commands.DeleteCommand;
import seedu.connectus.logic.commands.DeleteTagFromPersonCommand;
import seedu.connectus.logic.commands.EditCommand;
import seedu.connectus.logic.commands.ExitCommand;
import seedu.connectus.logic.commands.HelpCommand;
import seedu.connectus.logic.commands.ListCommand;
import seedu.connectus.logic.commands.SearchCommand;
import seedu.connectus.logic.parser.exceptions.ParseException;

public class HelpCommandParser implements Parser<HelpCommand> {

    //@@author gremmyz-reused
    //Reused HashMap idea from https://github.com/AY2223S1-CS2103T-W12-4/tp with modifications.
    private static final Map<String, String> COMMAND_USAGE_MESSAGES = new HashMap<>();

    static {
        COMMAND_USAGE_MESSAGES.put(AddCommand.COMMAND_WORD, AddCommand.MESSAGE_USAGE);
        COMMAND_USAGE_MESSAGES.put(AddTagToPersonCommand.COMMAND_WORD, AddTagToPersonCommand.MESSAGE_USAGE);
        COMMAND_USAGE_MESSAGES.put(ClearCommand.COMMAND_WORD, ClearCommand.MESSAGE_USAGE);
        COMMAND_USAGE_MESSAGES.put(DeleteCommand.COMMAND_WORD, DeleteCommand.MESSAGE_USAGE);
        COMMAND_USAGE_MESSAGES.put(DeleteTagFromPersonCommand.COMMAND_WORD, DeleteTagFromPersonCommand.MESSAGE_USAGE);
        COMMAND_USAGE_MESSAGES.put(EditCommand.COMMAND_WORD, EditCommand.MESSAGE_USAGE);
        COMMAND_USAGE_MESSAGES.put(ExitCommand.COMMAND_WORD, ExitCommand.MESSAGE_USAGE);
        COMMAND_USAGE_MESSAGES.put(HelpCommand.COMMAND_WORD, HelpCommand.MESSAGE_USAGE);
        COMMAND_USAGE_MESSAGES.put(ListCommand.COMMAND_WORD, ListCommand.MESSAGE_USAGE);
        COMMAND_USAGE_MESSAGES.put(SearchCommand.COMMAND_WORD, SearchCommand.MESSAGE_USAGE);
    }

    public HelpCommand parse(String args) throws ParseException {
        if (args.trim().isEmpty()) {
            return new HelpCommand();
        }

        String commandUsage = COMMAND_USAGE_MESSAGES.get(args.trim());
        if (commandUsage == null) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        return new HelpCommand(commandUsage);
    }
}
