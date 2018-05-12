package test.action;



import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxyFactory;
import com.opensymphony.xwork2.config.Configuration;
import com.opensymphony.xwork2.config.ConfigurationManager;
import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.mock.MockActionInvocation;
import com.opensymphony.xwork2.util.XWorkTestCaseHelper;

public class TestTrimInterceptor extends TestCase {

protected ConfigurationManager configurationManager;
protected Configuration configuration;
protected Container container;
protected ActionProxyFactory actionProxyFactory;


public void setup() throws Exception {

configurationManager = XWorkTestCaseHelper.setUp();
configuration =
configurationManager.getConfiguration();
container = configuration.getContainer();

actionProxyFactory =
	container.getInstance(ActionProxyFactory.class);
	}

public void testTrimming() {
	testTrimming("foo", " hello ", "hello");
	testTrimming("complex.nar", " hello ", "hello");
	testTrimming("simple", " hello ", " hello ");
	testTrimming("complex.foo[1]", " hello ", " hello ");
	}

private void testTrimming(final String param,
		final String val,
		final String expected) {
		MockActionInvocation i = setupInvocation(param, val);
		try {
		//trim.doIntercept(i);
		Map<String, Object> params =
		i.getInvocationContext().getParameters();
		assertTrue(params.containsKey(param));
		String newVal = ((String[]) params.get(param))[0];
		assertTrue(newVal.equals(expected));
		} catch (Exception e) {
			assertTrue(false);
			}
			}

private MockActionInvocation setupInvocation(
		final String param,
		final String val) {
		Map<String, Object> params =
		new HashMap<String, Object>() {{
		put(param, new String[] { val });
		}};
		MockActionInvocation i = new MockActionInvocation();
		ActionContext c = ActionContext.getContext();
		c.setName("show_inscription");
		//c.setParameters(params);
		i.setInvocationContext(c);
		return i;
		}


	}

