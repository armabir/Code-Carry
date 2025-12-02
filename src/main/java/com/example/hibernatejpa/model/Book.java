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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToMany(mappedBy = "bookList")
    private List<Author> authorList;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "publisher_city")),
            @AttributeOverride(name = "state", column = @Column(name = "publisher_state")),
            @AttributeOverride(name = "country", column = @Column(name = "publisher_country"))
    })
    private Address publisherAddress;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "isbn_id")
    private ISBNRegistration isbnRegistration;
}
