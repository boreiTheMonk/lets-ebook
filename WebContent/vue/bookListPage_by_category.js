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

function initPagination() {
    var num_entries = $('#nbResBook').text();
    // Create pagination element
    if (num_entries !=0){
	    $("#pagination").pagination(num_entries, {
	        num_edge_entries: 2,
	        num_display_entries: 8,
	        callback: pageselectCallback,
	        items_per_page:5
	    });
    } 
 }

$(document).ready(function(){      
	initPagination();
   // $('#Searchresult').empty().load('searchPaginateBook', null, initPagination);
});

//page_index is a variable automatiquely given from the callback function
function pageselectCallback(page_index, jq){
	//searchPaginateBook {mydeco:"empty_inline",pageNumber:page_index}
	//alert(page_index);
	 var id_c = $('#id_category').text();
	$("#searchResults").load('categoryPaginateBook',{id_category:id_c,my_deco:"empty_inline",min:(5*(page_index+1))-5,max:5} );
  //  var new_content = $('#hiddenresult div.result:eq('+page_index+')').clone();
   // $('#Searchresult').empty().append(new_content);
    return false;
}

/*
How this works?? 
1 we load a page result for showing categories list into pagination
2 bookList page load initpagination witch create the pagination thanks to the number of book in #nbResBook
3 nowadays item perpage is static
4 each pagination have a callback function wich load the result action categoryPaginateBook with some parametter (including decoration, min, max , and id)

*/