<!--FORM VALIDATION ATTACHED FILES-->
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="css/form-validation/formvalidation.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/form-validation/formvalidation.js"></script>
<script type="text/javascript" language="javascript">

</script>
<div class="mail-box-right-div">
  <form action="send_mail" method="post" enctype="multipart/form-data">
 
    <dl class="form-mailbox">
      <dd class="validated" id="xoxo1_li">
        <label for="idMember"><strong>destinataire :</strong></label>
        <div id="xoxo1_img"></div>
       <s:property value="me.login"/>
       <input type="hidden" name="idMember" value="<s:property value="me.idMember" />"/>
    
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
