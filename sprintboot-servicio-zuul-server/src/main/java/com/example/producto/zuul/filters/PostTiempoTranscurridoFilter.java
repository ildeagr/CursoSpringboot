package com.example.producto.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter{

	private static Logger Log =LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);
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
		
		Log.info("Entrando a post filter");
		
		Long tiempoInicio = (Long)request.getAttribute("tiempoInicio");
		Long tiempoFinal =System.currentTimeMillis();
		Long tiempoTranscurrido =tiempoFinal - tiempoInicio;
		
		Log.info(String.format("Tiempo transcurrido en segundos %s", tiempoTranscurrido.doubleValue()/1000.00));
		Log.info(String.format("Tiempo transcurrido en milisegundos %s", tiempoTranscurrido.doubleValue()));
		
		return null;
	}

	@Override
	//Indica el tipo de filtro pre, post o route 
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
