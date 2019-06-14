package gui;
import javax.swing.*;

import startup.GuiHospitalSystem;
public class MainMenuFrame extends JFrame{

    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 400;

    public MainMenuFrame(){
    setTitle("Main Menu");
    setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    MainMenuPanel panel = new MainMenuPanel();
    add(panel);
    }



}
