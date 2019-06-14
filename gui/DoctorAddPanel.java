package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.NumberUp;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import commands.AddPatient;
import commands.NewDoctor;

/**
 * The panel to obtain data for the creation of a Doctor, and to cause the Doctor to be created.
 */
public class DoctorAddPanel extends JPanel {
    /* Declare the components of the panel needed by inner classes. */

    /**
     * A text area to be used to display an error if one should occur.
     */
    JTextArea error = null;

    /**
     * A panel for the entry of the name of a new Doctor.
     */
    ValueEntryPanel namePanel;

    /**
     * A panel for the entry of the type of Doctor(Surgeon or not).
     */
    ValueEntryPanel typePanel;

    /**
     * Create the panel to obtain data for the creation of a Doctor, and to cause the Doctor to be
     * created.
     */
    public DoctorAddPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // add a label with a prompt to enter the patient data
        JLabel prompt = new JLabel("Enter Doctor Information");
        prompt.setMaximumSize(prompt.getPreferredSize());
        add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the patient's name
        namePanel = new ValueEntryPanel("Name");
        namePanel.setMaximumSize(namePanel.getPreferredSize());
        add(namePanel);
        namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the patient's health number
        typePanel = new ValueEntryPanel("Is Doctor a Surgeon Y or N..??");
        typePanel.setMaximumSize(typePanel.getPreferredSize());
        add(typePanel);
        typePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());


        // add a button to submit the information and create the patient
        JButton submitButton = new JButton("Submit");
        submitButton.setMaximumSize(submitButton.getPreferredSize());
        add(submitButton);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new SubmitListener());
        add(Box.createVerticalGlue());
    }

    /**
     * The class listening for the press of the submit button. It accesses the name & type
     *  entered, and uses them to add a new Doctorto the system.
     */
    private class SubmitListener implements ActionListener {
        /**
         * When the submit button is pressed, access the name and type, and use
         * them to add a new Doctor to the system.
         */
        public void actionPerformed(ActionEvent event) {
            if (error != null) {
                // remove error from the previous submission
                remove(error);
                error = null;
            }
            String name = namePanel.getValueAsString();

            String type = typePanel.getValueAsString();

            try {
                if(name==null){
                    throw new NullPointerException();
                }
                if(type==null){
                    throw new NullPointerException();
                }
            } catch (NullPointerException e) {
                revalidate(); // redraw the window as it has changed with
                // the addition of error message to the field
                // by the method getValueAsInt
                return;
            }
            NewDoctor doc = new NewDoctor();
            boolean flag = false;
            if(type=="y"||type=="Y"){
                flag =true;
            }
            doc.addDoctor(name,flag);

            if (doc.wasSuccessful()) {
                getTopLevelAncestor().setVisible(false);

            } else {
                error = new JTextArea(SplitString.at(doc.getErrorMessage(), 40));
                error.setMaximumSize(error.getPreferredSize());
                add(error);
                error.setAlignmentX(Component.CENTER_ALIGNMENT);
                add(Box.createVerticalGlue());
                revalidate(); // redraw the  window as it has changed
            }
        }
    }

    public static final long serialVersionUID = 1;
}
