/*
 * Class that represents the panels of my app
 * 
 * Within each panel there will be some buttons 
 * and of course the title of the corresponding song
 *  
 */

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel
{
	
	//Create some instances of different classes
	JLabel songTitle = new JLabel();
	MyButton pauseButton = new MyButton("Pause");
	MyButton playButton = new MyButton("Play");
	MyButton resetButton = new MyButton("Reset");
	
	//Constructor
	/*
	 * @param1 = "line": Checks if the line is an even or odd number
	 *  				 in order to paint consecutive lines with different colors 
	 * 
	 * @param2 = "SongTitle": The title the corresponding song (eg "Lie to me")
	 * 
	 */
	MyPanel(int line, String songTitle)
	{
		this.setLayout(null); //No need foe tLayout manager. Will place components manually
		
		//Check what color the panel will be
		if(line % 2 == 0)
			this.setBackground(Color.lightGray);
		else
			this.setBackground(Color.white);
		
		//Title
		this.songTitle.setText(songTitle);	//Add the name of the song within the Panel
		this.songTitle.setFont(new Font("Calibri", Font.PLAIN ,30)); //Set the font of the JLabel
		this.songTitle.setForeground(Color.black); //Set the foreground color (in fact text color)
		this.songTitle.setBounds(0, 0, 1000, 50);
	
		//"Pause" button
		this.pauseButton.setBorder(BorderFactory.createEtchedBorder()); //Creates border to pauseButton
		this.pauseButton.setBounds(600, 10, 45, 30); //Set the (x,y,width,height) of the pauseButton
		
		//"Play" button
		this.playButton.setBorder(BorderFactory.createEtchedBorder()); //Creates border to playButton
		this.playButton.setBounds(700, 10, 45, 30); //Set the (x,y,width,height) of the playButton
		
		//"Reset" button
		this.resetButton.setBorder(BorderFactory.createEtchedBorder()); //Creates border to resetButton
		this.resetButton.setBounds(800, 10, 45, 30); //Set the (x,y,width,height) of the resetButton
	
		//Add the components to the JPanel
		this.add(this.songTitle); //Add song's title to the corresponding panel
		this.add(this.pauseButton); //Add the "pause" buttons to the corresponding panel
		this.add(playButton); //Add the playButton to the corresponding panel
		this.add(this.resetButton); //Add the "reset" button to the corresponding panel
		
	}	
	
	
	
}
