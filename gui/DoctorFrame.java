package gui;

import javax.swing.JFrame;

import containers.DoctorMapAccess;
import containers.PatientMapAccess;
import entities.Doctor;
import entities.Patient;

/**
 * The frame for the window to display the information for a Doctor, and accept operations on the
 * Doctor.
 */
public class DoctorFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 400;

    /**
     * Create the frame to display the information for a Doctor.
     *
     * @param docName the name of the Doctor
     * @precond docName is the name of Doctor
     */
    public DoctorFrame(String docName) {
        Doctor doctor = DoctorMapAccess.dictionary().get(docName);
        if (doctor != null) {
            setTitle(doctor.getName());
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            DoctorPanel panel = new DoctorPanel(doctor);
            add(panel);
        } else
            throw new RuntimeException("Invalid Doctor Name " + docName);
    }

    public static final long serialVersionUID = 1;
}
