package view.controls;

import gamecontrollers.Facade;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

//TODO [Sydney][Jorge]

public class ConsoleView extends JPanel {
    private final int BORDER = 10;
    private final int WIDTH = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/ 4 - BORDER/2);
    private final int HEIGHT = 250;
    private JTextArea consoleLog;

    public ConsoleView() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        consoleLog = new JTextArea();
        consoleLog.setPreferredSize(new Dimension(WIDTH - 2*BORDER, HEIGHT - 2*BORDER));
        consoleLog.setFont(new Font("Arial", 0, 12));
        consoleLog.setEditable(false);
        consoleLog.setFocusable(false);
        consoleLog.setLineWrap(true);
        consoleLog.setBorder(new EmptyBorder(0, 5, 0, 5));

        JScrollPane scrollPane = new JScrollPane(consoleLog, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(WIDTH - 2*BORDER, HEIGHT - 2*BORDER));

        add(scrollPane);

        updateText("Console created, this is a placeholder.");
    }

    private void updateText(String alert) {
        consoleLog.append("\n" + alert);
    }
    private void setRedText(){
        consoleLog.setForeground(Color.RED);
    }
    private void setGreenText(){
        consoleLog.setForeground(Color.GREEN);
    }
    private void setBlackText(){
        consoleLog.setForeground(Color.BLACK);
    }

    public void displayErrorMessage(String message){
        //set color to red
        setRedText();
        //update the text
        updateText(message);
    }

    public void displaySuccessMessage(String message){
        //set the color to green
        setGreenText();
        //update the text
        updateText(message);
    }

    public void displayNormalMessage(String message){
        //set the color to black
        setBlackText();
        //update the text
        updateText(message);
    }

    public void update() {
    }
}
