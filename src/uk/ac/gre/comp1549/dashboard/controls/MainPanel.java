
package uk.ac.gre.comp1549.dashboard.controls;

import javax.swing.JLabel;
import javax.swing.JPanel;

//This will serve as our super class and should be inherited by the other panel classes to make code more flexible
abstract public class MainPanel extends JPanel {
     
    public JLabel lblTitle; // the label which always appears above the bar
    
    //Abstract methods 
    abstract public void setValue(int value);
    abstract public void setLabel(String label);
    
    //Each sub class will call this to create their graphic
    abstract public void create();
    
    //Null Design Pattern
    abstract public boolean isNil();
      
    public MainPanel(){
    }  
}
