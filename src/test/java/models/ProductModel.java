package models;

import lombok.Data;

@Data
public class ProductModel {

    private String brand;
    private String originalPrice;
    private String discount;
    private String priceWithDiscount;
}
