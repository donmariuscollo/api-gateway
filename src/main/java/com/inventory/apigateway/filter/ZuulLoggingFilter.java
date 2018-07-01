package com.inventory.apigateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ZuulLoggingFilter extends ZuulFilter{
	private Logger logger=LoggerFactory.getLogger(ZuulLoggingFilter.class);
	@Override
	public Object run() {
		HttpServletRequest request=RequestContext.getCurrentContext().getRequest();

		logger.info("request -> {} request uri",request,request.getRequestURI());
		
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 10000;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
