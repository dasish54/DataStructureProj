/**
 * This class is responsible for drawing the functions of a Tree
 * @author John Sharp
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.util.Queue;

import javax.swing.JPanel;

public class TreeEngine extends JPanel { /**
 * The width of each displayed cell
 */
private final static int CELL_WIDTH = 100;

/**
 * The height of each displayed cell
 */
private final static int CELL_HEIGHT = 20;

/**
 * The content to be painted as a vertical stack of values.
 */
private List<String> content;

/**
 * The number of elements that have been added to the tree
 */
private int numberElementsRemoved = 0;
/**
 * The number of elements that have been removed from the tree
 */
private int numberOfElements = 0;
/**
 * The number of pixels we will move down by before adding a new element
 */
private int valueToMoveDown = 0;
@Override
protected void paintComponent(Graphics g) {
	// this is called when the panel needs to be painted.
	numberElementsRemoved = QueuePanel.numberElementsRemoved;
	numberOfElements = QueuePanel.numberOfElements;
	valueToMoveDown = CELL_HEIGHT * numberElementsRemoved ;
	super.paintComponent(g);

	// Calc the starting x,y position of the first cell
	int x = this.getWidth() / 2 - CELL_WIDTH / 2;
	
	int y = this.getHeight() - 220;
	int initialy = this.getHeight()- 220;
    
	if (content != null) {
		
		// iterate over each available string and paint it in a rectangular area
		for (String item : content) {
		    y = y + CELL_HEIGHT;	// move up one level
			
			g.drawRect(x, y, CELL_WIDTH, CELL_HEIGHT);
			g.drawString(item, x + CELL_WIDTH/2 - 10, y+18);
			
		}
		g.drawString("<< Top", x +100, initialy + 35 );
		if((numberOfElements > 1)){
		g.drawString("<< Bottom", x +100, y + 15 );}
	} else {
		// no content set
		g.drawString("No content available", x, y);
	}
	
}


/**
 * Sets the current content.
 * 
 * @param content2 the array of string values to be painted
 */
public void setContent(List<String> content2) {

	this.content = content2;
	
	repaint();
}

/**
 * Constructor
 */
public TreeEngine() {
	
	
	setPreferredSize(new Dimension(600, 300));
	setBackground(Color.white);
}
}
