// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton FindAllByDate = new JButton("Find All By Date"); // addition of the new button//
    private JButton remove = new JButton("Remove");
    private  JLabel recovery = new JLabel ("Recovery");
    private JLabel repetitions = new JLabel ("Repetitions");
    private JLabel terrain = new JLabel ("Terrain");
    private JLabel tempo = new JLabel ("Tempo");
    private JLabel where = new JLabel ("Where");
    private JTextField recoveryText = new JTextField(3);
    private JTextField repetitionsText = new JTextField(3);
    private JTextField terrainText = new JTextField(3);
    private JTextField tempoText = new JTextField(3);
    private JTextField whereText = new JTextField(10);
    
    String [] Sports = {"Choose a sport", "SprintEntry", "CycleEntry", "SwimEntry"}; 
    JComboBox comboBox = new JComboBox<String>(Sports);

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(addR);
        add(FindAllByDate);
        FindAllByDate.addActionListener(this); // neeeded for button to function//
        addR.addActionListener(this);
        add(remove);
        remove.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();
        add (comboBox);
        
        
        

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
    	if (event.getSource()== comboBox) {
    		System.out.println(comboBox.getSelectedItem());
    	}
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
            
        }
       if (event.getSource() == FindAllByDate) { //*//
      	message = FindAll_by_date();
      	
       }
       if (event.getSource() == remove) {
       	message = remove();}
       
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String FindAll_by_date() { /* additton of statements for the action performed */ //Question 3//
    	int m = Integer.parseInt(month.getText());
    	int d = Integer.parseInt(day.getText());
    	int y = Integer.parseInt(year.getText());
    	outputArea.setText( "loading.... ");
    	String message = myAthletes.FindAll_by_date (d,m,y);
    	
		// TODO Auto-generated method stub
		return message;
	}


public String remove() {
	String message = "Entry removed"; 
	String n = name.getText();
    int m = Integer.parseInt(month.getText());
    int d = Integer.parseInt(day.getText());
    int y = Integer.parseInt(year.getText());
    myAthletes.removeEntry(n,d,m,y);
    return message;} 

	public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        Entry e = new Entry(n, d, m, y, h, mm, s, km);
        myAthletes.addEntry(e);
        return message;
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

