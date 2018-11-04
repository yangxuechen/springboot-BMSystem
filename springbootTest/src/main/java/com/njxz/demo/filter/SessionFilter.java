//package com.njxz.demo.filter;
//
//import org.springframework.core.annotation.Order;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;

/**
 * 问题：使用拦截器导致静态资源无法加载
 */
//@Order(1)
//@WebFilter(filterName = "sessionFilter",urlPatterns = "/*")
//public class SessionFilter implements Filter {
//
//    //不需要登录就可以访问的路径(注册登录以及用户名验证)
//    String[] includeUrls = {"/index","/adminLogin","/","https://rsms.me/inter/inter-ui.css","/getDepts","http://localhost:8080/","/userLogin","/isUserExist","/adminLoginPage","/isAdminExist"};
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request=(HttpServletRequest) servletRequest;
//        HttpServletResponse response=(HttpServletResponse) servletResponse;
//        HttpSession session=request.getSession(false);
//
//        String uri=request.getRequestURI();
//        boolean res=isNeedFilter(uri);
//        if(!res){
//            chain.doFilter(servletRequest,servletResponse);//不需要过滤传给下一个过滤器
//            return ;
//        }else{  //需要过滤
//            if(session!=null){
//                chain.doFilter(servletRequest,servletResponse);
//                return ;
//            }else{
//                response.sendRedirect("http://localhost:8080");//重定向到首页
//            }
//            return ;
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//    /**
//     * 判断是否需要过滤
//     * @param uri
//     * @return
//     */
//    public boolean isNeedFilter(String uri){
//        for(String s:includeUrls){
//            if(s.equals(uri)){
//                return false;
//            }
//        }
//        return true;
//    }
//}
