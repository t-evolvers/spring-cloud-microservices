package com.te.productservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "tbl_products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;
    private String description;

    @Positive
    private Double price;

    @Positive
    private int stock;
    private String status;

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name="categorie_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Categorie categorie;

}
