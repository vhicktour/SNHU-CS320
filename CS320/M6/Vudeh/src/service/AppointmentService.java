package service;

import java.util.HashMap;
import java.util.Date;
import model.Appointment;

/**
 * Service class for managing appointments in a simple in-memory data structure.
 * Provides methods to add, delete, and update appointments.
 * Uses a pseudo-GUID mechanism to generate unique appointment IDs.
 * Author: Victor Udeh
 * CS320
 * Date: Apr 12, 2024
 */
public class AppointmentService {

    private int currentIDNum = 0; // pseudo GUID for generating unique IDs
    private HashMap<String, Appointment> appointments = new HashMap<>();

    /**
     * Adds a new unique appointment to the service.
     * @param date The date of the new appointment.
     * @param description The description of the new appointment.
     */
    public void addUniqueAppointment(Date date, String description) {
        String stringID = Integer.toString(currentIDNum);
        Appointment newAppointment = new Appointment(stringID, date, description);
        appointments.put(stringID, newAppointment);
        currentIDNum++;
    }

    /**
     * Deletes an appointment from the service based on its ID.
     * @param id The ID of the appointment to be deleted.
     */
    public void deleteAppointment(String id) {
        if (appointments.containsKey(id)) {
            appointments.remove(id);
        }
    }

    /**
     * Updates an existing appointment's date and description based on its ID.
     * @param id The ID of the appointment to update.
     * @param date The new date for the appointment.
     * @param description The new description for the appointment.
     */
    public void updateAppointment(String id, Date date, String description) {
        if (appointments.containsKey(id)) {
            Appointment appointmentToUpdate = appointments.get(id);
            appointmentToUpdate.setDate(date);
            appointmentToUpdate.setDescription(description);
        }
    }
}
