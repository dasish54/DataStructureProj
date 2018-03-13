import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Data Structures Program");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		GraphicPanel G = new GraphicPanel();
		frame.setJMenuBar(G.getMenuBar());
		frame.add(G.getPanel());
	    frame.setVisible(true);

	}

}
