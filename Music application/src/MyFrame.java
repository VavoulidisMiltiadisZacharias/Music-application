/*
 * Class representing a frame to display everything
 */


import java.awt.event.*;
import java.io.*;

import javax.sound.sampled.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener
{
	//Declare a few MyPanel objects
	MyPanel[] panel = new MyPanel[8];
	File[] file = new File[8];
	
	//Declare some Audio Input Streams -> Need to be surrounded by try-catch or add throws declaration
	AudioInputStream[] audioStream = new AudioInputStream[8];
	
	//Declare some Clip objects
	Clip[] clip = new Clip[8];
	
	//Constructor
	MyFrame() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close frame (application) when "x" is clicked
		this.setSize(1000, 450); //Width = 1000, height = 397 (pixels) (Not 400 cause there is an annoying white line of 3 pixels height)
		this.setResizable(false); //User's not allowed to resize it
		this.setLayout(null); //Use no Layout manager within my JFrame
		
		//Create the panels with the songs' titles only
		panel[0] = new MyPanel(0, "Lie to me");
		panel[1] = new MyPanel(1, "Malibu");
		panel[2] = new MyPanel(2, "She looks so perfect");
		panel[3] = new MyPanel(3, "Somebody to you");
		panel[4] = new MyPanel(4, "Teenage dream");
		panel[5] = new MyPanel(5, "The one that got away");
		panel[6] = new MyPanel(6, "Thinking of you");
		panel[7] = new MyPanel(7, "Wake up");
		
		//Create the songs' files
		file[0] = new File("D:\\Github local repositories\\Music application\\Music application\\Songs\\Lie to me - 5SOS.wav");
		file[1] = new File("D:\\Github local repositories\\Music application\\Music application\\Songs\\Malibu - Miley Cyrus.wav");
		file[2] = new File("D:\\Github local repositories\\Music application\\Music application\\Songs\\She looks so perfect - 5SOS.wav");
		file[3] = new File("D:\\Github local repositories\\Music application\\Music application\\Songs\\Somebody to you - The Vamps ft. Demi Lovato.wav");
		file[4] = new File("D:\\Github local repositories\\Music application\\Music application\\Songs\\Teenage dream - Katy Perry.wav");
		file[5] = new File("D:\\Github local repositories\\Music application\\Music application\\Songs\\The one that got away - Katy Perry.wav");
		file[6] = new File("D:\\Github local repositories\\Music application\\Music application\\Songs\\Thinking of you - Katy Perry.wav");
		file[7] = new File("D:\\Github local repositories\\Music application\\Music application\\Songs\\Wake up - The Vamps.wav");
		
		//Create the corresponding audioStreams
		for(int i = 0 ; i < 8 ; i++)
		{
			audioStream[i] = AudioSystem.getAudioInputStream(file[i]);
		}
		
		//Create the corresponding clips
		for(int i = 0 ; i < 8 ; i++)
		{
			clip[i] = AudioSystem.getClip();
		}
		
		//Open the clips
		for(int i = 0 ; i < 8 ; i++)
		{
			clip[i].open(audioStream[i]);
		}
		
		//Register all the buttons with the ActionListener interface
		for(int i = 0 ; i < 8 ; i++)
		{
			this.panel[i].pauseButton.addActionListener((ActionListener)this);
			this.panel[i].playButton.addActionListener((ActionListener)this);
			this.panel[i].resetButton.addActionListener((ActionListener)this);
		}
		
		//Set the bounds for all the panels within the frame
		for(int i = 0 ; i < 8 ; i++)
		{
			this.panel[i].setBounds(0, i*50, 1000, 50);
		}
		
		//Add all the panels within the frame in order to display them
		for(int i = 0 ; i < 8 ; i++)
		{
			this.add(panel[i]);
		}
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(int i = 0 ; i < 8 ; i++)
		{
			if(e.getSource() == panel[i].pauseButton)
			{
				//pause corresponding clip
				clip[i].stop();
			}
			
			if(e.getSource() == panel[i].playButton)
			{
				//First of all pause all the (other) clips
				for(int j = 0 ; j < 8 ; j++)
				{
					clip[j].stop();
				}
				
				//Then play the clip you want 
				clip[i].start();	
			}
			
			if(e.getSource() == panel[i].resetButton)
			{
				//reset corresponding clip
				clip[i].setMicrosecondPosition(0*1000000);
			}
		}
	}
}
