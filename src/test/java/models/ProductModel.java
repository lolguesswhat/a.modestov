package models;

import lombok.Data;

import java.util.Objects;

@Data
public class ProductModel {
    private String brand;
    private String originalPrice;
    private String discount;
    private String priceWithDiscount;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        ProductModel product = (ProductModel) o;
        return (Objects.equals(this.brand, product.brand)
                && (Objects.equals(this.originalPrice, product.originalPrice))
                && (Objects.equals(this.discount, product.discount))
                && (Objects.equals(this.priceWithDiscount, product.priceWithDiscount)));
    }
}
