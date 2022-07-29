package org.pengfu.filter;

import org.apache.commons.lang3.StringUtils;
import org.pengfu.config.SwaggerProvider;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/28 22:15
 */
@Component
public class SwaggerHeaderFilter extends AbstractGatewayFilterFactory<Object> {

    private static final String HEADER_NAME = "X-Forwarded-Prefix";

    /**
     * 设置各服务接口的 basePath
     */
    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();
            if (!StringUtils.endsWithIgnoreCase(path, SwaggerProvider.API_URI)) {
                return chain.filter(exchange);
            }

            String basePath = path.substring(0, path.lastIndexOf(SwaggerProvider.API_URI));

            ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();
            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
            return chain.filter(newExchange);

        };
    }

}
