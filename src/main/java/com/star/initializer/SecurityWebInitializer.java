package com.star.initializer;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by hp on 2017/3/4.
 * AbstractSecurityWebApplicationInitializer实现了WebApplicationInitializer，因此
 * Spring会发现它，并用它在Web容器中注册DelegatingFilterProxy
 */

public class SecurityWebInitializer
        extends AbstractSecurityWebApplicationInitializer{

}
