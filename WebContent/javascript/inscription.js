jQuery.i18n.properties({
    name:'inscription',
    path:'bundle/',
    mode:'map',
    language:'pt_PT',
    callback: function() {
        // We specified mode: 'both' so translated values will be
        // available as JS vars/functions and as a map

        // Accessing a simple value through the map
        jQuery.i18n.prop('msg_hello');
        // Accessing a value with placeholders through the map
        jQuery.i18n.prop('msg_complex', ['John']);
 alert(jQuery.i18n.prop('error.form_name'));
        // Accessing a simple value through a JS variable
       // alert(jQuery.i18n.prop('msg_hello')+' '+jQuery.i18n.prop('msg_world'));
        // Accessing a value with placeholders through a JS function
        //alert( jQuery.i18n.prop('msg_complex', ['John']));
    }
});

 $(document).ready(function(){
     alert(jQuery.i18n.prop('error_form_name'));
     
    $("#register_form").validate({
   rules: {
     'm.nom': "required",
     'm.prenom': "required",
     'm.email': {
       required: true,
       email: true
     },
     
     'emailConfirm': {
         equalTo: "#email"
       
       
      
     },
     'm.login': "required",
     'm.password': "required",
    'passwordConfirm': "required"
   
   },
   messages: {
     'm.nom': jQuery.i18n.prop('error.form.name'),
     'm.email': {
       required: jQuery.i18n.prop('error_form_mail'),
       email: jQuery.i18n.prop('error_form_mail_bad')
     }

   }
});


 });

