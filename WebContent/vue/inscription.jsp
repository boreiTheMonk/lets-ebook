<?//xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>let's inscription</title>
          <link rel="stylesheet" media="screen" type="text/css" href="<s:url value="/css/inscription.css"/>" />
  <script type="text/javascript" src="javascript/jquery.validate.js"></script>
<script type="text/javascript" src="javascript/jquery.i18n.properties-1.0.4.js"></script>
  <script type="text/javascript" src="javascript/inscription.js"></script>
    </head>
    <body>
        <div class="titlepage">Lets inscription</div>

        <s:form action="save_register" id="register_form" method="POST" theme="simple" >
       <label for="m.nom">nom :</label>
       <s:textfield name="m.nom" label="nom"/>
        <label for="m.prenom">prenom :</label>
       <s:textfield name="m.prenom" label="prenom" />
        <label for="m.email">Votre email :</label>
       <s:textfield id="m.email" name="m.email" label="email"/>
        <label for="emailConfirm">confirmation email :</label>
       <s:textfield name="emailConfirm" label="confirmation"/>
        <label for="m.login">login :</label>
       <s:textfield name="m.login" label="login"/>
        <label for="m.password">pass :</label>
       <s:textfield name="m.password" label="mot de passe"/>
        <label for="passwordConfirm">pass confirm :</label>
       <s:textfield name="passwordConfirm" label="confirmation"/>
       <s:select name="pays" list="{'france','angleterre','espagne','us'}" theme="simple" />
       <s:submit  value="valider" /> 
       
       </s:form>
       <!-- <form action="save_register">
       <table style="border:solid">
        
            <tr >
                 <td>
                    	nom:
                </td>
                <td>
                    <input type="text" name="m.nom" id="" />
                </td>

            </tr>
             <tr >
                 <td>
                    	prenom:
                </td>
                <td>
                    <input type="text" name="m.prenom" id="" />
                </td>

            </tr>
            
             <tr >
                 <td>
                    	@mail:
                </td>
                <td>
                    <input type="text" name="m.email" id="" />
                </td>

            </tr>
             <tr >
                 <td>
                    	login:
                </td>
                <td>
                    <input type="text" name="m.login" id="" />
                </td>

            </tr>
                      <tr >
                 <td>
                    	mot de passe:
                </td>
                <td>
                    <input type="text" name="m.password" id="" />
                </td>

            </tr>
                      <tr >
                 <td>
                    	confirmation du mot de passe:
                </td>
                <td>
                    <input type="password" name="m.password" id="" />
                </td>

            </tr> --> 
                    <!-- <tr >
                 <td>
                    	avatar:
                </td>
                <td>
                    <input type="file" name="" id="" />
                </td>

            </tr>
    -->
               <!--   <tr >
                <td>
                    	pays:
                </td>
                <td>
                    <select><option>france</option></select>
                </td>

            </tr>
                    <tr >
                      <td>
                        <input type="submit" name="button" id="button" value="valider" />
                     </td>
                      <td>
                        <input type="button" name="button2" id="button2" value="revenir" />
                      </td>
                    </tr>
        </table>
        </form>--> 
        
            </body>
</html>

