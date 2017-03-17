package us.flexion.challenge.coding.developer.triangle_classifier.shape;

public enum TriangleClassificationEnum {

    EQUILATERAL("equilateral", 3), ISOCSCELES("isosceles", 2), SCALENE(
            "scalene", 0), NOT_A_TRIANGLE("not a triangle", null);

    private final String classification;
    private final Integer numberOfEqualSides;

    private TriangleClassificationEnum(String classification,
            Integer numberOfEqualSides) {
        
        this.classification = classification;
        this.numberOfEqualSides = numberOfEqualSides;
    }

    public String getClassification() {
        
        return this.classification;
    }

    public Integer getNumberOfEqualSides() {
        
        return this.numberOfEqualSides;
    }
}
