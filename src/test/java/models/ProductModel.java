package models;

import lombok.Data;

import java.util.Objects;

@Data
public class ProductModel {
    private String brand;
    private String originalPrice;
    private String discount;
    private String priceWithDiscount;
}
