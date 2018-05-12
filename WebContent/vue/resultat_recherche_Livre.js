//$(document).ready(function() {
//	// First Parameter: number of items
//		// Second Parameter: options object
//		$("#News-Pagination").pagination(7, {
//		    items_per_page:20,
//		    callback:loadContents
//		});
//	
//	
//});

function initPaginationBook() {
    var num_entries = $('#nbResBook').text();
    id=""
    	$("#tabAuth").removeClass('tab-select');
	$("#tab_group").removeClass('tab-select');
	$("#tab_book").addClass('tab-select');
    // Create pagination element
    if (num_entries !=0){
    	
	    $(".pagination").pagination(num_entries, {
	        num_edge_entries: 2,
	        num_display_entries: 8,
	        callback: pageselectCallbackBook,
	        items_per_page:10
	    });
    }
    else {
    	$("#searchResults").html('pas de r&eacute;sultat dans les livres');
    	$(".pagination").html("");
    }
 }

$(document).ready(function(){      
	initPaginationBook();
	
	//$("#myTabs").tabs();
	//$("#tabs").tabs();
	//click on the tab show result ajax
	
	
	/*$("#tabAuth").bind('click', function() {
initPaginationAuthor();
alert("ok");
});*/
	
	
   // $('#Searchresult').empty().load('searchPaginateBook', null, initPagination);
});

function pageselectCallbackBook(page_index, jq){
	//searchPaginateBook {mydeco:"empty_inline",pageNumber:page_index}
	//alert(page_index);
	var search = $('#word').text();
	//alert("toto");
	$("#searchResults").load('searchPaginateBook',{searchWord:search,my_deco:"empty_inline",min:(10*(page_index+1))-10,max:10} );
  //  var new_content = $('#hiddenresult div.result:eq('+page_index+')').clone();
   // $('#Searchresult').empty().append(new_content);
    return false;
}

function initPaginationAuthor() {
    var num_entries = $('#nbResAuthor').text();
 	$("#tabAuth").addClass('tab-select');
	$("#tab_group").removeClass('tab-select');
	$("#tab_book").removeClass('tab-select');
    // Create pagination element
    if (num_entries !=0){
    	
	    $(".pagination").pagination(num_entries, {
	        num_edge_entries: 2,
	        num_display_entries: 8,
	        callback: pageselectCallbackAuthor,
	        items_per_page:12
	    });
    }
    else {
    	$("#searchResults").html('pas de r&eacutesultat dans les auteurs');
    	$(".pagination").html("");
    }
 }


function pageselectCallbackAuthor(page_index, jq){
	//searchPaginateBook {mydeco:"empty_inline",pageNumber:page_index}
	//alert(page_index);
	var search = $('#word').text();
	
	$("#searchResults").load('searchPaginateAuthor',{searchWord:search,my_deco:"empty_inline",min:(10*(page_index+1))-10,max:10} );
  //  var new_content = $('#hiddenresult div.result:eq('+page_index+')').clone();
   // $('#Searchresult').empty().append(new_content);
    return false;
}


function initPaginationGroup() {
    var num_entries = $('#nbResGroup').text();
	$("#tabAuth").removeClass('tab-select');
	$("#tab_group").addClass('tab-select');
	$("#tab_book").removeClass('tab-select');
    // Create pagination element
    if (num_entries !=0){
    	
	    $(".pagination").pagination(num_entries, {
	        num_edge_entries: 2,
	        num_display_entries: 8,
	        callback: pageselectCallbackGroup,
	        items_per_page:12
	    });
    }
    else {
    	$("#searchResults").html('pas de r&eacutesultat dans les groupes');
    	$(".pagination").html("");
    }
 }


function pageselectCallbackGroup(page_index, jq){
	//searchPaginateBook {mydeco:"empty_inline",pageNumber:page_index}
	//alert(page_index);
	var search = $('#word').text();
	
	$("#searchResults").load('searchPaginateGroup',{searchWord:search,my_deco:"empty_inline",min:(10*(page_index+1))-10,max:10} );
  //  var new_content = $('#hiddenresult div.result:eq('+page_index+')').clone();
   // $('#Searchresult').empty().append(new_content);
    return false;
}