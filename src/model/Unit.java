package model;

/**
 *
 * Unit.java
 *
 * Author: Ephraim Becker
 *
 * Defines the units for the combo box
 */
public enum Unit {

    NONE("Select unit", MeasurementType.NONE),
    // Volume
    TEASPOON("tsp", MeasurementType.VOLUME),
    TABLESPOON("tbsp", MeasurementType.VOLUME),
    CUP("cup", MeasurementType.VOLUME),
    MILLILITER("ml", MeasurementType.VOLUME),
    LITER("l", MeasurementType.VOLUME),
    // Weight
    GRAM("g", MeasurementType.WEIGHT),
    KILOGRAM("kg", MeasurementType.WEIGHT),
    OUNCE("oz", MeasurementType.WEIGHT),
    POUND("lb", MeasurementType.WEIGHT),
    // Count
    PIECE("piece", MeasurementType.COUNT),
    CLOVE("clove", MeasurementType.COUNT),
    SLICE("slice", MeasurementType.COUNT);

    private final String abbreviation;
    private final MeasurementType type;

    Unit(String abbreviation, MeasurementType type) {
        this.abbreviation = abbreviation;
        this.type = type;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public MeasurementType getType() {
        return type;
    }

    @Override
    public String toString() {
        return abbreviation;
    }
}
