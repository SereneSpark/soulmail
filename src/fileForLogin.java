import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;

import java.util.Properties;
//loging in Gmail.
public class fileForLogin extends JFrame
{	public String fileName;
	public JTextArea mail;
	public Folder inbox;
	public JLabel from;
	public JLabel subject;
	public JTextArea from1;
	public JTextArea subject1;
	public JLabel logo;
	public JButton back;
	public JButton exit;
	public JButton reply;
	public JButton next;
	public JButton prev;
	public File f1;
	public  String lines[];
	public String userName;
	public String userPass;
	public FileReader openKeep;
	public BufferedReader br;
	public String everything ="";
	public Properties props;
	public Session sessions;
	public Store store;
	public FetchProfile fp;
	public static String v;
	public fileForLogin()
	{
	super("Mail System");
	setLayout(null);
	 fileName = JOptionPane.showInputDialog("Enter the File Name");
	 
	 logo = new JLabel(new ImageIcon("//home//sandeep//Desktop//gmail.png"));
	 logo.setBounds(0,0,300,100);
	 add(logo);
	 mail =new JTextArea();
	 mail.setBounds(0,123,600,300);
	 add(mail);
	 subject = new JLabel("Subject");
	 subject.setBounds(0, 100, 60,20);
	 add(subject);
	 from = new JLabel("From");
	 from.setBounds(0,423,60,20);
	 add(from);
	 prev = new JButton("Previous");
	 prev.setBounds(0,443,120,40);
	 add(prev);
	 next = new JButton("Next");
	 next.setBounds(120,443,120,40);
	 add(next);
	 reply = new JButton("Reply");
	 reply.setBounds(240,443,120,40);
	 add(reply);
	 back = new JButton("Back");
	 back.setBounds(360,443,120,40);
	 add(back);
	 exit = new JButton("Exit");
	 exit.setBounds(480,443,120,40);
	 add(exit);
	 f1 = new File(fileName);
	 if(f1.exists())
	 {
		 try
			{
			openKeep = new FileReader(fileName);
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
		            mail.setText(everything);
		           
		        }
		       lines= everything.split("\\n");
	            System.out.println(lines.length);
		    }
		        catch(Exception e)
		        {
		        	;
		        }
		    userName= lines[0];
		    userPass=lines[1];
		    props = System.getProperties();
			 props.setProperty("mail.store.protocol", "imaps");
			 sessions = Session.getDefaultInstance(props, null);
			 try
			 {
				store = sessions.getStore("imaps");
				store.connect("imap.gmail.com",userName,userPass);
				System.out.println("Logged in");
				inbox = store.getFolder("Inbox");
				System.out.println(inbox.getMessageCount());
				inbox.open(Folder.READ_ONLY);
				Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.RECENT), false));
				fp = new FetchProfile();
				fp.add(FetchProfile.Item.ENVELOPE);
				fp.add(FetchProfile.Item.CONTENT_INFO);
				inbox.fetch(messages, fp);
				Address[] a;
				char[] p;
				a=messages[443].getFrom();
				System.out.println(a[0]);
				for(int i=0;i<a.length;i++)
					System.out.println(a[i]);
				String s =a[0].toString();
				if(s.equals("Jennifer Parise <jenn.parise@gmail.com>"))
					System.out.println("yes");
				
			 }
			 catch(Exception e)
			 {
				 System.out.println("error");
			 }
			 //---now linking part--//
			 
			 
	 }
	 else
		 System.out.println("File not found");
	}
	
	public static void main(String args[])
	{
		fileForLogin f1 = new fileForLogin();
		f1.setVisible(true);
		f1.setSize(600,483);
		f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
