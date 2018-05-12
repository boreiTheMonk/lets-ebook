package core_lib;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
;
public class WebSiteMessage {
        private String msgReplyTo="admin@lets-ebook.com" ;
        //private String msgContents ;
        private String subject= "inscription au site lets ebook" ;
        //private String email_server="smtp.gmail.com"  ;
        
        private String email_server="localhost"  ;
       // private String email_server="192.168.0.12"  ;
        /*
           SimpleEmail email = new SimpleEmail();
  		   email.setHostName("mail.myserver.com");
           email.addTo("jdoe@somewhere.org", "John Doe");
          email.setFrom("me@apache.org", "Me");
          email.setSubject("Test message");
          email.setMsg("This is a simple test of commons-email");
          email.send();

         */

    public static  String INVIT = "Bonjour,<br/><br/>"
      +  "Envie de partager une oeuvre, de dialoguer avec des &eacute;crivains et des lecteurs du monde entier ou bien de vendre vos cr&eacute;ations à leur juste valeur, alors n'h&eacute;sites plus !<br/>" 
    +  "  lets-ebook, c'est un v&eacute;ritable espace personnel, complet et facile d'acc&egrave;s."
     +  " Et tout &ccedil;a Gratuitement !!!<br><br>"
     + "  Alors n'attends plus et rejoins moi sur le premier portail communautaire d'ebooks et de documents électroniques en tout genre gr&acirc;ce au lien suivant :<br/><br/>"
    ;

        public void send(String to,String msgContents, String subject) throws RuntimeException {
                try {
                      //  SimpleEmail email = new SimpleEmail();
                	 HtmlEmail email = new HtmlEmail();

                        email.setHostName( this.email_server );
                        //email.addHeader(name, value)
                        email.setSmtpPort(25);
                     //   email.setc
                        email.addTo( to );
                      //  String authuser = "borei.eng@gmail.com";
                       // String authpwd = "Djidane41771";
                        email.setFrom(this.msgReplyTo, "admin let's ebook");
                      //  email.setAuthenticator(new DefaultAuthenticator(authuser, authpwd));
                       email.setSubject(  subject );
                      // String hostName=ServletActionContext.getRequest().getServerName();
                       String hostName="localhost";
                       System.out.println("http://"+hostName+"/images/bando.png");
                       URL url;
                       String cid = null;
					try {
						url = new URL("http://"+hostName+"/ebooksite/images/bando.png");
						cid = email.embed(url, "let's ebook");
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                 	
                 	  
                 	  // set the html message
					msgContents=" <img src=\"cid:"+cid+"\"><br/>"+msgContents;
		
					msgContents="<html><body>"  +msgContents+"</body></html>"; 
					email.setHtmlMsg( msgContents );
                       
                       //SimpleEmail email2 = new SimpleEmail();
 
                       //email.setTMsg( msgContents );
                        email.send();
                }
                catch(EmailException ee){
                	ee.printStackTrace();
                       // throw new RuntimeException("EmailException thrown - " + ee.getMessage());
                }
        }
        
      
        public String getMsgReplyTo() {
                return msgReplyTo;
        }
        public void setMsgReplyTo(String msgReplyTo) {
                this.msgReplyTo = msgReplyTo;
        }
        public String getSubject() {
                return subject;
        }
        public void setSubject(String subject) {
                this.subject = subject;
        }       
        
        public static void main(String[] arg0){
    		
        	WebSiteMessage aa= new WebSiteMessage();
        	 // embed the image and get the content id
        	 

        	//aa.send("borei.eng@gmail.com", INVIT,"rr");
        	aa.send("borei.eng@gmail.com", INVIT,"rr");
        	aa.send("japan44@hotmail.fr", INVIT,"rr");
        	
        /*	Set<Member> c = new HashSet<Member>();
        	Member m =new Member();
        	c.add(m);
        	c.add(m);
        	System.out.println(c.size());*/
    	}
        
        
}