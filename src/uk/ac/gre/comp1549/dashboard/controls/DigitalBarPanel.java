/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.comp1549.dashboard.controls;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author The Emperor
 */
public class DigitalBarPanel extends MainPanel {
    
    private DigitalBarDrawPanel bar;
    
      @Override
    public void create(){
        setLayout(new BorderLayout());

        // set the style of the border
        setBorder(new BevelBorder(BevelBorder.LOWERED));

        // position the label above the dial
        lblTitle = new JLabel();
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        add(lblTitle, BorderLayout.NORTH);
        bar = new DigitalBarDrawPanel();
        add(bar, BorderLayout.CENTER);
    }
    
    
     @Override
    public void setValue(int value) {
        bar.setValue(value);
    }
    
     @Override
    public void setLabel(String label) {
        lblTitle.setText(label);
    }
}
