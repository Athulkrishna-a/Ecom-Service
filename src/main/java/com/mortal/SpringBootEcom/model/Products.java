package com.mortal.SpringBootEcom.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String name;
    private  String description;
    private  String brand;
    private  BigDecimal price;
    private  String category;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
    private  Date releaseDate;
    private  boolean productAvailable;
    private  int stockQuantity;
    private String imageName;
    private String imageType;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageData;


    public Products(int id) {
        this.id = id;
    }
}

