package seedu.address.model.appointment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.appointmentcommands.AppointmentCommandTestUtil.*;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalAppointments.APT1;
import static seedu.address.testutil.TypicalAppointments.APT2;
import static seedu.address.testutil.TypicalPatients.ALICE;
import static seedu.address.testutil.TypicalPatients.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.AppointmentBuilder;

public class AppointmentTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Appointment appointment = new AppointmentBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> appointment.getTags().remove(0));
    }

    @Test
    public void isSameAppointment() {
        // same object -> returns true
        assertTrue(APT1.isSameAppointment(APT1));

        // null -> returns false
        assertFalse(APT1.isSameAppointment(null));

        // different date and time -> returns false
        Appointment editedAPT1 = new AppointmentBuilder(APT1).withAppointmentTime(VALID_START_TWO, VALID_END_TWO).build();
        assertFalse(APT1.isSameAppointment(editedAPT1));

        // different description -> returns false
        editedAPT1 = new AppointmentBuilder(APT1).withDescription(VALID_DESCRIPTION_TWO).build();
        assertFalse(APT1.isSameAppointment(editedAPT1));

        // different patient-> returns false
        editedAPT1 = new AppointmentBuilder(APT1).withPatient(BOB).build();
        assertFalse(APT1.isSameAppointment(editedAPT1));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Appointment apt1Copy = new AppointmentBuilder(APT1).build();
        assertTrue(APT1.equals(apt1Copy));

        // same object -> returns true
        assertTrue(APT1.equals(APT1));

        // null -> returns false
        assertFalse(APT1.equals(null));

        // different type -> returns false
        assertFalse(APT1.equals(5));

        // different appointment -> returns false
        assertFalse(APT1.equals(APT2));

        // different appointment time -> returns false
        Appointment editedAPT1 = new AppointmentBuilder(APT1).withAppointmentTime(VALID_START_TWO, VALID_END_TWO).build();
        assertFalse(APT1.equals(editedAPT1));

        // different description -> returns false
        editedAPT1 = new AppointmentBuilder(APT1).withDescription(VALID_DESCRIPTION_TWO).build();
        assertFalse(APT1.equals(editedAPT1));

        // different patient -> returns false
        editedAPT1 = new AppointmentBuilder(APT1).withPatient(BOB).build();
        assertFalse(APT1.equals(editedAPT1));

        // different tags -> returns false
        editedAPT1 = new AppointmentBuilder(APT1).withTags(VALID_TAG_TWO).build();
        assertFalse(APT1.equals(editedAPT1));
    }
}
