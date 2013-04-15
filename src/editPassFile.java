import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.event.*;
public class editPassFile extends JFrame
{	public JTextField fileLookUp;
	public JTextField showPass;
	public int exitpass;
	public String text1;
	public String text2;
	public JLabel label1;
	public JButton b1;
	public JTextArea readFile;
	public JButton exitForm;
	public int select;
	public int select1;
	public FileReader openKeep;
	public File f1;
	public BufferedWriter op1;
	public String everything="";
	public BufferedReader br;
	public editPassFile()
	{
	super("Edit");
	setLayout(null);
	readFile = new JTextArea("this is the new shit");
	exitForm = new JButton("Exit");
	fileLookUp = new JTextField();
	fileLookUp.setBounds(180,10,180,40);
	label1 = new JLabel();
	b1 = new JButton();
	readFile.setBounds(10,200,400,100);
	label1.setText("Enter the File Name");
	label1.setBounds(25,05,175,50);
	b1.setBounds(10,100,150,60);
	b1.setText("Edit");
	exitForm.setBounds(200,100,150,60);
	b1.setFont(new Font("Serif",Font.PLAIN,14));
	exitForm.setFont(new Font("Serif",Font.PLAIN,14));
	add(label1);
	add(b1);
	add(exitForm);
	add(fileLookUp);
	handle h = new handle();
	this.setSize(800,800);
	b1.addActionListener(h);
	exith h1 = new exith();
	exitForm.addActionListener(h1);
	
	}
	class handle implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{  f1 = new File(fileLookUp.getText());
			if(b1.getText()=="Edit")
			sizing();
		else
			delete();
		}
	}
	public void delete()
	{//System.out.println("coming");
		if(readFile.getText().equals(""))
		{
			System.out.println("coming1");
			
			select = JOptionPane.YES_NO_OPTION;
			select1 = JOptionPane.showConfirmDialog(null, "Do you want to Delete the File.", "Delete", JOptionPane.YES_NO_OPTION);
			if(select1 == JOptionPane.YES_OPTION)
			{ 	f1.delete();
				//System.out.println("Deleted");
				JOptionPane.showMessageDialog(null,"File Deleted","Report",JOptionPane.INFORMATION_MESSAGE);
				b1.setText("Edit");
				this.setSize(370,200);
				b1.setBounds(10,100,150,60);
				exitForm.setBounds(200,100,150,60);
			}	
			
		}
		else
		{
			String lines[] = readFile.getText().split("\\n");
			for(int i=0;i<lines.length;i++);
				f1.delete();
				try
				{
				f1.createNewFile();
				op1= new BufferedWriter(new FileWriter(f1));
					try
					{
						op1.write(readFile.getText());
						JOptionPane.showMessageDialog(null,"lllo","Error!!!",JOptionPane.ERROR_MESSAGE );
						op1.close();
					}
					catch(Exception e)
					{
						System.out.println("hello");
					}
				}
				catch(Exception e)
				{
					System.out.println("hello");
				}
			
			//check for the file over here;
		}
	}
	public void sizing()
	{	if(f1.exists())
	{
		text1 = fileLookUp.getText();
		try
		{
		openKeep = new FileReader(text1);
		}
		catch (FileNotFoundException f)
		{
			System.out.println("error Found");
		}
		 
		
	    try{
	    	br = new BufferedReader(openKeep);
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	            everything = sb.toString();
	        }
	    }
	        catch(Exception e){
	        	;
	        }
		
	    add(readFile);
	       // br.close();
	        //showPass.setText(everything);
	        readFile.setText(everything);
	     //catch(IOException e) 
	    
	    	//System.out.println("Error");
	    
		this.validate();
		//this.repaint(0, 0, 800, 800);
		this.setSize(430,370);
		exitForm.setBounds(230,100,150,60);
		
		b1.setBounds(30,100,150,60);
		b1.setText("Save Changes");
		}
	}
	public static void main(String args[])
	{
		editPassFile f1= new editPassFile();
		f1.setVisible(true);
		f1.setResizable(false);
		f1.setSize(370,200);
		f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	class exith implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{try
		{
			select = JOptionPane.YES_NO_OPTION;
			select1 = JOptionPane.showConfirmDialog(null, "Do you want to Exit.", "EXIT", JOptionPane.YES_NO_OPTION);
			if(select1 == JOptionPane.YES_OPTION)
				System.exit(0);
		}
		catch(Exception e)
		{
			;
		}
		}
	}
}
