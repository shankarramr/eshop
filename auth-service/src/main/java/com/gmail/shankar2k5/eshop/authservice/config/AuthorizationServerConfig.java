package com.gmail.shankar2k5.eshop.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private EposClientDetailsService clientDetailsService;

    @Autowired
    private EposTokenConverter eposTokenConverter;

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
        configurer.withClientDetails(clientDetailsService);
        // LOGGER.info("zzzzzzzzzzzz: " + passwordEncoder.encode("pass1"));
        // For testing
        // configurer.inMemory().withClient("clientid").secret(passwordEncoder.encode("secret"))
        // .authorizedGrantTypes("password").scopes("read").accessTokenValiditySeconds(30).autoApprove(true);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
        endpoints.setClientDetailsService(clientDetailsService);
        endpoints.accessTokenConverter(eposTokenConverter);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer serverSecurity) {
        serverSecurity.realm("oauth2").allowFormAuthenticationForClients().checkTokenAccess("permitAll");
    }
}
