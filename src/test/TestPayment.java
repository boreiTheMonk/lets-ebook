package test;

import org.apache.struts2.StrutsTestCase;
/*
 * 
 * go checkout without login
 * go checkout with login
 * 	-go checkout with book not approved
 * 	-go checkout with book approved
 * 	-go checkout when book already ordered
 * 	-go checkout twice in a row, but second time book changed and not approved
 * 
 * pay without login : case very annoying => try to check if receive a transaction ok, then force connect with order_id
 * pay with login
 * 	-go twice checkout, but second time book changed (all data): data update without trouble
 *  -go checkout and before pay, member update his book. so in order to prevent that, we update each time the new data and the payment only put true on treated.
 *  
 */
public class TestPayment extends StrutsTestCase {
	// create test to populate database
	
	
	
	public void populate(){
		/* create 3 members
		* one who want to buy
		* 
		*
		*/
		
	}
	
	
}
