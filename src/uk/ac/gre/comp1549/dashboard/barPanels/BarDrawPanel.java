package uk.ac.gre.comp1549.dashboard.barPanels;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
import uk.ac.gre.comp1549.dashboard.interfaces.MyValues;

/**
 * BarDrawPanel. Draw a horizontal bar indicator and show its current value
 *
 * @author COMP1549
 * @version 2.0
 */
public class BarDrawPanel extends JPanel implements MyValues {

    private int value; // current value - will be indicated on the bar

    private int barLength; // length/width of the bar
    private int barHeight; // height of the bar

    private int padding; // padding around the bar
    private float barMaxValue; // bar runs from 0 to barMaxValue

    /**
     * Default constructor - sets default values
     */
    public BarDrawPanel() {
        this(20, 200, 8, 100, 0); // I modified, to Fix back to normal- 200, 20, 8, 100, 0
    }

    /**
     *
     * @param length - length of the horizontal bar
     * @param height - height of the bar
     * @param padding - padding around the bar
     * @param barMaxValue - bar runs from 0 to barMaxValue
     * @param value - current value that will be indicated on the bar
     */
    public BarDrawPanel(int length, int height, int padding, int barMaxValue, int value) {
        // set size of the JPanel to be big enough to hold the bar plus padding
        setPreferredSize(new Dimension(length + (2 * padding), height + (2 * padding)));

        this.barLength = length;
        this.barHeight = height;
        this.padding = padding;
        this.barMaxValue = barMaxValue;
        this.value = value;
    }

    /**
     * This method is called every time the Bar needs drawing for instance when
     * the value has changed. It draws the bar itself and the indicator in the
     * correct position to indicate the current value
     *
     * @param g - graphics object used to draw on the JPanel
     */
    @Override //Need to change this to get it working
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // get a Graphics2D object to draw with
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the bar itself.   The first 10% of the bar is red.  The last 30% is yellow.  Between 10% and 30% 
        // the colour graduates from red to yellow.   Check the API documentation for GradientPaint to see
        // how this works. 
        Rectangle2D barx = new Rectangle2D.Double(padding, padding, barLength, barHeight);

        GradientPaint redtoyellow = new GradientPaint(0, 0 + (float) barx.getHeight() * 0.8F, Color.RED, 0, (float) barx.getHeight() * 0.1F, Color.YELLOW);
        g2.setPaint(redtoyellow);

        g2.fill(barx);

        // draw the value indicator to show the current value
        g2.setStroke(new BasicStroke(barHeight / 30, BasicStroke.CAP_SQUARE, 0));
        g2.setPaint(Color.gray);
        Line2D valueIndicator = new Line2D.Double( padding / 2F ,padding + (barHeight - (barHeight * value / barMaxValue)),padding + barHeight + (padding* 2F ),(barHeight - (barHeight * value / barMaxValue)));
        g2.draw(valueIndicator);
    }

    /**
     * Set the value to be displayed on the bar
     *
     * @param value value
     */
    @Override
    public void setValue(int value) {
        // don't let the value go over the maximum for the bar.  But what about the minimum?
        this.value = value > barMaxValue ? (int) barMaxValue : value;
        repaint(); // causes paintComponent() to be called
    }

}
