/* 
 * Class that represents all the different buttons such as "play", "pause" etc
 */
import java.awt.*;
import javax.swing.*;

public class MyButton extends JButton
{
	//Constructor
	/*
	 * Do stuff within the constructor
	 * 
	 * In the end only this is going to be called to display the buttons
	 *
	 * @param1 = "type": Define the type of the button(pause, play, reset)
	 * 
	 */
	MyButton(String type)
	{	
		switch(type)
		{
			case("Play"): //Play the corresponding song
			{
				this.setText("Play");
				break;
			}
			case("Pause"): //Pause the corresponding song
			{
				this.setText("Pause");
				break;
			}
			case("Reset"):
			{
				this.setText("Reset"); //Reset (start from the beginning) the corresponding song
				break;
			}
		}
		//this.setPreferredSize(new Dimension(20,20)); //Set the width and the height respectively
		this.setFocusable(false); //Get rid of the annoying outline when clicked
		this.setBackground(Color.white); //Test color
		
		//this.addActionListener((ActionListener) this);
		this.setVisible(true);
	}
}
