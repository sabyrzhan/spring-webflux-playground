package kz.sabyrzhan.springwebfluxplayground.repositories;

import kz.sabyrzhan.springwebfluxplayground.entities.Order;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface OrderRepository extends R2dbcRepository<Order, Long> {
}
