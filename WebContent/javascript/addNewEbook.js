jQuery.i18n.properties({
    name:'addNewEbook',
    path:'bundle/',
    mode:'map',
  
    callback: function() {
        // We specified mode: 'both' so translated values will be
        // available as JS vars/functions and as a map

        // Accessing a simple value through the map
     //   jQuery.i18n.prop('msg_hello');
        // Accessing a value with placeholders through the map
     //   jQuery.i18n.prop('msg_complex', ['John']);
 //alert(jQuery.i18n.prop('error_form_name'));
        // Accessing a simple value through a JS variable
       // alert(jQuery.i18n.prop('msg_hello')+' '+jQuery.i18n.prop('msg_world'));
        // Accessing a value with placeholders through a JS function
        //alert( jQuery.i18n.prop('msg_complex', ['John']));
    }
});

 $(document).ready(function(){
    
/*     
    $("#new_book").validate({
   rules: {
     'b.name': "required",
     'b.nbPages': "required",
     'bookFile': {
       required: true
      
     },
     
    
     'image': "required",
     'b.description': "required"
    
   
   },
   messages: {
   	'b.name': jQuery.i18n.prop('error.form.name'),
     'b.nbPages': jQuery.i18n.prop('error_form_nbpages'),
     'bookFile': jQuery.i18n.prop('error_form_bookfile'),
     
    
     'image': jQuery.i18n.prop('error_form_image'),
     'b.description': jQuery.i18n.prop('error_form_description')
     
   }
});*/


 });
 
                
               
              
              
              