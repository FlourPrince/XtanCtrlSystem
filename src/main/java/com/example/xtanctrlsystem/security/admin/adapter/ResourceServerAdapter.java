package com.example.xtanctrlsystem.security.admin.adapter;

import com.example.xtanctrlsystem.security.common.adapter.DefaultAuthConfigAdapter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author panswa
 * @date 2022/3/28 14:57
 */
@Component
public class ResourceServerAdapter extends DefaultAuthConfigAdapter {
    public static final List<String> EXCLUDE_PATH = Arrays.asList(
            "/webjars/**",
            "/swagger/**",
            "/v2/api-docs",
            "/doc.html",
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/captcha/**",
            "/adminLogin");

    @Override
    public List<String> excludePathPatterns() {
        return EXCLUDE_PATH;
    }
}
