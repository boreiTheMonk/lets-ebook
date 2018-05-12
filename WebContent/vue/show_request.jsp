<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<!--MAIL BOX-->
<link href="css/main-style/main.css" rel="stylesheet" type="text/css" />
<link href="css/mail-box/mailbox.css" rel="stylesheet" type="text/css" />


<!--HIDE & SHOW SCRIPT-->
<script type="text/javascript">
//<![CDATA[
function showSlidingDiv(ctrl){
if($(ctrl).children('img').attr("src") == 'images/mail-image2.gif') {
$(ctrl).children('img').attr("src","images/mail-img3.gif");
$(ctrl).parent().parent().parent().children().attr("style","display:block;");
$('#page4').jScrollPane({showArrows:true, scrollbarWidth: 15, arrowSize: 16});
}
else {
$(ctrl).children('img').attr("src","images/mail-image2.gif");
$(ctrl).parent().parent().next().attr("style","display:none;");
$('#page4').jScrollPane({showArrows:true, scrollbarWidth: 15, arrowSize: 16});
}

}
//]]>
</script>
<!--RATING STAR ATTACHED FILEES-->
<script src='js/rating-star/jquery.MetaData.js' type="text/javascript" language="javascript"></script>
<script src='js/rating-star/jquery.rating.js' type="text/javascript" language="javascript"></script>
<link href='css/rating-star/jquery.rating.css' type="text/css" rel="stylesheet"/>

<script type="text/javascript">

function publish_com(divWrap,idRequest){
	//console.log(text);
	//alert(divWrap.find('textarea').val()+" "+idRequest);
	aa= $.post('addMessageReqAjax',{ "requestId": idRequest,"msg_req":divWrap.find('textarea').val() ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
		//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
		//	bod=data;
		
		alert(data);
	 

	  str= "     <div class='big-list-cover'>";

	  str+="<div class='hidden-bullet'><img src='images/hidden-bullet.gif' alt='' width='23' height='20' border='0' align='left'/></div>";
	  str+=" <div class='mail-list-left-div'> <img src='/<s:property value='@constant.Application@FOLDER_MEMBER_IMAGE_URL'/>/<s:property value='#session[@constant.Application@USER_KEY].avatarUrl'/>' alt='' width='59' height='59' border='0' align='left' class='img-border-blue' /> </div>";
		  str+="<div class='big-list-right-div'>";
		  str+="  <div class='right ver'>";
		  str+="  <ul class='vertical'>";
		  str+="   <li><a href='#'><img src='images/plus-icon.jpg' alt='' border='0'  /></a>";
		  str+="    <ul >";
			  str+="      <li ><a href='#'>abus</a></li>";
			  str+="      <li class='no-border'><a href='#'>xoxoxo</a></li>";
			  str+="    </ul>";
				  str+="   </li>";
					  str+="  </ul>";
						  str+="</div>";
							  str+="  <p><strong><s:property value='#session[@constant.Application@USER_KEY].login'/> :</strong><br />";
							  str+=divWrap.find('textarea').val()+"</p>";

	        
							  str+=" </div>";

							  divWrap.before(str);
	//reinitialiseScrollPane();

	},"html");
}

$(function()
{
// this initialises the demo scollpanes on the page.

$('#page4').jScrollPane({showArrows:true, scrollbarWidth: 15, arrowSize: 16});

});

</script>

</head>
<body>
 <div id="content-area">
          <div class="border-heading-div">
             <div class="bg-heading-div">
              <div class="main-heading-div">Info</div>
              <div class="top-heading-icon"><img src="images/groupe-icon.png" width="38" height="24" alt="" border="0" class="margin-top-4" /></div>
              <div class="main-heading-txt"><span class="blue-txt">genre : <s:property value="showGroup.themes.iterator.next.name"/>  /   sujet :   <s:property value="showGroup.name"/></span></div>
              <div class="tabs-nav"><a href="show_group_home?groupId=<s:property value='groupId' />">Home</a><a href="showGroup?groupId=<s:property value='groupId' />" class="tab-select">Info</a><a href="showRequest?groupId=<s:property value='groupId' />">Requete</a></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div ">
              <div class="content-tab-cover ">
                <div class="inner-heading-cover">
                  <div class="inner-heading1">
                    <div class="inner-heading">requetes</div>
                  </div>
                  <div class="write-icon" > <a href="newRequest?groupId=<s:property value='groupId' />"> <img src="images/comment-write-icon.gif" alt="" width="26" height="16" border="0" align="right" /></a></div>
                </div>
                <div class="tab-content ">
                  <div class="right margin-bottom10">
                    <div class="holder osX">
                      <div id="page4" class="scroll-pane">
                       <s:iterator value="requests">                        
                       <div id="req<s:property value='idRequest' />">
	                       <div class="mail-list-cover">
	                          <div class="mail-list-left-div"><a href="#" onclick="showSlidingDiv(this); return false;"><img src="images/mail-image2.gif" alt="" width="61" height="45" border="0" /></a></div>
	                          <div class="mail-list-right-div">
	                            <div class="mail-list-link-div"><a href="javascript: centerEditorPopup(); loadEditorPopup();"">commenter</a></div>
	                            <b><s:property value="title"/></b>
	                          </div>
	                        </div>
	                        <div class="big-list-cover display-none">
	                          <div class="hidden-bullet"><img src="images/hidden-bullet.gif" alt="" width="23" height="20" border="0" align="left"/></div>
	                          <div class="mail-list-left-div"> <img src="images/mail-image.gif" alt="" width="59" height="59" border="0" align="left" class="img-border-blue" /> </div>
	                          <div class="big-list-right-div">
	                            <div class="right ver">
	                            <ul class="vertical">
	                              <li><a href="#"><img src="images/plus-icon.jpg" alt="" border="0"  /></a>
	                                <ul >
	                                  <li ><a href="#">abus</a></li>
	                                  <li class="no-border"><a href="#">xoxoxo</a></li>
	                                </ul>
	                              </li>
	                            </ul>
	                          </div>
	                            <p><strong><s:property value="member.login"/> :</strong><br />
	                              <s:property value="description" /></p>
	                            <div class="mail-list-link-div">
	                              <div class="rating-star">
	                                <form name="apireadonly" id="apireadonly" action="">
	                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="1"/>
	                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="2"/>
	                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="3"/>
	                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="4"/>
	                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="5"/>
	                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="6"/>
	                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="7"/>
	                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="8"/>
	                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="9"/>
	                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="10"/>
	                                </form>
	                                <span class="orange-txt">Xoxo!</span> </div>
	                            </div>
	                            
	                          </div>
	                          
	                          
	                          
	                        </div>
	                     	<s:iterator value="messageRequests" var="mr">
	                     		      
	                        
	                         <div class="big-list-cover display-none">
	                          <div class="hidden-bullet"><img src="images/hidden-bullet.gif" alt="" width="23" height="20" border="0" align="left"/></div>
	                          <div class="mail-list-left-div"> <img src="images/mail-image.gif" alt="" width="59" height="59" border="0" align="left" class="img-border-blue" /> </div>
	                          <div class="big-list-right-div">
	                            <div class="right ver">
	                            <ul class="vertical">
	                              <li><a href="#"><img src="images/plus-icon.jpg" alt="" border="0"  /></a>
	                                <ul >
	                                  <li ><a href="#">abus</a></li>
	                                  <li class="no-border"><a href="#">xoxoxo</a></li>
	                                </ul>
	                              </li>
	                            </ul>
	                          </div>
	                            <p><strong><s:property value="member.login"/> :</strong><br />
	                              <s:property value="body" /></p>
	                    
	                            
	                          </div>
	                          
	                          
	                          
	                        </div>
	                        
	                        
                     	</s:iterator>
                     	
                     	
                     	    <div class="big-list-cover display-none">
	                          <div class="hidden-bullet"><img src="images/hidden-bullet.gif" alt="" width="23" height="20" border="0" align="left"/></div>
	                          <div class="mail-list-left-div">  <img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="#session[@constant.Application@USER_KEY].avatarUrl"/>" alt="" width="59" height="59" border="0" align="left" class="img-border-blue" /> </div>
	                          <div class="big-list-right-div">
	                            <div class="right ver">
	                            <ul class="vertical">
	                              <li><a href="#"><img src="images/plus-icon.jpg" alt="" border="0"  /></a>
	                                <ul >
	                                  <li ><a href="#">abus</a></li>
	                                  <li class="no-border"><a href="#">xoxoxo</a></li>
	                                </ul>
	                              </li>
	                            </ul>
	                          </div>
	                            <p><strong><s:property value="#session[@constant.Application@USER_KEY].login"/> :</strong><br />
	                              <textarea style="overflow:auto;" cols="60"></textarea></p>
	                    		 <div class="mail-list-link-div">
	                            <input type="submit" name="button2" id="button2" value="publier" class="btn-small-gray" onclick="publish_com($(this).parent().parent().parent(),<s:property value='idRequest' />);" />
	                           	 </div>
	                          </div>
	                          
	                          
	                          
	                        </div>
	                        
                     	   	
                      </div>  
                     </s:iterator>
                        <div class="mail-list-cover">
                          <div class="mail-list-left-div"><a href="#" onclick="showSlidingDiv(this); return false;"><img src="images/mail-image2.gif" alt="" width="61" height="45" border="0" /></a></div>
                          <div class="mail-list-right-div">
                            <div class="mail-list-link-div"><a href="#">xoxoxoxo</a></div>
                            <b>XOXOXOXO</b>
                          </div>
                        </div>
                        <div class="big-list-cover display-none">
                          <div class="hidden-bullet"><img src="images/hidden-bullet.gif" alt="" width="23" height="20" border="0" align="left"/></div>
                          <div class="mail-list-left-div"> <img src="images/mail-image.gif" alt="" width="59" height="59" border="0" align="left" class="img-border-blue" /> </div>
                          <div class="big-list-right-div">
                          <div class="right ver">
                            <ul class="vertical">
                              <li><a href="#"><img src="images/plus-icon.jpg" alt="" border="0"  /></a>
                                <ul >
                                  <li ><a href="#">xoxoxo</a></li>
                                  <li class="no-border"><a href="#">xoxoxo</a></li>
                                </ul>
                              </li>
                            </ul>
                          </div>
                            <p><strong>Pikabou23 :</strong><br />
                              xoxooxoxooxoxooxoxooxoxooxoxooxoxooxoxooxoxooxoxooxoxooxoxooxoxooxoxooxoxooxoox ooxox  ooxoxooxoxoo xoxooxoxo oxo xooxoxooxoxooxoxooxoxooxoxo</p>
                            <div class="mail-list-link-div">
                              <div class="rating-star">
                                <form name="api-readonly" id="api-readonly" action="">
                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="1"/>
                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="2"/>
                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="3"/>
                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="4"/>
                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="5"/>
                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="6"/>
                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="7"/>
                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="8"/>
                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="9"/>
                                  <input type="radio" class="star {split:2}" name="api-readonly-test" value="10"/>
                                </form>
                                <span class="orange-txt">Xoxo!</span> </div>
                            </div>
                          </div>
                        </div>
                        <div class="mail-list-cover">
                          <div class="mail-list-left-div"><img src="images/mail-image2.gif" alt="" width="61" height="45" border="0" /></div>
                          <div class="mail-list-right-div">
                            <div class="mail-list-link-div"><a href="#">xoxoxoxo</a></div>
                            <b>XOXOXOXO</b>
                          </div>
                        </div>
                        <div class="mail-list-cover">
                          <div class="mail-list-left-div"><img src="images/mail-image2.gif" alt="" width="61" height="45" border="0" /></div>
                          <div class="mail-list-right-div">
                            <div class="mail-list-link-div"><a href="#">xoxoxoxo</a></div>
                            <b>XOXOXOXO</b>
                          </div>
                        </div>
                        <div class="mail-list-cover">
                          <div class="mail-list-left-div"><img src="images/mail-image2.gif" alt="" width="61" height="45" border="0" /></div>
                          <div class="mail-list-right-div">
                            <div class="mail-list-link-div"><a href="#">xoxoxoxo</a></div>
                            <b>XOXOXOXO</b>
                          </div>
                        </div>
                        <div class="mail-list-cover">
                          <div class="mail-list-left-div"><img src="images/mail-image2.gif" alt="" width="61" height="45" border="0" /></div>
                          <div class="mail-list-right-div">
                            <div class="mail-list-link-div"><a href="#">xoxoxoxo</a></div>
                            <b>XOXOXOXO</b>
                          </div>
                        </div>
                        <div class="mail-list-cover">
                          <div class="mail-list-left-div"><img src="images/mail-image2.gif" alt="" width="61" height="45" border="0" /></div>
                          <div class="mail-list-right-div">
                            <div class="mail-list-link-div"><a href="#">xoxoxoxo</a></div>
                            <b>XOXOXOXO</b>
                          </div>
                        </div>
                        <div class="mail-list-cover">
                          <div class="mail-list-left-div"><img src="images/mail-image2.gif" alt="" width="61" height="45" border="0" /></div>
                          <div class="mail-list-right-div">
                            <div class="mail-list-link-div"><a href="#">xoxoxoxo</a></div>
                            <b>XOXOXOXO</b>
                          </div>
                        </div>
                        <div class="mail-list-cover">
                          <div class="mail-list-left-div"><img src="images/mail-image2.gif" alt="" width="61" height="45" border="0" /></div>
                          <div class="mail-list-right-div">
                            <div class="mail-list-link-div"><a href="#">xoxoxoxo</a></div>
                            <b>XOXOXOXO</b>
                          </div>
                        </div>
                        <div class="mail-list-cover">
                          <div class="mail-list-left-div"><img src="images/mail-image2.gif" alt="" width="61" height="45" border="0" /></div>
                          <div class="mail-list-right-div">
                            <div class="mail-list-link-div"><a href="#">xoxoxoxo</a></div>
                            <b>XOXOXOXO</b>
                          </div>
                        </div>
                        <div class="mail-list-cover">
                          <div class="mail-list-left-div"><img src="images/mail-image2.gif" alt="" width="61" height="45" border="0" /></div>
                          <div class="mail-list-right-div">
                            <div class="mail-list-link-div"><a href="#">xoxoxoxo</a></div>
                            <b>XOXOXOXO</b>
                          </div>
                        </div>
                        <div class="mail-list-cover">
                          <div class="mail-list-left-div"><img src="images/mail-image2.gif" alt="" width="61" height="45" border="0" /></div>
                          <div class="mail-list-right-div">
                            <div class="mail-list-link-div"><a href="#">xoxoxoxo</a></div>
                            <b>XOXOXOXO</b>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div id="popupEditor" class="popupbig_bg">
  <div class="popupbig-innearea">
    <div class="popup-innearea-box" >
      <textarea cols="" rows=""></textarea>
    </div>
    <div class="right">
      <input type="button" name="button2" id="popupEditorClose" value="fermer" class="btn-large-gray" />
      &nbsp;
      <input type="button" name="button3" id="popupEditorSubmit" value="commenter" class="btn-blue" />
    </div>
  </div>
</div>
</body>
</html>