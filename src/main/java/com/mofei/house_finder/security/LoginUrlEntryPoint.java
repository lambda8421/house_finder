package com.mofei.house_finder.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.PathMatcher;
import java.util.HashMap;
import java.util.Map;

public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint{
    private final Map<String,String> authEntryPointMap;
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    public LoginUrlEntryPoint(String loginFormUrl) {
        super(loginFormUrl);

        authEntryPointMap = new HashMap<>();

        authEntryPointMap.put("/user/**","/user/login");

        authEntryPointMap.put("/admin/**","/admin/login");

    }

    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        String uri = request.getRequestURI().replace(request.getContextPath(), "");

        for (Map.Entry<String, String> authEntry : this.authEntryPointMap.entrySet()) {
            if (this.pathMatcher.match(authEntry.getKey(), uri)) {
                return authEntry.getValue();
            }
        }
        return super.determineUrlToUseForThisRequest(request, response, exception);
    }
}
