package uk.ac.gre.comp1549.dashboard.designPatterns;

import uk.ac.gre.comp1549.dashboard.controls.MainPanel;


public class NullPattern extends MainPanel {

    @Override
    public void create() {
        MainPanel dial1 = Factory.createDial("MILES");
        MainPanel dial2 = Factory.createDial("OIL");
        MainPanel dial3 = Factory.createDial("TEMPERATURE");
        MainPanel dial4 = Factory.createDial("SPEED");
        MainPanel dial5 = Factory.createDial("PETROL");
        
        System.out.println(dial1);
        System.out.println(dial2);
        System.out.println(dial3);
        System.out.println(dial4);
        System.out.println(dial5);
    }

    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public void setValue(int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLabel(String label) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
