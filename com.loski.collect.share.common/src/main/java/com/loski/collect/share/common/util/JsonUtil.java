package com.loski.collect.share.common.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 *
 * Json工具类
 * 〈功能详细描述〉
 *
 * @author liguitian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class JsonUtil
{

    public static void sendSuccessMsg(final HttpServletResponse response, String msg, Object obj)
    {
    	JSONObject json = new JSONObject();
    	json.put("success", true);
    	json.put("msg", msg);
    	json.put("result", obj);
        renderObj(response, json);
    }
    
    public static void sendFailMsg(final HttpServletResponse response, String msg, Object obj)
    {
    	JSONObject json = new JSONObject();
    	json.put("success", false);
    	json.put("msg", msg);
    	json.put("result", obj);
        renderObj(response, json);
    }

    public static void renderObj(final HttpServletResponse response,
            final Object object)
    {
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        try
        {
            response.getWriter().print(object);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
