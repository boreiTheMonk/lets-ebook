// JavaScript Document
/*$.fn.copyTo = function(to) {
    var to = $(to);
    for ( var i = 1; i < arguments.length; i++ )
        to.set( arguments[i], this.getter(0)[ arguments[i] ] );
    return this;
};
*/
new function() {
       // $.fn.validate = validate() {};
    $.fn.validate = {
        init: function(o) {
			if(o.name == 'xoxo1') { this.xoxo1(o) };
			if(o.name == 'xoxo2') { this.xoxo2(o) };
			if(o.name == 'xoxo3') { this.xoxo3(o) };
			if(o.name == 'xoxo4') { this.xoxo4(o) };
			if(o.name == 'xoxo5') { this.xoxo5(o) };
			if(o.name == 'xoxo6') { this.xoxo6(o) };
			if(o.name == 'xoxo7') { this.xoxo7(o) };
			if(o.name == 'xoxo8') { this.xoxo8(o) };
			if(o.name == 'xoxo9') { this.xoxo9(o) };
			if(o.name == 'xoxoDate') { this.xoxoDate(o) };
			
			if(o.name == 'textArea1') { this.textArea1(o) };
			if(o.name == 'textArea2') { this.textArea2(o) };
			
			if(o.name == 'Double1') { this.Double1(o) };
			if(o.name == 'double1xoxo') { this.double1xoxo(o) };
			if(o.name == 'Double2') { this.Double2(o) };
			if(o.name == 'double2xoxo') { this.double2xoxo(o) };
			
			if(o.name == 'xoxoFile1') { this.xoxoFile1(o) };
			if(o.name == 'xoxoFile2') { this.xoxoFile2(o) };
			if(o.name == 'xoxoFile3') { this.xoxoFile3(o) };
			
			if(o.name == 'officeItemList1') { this.officeItemList1(o) };
			if(o.name == 'officeItemList2') { this.officeItemList2(o) };
			if(o.name == 'officeItemList3') { this.officeItemList3(o) };
			
			if(o.name == 'xoxoEmail') { this.xoxoEmail(o) };
			if(o.name == 'choix') { this.choix(o) };
			
		},
        xoxo1: function(o) {
          var user = /[(\*\(\)\[\]\+\.\,\/\?\:\;\'\"\`\~\\#\$\%\^\&\<\>)+]/;
           if (!o.value.match(user)) {
             doValidate(o);
            } else {
             doError(o,'no special characters allowed');
            };
        },
		 xoxo2: function(o) {
          var user = /[(\*\(\)\[\]\+\.\,\/\?\:\;\'\"\`\~\\#\$\%\^\&\<\>)+]/;
           if (!o.value.match(user)) {
             doValidate(o);
            } else {
             doError(o,'no special characters allowed');
            };
        },
		 xoxo3: function(o) {
          var user = /[(\*\(\)\[\]\+\.\,\/\?\:\;\'\"\`\~\\#\$\%\^\&\<\>)+]/;
           if (!o.value.match(user)) {
             doValidate(o);
            } else {
             doError(o,'no special characters allowed');
            };
        },
		 xoxo4: function(o) {
          var user = /[(\*\(\)\[\]\+\.\,\/\?\:\;\'\"\`\~\\#\$\%\^\&\<\>)+]/;
           if (!o.value.match(user)) {
             doValidate(o);
            } else {
             doError(o,'no special characters allowed');
            };
        },
		 xoxo5: function(o) {
          var user = /[(\*\(\)\[\]\+\.\,\/\?\:\;\'\"\`\~\\#\$\%\^\&\<\>)+]/;
           if (!o.value.match(user)) {
             doValidate(o);
            } else {
             doError(o,'no special characters allowed');
            };
        }
		,
		 xoxo6: function(o) {
          var user = /[(\*\(\)\[\]\+\.\,\/\?\:\;\'\"\`\~\\#\$\%\^\&\<\>)+]/;
           if (!o.value.match(user)) {
             doValidate(o);
            } else {
             doError(o,'no special characters allowed');
            };
        }
		,
		 xoxo7: function(o) {
          var user = /[(\*\(\)\[\]\+\.\,\/\?\:\;\'\"\`\~\\#\$\%\^\&\<\>)+]/;
           if (!o.value.match(user)) {
             doValidate(o);
            } else {
             doError(o,'no special characters allowed');
            };
        }
		,
		 xoxo8: function(o) {
          var user = /[(\*\(\)\[\]\+\.\,\/\?\:\;\'\"\`\~\\#\$\%\^\&\<\>)+]/;
           if (!o.value.match(user)) {
             doValidate(o);
            } else {
             doError(o,'no special characters allowed');
            };
        }
		,
		 xoxo9: function(o) {
          var user = /[(\*\(\)\[\]\+\.\,\/\?\:\;\'\"\`\~\\#\$\%\^\&\<\>)+]/;
           if (!o.value.match(user)) {
             doValidate(o);
            } else {
             doError(o,'no special characters allowed');
            };
        }
		,
		 xoxoDate: function(o) {
			if(o.value != '') {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
         }
		 ,
		 textArea1: function(o) {
             if(o.val().length < 1) {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
         },
		 textArea2: function(o) {
             if(o.val().length < 1) {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
         }
		 ,
		 Double1: function(o) {
             if(o.value != '') {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
         }
		 ,
		 double1xoxo: function(o) {
             if(o.value != '') {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
         }
		 ,
		 Double2: function(o) {
             if(o.value != '') {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
         }
		 ,
		 double2xoxo: function(o) {
             if(o.value != '') {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
         }
		,
		 xoxoFile1: function(o) {
             if(o.value != '') {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
         }
		 ,
		 xoxoFile2: function(o) {
             if(o.value != '') {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
         }
		 ,
		 xoxoFile3: function(o) {
             if(o.value != '') {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
         }
		 ,
		 officeItemList1: function(o) {
            if(o.value != '') {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
         }
		 ,
		 officeItemList2: function(o) {
            if(o.value != '') {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
         }
		 ,
		 officeItemList3: function(o) {
             if(o.value != '') {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
         }
		 ,
        xoxoEmail: function(o) {
          var email  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
           if (o.value.match(email)) {
              doSuccess(o);
            } else {
              doError(o,'not a valid email');
            };
        },
		 choix: function(o) {
             if(o.value != '') {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
         }
			
/*        password: function(o) {
          var pass = /[(\*\(\)\[\]\+\.\,\/\?\:\;\'\"\`\~\\#\$\%\^\&\<\>)+]/;
           if (!o.value.match(pass)) {
             doValidate(o);
            } else {
             doError(o,'no special characters allowed');
            };
        },
        email: function(o) {
          var email  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
           if (o.value.match(email)) {
              doSuccess(o);
            } else {
              doError(o,'not a valid email');
            };
        },
        dob: function(o) {
          var dob  = /(0[1-9]|1[012])+\/(0[1-9]|[12][0-9]|3[01])+\/(19|20)\d\d/;
            if (o.value.match(dob)) {
              doSuccess(o);
            } else {
              doError(o,'not a valid date');
            };
        }*/
     };

     function doSuccess(o) {
              $('#' + o.id + '_img').html('<img src="images/accept.gif" border="0" style="float:left;" />');
              $('#' + o.id + '_li').removeClass("error");
              $('#' + o.id + '_msg').html("");
              $('#' + o.id + '_li').addClass("success");
     }

     function doError(o,m) {
              $('#' + o.id + '_img').html('<img src="images/exclamation.gif" border="0" style="float:left;" />');
              $('#' + o.id + '_li').addClass("error");
              $('#' + o.id + '_msg').html(m);
              $('#' + o.id + '_li').removeClass("success");
     }
     //private helper, validates each type after check
     function doValidate(o) {
        	$('#' + o.id + '_img').html('<img src="images/loading.gif" border="0" style="float:left;" />');
			
			if(o.value != '') {
				doSuccess(o);
			} else {
				doError(o,'You can not leave this field empty');
			}
    };

};
$.fn.match = function(m) {
	$('#' + this.get(0).id + '_img').html('<img src="images/loading.gif" border="0" style="float:left;" />');
	if ($(this).get(0).val() == $(m.match).val()) {
          $('#' + this.get(0).id + '_img').html('<img src="images/accept.gif" border="0" style="float:left;" />');
          $(m.error).removeClass("error");
          $(m.error).addClass("success");
          $('#' + this.get(0).id + '_msg').html("");
        } else {
          $('#' + this.get(0).id + '_img').html('<img src="images/exclamation.gif" border="0" style="float:left;" />');
          $(m.error).addClass("error");
          $(m.error).removeClass("success");
          $('#' + this.get(0).id + '_msg').html("The passwords don't match, please try again");
        };
};
/*$(document).ready(function()
{

  $("//[@class=validated]/input").blur(function() {
          $(this).validate.init(this);
  });
  $(".form li").mouseover(function() {
          $(this).addClass("selected");
  });
  $(".form li").mouseout(function() {
          $(this).removeClass("selected");
  });

});*/