 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>liste d'auteur</title>

<link rel="stylesheet" href="css/pagination/pagination.css"  />
<script type="text/javascript" src="js/pagination/jquery.pagination.js"></script>
<script type="text/javascript">
// This is a very simple demo that shows how a range of elements can
// be paginated.
// The elements that will be displayed are in a hidden DIV and are
// cloned for display. The elements are static, there are no Ajax 
// calls involved.
function initPaginationAuthor() {
    var num_entries = <s:property value="nbfriends"/>;
    // Create pagination element
    if (num_entries !=0){
    	
	    $(".pagination").pagination(num_entries, {
	        num_edge_entries: 2,
	        num_display_entries: 8,
	        callback: pageselectCallbackAuthor,
	        items_per_page:10
	    });
    }
 }


function pageselectCallbackAuthor(page_index, jq){
	//searchPaginateBook {mydeco:"empty_inline",pageNumber:page_index}
	//alert(page_index);
	//var search = $('#word').text();
	
	$("#searchResults").load('listPaginateFriends',{my_deco:"empty_inline",min:(10*(page_index+1))-10,max:10} );
  //  var new_content = $('#hiddenresult div.result:eq('+page_index+')').clone();
   // $('#Searchresult').empty().append(new_content);
    return false;
}
// When document is ready, initialize pagination
$(document).ready(function(){      
	initPaginationAuthor();
});

function confirm_delete (idAuthor,name,wrap){
	
	//stopPropagation();
	$("#member_name").html(name);
	 centerPopup();
	 loadPopup();
	var p=$(wrap).parent().parent();
	$('#button_delete').unbind('click');
	 $("#button_delete").click(function(){
			$.post('delete_friends',{ "idMember": idAuthor ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
				//$("#wall").load('addMessage',{ "mm.body": body,my_deco:"empty_inline" }, function(data) {
				//	bod=data;
				if(data!='0'){
					
					}
				else{
					
					}
				//console.log(wrap);
				//console.log(p);
				p.hide();	
				disablePopup();
			 // $('#page2').prepend(data);
			
			},"html");

			return false;
		 });
	 
}
</script>
<!--POPUP ATTACHED FILEES-->
<link rel="stylesheet" href="css/popup/popup.css" type="text/css" media="screen" />
<script src="js/popup/popup.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
$(document).ready(function(){
//CLOSING POPUP
//Click the x event!
$(".popupContactClose").click(function(){
disablePopup();
});
$(".popupEditorClose").click(function(){
disableEditorPopup();
});
//Click out event!
$(".backgroundPopup").click(function(){
disablePopup();
});

//Click the button event!
});
</script>
</head>
<body>

        <div id="content-area">
          <div class="border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">Mes Amis</div>
              <div class="top-heading-icon"><img src="images/amis-icon.png" width="26" height="26" alt="" border="0" class="margin-top-3" /></div>
              <div class="main-heading-right-txt"><span class="blue-txt size-txt12">Total : <s:property value="nbfriends"/> Amis</span></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="content-tab-cover left">
                <div class="tab-content left">
                  <div class="breadcrumb" style="visibility: hidden;"><a href="#">xoxoxox</a><span>/</span><a href="#">xoxoxox</a><span>/</span><a href="#">xoxoxox xox</a></div>
                  <div id="searchResults" class="left"> aucun ami. </div>
                  <!-- Container element for all the Elements that are to be paginated -->
                  <div id="hiddenresult" class="display-none">
                    <div class="result">
                      <div class="amis-tab-cover">
                  <s:iterator value="resMember" >
    				<s:url id="url_show_author" action="show_author" >
                        <s:param name="idMember" value="idMember"/>
                     </s:url>
    
                    <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <s:a href="%{url_show_author}"><img src="/<s:property value="@constant.Application@FOLDER_MEMBER_IMAGE_URL"/>/<s:property value="avatarUrl"/>" alt="" border="0" class="img-border-gray" height="48px" width="48px" /></s:a> 
                    <div class="text_name_avatar" style="width: 50px;padding: 1px;word-wrap:break-word;"> <span class="ellipsis_text"> <s:property value="login"/></span></div>
                    </div>
   </s:iterator> 
                      </div>
                    </div>
                    <div class="result">
                      <div class="amis-tab-cover">
                        <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" /> </div>
                        <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" /> </div>
                        <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" /> </div>
                        <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" /> </div>
                        <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" /> </div>
                        <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" /> </div>
                        <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" /> </div>
                        <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" /> </div>
                        <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" /> </div>
                        <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" /> </div>
                        <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" /> </div>
                        <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" /> </div>
                        <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" /> </div>
                        <div class="amis-tab"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="popup-link-amis" /></a></span> <img src="images/amis-img.gif" alt="" border="0" class="img-border-gray" /> </div>
                      </div>
                    </div>
                  </div>
                  <div class="pagination" style="clear:both;float: right;"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
 <div id="popupContact" class="popupsmall_bg">
  	<div class="popupsmall-innearea">
    <p class="size-txt12"><span id="member_name"></span> <br />sera enlevé de vos amis
             
      
      </p>
    <input type="button" name="button2"  value="fermer" class="pop-btn-small-gray popupContactClose" />
    <input type="button" name="button2" id="button_delete" value="ok" class="pop-btn-small-blue" />
  </div>
  <div class="response center" style="display: none">
      <p class="size-txt12"> 
          <span id="confirmTxt">livre inséré avec succès</span>
      </p>
  	<input type="button" name="button2"  value="fermer" class="pop-btn-small-gray" />
  </div>
  
</div>
</body>
</html>