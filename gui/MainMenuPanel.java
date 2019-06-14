package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import commands.CreateWard;

/**
 * The panel to obtain input to initialize the ward, and then it will start the main system.
 */
public class MainMenuPanel extends JPanel {
    /**
     * The panel for the entry of the ward's name.
     */
    ValueEntryPanel namePanel;

    /**
     * The panel for the entry of the label of the first bed of the ward.
     */
    ValueEntryPanel firstLabelPanel;

    /**
     * The panel for the entry of the label of the last bed of the ward.
     */
    ValueEntryPanel lastLabelPanel;

    /**
     * A panel for an error message, if an error should occur.
     */
    JTextArea error = null;

    /**
     * Create a panel with a field for the entry of the ward's name, a field for the label of the
     * first bed, a field for the label of the last bed, and a submit button to submit the data for
     * the creation of the ward.
     */
    public MainMenuPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        JButton patientButton = new JButton("Patient Operations");
        patientButton.setMaximumSize(patientButton .getPreferredSize());
        add(patientButton );
        patientButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ActionListener listener = new pListner();
        patientButton.addActionListener(listener);
        add(Box.createVerticalGlue());

        JButton doctorButton = new JButton("Doctor Operations");
        doctorButton.setMaximumSize(doctorButton.getPreferredSize());
        add(doctorButton);
        doctorButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ActionListener listener1 = new dListner();
        doctorButton.addActionListener(listener1);
        add(Box.createVerticalGlue());

        JButton wardButton = new JButton("Ward Operations");
        wardButton.setMaximumSize(wardButton.getPreferredSize());
        add(wardButton);
        wardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ActionListener listener2 = new wListner();
        wardButton.addActionListener(listener2);
        add(Box.createVerticalGlue());

        JButton exitButton = new JButton("Exit System");
        exitButton.setMaximumSize(exitButton.getPreferredSize());
        add(exitButton);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ActionListener listener3 = new eListner();
        exitButton.addActionListener(listener3);
        add(Box.createVerticalGlue());

    }

    private class pListner implements ActionListener{

        public void actionPerformed(ActionEvent p){
            PatientOpsFrame frame = new PatientOpsFrame();
            frame.setLocation(300,300);
            System.out.println("hey");
            //revalidate();
          //  frame.repaint();
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);
        }
   }
    private class dListner implements ActionListener{

        public void actionPerformed(ActionEvent d){
            DoctorOpsFrame frame = new DoctorOpsFrame();
            frame.setLocation(300,300);
            revalidate();
            frame.repaint();
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);
        }
    }
    private class wListner implements ActionListener{

        public void actionPerformed(ActionEvent w){
            WardFrame frame = new WardFrame();
            frame.setLocation(300,300);
            revalidate();
            frame.repaint();
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);
        }
    }
    private class eListner implements ActionListener{

        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    public static final long serialVersionUID = 1;
}

