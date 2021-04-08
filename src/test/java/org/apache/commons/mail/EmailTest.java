package org.apache.commons.mail;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Date;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailTest {

	private static final String[] Test_Emails = { "ab@c.com", "a.b@c.org", "abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd" };
	private static final String[] Empty_Emails = null;
	
	// Concrete Email Class for Testing
	private EmailConcrete email;
	
	@Before		// set up method
	public void setUpEmailTest() throws Exception {
		
		email = new EmailConcrete();
		
		//mockSmtpServer = new MockSmtpServer(EmailConfiguration.MOCK_SMTP_PORT);
	}
	
	@After
	public void tearDownEmailTest() throws Exception {
		
		// don't need to write anything, just blank
		// can write something if want to
		
	}
	// addBcc Test Cases
	@Test
	public void testAddBcc() throws Exception {

		email.addBcc(Test_Emails);
		
		assertEquals(3,  email.getBccAddresses().size());

		// assertEquals -- used to make sure expected & current behavior is equal
		
	}
	
	@Test(expected = EmailException.class)
	public void testAddBccEmpty() throws Exception {
		
		email.addBcc(Empty_Emails);
		
		assertEquals(0, email.getBccAddresses().size());
	}

	
	// addCC Test Cases
	@Test
	public void testAddCc() throws Exception {
		// email.addCc(Test_Emails);
		// assertEquals(3, this.email.getCcAddresses().size());
		
		List<InternetAddress> addCcTesting = new ArrayList<InternetAddress>();
		addCcTesting.add(new InternetAddress("abc@def.com"));
		addCcTesting.add(new InternetAddress("ghi@jkl.com"));
		addCcTesting.add(new InternetAddress("mno@pqr.com"));
		
		for(int i = 0; i < Test_Emails.length; i++)
		{
			this.email.addCc(Test_Emails[i]);
		}

		assertEquals(addCcTesting.size(), this.email.getCcAddresses().size());
	} 

	
	
}
