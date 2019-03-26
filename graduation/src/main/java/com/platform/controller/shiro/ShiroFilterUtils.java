package com.platform.controller.shiro;

import com.platform.model.vm.ApiResult;
import com.platform.utils.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;

public class ShiroFilterUtils {
    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 是否是Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(ServletRequest request){
        return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
    }

    /**
     * response 输出JSON
     */
    public static void out(ServletResponse response, ApiResult result){

        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            out.println(GsonUtil.objectToJson(result));
        } catch (Exception e) {
            System.out.print("输出JSON报错:"+e);
        }finally{
            if(null != out){
                out.flush();
                out.close();
            }
        }
    }
}
