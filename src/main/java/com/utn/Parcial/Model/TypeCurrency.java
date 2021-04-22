package com.utn.Parcial.Model;

public enum TypeCurrency {

    ARS("Peso"),
    USD("Dollar"),
    EU("Euro");

    private final String description;

    TypeCurrency(String description){this.description = description;}

    public static TypeCurrency find(final String value){
        for (TypeCurrency currencies : values()){
            if (value.toString().equalsIgnoreCase(value)){
                return currencies;
            }
        }
        throw new IllegalArgumentException("Invalid argument for type Person");
    }

    public String getDescription() {
        return description;
    }
}
