package hu.baksa.trading.store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "product_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private float price;

}
