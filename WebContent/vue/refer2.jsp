<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>parainage</title>
</head>
<body>
        <div id="content-area">
          <div class="none-border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">parrainage</div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="form-heading"><em>formulaire de parrainage</em></div>
              <div class="bg-parainage-form">
                <form action="sendreferMail" method="post" enctype="multipart/form-data">
                  <dl class="form">
                    <dd class="validated" id="xoxoEmail_li">
                      <label for="emails"><strong>email (plusieurs separés par une virgule) :</strong></label>
                      <div id="xoxoEmail_img"></div>
                      <input class="form-input1 validated" name="emails" id="xoxoEmail" type="text"  value=""  />
                      <div id="xoxoEmail_msg" class="msg"></div>
                    </dd>
                    <dd class="validated" id="choix_li">
                      <label for="choix"><strong>objet :</strong></label>
                      <div id="choix_img"></div>
                      <input name="subject" id="choix" type="text" class="form-input1 validated"  />
                      <div id="choix_msg" class="msg"></div>
                    </dd>
                    <dd class="validated" id="textarea1_li">
                      <label for="textArea1"><strong>corps :</strong></label>
                      <div id="textarea1_img"></div>
                      <div style="height: 150pxheight: 180px; width: 340px; float: right;"><s:property value="@core_lib.WebSiteMessage@INVIT" escape="false"/>
                      
                      <br/><a href="http://www.lets-ebook.com/ebooksite?referee=<s:property value='#session[@constant.Application@USER_KEY].idMember'/>">http://lets-ebook.com</a>
                      </div>
                      <% //<textarea name="textArea1" id="textArea1" cols="45" rows="5" class="form-text-area1 validated"></textarea>%>
                      <div id="textarea1_msg" class="msg"></div>
                    </dd>
                  </dl>
                  <div class="form-row">
                    <div class="form-col-left"></div>
                    <div class="form-col-right center">
                      
                      &nbsp;&nbsp;
                      <input type="submit" name="button3" id="button3" value="envoyer" class="btn-blue" />
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
</body>
</html>