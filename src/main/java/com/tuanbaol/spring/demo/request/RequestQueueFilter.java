package com.tuanbaol.spring.demo.request;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.concurrent.Semaphore;
@WebFilter("/req/*")
public class RequestQueueFilter extends GenericFilter {
    public final static int REQUEST_PERMITS = 1;
    private Semaphore semaphore = new Semaphore(REQUEST_PERMITS, true);

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("init RequestQueueFilter...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            System.out.println("waiting num: " + semaphore.getQueueLength());
            semaphore.acquire();
            chain.doFilter(request, response);
            Thread.sleep(1000L);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
