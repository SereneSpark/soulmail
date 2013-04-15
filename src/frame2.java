import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class frame2 extends JFrame {
	public JProgressBar prgbar;
	public File savingFile;
	public JLabel heading;
	public Timer timer2;
	public int clockTick1;
	public double clockTime1;
	public int error1;
	public static final int ja1=10;
	public Writer op1;
	public frame2(String userName,String userPassword,String fileAddress)
	{
		super("Saving Password");
		setLayout(null);
		//---formation of a passfile------//
		String extension = fileAddress+".keep";
		savingFile = new File(extension);
		try
		{
		savingFile.createNewFile();
		op1= new BufferedWriter(new FileWriter(savingFile));
			try
			{
				op1.write(userName+"\n"+userPassword);
				JOptionPane.showMessageDialog(null,userName,"Error!!!",JOptionPane.ERROR_MESSAGE );
				op1.close();
			}
			catch(Exception e)
			{
				error1=1;
			}
		}
		catch(Exception e)
		{
			error1=1;
		}
		heading  = new JLabel();
		heading.setLocation(0,0);
		heading.setSize(180,45);
		heading.setText("File Formation");
		//this.setSize(200,200);
		//this.setResizable(false);
		add(heading);
		heading.setFont(new Font("Comic Sans MS",Font.ITALIC,24));
		prgbar = new JProgressBar();
		prgbar.setSize(300,30);
		prgbar.setStringPainted(true);
		prgbar.setLocation(0,270);
		clockTick1 =0;
		add(prgbar);
		prgbar.setMaximum(100);
		prgbar.setMinimum(0);
		clockTime1 = (double)clockTick1/10;
		timeHandle handler2 = new timeHandle();
		timer2 = new Timer(ja1,handler2);
		timer2.start();
		setVisible(true);
	}
	public class timeHandle implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
		clockTick1++;
		clockTime1=(double)clockTick1/5.0;
		prgbar.setValue((int)clockTime1);
}
}
}