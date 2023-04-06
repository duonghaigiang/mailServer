package mailServer;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Store;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mailmain
 */
@WebServlet("/mailmain")
public class mailmain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public mailmain() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("view/mailserver.jsp");
		rd.forward(request, response);
	}
	private static void fetchEmails(String userName, String password) {
	    try {
	        Properties properties = new Properties();
	        properties.put("mail.store.protocol", "imaps"); //Giao thức lưu trữ email (imaps).
	        properties.put("mail.imap.host", "imap.gmail.com"); //Địa chỉ máy chủ IMAP (imap.gmail.com).
	        properties.put("mail.imap.ssl.enable", "true"); //Kích hoạt SSL (true).
	        
	        properties.put("mail.imap.port", "993");//Cổng kết nối IMAP (993).
	        properties.put("mail.imaps.ssl.protocols", "TLSv1.2");
	        properties.put("mail.imaps.timeout", "10000");

	        Session emailSession = Session.getInstance(properties);
	        Store store = emailSession.getStore("imaps");
	        store.connect("imap.gmail.com", userName, password);

	        Folder inboxFolder = store.getFolder("INBOX");
	        inboxFolder.open(Folder.READ_ONLY);

	        Message[] messages = inboxFolder.getMessages();
	        System.out.println("Total Messages: " + messages.length);
	      int n =  messages.length;
	            Message message = messages[n-1];
	            System.out.println("---------------------------------");
	            System.out.println("Email " );
	            System.out.println("Subject: " + message.getSubject());
	            System.out.println("From: " + message.getFrom()[0]);
	            System.out.println("Content: " + message.getContent().toString());
	        
	        inboxFolder.close(false);
	        store.close();
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	






	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String userName = "haptkbte2015@gmail.com"; // gmail người gửi
		final String password = "jsqmmavdigceppho"; // mật khẩu ứng dụng
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");   // smtp server
		prop.put("mail.smtp.port", "587");  // cổng giao thức tls
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		prop.put("mail.smtp.starttls.enable", "true"); // tls
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		String emailTo = request.getParameter("to");
		String emailSubject = request.getParameter("subject");
		String emailContent = request.getParameter("content"); // Lấy các thông tin email từ yêu cầu người dùng
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			message.setSubject(emailSubject);
			message.setText(emailContent);  // thiết lập các thông tin
			Transport.send(message);  //gửi email.
			fetchEmails("duonghaigiang127@gmail.com" , "dduwtscxqhzlkfsk");
			
		} catch (MessagingException e) {
            throw new RuntimeException(e);

		}
	}

}
