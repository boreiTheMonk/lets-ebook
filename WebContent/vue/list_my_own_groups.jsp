 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>liste de groupe</title>

<link rel="stylesheet" href="css/pagination/pagination.css"  />
<script type="text/javascript" src="js/pagination/jquery.pagination.js"></script>
<script type="text/javascript">
// This is a very simple demo that shows how a range of elements can
// be paginated.
// The elements that will be displayed are in a hidden DIV and are
// cloned for display. The elements are static, there are no Ajax 
// calls involved.
function initPaginationGroup() {
    var num_entries = <s:property value="nbGroups"/>;
    // Create pagination element
    if (num_entries !=0){
    	
	    $(".pagination").pagination(num_entries, {
	        num_edge_entries: 2,
	        num_display_entries: 8,
	        callback: pageselectCallbackGroup,
	        items_per_page:10
	    });
    }
 }


function pageselectCallbackGroup(page_index, jq){
	//searchPaginateBook {mydeco:"empty_inline",pageNumber:page_index}
	//alert(page_index);
	//var search = $('#word').text();
	
	$("#searchResults").load('listPaginateMyOwnGroups',{my_deco:"empty_inline",min:(10*(page_index+1))-10,max:10} );
	//alert("ok");
  //  var new_content = $('#hiddenresult div.result:eq('+page_index+')').clone();
   // $('#Searchresult').empty().append(new_content);
    return false;
}
// When document is ready, initialize pagination
$(document).ready(function(){      
	initPaginationGroup();
});
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
$("#popupEditorClose").click(function(){
disableEditorPopup();
});
//Click out event!
$("#backgroundPopup").click(function(){
disablePopup();
});

//Click the button event!
});

function confirm_delete (idGroup,name,wrap){
	
	//stopPropagation();
	$("#group_name").html(name);
	 centerPopup();
	 loadPopup();
	var p=$(wrap).parent().parent().parent().parent().parent();
	$('#button_delete').unbind('click');
	 $("#button_delete").click(function(){
		 
			if( submitOnce==0){
				
				submitOnce=1;		 
		 
	 
			$.post('delete_group',{ "groupId": idGroup ,"my_deco":"empty_inline"}, function(data,textStatus,http) {
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

			}
			return false;
		 });
	 
}
</script>
</head>
<body>
  <div id="content-area">
          <div class="border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">Mes groupes créés</div>
              <div class="top-heading-icon"><img src="images/groupe-icon.png" width="38" height="24" alt="" border="0" class="margin-top-2" /></div>
              <div class="main-heading-right-txt" style="visibility: hidden;">Recherche par nom :
                <input type="text" name="textfield2" id="textfield2" class="search-input2" />
              </div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="content-tab-cover left">
                <div class="tab-content left">
                  <div class="breadcrumb">Total : <s:property value="nbGroups"/> Groupes créés</div>
                  <div id="searchResults" class="left"> pas de groupe créé </div>
                  <!-- Container element for all the Elements that are to be paginated -->
                  <div id="hiddenresult" class="display-none">
                    <div class="result">
                      <div class="search-tab-cover">
                        <div class="search-tab">
                          <table width="135" cellpadding="0" cellspacing="0" border="0">
                            <tr>
                              <td width="17" align="left" valign="top"><img src="images/blue-square.gif" alt="" border="0" /></td>
                              <td width="91" align="left" valign="top"><a href="#"><b>Xoxoxoxox  xo</b></a></td>
                              <td width="27" align="left" valign="top">&nbsp;</td>
                            </tr>
                            <tr>
                              <td align="left" valign="top">&nbsp;</td>
                              <td align="left" valign="top">xoxoxoxoxo<br />
                                xoxo</td>
                              <td align="left" valign="bottom" ><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt=""  border="0" /></a> </td>
                            </tr>
                          </table>
                        </div>
                   
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
    <p class="size-txt12"><span id="group_name"></span> <br />sera enlevé de vos groupes
             
      
      </p>
    <input type="button" name="button2"  value="fermer" class="pop-btn-small-gray popupContactClose" />
    <input type="button" name="button2" id="button_delete" value="ok" class="pop-btn-small-blue" />
  </div>
  </div>
</body>
</html>