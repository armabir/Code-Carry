package com.example.hibernatejpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "customer_city")),
            @AttributeOverride(name = "state", column = @Column(name = "customer_state")),
            @AttributeOverride(name = "country", column = @Column(name = "customer_country"))
    })
    private Address customerAddress;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<Order> orderList;

    @Embedded
    private TravelDocument travelDocument;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Booking> bookingList;

}
