package com.borani.functional.function;import java.math.BigDecimal;public class PriceCalculator {    public BigDecimal calculatePrice(Product product, Integer quantity, BigDecimal discout) {        var grossPrice = product.getUnitPrice()                                .multiply(BigDecimal.valueOf(quantity));        var discountAmount = grossPrice.multiply(discout)                                        .divide(BigDecimal.valueOf(100));        return grossPrice.subtract(discountAmount);    }}class Product {    private BigDecimal unitPrice;    public Product(BigDecimal unitPrice) {        this.unitPrice = unitPrice;    }    public BigDecimal getUnitPrice() {        return unitPrice;    }}