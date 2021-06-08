package dynamicproxy;

import java.lang.reflect.Proxy;
import java.util.Map;

public class DynamicProxy {

	public static void main(String[] args) {
		Map map = (Map) Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(),
				new Class[] {Map.class},
				new DynamicInvocationHandler());
		map.put("Hello", "World");
	}

}
