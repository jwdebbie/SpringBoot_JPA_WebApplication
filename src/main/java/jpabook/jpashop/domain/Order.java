package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter

public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;  // Member.java에서 mapped by member의 그 멤버

    private List<OrderItem> orderItems = new ArrayList<>();

    private Delivery delivery;

    private LocalDateTime orderDate;

    private OrderStatus status; //주문상태 [ORDER, CANCEL]


}
