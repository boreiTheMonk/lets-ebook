 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>liste de livres</title>

<link rel="stylesheet" href="css/pagination/pagination.css"  />
<script type="text/javascript" src="js/pagination/jquery.pagination.js"></script>
<script type="text/javascript">
// This is a very simple demo that shows how a range of elements can
// be paginated.
// The elements that will be displayed are in a hidden DIV and are
// cloned for display. The elements are static, there are no Ajax 
// calls involved.
function initPaginationBook() {
    var num_entries = <s:property value="nbBooks"/>;
    // Create pagination element
    if (num_entries !=0){
    	
	    $(".pagination").pagination(num_entries, {
	        num_edge_entries: 2,
	        num_display_entries: 8,
	        callback: pageselectCallbackBook,
	        items_per_page:10
	    });
    }
 }


function pageselectCallbackBook(page_index, jq){
	//searchPaginateBook {mydeco:"empty_inline",pageNumber:page_index}
	//alert(page_index);
	//var search = $('#word').text();
	
	$("#searchResults").load('listPaginateAuthorBooks',{idMember:<s:property value="idMember"/>,my_deco:"empty_inline",min:(10*(page_index+1))-10,max:10} );
	//alert("ok");
  //  var new_content = $('#hiddenresult div.result:eq('+page_index+')').clone();
   // $('#Searchresult').empty().append(new_content);
    return false;
}
// When document is ready, initialize pagination
$(document).ready(function(){      
	initPaginationBook();
});
</script>
<!--POPUP ATTACHED FILEES-->
<link rel="stylesheet" href="css/popup/popup.css" type="text/css" media="screen" />
<script src="js/popup/popup.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
$(document).ready(function(){
//CLOSING POPUP
//Click the x event!
$("#popupContactClose").click(function(){
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
</script>
</head>
<body>
 <div id="content-area">
          <div class="border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div"> livres</div>
              <div class="top-heading-icon"><img src="images/livres-icon.png" width="23" height="28" alt="" border="0" class="margin-top-5" /></div>
              <div class="main-heading-right-txt"><span class="blue-txt size-txt12">Total : <s:property value="nbBooks"/> Livres</span></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="content-tab-cover left">
                <div class="tab-content left">
                  <div class="breadcrumb" style="visibility: hidden;"><a href="#">xoxoxox</a><span>/</span><a href="#">xoxoxox</a><span>/</span><a href="#">xoxoxox xox</a></div>
                  <div id="searchResults" class="left"> pas de livres. </div>
                  <!-- Container element for all the Elements that are to be paginated -->
                  <div id="hiddenresult" class="display-none">
                    <div class="result">
                      <div class="horizontal-scroll-tab2"> <span ><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="horizontal-tab-popup-link" /></a></span> <img src="images/horizontal-scroll-img.jpg" alt="" border="0" class="img-border-gray" /> Xoxoxox
                        xox
                        xoxoxoxox </div>
                      <div class="horizontal-scroll-tab2"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="horizontal-tab-popup-link" /></a></span> <img src="images/horizontal-scroll-img.jpg" alt="" border="0" class="img-border-gray" /> Xoxoxox
                        xox
                        xoxoxoxox </div>
                     
                    </div>
                    <div class="result">
                      <div class="horizontal-scroll-tab2"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="horizontal-tab-popup-link" /></a></span> <img src="images/horizontal-scroll-img.jpg" alt="" border="0" class="img-border-gray" /> Xoxoxox
                        xox
                        xoxoxoxox </div>
                      <div class="horizontal-scroll-tab2"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="horizontal-tab-popup-link" /></a></span> <img src="images/horizontal-scroll-img.jpg" alt="" border="0" class="img-border-gray" /> Xoxoxox
                        xox
                        xoxoxoxox </div>
                      <div class="horizontal-scroll-tab2"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="horizontal-tab-popup-link" /></a></span> <img src="images/horizontal-scroll-img.jpg" alt="" border="0" class="img-border-gray" /> Xoxoxox
                        xox
                        xoxoxoxox </div>
                      <div class="horizontal-scroll-tab2"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="horizontal-tab-popup-link" /></a></span> <img src="images/horizontal-scroll-img.jpg" alt="" border="0" class="img-border-gray" /> Xoxoxox
                        xox
                        xoxoxoxox </div>
                      <div class="horizontal-scroll-tab2"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="horizontal-tab-popup-link" /></a></span> <img src="images/horizontal-scroll-img.jpg" alt="" border="0" class="img-border-gray" /> Xoxoxox
                        xox
                        xoxoxoxox </div>
                      <div class="horizontal-scroll-tab2"> <span><a href="javascript: centerPopup(); loadPopup();"><img src="images/cross-icon.gif" alt="" border="0" class="horizontal-tab-popup-link" /></a></span> <img src="images/horizontal-scroll-img.jpg" alt="" border="0" class="img-border-gray" /> Xoxoxox
                        xox
                        xoxoxoxox </div>
                    </div>
                  </div>
                  <div class="pagination" style="clear:both;float: right;"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
</body>
</html>