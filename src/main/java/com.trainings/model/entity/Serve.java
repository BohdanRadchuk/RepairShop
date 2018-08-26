package com.trainings.model.entity;

import java.math.BigDecimal;

public class Serve {
    private int idServe;
    private String typeEn;
    private String typeUa;
    private String descriptionEn;
    private String descriptionUa;
    private BigDecimal price;

    private Serve(int idServe, String typeEn, String typeUa, String descriptionEn, String descriptionUa, BigDecimal price) {
        this.idServe = idServe;
        this.typeEn = typeEn;
        this.typeUa = typeUa;
        this.descriptionEn = descriptionEn;
        this.descriptionUa = descriptionUa;
        this.price = price;
    }

    public int getIdServe() {
        return idServe;
    }

    public String getTypeEn() {
        return typeEn;
    }

    public String getTypeUa() {
        return typeUa;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public String getDescriptionUa() {
        return descriptionUa;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static class ServeBuilder {
        private int nestedIdServe;
        private String nestedTypeEn;
        private String nestedTypeUa;
        private String nestedDescriptionEn;
        private String nestedDescriptionUa;
        private BigDecimal nestedPrice;

        public ServeBuilder() {
        }

        public ServeBuilder idServe(int idServe) {
            this.nestedIdServe = idServe;
            return this;
        }

        public ServeBuilder typeEn(String nestedTypeEn) {
            this.nestedTypeEn = nestedTypeEn;
            return this;
        }

        public ServeBuilder typeUa(String nestedTypeUa) {
            this.nestedTypeUa = nestedTypeUa;
            return this;
        }

        public ServeBuilder descriptionEn(String nestedDescriptionEn) {
            this.nestedDescriptionEn = nestedDescriptionEn;
            return this;
        }

        public ServeBuilder descriptionUa(String nestedDescriptionUa) {
            this.nestedDescriptionUa = nestedDescriptionUa;
            return this;
        }

        public ServeBuilder price(BigDecimal price) {
            this.nestedPrice = price;
            return this;
        }

        public Serve build(){
            return new Serve(nestedIdServe, nestedTypeEn, nestedTypeUa, nestedDescriptionEn, nestedDescriptionUa, nestedPrice);
        }
    }

    @Override
    public String toString() {
        return "Serve{" +
                "idServe=" + idServe +
                ", typeEn='" + typeEn + '\'' +
                ", typeUa='" + typeUa + '\'' +
                ", descriptionEn='" + descriptionEn + '\'' +
                ", descriptionUa='" + descriptionUa + '\'' +
                ", price=" + price +
                '}';
    }
}
