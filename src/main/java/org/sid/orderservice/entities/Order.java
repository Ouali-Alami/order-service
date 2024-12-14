package org.sid.orderservice.entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.orderservice.enums.OrderStatus;
import org.sid.orderservice.model.Customer;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private OrderStatus status;
    private Long customerId;
    @Transient
    private Customer customer; // usually handled by DTO
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;
    @JsonGetter("total")
    public double geTotal(){
        double total = 0;
        for (ProductItem productItem : productItems) {
            total += productItem.getAmount()  ;
        }
        return total;
    }

}
