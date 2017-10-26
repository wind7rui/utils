package com.wind.util.net;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.google.common.base.Splitter.on;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.FluentIterable.from;
import static java.util.Arrays.asList;
import static org.apache.commons.lang.ArrayUtils.isNotEmpty;

/**
 * 从请求中获取用户的ip、user-agent、Cookie、host
 *
 * @author wind
 * @since 2016/6/11
 */
public class WebUtils {

    /**
     * 获得用户的IP地址
     * 首先从X-Forwarded-For里获取,如果取不到然后从X-Real-IP获取,实在取不到,最后取socketAddress
     *
     * @param request HttpServletRequest
     * @return 客户端请求ip地址
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");//clientIp,proxy1Ip,proxy2Ip...
        if (isIp(ip)) {
            //多次反向代理后会有多个ip值,这里相信用户没有篡改X-Forwarded-For,直接取第一位clientIp.
            List<String> ips = on(",").splitToList(ip);
            if (!ips.isEmpty()) {
                return ips.get(0);
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (isIp(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    private static boolean isIp(String ip) {
        return !Strings.isNullOrEmpty(ip) && !"unknown".equalsIgnoreCase(ip);
    }


    public static String getUserAgent(HttpServletRequest request) {
        return request.getHeader("user-agent");
    }


    public static String getCookieValue(HttpServletRequest request, final String key) {
        Cookie cookies[] = request.getCookies();
        if (isNullOrEmpty(key) || !isNotEmpty(cookies)) {
            return null;
        }
        Optional<Cookie> cookie = from(asList(cookies)).firstMatch(new Predicate<Cookie>() {
            @Override
            public boolean apply(Cookie input) {
                return key.equals(input.getName());
            }
        });
        if (cookie.isPresent()) {
            return cookie.get().getValue();
        }
        return null;
    }


    public static String getHost(HttpServletRequest request) {
        return StringUtils.substringBefore(request.getRequestURL().toString(), request.getRequestURI());
    }

    public static String getHostAndApplicationName(HttpServletRequest request) {
        return getHost(request) + request.getContextPath();
    }

    public static String getHttpsHost(HttpServletRequest request) {
        if ("http".equalsIgnoreCase(request.getScheme())) {
            return "https://" + StringUtils.substringAfter(getHost(request), "http://");
        }
        return getHost(request);
    }
}
