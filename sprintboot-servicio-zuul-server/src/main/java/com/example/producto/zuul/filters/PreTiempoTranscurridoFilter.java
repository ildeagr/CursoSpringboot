package com.example.producto.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreTiempoTranscurridoFilter extends ZuulFilter{

	private static Logger Log =LoggerFactory.getLogger(PreTiempoTranscurridoFilter.class);
	@Override
	//Es para validar si se ejecuta o no el filtro (con true lo ejecuta)
	public boolean shouldFilter() {
		return true;
	}

	@Override
	//Resuelve la logica del filtro
	public Object run() throws ZuulException {
		RequestContext ctx =RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		Log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));
		
		Long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		return null;
	}

	@Override
	//Indica el tipo de filtro pre, post o route 
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
