//package gui;
//
//import java.awt.Component;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.LinkedList;
//
//import javax.swing.*;
//
//import commands.DropDoctor;
//import commands.AssignDoctor;
//import containers.DoctorMapAccess;
//import entities.Doctor;
//import entities.Patient;
//import entities.BasicDoctor;
//import entities.Surgeon;
//
///**
// * The panel to display the information for a patient, and accept operations on the patient. The
// * panel gives the patient's name and health number. If the patient has bed in the ward, it is given
// * and the user has the option to remove the patient from the bed. If the patient does not have a
// * bed, a create is created for the ward information, so that the patient can be added to an empty
// * bed. The doctors of the patient are given, and the user has the option to add another doctor or
// * remove a doctor.
// */
//public class DoctorPanel extends JPanel {
//    String docType;
//    JTextField tField;
//
//    /**
//     * Create the panel to display the patient's information and accept operations on the patient.
//     *
//     * @param doctor the patient whose information is to be displayed and on whom operations can be
//     *        done
//     */
//    public DoctorPanel(Doctor doctor) {
//
//        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
//        add(new JLabel("Doctor Name: "+doctor.getName()));
//        if(doctor instanceof Surgeon){
//            docType = "yes";
//        }else {
//            docType = "no";
//        }
//        add(new JLabel("Is Surgeon..??"+docType));
//
//        JButton assignP = new JButton("Assign Patient to Doctor");
//
//        assignP.setSize(assignP.getPreferredSize());
//        add(assignP);
//        assignP.setAlignmentX(Component.CENTER_ALIGNMENT);
//        assignP.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                PatientAddFrame frame = new PatientAddFrame();
//                frame.setLocation(300, 300);
//                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//                frame.setVisible(true);
//            }
//        });
//        add(Box.createVerticalGlue());
//
//        JLabel promt = new JLabel("Access my Patient");
//        tField = new JTextField(10);
//        add(promt);
//        add(tField);
//        tField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int void
//            }
//        });
//        }
//
//
//
//
//       }
//
//}

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
    String isSurgeon;
    JTextField textField;

    DoctorPanel(Doctor dr) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new JLabel("Doctor's Name:   " + dr.getName()));
        if (dr instanceof Surgeon) {
            isSurgeon = "YES";
        }
        else {
            isSurgeon = "NO";
        }
        add(new JLabel("Is a Surgeon?:    " + isSurgeon));

        JButton assignPatient = new JButton("Assign Patient to Doctor");
        assignPatient.setSize(assignPatient.getPreferredSize());
        add(assignPatient);
        assignPatient.setAlignmentX(Component.LEFT_ALIGNMENT);
        assignPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                PatientAddFrame frame = new PatientAddFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        JLabel prompt = new JLabel("Access my Patient");
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
                    JTextArea error = new JTextArea("ENTER AN INTEGER!");
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
                    JTextArea error = new JTextArea("Patient Doesn't Exist");
                    error.setMaximumSize(error.getPreferredSize());
                    add(error);
                    error.setAlignmentX(Component.CENTER_ALIGNMENT);
                    add(Box.createVerticalGlue());
                    revalidate();
                }
            }});
        Box.createVerticalGlue();

        JButton removePatient = new JButton("Unassign Patient");
        removePatient.setSize(assignPatient.getPreferredSize());
        add(removePatient);
        removePatient.setAlignmentX(Component.LEFT_ALIGNMENT);
        removePatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                PatientAddFrame frame = new PatientAddFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());
    }


    public static final long serialVersionUID = 1;

}