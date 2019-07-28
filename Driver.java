
/** A "4 in a row" game program
 * @author Dean Ratzon
 * @version 18/11/18
 * 
 */
import java.awt.Color;

import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {
		GridLayoutFrame gridLayoutFrame = new GridLayoutFrame();
		gridLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridLayoutFrame.setSize(600,650);
		gridLayoutFrame.getContentPane().setBackground(Color.black );
		gridLayoutFrame.setVisible(true);
//		gridLayoutFrame.setResizable(false);
	}

}
