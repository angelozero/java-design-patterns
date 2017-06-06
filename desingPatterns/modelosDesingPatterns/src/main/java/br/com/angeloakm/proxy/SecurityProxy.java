package br.com.angeloakm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SecurityProxy implements InvocationHandler {

	private Object obj;

	private SecurityProxy(Object obj) {
		this.obj = obj;
	}

	public static Object newInstance(Object obj) {
		return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				new SecurityProxy(obj));
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Object result;

		try {

			if (method.getName().contains("post")) {
					throw new RuntimeException("Post não é permitido !");
			} else {
				result = method.invoke(obj, args);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro aqui: " + e.getMessage());
		}

		return result;
	}

}
