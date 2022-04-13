package kz.sabyrzhan.springwebfluxplayground.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("orders")
@Data
public class Order {
    @Id
    @Column("id")
    private long id;

    @Column("amount")
    private int amount;

    @Column("placed_date")
    private Instant placedDate;
}
