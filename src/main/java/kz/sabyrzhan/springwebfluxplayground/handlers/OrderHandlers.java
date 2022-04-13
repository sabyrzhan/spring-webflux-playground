package kz.sabyrzhan.springwebfluxplayground.handlers;

import kz.sabyrzhan.springwebfluxplayground.entities.Order;
import kz.sabyrzhan.springwebfluxplayground.repositories.OrderRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class OrderHandlers {
    private OrderRepository orderRepository;

    public OrderHandlers(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderRepository.findAll(), Order.class);
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        long id = Long.parseLong(request.pathVariable("id"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderRepository.findById(id), Order.class);
    }

    public Mono<ServerResponse> addOrder(ServerRequest request) {
        var newOrder = request.bodyToMono(Order.class);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(newOrder.flatMap(order ->  orderRepository.save(order)), Order.class);
    }

    public Mono<ServerResponse> deleteOrder(ServerRequest request) {
        long id = Long.parseLong(request.pathVariable("id"));
        return orderRepository.deleteById(id)
                .flatMap(v -> ServerResponse.noContent().build());
    }
}
