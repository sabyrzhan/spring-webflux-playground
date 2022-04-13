package kz.sabyrzhan.springwebfluxplayground.routers;

import kz.sabyrzhan.springwebfluxplayground.handlers.OrderHandlers;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class OrderRouter {
    private OrderHandlers orderHandlers;

    public OrderRouter(OrderHandlers orderHandlers) {
        this.orderHandlers = orderHandlers;
    }

    @Bean
    public RouterFunction<ServerResponse> orderRoutes() {
        return RouterFunctions
                .route(RequestPredicates.GET("/api/orders"), orderHandlers::getAll)
                .andRoute(RequestPredicates.GET("/api/orders/{id}"), orderHandlers::getById)
                .andRoute(RequestPredicates.POST("/api/orders"), orderHandlers::addOrder)
                .andRoute(RequestPredicates.DELETE("/api/orders/{id}"), orderHandlers::deleteOrder);
    }
}
