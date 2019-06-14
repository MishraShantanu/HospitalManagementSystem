package gui;

import entities.Doctor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * The panel for the access of a specific Doctor. It has a prompt label, and a text field for the
 * entry of the Doctor's name. When the Enter key is pressed, the Doctor name entered is
 * used to create a new window with the Doctor's data and operations on the Doctor.
 */
public class DoctorAccessPanel extends JPanel {
    /**
     * The text field for the entry of the Doctor Name.
     */
    JTextField textField;

    /**
     * Create the panel with the prompt label and text field. If data is entered into the text field
     * that is not an empty String, a brief error message is entered at the front of the text
     * field. Otherwise, a new window is created with the patient's data and operations on the
     * patient.
     */
    public DoctorAccessPanel() {
        JLabel promptLabel = new JLabel("Access Doctor");
        add(promptLabel);
        textField = new JTextField(10);
        add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String docName = textField.getText();

                if (docName != null && docName.length() > 0) {
                    DoctorFrame frame = null;
                    try {
                        frame = new DoctorFrame(docName);
                    } catch (RuntimeException e) {
                        textField.setText("Invalid name: " + textField.getText());
                        textField.revalidate();
                        return;
                    }
                    frame.setLocation(300, 300);
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setVisible(true);
                    textField.setText("");
                    textField.revalidate();
                } else {
                    textField.setText("Empty field: " + textField.getText());
                    textField.revalidate();
                }
            }
        });
    }

    public static final long serialVersionUID = 1;
}
