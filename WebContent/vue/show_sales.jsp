<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="css/jqueryui/start/jquery.ui.all.css">

	<script src="js/jqueryui/datepicker/jquery.ui.core.js"></script>
	<script src="js/jqueryui/datepicker/jquery.ui.widget.js"></script>
	<script src="js/jqueryui/datepicker/jquery.ui.datepicker.js"></script>
	<script>
	$(function() {
		$( ".datepicker" ).datepicker();
		$( "#validate_submit" ).click(send_sales_period_request);
	});
	
	
	function send_sales_period_request(){
		//select right radio
		
		var radio=$("['sel_date']:checked");
		//alert(radio.val()+$("#select_period option:selected").val());
		if(radio.val()=="choice"){
			var choice = $("#select_period option:selected");
			$("#result_sales").load('showPeriodSales',{option_choice:choice.val(),my_deco:"empty_inline"} );
		}
		else{
			$("#result_sales").load('showPeriodSales',{option_choice:6,my_deco:"empty_inline",start:$("[name='start_period']").val(),end:$("[name='end_period']").val()} );
		}
		
		//$("#searchResults").load('listPaginateMyBooks',{my_deco:"empty_inline",min:(10*(page_index+1))-10,max:10} );
		//alert("ok");
	  //  var new_content = $('#hiddenresult div.result:eq('+page_index+')').clone();
	   // $('#Searchresult').empty().append(new_content);
	    return false;
	}
	
	</script>
</head>
<body>

<div id="content-area">
          <div class="border-heading-div">
            <div class="bg-heading-div">
              <div class="main-heading-div">rapports de vente</div>
              <div class="top-heading-icon"><img src="images/gestion-icon.png" width="29" height="27" alt="" border="0" class="margin-top-5" /></div>
            </div>
          </div>
          <div class="content-padd">
            <div class="content-area-border-div left">
              <div class="content-tab-cover left">
                <div class="inner-heading-cover">
                  <div class="inner-heading1">
                    <div class="inner-heading">r&eacute;sum&eacute;</div>
                  </div>
                </div>
                <div class="tab-content left">
                  <div>
                    <div class="left">total payé : <span class="blue-txt"><strong><s:property value="total_paid"/></strong></span> <br />
                      dû pour le mois : <span class="blue-txt"><strong><s:property value="total_due"/></strong></span> <br />
                      
                      <% /* 
                      
                      total livre en vente: <span class="blue-txt"><strong>01/11/2010</strong></span> <br />
                      xoxoxo xoxoxoxoxox : <span class="blue-txt"><strong>Xoxox
                      Xoxoxoxo</strong></span> <br />
                      xoxoxox xoxoxo :<span class="blue-txt"><strong> xoxox xoxox</strong></span> */%>
                      </div>
                    
                  </div>
                </div>
              </div>
              
              <div class="content-tab-cover left">
                <div class="inner-heading-cover">
                  <div class="inner-heading2">
                    <div class="inner-heading">Choisir une p&eacute;riode</div>
                  </div>
                </div>
                <div class="tab-content left">
                  <div>
                    <div class="left"><input type="radio" name="sel_date"  checked="checked" value="choice"  /> &nbsp;Periode preselectioné: 
                    <br /> <br />
                     <select name="select_period" class="validated" id="select_period" >
               
					<option value="1">Mois en cours</option>
			     	<option value="2">Hier</option>
			    	<option value="3">Semaine en cours</option>
			    	<option value="4">Semaine derni&egrave;re</option>
					<option value="5">total</option>
                      </select></div>
                    <div><img src="images/sep-back-slash.gif" alt="" border="0" align="left" class="margin-left-right40" /></div>
                    <div class="left">    <input type="radio" name="sel_date"    /> &nbsp;Periode pr&eacute;cise:    
                    <table width="300px" style="margin-top: 5px">
                    <tr>
                    	<td>
                    	&Agrave; partir de 
                    	</td>
                    	<td>
                    	<input type="text" readonly="readonly" class="datepicker" name="start_period"/>
                    	</td>
                    </tr>
                    <tr>
                    	<td>
                    	vers 
                    	</td>
                    	<td>
                    	<input type="text" readonly="readonly"  class="datepicker" name="end_period"/>
                    	</td>
                    </tr>
                     
                    
                    </table>
                    
                    </div>
                     <div style="clear:both;text-align:center; padding:30px"> <input type="button" name="validate_submit" id="validate_submit" value="valider" class="btn-blue" /></div>
                  </div>
                 
                     
                </div>
              
              </div>
              
              <div class="content-tab-cover left">
                <div class="inner-border-heading-cover">
                  <div class="inner-heading2">
                    <div class="inner-heading">tableau </div>
                    <div class="inner-heading-icon"><img src="images/cart-icon.png" alt="" width="35" height="21" border="0" class="margin-top2" /></div>
                  </div>
                  <div class="inner-heading-txt"><span class="size-txt12" style="display: none;">Xoxoxoxoxoxoxoxo xoxoxoxooxoxoxox xoxoxooxoxoxoxo</span></div>
                </div>
                <div class="tab-content left" id="result_sales">
               
        
                </div>
              </div>

            </div>
          </div>
        </div>
        <!--MAIN CONTENT AREA END-->

</body>
</html>