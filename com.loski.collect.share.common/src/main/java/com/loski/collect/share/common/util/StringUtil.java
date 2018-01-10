package com.loski.collect.share.common.util;

/**
 *
 * 字符串公共处理类<br>
 *
 * @author zhouyaoli
 * @see StringUtil
 * @since 1.0.0
 */
public final class StringUtil
{
    
    private StringUtil()
    {
    }
    
    /**
     *
     *判断字符串是否为空<br>
     *
     * @author zhouyaoli <br>
     *		   2016年4月24日
     * @update
     * @param str 字符串
     * @return  Boolean 为空时返回true
     * @see StringUtil#isEmpty(final String str)
     * @since 1.0.0
     */
    public static boolean isEmpty(final String str)
    {
        return null == str || str.trim().isEmpty();
    }
    
    /**
     *
     *判断字符串是否为空<br>
     *
     * @author zhouyaoli <br>
     *         2016年4月24日
     * @update
     * @param str 字符串
     * @return  Boolean 为空时返回true
     * @see StringUtil#isEmpty(final String str)
     * @since 1.0.0
     */
    public static boolean isNotEmpty(final String str)
    {
        return null != str && !str.trim().isEmpty();
    }
    
    /**
     *
     *对象转化为字符串
     *为空时转化为"" 转化失败时返回""<br>
     *
     * @author zhouyaoli <br>
     *		   2016年4月27日
     * @update
     * @param obj    Object
     * @return  String
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public static String objToString(final Object obj)
    {
        if (null == obj)
        {
            return "";
        }
        return String.valueOf(obj);
        
    }
    
    /**
     *
     *对象转换为整形
     *  对象为空时 转化为0、转化失败时抛出异常信息<br>
     *
     * @author  zhouyaoli <br>
     *         2016年4月27日
     * @update
     * @param obj Object
     * @return  int 对象为空时 、转化失败时抛出异常信息
     * @exception  NumberFormatException 对象为空时 、转化失败时抛出异常信息
     * @see   StringUtil#objToInt(Object)
     * @since 1.0.0
     */
    public static Integer objToInt(final Object obj)
            throws NumberFormatException
    {
        if (null == obj)
        {
            return Integer.valueOf("0");
        }
        if (obj instanceof java.lang.String)
        {
            if (obj.toString().isEmpty())
            {
                return Integer.valueOf("0");
            }
        }
        return Integer.valueOf(obj.toString());
        
    }
    
}
