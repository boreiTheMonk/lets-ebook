<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Envoi d'un message</title>

<!--COMBOBOX ATTACHED FILES-->
<link href="css/combo-box/combobox.css" rel="stylesheet" type="text/css" />

<!--FORM VALIDATION ATTACHED FILES-->
<link href="css/form-validation/formvalidation.css" rel="stylesheet" type="text/css" />
<link href="css/mail-box/mailbox.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(document).ready(function() {
 $("#sendMailbut").click(function() {
	 var i =$("#subject").val();
  var j = $("#mailbody").val();
		 //alert(i);
		 //alert(j);
		 //alert($("#idMember").val());
		
			if( submitOnce==0){
				
				submitOnce=1;
		  aa= $.post('send_mail',{ "mail.subject":i,"mail.body":j,"idMember":($("#idMember").val())}, function(data,textStatus,http) {
				
				var msg="message envoyé";
				$("#msgContent").html(msg);
				centerPopup(); loadPopup();
			},"html");
		  
			}//end if
		});
		

		});
</script>
</head>
<body>
 <div id="content-area">
          <div class="none-border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">envoi d'un message</div>
              <div class="top-heading-icon"><img src="images/mail-box-icon.png" width="19" height="30" alt="" border="0" class="margin-top-5" /></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="mail-box-div">
  <form action="send_mail" method="post" enctype="multipart/form-data">
 
    <dl class="form-mailbox">
      <dd class="validated" id="xoxo1_li">
        <label for="idMember"><strong>destinataire :</strong></label>
        <div id="xoxo1_img"></div>
       <s:property value="me.login"/>
       <input type="hidden" id="idMember" name="idMember" value="<s:property value="me.idMember" />"/>
    
        <div id="xoxo1_msg" class="msg-mailbox"></div>
      </dd>
      <dd >
        <label for="r_xoxo2"><strong>objet :</strong></label>
        <div id="xoxo2_img"></div>
        <input name="xoxo2" id="subject" type="text"  class="mail-form-input1 validated"  />
        <div  class="msg"></div>
      </dd>
      <dd id="textarea1_li">
        <label for="r_textarea1"><strong>message :</strong></label>
        <div id="textarea1_img"></div>
        <textarea name="mail.body" id="mailbody" cols="45" rows="5" class="mail-text-area1"></textarea>
        <div id="textarea1_msg" class="msg"></div>
      </dd>
   
    </dl>
       <div class="mail-form-row">
        <div class="mail-form-left"></div>
        <div class="mail-form-right center">
          <input type="button" name="button2" id="sendMailbut" value="Envoyer" class="btn-blue" />
        </div>
      </div>
  </form>
</div>
            </div>
          </div>
        </div>
        <div id="popupContact" class="popupsmall_bg">
  <div class="popupsmall-innearea">
    <p class="size-txt12" id="msgContent"> </p>

     <input type="button" onclick="self.location.href='show_author?idMember=<s:property value="me.idMember" />';" value="retour" class="pop-btn-small-blue" />
  </div>
</div>
</body>
</html>