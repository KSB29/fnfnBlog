package com.fnfn.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * 클래스명: <code>LoggerInterceptor</code><br>
 *
 * 각 요청의 시작과 끝을 보여주는 로그 출력
 *
 * @author fnfnk
 * @since 2020. 4. 24.
 *
 */
@Slf4j
public class LoggerInterceptor extends HandlerInterceptorAdapter {


    /**
     * controller 실행 전 수행
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.debug("=================================START=================================");
        log.debug(" Request URI \t: " + request.getRequestURI());

        return super.preHandle(request, response, handler);
    }

    /**
     * controller 정상 실행 후 수행
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        log.debug("==================================END==================================\n");
    }
}
