package ar.edu.utn.parcial.futbolmanager.models.enums;

/**
 * Enum for Currency
 */
public enum Currency {

    ARS("Argentine Peso."), EUR("Euro"),
    USD("Oficial");

    private String description;

    private Currency(String description){
        this.description = description;
    }

    public static Currency valueOfDescription(String description) {
        for (Currency c : values()) {
            if (c.description.equals(description)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
