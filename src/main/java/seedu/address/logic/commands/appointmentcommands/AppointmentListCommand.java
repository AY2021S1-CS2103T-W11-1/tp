package seedu.address.logic.commands.appointmentcommands;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_APPOINTMENTS;

/**
 * Lists all appointments in the address book to the user.
 */
public class AppointmentListCommand extends Command {

    public static final String COMMAND_WORD = "a-list";

    public static final String MESSAGE_USAGE = COMMAND_WORD;

    public static final String MESSAGE_LIST_APPOINTMENT_SUCCESS = "Listed all appointments";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredAppointmentList(PREDICATE_SHOW_ALL_APPOINTMENTS);
        return new CommandResult(MESSAGE_LIST_APPOINTMENT_SUCCESS);
    }
}
