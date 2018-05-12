<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title > creer groupe</title>
        <link rel="stylesheet" media="screen" type="text/css" title="Design" href="block.css" />
    </head>
    <body>
        <div class="titlepage">creer groupe</div>
        <div id="wrapform">
        <form action="insert_group">
         <table>
            
            <tbody>
            <tr >
                 <td>
                    	nom 
                </td>
                <td>
                     <s:textfield  name="g.name" id="" />
                </td>

            </tr>
             <tr >
                 <td>
                    	theme
                </td>
                <td>
                      <s:select name="theme_id" list="themes"  />
                </td>

            </tr>
            <tr >
                 <td>
                    	description
                </td>
                <td>
                     <s:textarea name="g.description" rows="15" cols="30"></s:textarea>
                </td>

            </tr>
             <tr >
                 <td>
                    	limitation
                </td>
                <td>
                    <select  name="g.status" id="" ><option value="1">public</option><option value="2">prot&eacute;g&eacute;</option><option value="3">privé</option></select>
                </td>

            </tr>
               <tr >
                 <td>
                    	livre
                </td>
                <td>
                     <input type="file"  name="" id="" />
                </td>

            </tr>
              <tr >
                 <td>
                    	image
                </td>
                <td>
                     <input type="file"  name="" id="" />
                </td>

            </tr>
            </tbody>
            </table>

            <table><tr><td><input type="submit"  name="" id="" value="valider" /></td>
                    <td><input type="submit"  name="" id="" value="anuller"/></td></tr>
            </table>
        </form>
        </div>
    </body>
</html>
