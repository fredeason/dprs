package com.weimai.dprs.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("crossDomainFilter")  
public class CrossDomainFilter implements Filter {  
  
    private static Logger logger = LoggerFactory.getLogger(CrossDomainFilter.class);  
  
    @Override  
    public void init(FilterConfig filterConfig) throws ServletException {  
    }  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response,  
                         FilterChain chain) throws IOException, ServletException {  
        try {  
            HttpServletRequest httpRequest = (HttpServletRequest) request;  
            HttpServletResponse httpResponse = (HttpServletResponse) response;  
  
            // 跨域  
            String origin = httpRequest.getHeader("Origin");  
            httpResponse.addHeader("Access-Control-Allow-Origin", "*");  
//            httpResponse.addHeader("Access-Control-Allow-Origin", "*");  
            httpResponse.addHeader("Access-Control-Allow-Headers",httpRequest.getHeader("Access-Control-Request-Headers"));  

            httpResponse.addHeader("Access-Control-Allow-Credentials", "true");  
            httpResponse.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,OPTIONS,DELETE");  
            if ( httpRequest.getMethod().equals("OPTIONS") ) {  
                httpResponse.setStatus(HttpServletResponse.SC_OK);  
                return;  
            }  
            chain.doFilter(request, response);  
        } catch (Exception e) {  
        	logger.error("Exception in crossDomainFilter.doFilter", e);  
        }  
    }  
    @Override  
    public void destroy() {  
    }  
}  