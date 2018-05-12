package test.action;

import org.apache.struts2.StrutsTestCase;

import action.register.Register;

import com.opensymphony.xwork2.ActionProxy;

public class TestBuyAction  extends StrutsTestCase{
	
    public void testUserNameErrorMessage() throws Exception {
    //	request.setParameter("accountBean.userName", "Bruc");
    //	request.setParameter("accountBean.password", "test");

    	ActionProxy proxy = getActionProxy("/show_inscription");

    	Register accountAction = (Register) proxy.getAction();

        proxy.execute();

        assertTrue("Problem There were no errors present in fieldErrors but there should have been one error present", accountAction.getFieldErrors().size() == 1);
		assertTrue("Problem field account.userName not present in fieldErrors but it should have been",
				accountAction.getFieldErrors().containsKey("accountBean.userName") );

    }

    public void testUserNameCorrect() throws Exception {

    //	request.setParameter("accountBean.userName", "Bruce");
    //	request.setParameter("accountBean.password", "test");

    	

    	ActionProxy proxy = getActionProxy("/show_inscription");

    	Register accountAction = (Register) proxy.getAction();

        String result = proxy.execute();

        assertTrue("Problem There were errors present in fieldErrors but there should not have been any errors present", accountAction.getFieldErrors().size() == 0);
        assertEquals("Result returned form executing the action was not success but it should have been.", "success", result);

    }
	
	/*private Dispatcher dispatcher;
	protected ActionProxy proxy;
	protected static MockServletContext servletContext;
	protected static MockServletConfig servletConfig;
	protected HttpServletRequest request;
	protected HashMap requestParameters = new HashMap();
	protected HttpServletResponse response;


	public void testCollection() {
		Collection collection = new ArrayList();
		assertTrue(collection.isEmpty());
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuyEbook action = new BuyEbook();
		view.setRecipeService(new FakeRecipeService());
		Recipe recipe = new Recipe();
		recipe.setId(1);
		view.setRecipe(recipe);
		String result = view.execute();

	}
	
	private MockActionInvocation setupInvocation(
			final String param,
			final String val) {
			Map<String, Object> params =new HashMap<String, Object>() {
				{put(param, new String[] { val });
				}
			};
			
			
			
			MockActionInvocation i = new MockActionInvocation();
			ActionContext c = ActionContext.getContext();
			c.setParameters(params);
			i.setInvocationContext(c);
			return i;
			}
	
	@SuppressWarnings("unchecked")
	protected T createAction(Class clazz, String namespace, String name)
	throws Exception {
	dispatcher = StrutsTestCaseHelper.initDispatcher(null);
	// dispatcher = Dispatcher.getInstance();
	proxy = dispatcher.getContainer().getInstance(ActionProxyFactory.class)
	.createActionProxy(namespace, name, null, true, false);
	proxy.getInvocation().getInvocationContext().setParameters(
	requestParameters);

	// do not execute the result after executing the action
	proxy.setExecuteResult(true);

	// set the actions context to the one which the proxy is using
	ServletActionContext.setContext(proxy.getInvocation()
	.getInvocationContext());
	ServletActionContext.setRequest(request);
	ServletActionContext.setResponse(response);
	ServletActionContext.setServletContext(servletContext);
	return (T) proxy.getAction();
	}*/


}
