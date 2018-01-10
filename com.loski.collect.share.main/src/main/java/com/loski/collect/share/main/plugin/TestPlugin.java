package com.loski.collect.share.main.plugin;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts(@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
public class TestPlugin implements Interceptor{
	
	private String name;

	public Object intercept(Invocation invocation) throws Throwable {
		
		System.out.println( name + "进入拦截器");
		
		return invocation.proceed();
	}

	public Object plugin(Object target) {
        return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		
		String name = properties.getProperty("name");
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
