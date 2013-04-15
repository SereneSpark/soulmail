import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Properties;
import javax.swing.*;
public class option extends JFrame
{
	public JRadioButton create;
	public JRadioButton edit;
	public firstframe fr;
	public JLabel header;
	public JLabel choose;
	public JRadioButton login;
	public JButton exit;
	public int select;
	public int select1;
	public editPassFile filer;
	public option()
	{
		super("SOUL Mail");
		setLayout(null);
		JPanel b1 = new JPanel();
		b1.setLayout(null);
		b1.setVisible(true);
		exit = new JButton("Exit");
		header = new JLabel();
		header.setText("Secure Online USB Login Mail System");
		header.setFont(new Font("Comic Sans MS",Font.ITALIC+Font.BOLD,20));
		header.setBounds(0,0,400,75);
		choose = new JLabel();
		choose.setText("Choose the Action");
		choose.setFont(new Font("Serif",Font.PLAIN+Font.BOLD,14));
		choose.setBounds(0,50,400,75);
		add(choose);
		add(header);
		b1.setBounds(0, 150, 300, 300);
		ButtonGroup b2 = new ButtonGroup();
		create  = new JRadioButton("Create a Password File");
		edit = new JRadioButton("Edit a listed File");
		login = new JRadioButton("Login");
		create.setBounds(0, 0, 300, 50);
		edit.setBounds(0,75,300,50);
		login.setBounds(0,150,300,50);
		radio12 handle1 = new radio12();
		create.addActionListener(handle1);
		edit.addActionListener(handle1);
		login.addActionListener(handle1);
		exitbut a0= new exitbut();
		exit.addActionListener(a0);
		exit.setBounds(400, 340, 80, 60);
		add(exit);
		
		b2.add(create);
		b2.add(edit);
		b2.add(login);
		b1.add(create);
		b1.add(edit);
		b1.add(login);
		add(b1);
	}
		class exitbut implements ActionListener
		{
			public void actionPerformed(ActionEvent a)
			{try
			{
				select = JOptionPane.YES_NO_OPTION;
				select1 = JOptionPane.showConfirmDialog(null, "Do you want to exit", "EXIT", JOptionPane.YES_NO_OPTION);
				if(select1 == JOptionPane.YES_OPTION)
					System.exit(0);
			}
			catch(Exception e)
			{
				;
			}
			}
		}
		class radio12 implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==create)
				{
					 fr = new firstframe();
					 fr.setVisible(true);
					 fr.setSize(450,300);
					 dispose();
				}
				if(e.getSource()==edit)
				{
					filer = new editPassFile();
					filer.setVisible(true);
					filer.setSize(300,300);
					dispose();
				}
				if(e.getSource()==login)
					JOptionPane.showMessageDialog(null,"loign","Error!!!",JOptionPane.ERROR_MESSAGE );				
			}
			
		}
	
}