<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>coupez votre image</title>
 	
		<script type="text/javascript" src="<s:url value='/jquery/Jcrop/js/jquery.Jcrop.js'/>"/> </script>
		<link rel="stylesheet" href="<s:url value='/jquery/Jcrop/css/jquery.Jcrop.css'/>" />
<!--		<link rel="stylesheet" href="demo_files/demos.css" type="text/css" />-->
	  <script type="text/javascript" src="<s:url value='/vue/cropImage.js'/>" ></script>
	  
	  <script type="text/javascript" >
$(function() {

	$("#popupContactClose").click(function(){
		disablePopup();
		});
	 $("#crop_form").validate({

		 showErrors: function(errorMap, errorList) {
		 	
		
		 centerPopup(); loadPopup();
		 


		 		},
		    rules: {
		      'x1': "required"
		      
		    }
		   
		 });


	 
});
</script>  
</head>

<body>
   <div id="content-area">
          <div class="border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">découpage de l'avatar</div>
              <div class="top-heading-icon"><img src="images/upload-icon.png" width="36" height="29" alt="" border="0" class="margin-top-5" /></div>
            </div>
          </div>
          <div class="content-padd">
     <h1>Selection des parties a afficher</h1>

		<!-- This is the image we're attaching Jcrop to -->
		<div style="display:table;margin:auto;clear: both;">
		<img   src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="#session[@constant.Application@USER_KEY].avatarUrl"/>" id="cropbox"  style="display: block;" alt="image"/>
		</div>
		
		 <form id="crop_form" action="cropImageAvatar">
		<input type="hidden" name="bookId" value="<s:property value="bookId" />"/> 
		
      <input type="hidden" name="x1" id="x1"/>
      <input type="hidden" name="y1" id="y1"/>
      <input type="hidden" name="x2" id="x2"/>
      <input type="hidden" name="y2" id="y2"/>
      <input type="hidden" name="w" id="w"/>
      <input type="hidden" name="h" id="h"/>
      <div class="form-row">
                  <div class="form-col-left" style="visibility: hidden;">
                    <div class="padding10">
                      <input type="submit" name="button2" id="button2" value="Xoxox" class="btn-small-gray left" />
                    </div>
                  </div>
                  <div class="form-col-right" style="margin:10px">
                    <div class="padding-left15">
                      <input type="submit" value="Ok" name="action" class="btn-blue" />
                    </div>
                  </div>
                </div>
     
    </form>
          </div>
        </div>
        
        <div id="popupContact" class="popupsmall_bg">
  <div class="popupsmall-innearea">
    <p class="size-txt12" id="msgContent"> veuillez selectioner la partie de l'image<br/>que vous souhaitez conserver </p>

    <input type="button" name="button3" id="popupContactClose" value="fermer" class="pop-btn-small-blue" />
  </div>
</div>
		
</body>
</html>