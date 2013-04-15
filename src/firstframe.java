import java.awt.*;
import java.awt.event.*;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.*;
import java.io.*;
import java.util.Properties;
public class firstframe extends JFrame {
	public String savename;
	public Properties props;
	public Session session;
	public Store store;
	public String savepass;
	public String savepath;
	public JButton submit;
	public JTextField userName;
	public JTextField userPassword;
	public JLabel name;
	public JLabel pass;
	public JButton exit;
	public JTextField filePath;
	public JLabel path;
	public frame2 second;
	public JLabel header;
	public  String num;
	public firstframe()
	{
		super("Frame1");	
	//num = JOptionPane.showInputDialog("Enter 1 for Yahoo "+'\n'+"2 for Gmail");
	setLayout(null);
	//------"Submit" button---------//	
	submit = new JButton("Save");
	submit.setToolTipText("Create the USB Key File");
	submit.setBounds(50,195,100,50);
	//-------"Exit" Button---------//
	exit = new JButton("Exit");
	exit.setToolTipText("Exit the Program");
	exit.setBounds(250,195,100,50);
	//------adding elements--------//
	userName = new JTextField("Enter User Name");
	userName.setBounds(150,30,150,40);
	userName.setForeground(Color.gray);
	userName.setToolTipText("xyz@gmail.com");
	userPassword = new JPasswordField("*****");
	userPassword.setBounds(150,85,150,40);
	userPassword.setToolTipText("Password");
	filePath = new JTextField("Enter the path for Saving the Key");
	filePath.setBounds(150,145,150,40);
	filePath.setToolTipText("Put the file path over Here");
	filePath.setForeground(Color.gray);
	name = new JLabel("User Name");
	name.setBounds(30, 30,100, 40);
	pass = new JLabel("Password");
	pass.setBounds(30,85,100,40);
	path = new JLabel("File Path");
	path.setBounds(30,145,100,40);
	add(userPassword);
	add(userName);
	add(path);
	add(pass);
	add(name);
	add(exit);
	add(submit);
	add(filePath);
	//------defining handles------//
	exitHandle handle1 = new exitHandle();
	submitHandle handle2 = new submitHandle();
	exit.addActionListener(handle1);
	submit.addActionListener(handle2);
	keyhandler h3 = new keyhandler();
	keyhandler1 h4 = new keyhandler1();
	exit.addKeyListener(h3);
	submit.addKeyListener(h4);
	focus handle5 = new focus();
	userName.addFocusListener(handle5);
	passfocus handle6 = new passfocus();
	userPassword.addFocusListener(handle6);
	filefocus handle7 = new filefocus();
	filePath.addFocusListener(handle7);
	
	}
	class filefocus implements FocusListener
	{
		public void focusGained(FocusEvent f2)
		{
			filePath.setText("");			
		}
		public void focusLost(FocusEvent f2)
		{
		}
	}
	class passfocus implements FocusListener
	{	@Override
		public void focusGained(FocusEvent f1)
		{
			userPassword.setText("");
		}
		@Override
		public void focusLost(FocusEvent f1)
		{
		}
	}
	class focus implements FocusListener
	{
		@Override
		public void focusGained(FocusEvent arg0) {
			userName.setText("");
		}
		@Override
		public void focusLost(FocusEvent arg0) 
		{
		}
	}
	class keyhandler1 implements KeyListener
	{
		public void keyPressed(KeyEvent key1)
		{
			if(key1.getSource()==submit&&(key1.getKeyCode()==10));
			{
				
				savename = userName.getText();
				savepass = userPassword.getText();
				savepath = filePath.getText();
				if(savename.equals(""))
				JOptionPane.showMessageDialog(null,"Name field cannot be empty.","Error",JOptionPane.PLAIN_MESSAGE );
				else if(savepass.equals(""))
				JOptionPane.showMessageDialog(null,"Password field cannot be empty.","Error",JOptionPane.PLAIN_MESSAGE );
				else if(savepath.equals(""))
				JOptionPane.showMessageDialog(null,"File Name field cannot be empty.","Error",JOptionPane.PLAIN_MESSAGE );
				if (!(savename.equals("") || savepass.equals("") || savepath.equals("")))
				{
					//-----------Creating a Test Session----------//
					 props = System.getProperties();
					 props.setProperty("mail.store.protocol", "imaps");
					 try
					 {
					session = Session.getDefaultInstance(props, null);
					store = session.getStore("imaps");
					if(savename.endsWith("@gmail.com"))
					{
					store.connect("imap.gmail.com",savename,savepass);
					File f = new File(savepath);
					if (!f.exists())
					{
				second= new frame2(savename,savepass,savepath);
				second.setVisible(true);
				second.setDefaultCloseOperation(EXIT_ON_CLOSE);
				second.setSize(300, 300);
				dispose();
				onsubmit();
					}
					else
					{
						userName.setText("");
						userPassword.setText("");
						filePath.setText("");
					}
					}
					else if(savename.endsWith("@yahoo.co.in"))
							{
					File f = new File(savepath);
					if (!f.exists())
					{
				second= new frame2(savename,savepass,savepath);
				second.setVisible(true);
				second.setDefaultCloseOperation(EXIT_ON_CLOSE);
				second.setSize(300, 300);
				dispose();
				onsubmit();
					}
					else
					{
						userName.setText("");
						userPassword.setText("");
						filePath.setText("");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Wrong Entry","Error",JOptionPane.ERROR_MESSAGE );
					userName.setText("");
					userPassword.setText("");
					filePath.setText("");
				}
					 }
					 catch(Exception ex)
					 {
						 JOptionPane.showMessageDialog(null,"Invalid Email/Password","Error!!!",JOptionPane.ERROR_MESSAGE );			 
					 }
			}
		}
		}
		public void keyTyped(KeyEvent key1)
		{
			if(key1.getSource()==submit&&(key1.getKeyCode()==10));
			{
				savename = userName.getText();
				savepass = userPassword.getText();
				savepath = filePath.getText();
				if(savename.equals(""))
				JOptionPane.showMessageDialog(null,"Name field cannot be empty.","Error",JOptionPane.PLAIN_MESSAGE );
				else if(savepass.equals(""))
				JOptionPane.showMessageDialog(null,"Password field cannot be empty.","Error",JOptionPane.PLAIN_MESSAGE );
				else if(savepath.equals(""))
				JOptionPane.showMessageDialog(null,"File Name field cannot be empty.","Error",JOptionPane.PLAIN_MESSAGE );
				if (!(savename.equals("") || savepass.equals("") || savepath.equals("")))
				{
					//-----------Creating a Test Session----------//
					 props = System.getProperties();
					 props.setProperty("mail.store.protocol", "imaps");
					 try
					 {
					session = Session.getDefaultInstance(props, null);
					store = session.getStore("imaps");
						if(savename.endsWith("@gmail.com"))
						{
							store.connect("imap.gmail.com",savename,savepass);
							File f = new File(savepath);
							if (!f.exists())
							{
						second= new frame2(savename,savepass,savepath);
						second.setVisible(true);
						second.setDefaultCloseOperation(EXIT_ON_CLOSE);
						second.setSize(300, 300);
						dispose();
						onsubmit();
							}
							else
							{
								userName.setText("");
								userPassword.setText("");
								filePath.setText("");
							}
						}
						else if(savename.endsWith("yahoo.co.in"))
						{
							store.connect("imap.mail.yahoo.com",savename,savepass);
							File f = new File(savepath);
							if (!f.exists())
							{
						second= new frame2(savename,savepass,savepath);
						second.setVisible(true);
						second.setDefaultCloseOperation(EXIT_ON_CLOSE);
						second.setSize(300, 300);
						dispose();
						onsubmit();
							}
							else
							{
								userName.setText("");
								userPassword.setText("");
								filePath.setText("");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Wrong Entry","Error",JOptionPane.ERROR_MESSAGE );
							userName.setText("");
							userPassword.setText("");
							filePath.setText("");
						}
					
					 }
					 catch(Exception ex)
					 {
						 JOptionPane.showMessageDialog(null,"Invalid Email/Password","Error!!!",JOptionPane.ERROR_MESSAGE );	 
					 }
				}
			}
		}
		public void keyReleased(KeyEvent key1)
		{
			if(key1.getSource()==submit&&(key1.getKeyCode()==10));
			{
				savename = userName.getText();
				savepass = userPassword.getText();
				savepath = filePath.getText();
				if(savename.equals(""))
				JOptionPane.showMessageDialog(null,"Name field cannot be empty.","Error",JOptionPane.PLAIN_MESSAGE );
				else if(savepass.equals(""))
				JOptionPane.showMessageDialog(null,"Password field cannot be empty.","Error",JOptionPane.PLAIN_MESSAGE );
				else if(savepath.equals(""))
				JOptionPane.showMessageDialog(null,"File Name field cannot be empty.","Error",JOptionPane.PLAIN_MESSAGE );
				if (!(savename.equals("") || savepass.equals("") || savepath.equals("")))
				{
					//-----------Creating a Test Session----------//
					 props = System.getProperties();
					 props.setProperty("mail.store.protocol", "imaps");
					 try
					 {
					session = Session.getDefaultInstance(props, null);
					store = session.getStore("imaps");
						if(savename.endsWith(".gmail.com"))
						{
							store.connect("imap.gmail.com",savename,savepass);
							File f = new File(savepath);
							if (!f.exists())
							{
						second= new frame2(savename,savepass,savepath);
						second.setVisible(true);
						second.setDefaultCloseOperation(EXIT_ON_CLOSE);
						second.setSize(300, 300);
						dispose();
						onsubmit();
							}
							else
							{
								userName.setText("");
								userPassword.setText("");
								filePath.setText("");
							}
						}
						else if(savename.endsWith("@yahoo.co.in"))
						{
							store.connect("imap.mail.yahoo.com",savename,savepass);
							File f = new File(savepath);
							if (!f.exists())
							{
						second= new frame2(savename,savepass,savepath);
						second.setVisible(true);
						second.setDefaultCloseOperation(EXIT_ON_CLOSE);
						second.setSize(300, 300);
						dispose();
						onsubmit();
							}
							else
							{
								userName.setText("");
								userPassword.setText("");
								filePath.setText("");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Wrong Entry","Error",JOptionPane.ERROR_MESSAGE );
							userName.setText("");
							userPassword.setText("");
							filePath.setText("");
						}
					 }
					 catch(Exception ex)
					 {
						 JOptionPane.showMessageDialog(null,"Invalid Email/Password","Error!!!",JOptionPane.ERROR_MESSAGE ); 
					 }
			}
	}
	}
}
	class keyhandler implements KeyListener
	{
		
		public void keyPressed(KeyEvent key)
		{
		if(key.getSource()==exit&&(key.getKeyCode()==10));
		System.exit(0);
		}
		public void keyReleased(KeyEvent key)
		{
			if(key.getSource()==exit&&(key.getKeyCode()==10));
			System.exit(0);
		}
		public void keyTyped(KeyEvent key)
		{
		if(key.getSource()==exit&&(key.getKeyCode()==10));
		System.exit(0);
		}
	}
	class exitHandle implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.exit(0);
		}
	}	
	class submitHandle implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			{
				savename = userName.getText();
				savepass = userPassword.getText();
				savepath = filePath.getText();
				if(savename.equals(""))
				JOptionPane.showMessageDialog(null,"Name field cannot be empty.","Error",JOptionPane.PLAIN_MESSAGE );
				else if(savepass.equals(""))
				JOptionPane.showMessageDialog(null,"Password field cannot be empty.","Error",JOptionPane.PLAIN_MESSAGE );
				else if(savepath.equals(""))
				JOptionPane.showMessageDialog(null,"File Name field cannot be empty.","Error",JOptionPane.PLAIN_MESSAGE );
				if (!(savename.equals("") || savepass.equals("") || savepath.equals("")))
				{
					//-----------Creating a Test Session----------//
					 props = System.getProperties();
					 props.setProperty("mail.store.protocol", "imaps");
					 try
					 {
					session = Session.getDefaultInstance(props, null);
					store = session.getStore("imaps");
						if(savename.endsWith("@gmail.com"))
						{
							store.connect("imap.gmail.com",savename,savepass);
							File f = new File(savepath);
							if (!f.exists())
							{
						second= new frame2(savename,savepass,savepath);
						second.setVisible(true);
						second.setDefaultCloseOperation(EXIT_ON_CLOSE);
						second.setSize(300, 300);
						dispose();
						onsubmit();
							}
							else
							{
								userName.setText("");
								userPassword.setText("");
								filePath.setText("");
							}
						}
						else if(savename.endsWith("@yahoo.co.in"))
						{
							store.connect("imap.mail.yahoo.com",savename,savepass);
							File f = new File(savepath);
							if (!f.exists())
							{
						second= new frame2(savename,savepass,savepath);
						second.setVisible(true);
						second.setDefaultCloseOperation(EXIT_ON_CLOSE);
						second.setSize(300, 300);
						dispose();
						onsubmit();
							}
							else
							{
								userName.setText("");
								userPassword.setText("");
								filePath.setText("");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Wrong Entry","Error",JOptionPane.ERROR_MESSAGE );
							userName.setText("");
							userPassword.setText("");
							filePath.setText("");
						}
				}
				catch(Exception E)
				{
					JOptionPane.showMessageDialog(null,"Invalid Email/Password","Error!",JOptionPane.ERROR_MESSAGE );	
				}
			}
		}
	}
}
	public void onsubmit()
	{
		this.dispose();
	}
}
