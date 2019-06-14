
package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entities.*;

/**
 * Doctor Panel for prompting the user for a Doctor's name, along
 * with a prompt if the doctor is a surgeon or not
 */
public class DoctorPanel extends JPanel {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    String docType;
    JTextField textField;

    DoctorPanel(Doctor dr) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new JLabel("Doctor's Name:   " + dr.getName()));
        if (dr instanceof Surgeon) {
            docType = "YES";
        }
        else {
            docType = "NO";
        }
        add(new JLabel("Is a Surgeon?:    " + docType));

        JButton assignPatient = new JButton("Assign Patient to Doctor");
        assignPatient.setSize(assignPatient.getPreferredSize());
        add(assignPatient);
        assignPatient.setAlignmentX(Component.LEFT_ALIGNMENT);
        assignPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                PatientAddFrame frame = new PatientAddFrame();
                frame.setLocation(DEFAULT_WIDTH,DEFAULT_HEIGHT);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        JLabel prompt = new JLabel("Access Patient");
        textField = new JTextField(10);
        add(prompt);
        add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int number = 0;
                try {
                    number = Integer.parseInt(textField.getText());
                }
                catch (NumberFormatException e) {
                    JTextArea error = new JTextArea("Enter a valid  integer!");
                    error.setMaximumSize(error.getPreferredSize());
                    add(error);
                    error.setAlignmentX(Component.CENTER_ALIGNMENT);
                    add(Box.createVerticalGlue());
                    revalidate();
                    return;
                }
                if (dr.hasPatient(number)) {
                    PatientFrame patient = new PatientFrame(number);
                    patient.setVisible(true);
                }
                else {
                    JTextArea error = new JTextArea("The Patient Doesnt exist in the system");
                    error.setMaximumSize(error.getPreferredSize());
                    add(error);
                    error.setAlignmentX(Component.CENTER_ALIGNMENT);
                    add(Box.createVerticalGlue());
                    revalidate();
                }
            }});
        Box.createVerticalGlue();

        JButton removePatient = new JButton("Drop Patient");
        removePatient.setSize(assignPatient.getPreferredSize());
        add(removePatient);
        removePatient.setAlignmentX(Component.LEFT_ALIGNMENT);
        removePatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                PatientAddFrame frame = new PatientAddFrame();
                frame.setLocation(DEFAULT_WIDTH,DEFAULT_HEIGHT);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());
    }


    public static final long serialVersionUID = 1;

}