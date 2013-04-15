import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.Border;
import java.util.*;
import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;
import javax.mail.internet.*;
public class loadup extends JWindow
{
	Image imageForSplashScreen;
	ImageIcon ii;
	public String str[]=new String[10];
	static JProgressBar pbar;
	public Timer myTimer;
	public JLabel loadupProcess;
	public int clockTick;
	public double clockTime;
	public static final int ja=10;
	public double opacity = 0.00;
	public loadup()	
	{
	imageForSplashScreen=Toolkit.getDefaultToolkit().getImage("//home//sandeep//Desktop//secure.jpg");
	//Create ImageIcon from Image
		ii=new ImageIcon(imageForSplashScreen);
	//Set JWindow size from image size
		setSize(ii.getIconWidth(),ii.getIconHeight());
	//Get current screen size
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	//Get x coordinate on screen for make JWindow locate at center
		int x=(screenSize.width-getSize().width)/2;
	//Get y coordinate on screen for make JWindow locate at center
		int y=(screenSize.height-getSize().height)/2;
	//Set new location for JWindow
		setLocation(x,y);
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		str[1] = "Starting Daemon...";
		str[2] = "Loading Selector Frame...";
		str[3] = "Loading converter Algorithm...";
		str[4] = "Loading File Creator...";
		str[5] = "Loading File Checker...";
		str[6] = "Loading Connectors...";
		str[7] = "Loading Encrypters...";
		str[8] = "Loading Decrypters...";
		str[9] = "Loading Tables...";		
		str[0] = "loading Complete :)";
		loadupProcess = new JLabel();
		loadupProcess.setFont(new Font("Comic Sans MS",Font.ITALIC+Font.BOLD,16));
		pbar = new JProgressBar();
		loadupProcess.setBorder(loweredbevel);
		loadupProcess.setSize(625,30);
		loadupProcess.setLocation(0,465);
	pbar.setSize(625,50);
	pbar.setLocation(0,495);
	pbar.setMaximum(100);
	pbar.setMinimum(0); 
	pbar.setStringPainted(true);
	pbar.setForeground(new Color(20,20,112));
	pbar.setFocusable(false);
	pbar.setBackground(Color.WHITE);
		setLayout(null);
		add(loadupProcess);
	add(pbar);
	clockTick =0;
	clockTime = (double)clockTick/1;
	timeHandle handler1 = new timeHandle();
	Timer myTimer = new Timer(ja,handler1);
	myTimer.start();
	setVisible(true);
}
public class timeHandle implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{
	clockTick++;
	clockTime=(double)clockTick/10.0;
	pbar.setValue((int)clockTime);
	opacity= opacity +  .001;
	//System.out.println((float)opacity);
	if (pbar.getValue()==100)
		startFrame();
	if(opacity>0 && opacity<.1)
		loadupProcess.setText(str[1]);
	if(opacity>.1 && opacity<.2)
		loadupProcess.setText(str[2]);
	if(opacity>.2 && opacity<.3)
		loadupProcess.setText(str[4]);
	if(opacity>.4 && opacity<.5)
		loadupProcess.setText(str[5]);
	if(opacity>.5 && opacity<.6)
		loadupProcess.setText(str[3]);
	if(opacity>.6 && opacity<.7)
		loadupProcess.setText(str[6]);
	if(opacity>.7 && opacity<.8)
		loadupProcess.setText(str[7]);
	if(opacity>.8 && opacity<.9)
		loadupProcess.setText(str[8]);
	if(opacity>.9 && opacity<1)
	{
		loadupProcess.setText(str[9]);
	}
	}
}
//------changing frame-----//
public void startFrame()
{	
	
	option fr = new option();
	fr.setVisible(true);
	this.hide();
	fr.setSize(500,450);
	myTimer.stop();
}
//-------Paint image onto JWindow-----//
public void paint(Graphics g)
{
	super.paint(g);
	g.drawImage(imageForSplashScreen,0,0,this);
}
}
  
