package us.flexion.challenge.coding.developer.triangle_classifier;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import us.flexion.challenge.coding.developer.triangle_classifier.exception.InvalidArguementsException;

public class TriangleClassifierTest {

    @Test
    public void testEquilateral() {

        // Assign
        double sideOne = 10;
        double sideTwo = 10;
        double sideThree = 10;

        List<Double> values = new ArrayList<Double>();
        values.add(sideOne);
        values.add(sideTwo);
        values.add(sideThree);

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        String shouldBeEquilateral = triangleClassifier
                .getTriangleClassification(values);

        // Assert
        assertTrue(shouldBeEquilateral
                .equals(TriangleClassificationEnum.EQUILATERAL
                        .getClassification()));
    }

    @Test
    public void testIsoscelesOne() {

        // Assign
        double sideOne = 8;
        double sideTwo = 10;
        double sideThree = 10;

        List<Double> values = new ArrayList<Double>();
        values.add(sideOne);
        values.add(sideTwo);
        values.add(sideThree);

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        String shouldBeIsocsceles = triangleClassifier
                .getTriangleClassification(values);

        // Assert
        assertTrue(shouldBeIsocsceles
                .equals(TriangleClassificationEnum.ISOCSCELES
                        .getClassification()));
    }

    @Test
    public void testIsoscelesTwo() {

        // Assign
        double sideOne = 10;
        double sideTwo = 0.8;
        double sideThree = 10.0;

        List<Double> values = new ArrayList<Double>();
        values.add(sideOne);
        values.add(sideTwo);
        values.add(sideThree);

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        String shouldBeIsocsceles = triangleClassifier
                .getTriangleClassification(values);

        // Assert
        assertTrue(shouldBeIsocsceles
                .equals(TriangleClassificationEnum.ISOCSCELES
                        .getClassification()));
    }

    @Test
    public void testIsoscelesThree() {

        // Assign
        double sideOne = 10;
        double sideTwo = 10;
        double sideThree = 8;

        List<Double> values = new ArrayList<Double>();
        values.add(sideOne);
        values.add(sideTwo);
        values.add(sideThree);

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        String shouldBeIsocsceles = triangleClassifier
                .getTriangleClassification(values);

        // Assert
        assertTrue(shouldBeIsocsceles
                .equals(TriangleClassificationEnum.ISOCSCELES
                        .getClassification()));
    }

    @Test
    public void testScalene() {

        // Assign
        double sideOne = 8;
        double sideTwo = 9;
        double sideThree = 10;

        List<Double> values = new ArrayList<Double>();
        values.add(sideOne);
        values.add(sideTwo);
        values.add(sideThree);

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        String shouldBeScalene = triangleClassifier
                .getTriangleClassification(values);

        // Assert
        assertTrue(shouldBeScalene.equals(TriangleClassificationEnum.SCALENE
                .getClassification()));
    }

    @Test
    public void testNotATriangle() {

        // Assign
        double sideOne = 8;
        double sideTwo = 9;
        double sideThree = 100;

        List<Double> values = new ArrayList<Double>();
        values.add(sideOne);
        values.add(sideTwo);
        values.add(sideThree);

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        String shouldBeNotATriangle = triangleClassifier
                .getTriangleClassification(values);

        // Assert
        assertTrue(shouldBeNotATriangle
                .equals(TriangleClassificationEnum.NOT_A_TRIANGLE
                        .getClassification()));
    }
    
    @Test
    public void testAreaOfZeroIsATriangle() {

        // Assign
        double sideOne = 1;
        double sideTwo = 2;
        double sideThree = 3;

        List<Double> values = new ArrayList<Double>();
        values.add(sideOne);
        values.add(sideTwo);
        values.add(sideThree);

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        String shouldBeScalene = triangleClassifier
                .getTriangleClassification(values);

        // Assert
        assertTrue(shouldBeScalene
                .equals(TriangleClassificationEnum.SCALENE
                        .getClassification()));
    }

    @Test
    public void testZeroShouldNotBeATriangle() {

        // Assign
        double sideOne = 8;
        double sideTwo = 9;
        double sideThree = 0;

        List<Double> values = new ArrayList<Double>();
        values.add(sideOne);
        values.add(sideTwo);
        values.add(sideThree);

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        String shouldBeNotATriangle = triangleClassifier
                .getTriangleClassification(values);
    }

    @Test
    public void testIncorrectNumberOfValuesShouldNotBeATriangle() {

        // Assign
        double sideOne = 8;
        double sideTwo = 9;

        List<Double> values = new ArrayList<Double>();
        values.add(sideOne);
        values.add(sideTwo);

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        String shouldBeNotATriangle = triangleClassifier
                .getTriangleClassification(values);

        // Assert
        assertTrue(shouldBeNotATriangle
                .equals(TriangleClassificationEnum.NOT_A_TRIANGLE
                        .getClassification()));
    }

    @Test
    public void testValidatorSuccess() {

        // Assign
        final String sideOne = "8";
        final String sideTwo = "9";
        final String sideThree = "10";

        String[] values = new String[3];
        values[0] = sideOne;
        values[1] = sideTwo;
        values[2] = sideThree;

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        boolean shouldBeTrue = false;

        shouldBeTrue = triangleClassifier.areArguementsValid(values);

        // Assert
        assertTrue(shouldBeTrue);
    }

    @Test
    public void testValidatorWithZero() {

        // A logger error message will be generated.

        // Assign
        final String sideOne = "8";
        final String sideTwo = "9";
        final String sideThree = "0";

        String[] values = new String[3];
        values[0] = sideOne;
        values[1] = sideTwo;
        values[2] = sideThree;

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        boolean shouldBeFalse = true;

        shouldBeFalse = triangleClassifier.areArguementsValid(values);

        // Assert
        assertFalse(shouldBeFalse);
    }

    @Test
    public void testValidatorWithMissingValue() {

        // A logger error message will be generated.

        // Assign
        final String sideOne = "8";
        final String sideTwo = "9";

        String[] values = new String[2];
        values[0] = sideOne;
        values[1] = sideTwo;

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        boolean shouldBeFalse = true;

        shouldBeFalse = triangleClassifier.areArguementsValid(values);

        // Assert
        assertFalse(shouldBeFalse);
    }
    
    @Test
    public void testValidatorWithNotNumeric() {

        // A logger error message will be generated.

        // Assign
        final String sideOne = "8";
        final String sideTwo = "9";
        final String sideThree = "Nine";

        String[] values = new String[3];
        values[0] = sideOne;
        values[1] = sideTwo;
        values[2] = sideThree;

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        boolean shouldBeFalse = true;

        shouldBeFalse = triangleClassifier.areArguementsValid(values);

        // Assert
        assertFalse(shouldBeFalse);
    }

    @Test(expected = InvalidArguementsException.class)
    public void testRunMainToThrowException() throws InvalidArguementsException {
        
        // A logger error message will be generated.

        // Assign
        final String sideOne = "8";
        final String sideTwo = "9";

        String[] values = new String[2];
        values[0] = sideOne;
        values[1] = sideTwo;

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        triangleClassifier.runMain(values);

        // Assert
        // Should throw an InvalidArguementsException so assertion is not done
        // here.
    }

    @Test
    public void testFormatArguements() {
        
        // Assign
        final String sideOne = "8";
        final String sideTwo = "9";
        final String sideThree = "0";

        String[] values = new String[3];
        values[0] = sideOne;
        values[1] = sideTwo;
        values[2] = sideThree;

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        String shouldNotBeNullOrEmpty = triangleClassifier
                .formatArguements(values);

        // Assert
        assertTrue(shouldNotBeNullOrEmpty != null);
        assertTrue(shouldNotBeNullOrEmpty.length() > 0);
    }

    @Test
    public void testFormatUsage() {

        // Assign
        TriangleClassifier triangleClassifier = new TriangleClassifier();

        // Act
        String shouldNotBeNullOrEmpty = triangleClassifier.formatUsage();

        // Assert
        assertTrue(shouldNotBeNullOrEmpty != null);
        assertTrue(shouldNotBeNullOrEmpty.length() > 0);
    }
}
