package calender;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EastMessage extends JFrame {
	JLabel jlb_rec = new JLabel  ("받는 사람 ");
	JLabel jlb_title = new JLabel("제목");
	JTextField jtf_mail_ads = new JTextField(20);
	JTextField jtf_title = new JTextField(20);
	JTextArea jta 	= new JTextArea();
	JScrollPane jsp = new JScrollPane(jta);
	JButton send = new JButton("보내기");
	
	public EastMessage() {
		initDisplay();
	}
	public void SendMessage() {
		String smtpServer = "smtp.naver.com";
		final String sendId = "아이디";
		final String sendPass = "비밀번호";
		String sendEmailAddress = "보내는 사람 이메일";
		int smtpPort=465;
		
		//받는 분
		String receiveEmailAddress="받는 사람 이메일";
		String subject="안녕하세요. 강감찬입니다.";
		String content="안녕하세요. 학습용3으로 이메일 보내기3 연습 중입니다.";
		
		
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpServer);
		props.put("mail.smtp.port", smtpPort);
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.ssl.enable", true);
		props.put("mail.smtp.ssl.trust", smtpServer);
		
		Session session5 = Session.getDefaultInstance(props, new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(sendId, sendPass);
			}
		});
		//session2.setDebug(true);
		try{
			Message mimeMessage = new MimeMessage(session5);
			mimeMessage.setFrom(new InternetAddress(sendEmailAddress));
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveEmailAddress));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(content);
			Transport.send(mimeMessage);
			System.out.print("message sent successfully..."); 
		} catch (AddressException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} catch (MessagingException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 
	}

	public void initDisplay() {
		jta.setLineWrap(true);
		jsp.setBounds(45, 100, 500, 300);
		jlb_rec.setBounds(25, 17, 100, 50);
		jlb_title.setBounds(25, 48, 100, 50);
		jtf_mail_ads.setBounds(120, 35, 300, 20);
		jtf_title.setBounds(120, 65, 300, 20);
		send.setBounds(440, 35, 100, 50);
		jlb_rec.setHorizontalAlignment(JLabel.CENTER);
		jlb_title.setHorizontalAlignment(JLabel.CENTER);
		this.add(jsp);
		this.add(send);
		this.add(jlb_rec);
		this.add(jlb_title);
		this.add(jtf_mail_ads);
		this.add(jtf_title);
		this.setLayout(null);
		this.setTitle("메일쓰기");
		this.setResizable(false);
		this.setSize(600, 500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
