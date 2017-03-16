package us.flexion.challenge.coding.developer.triangle_classifier;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import us.flexion.challenge.coding.developer.triangle_classifier.exception.InvalidArguementsException;

public class TriangleClassifier {

    private static Logger logger = LogManager
            .getLogger(TriangleClassifier.class);

    private static final String OS_INDEPENDENT_CARRIAGE_RETURN = String.format(
            "%n", (Object[]) null);

    private static final int NUMBER_OF_EXPECTED_ARGUEMENTS = 3;

    public static void main(String[] args) throws InvalidArguementsException {

        TriangleClassifier triangleClassifier = new TriangleClassifier();

        try {

            triangleClassifier.runMain(args);
        }

        catch (InvalidArguementsException e) {

            logger.error(e);
        }
    }

    protected void runMain(String[] arguements)
            throws InvalidArguementsException {

        if (!areArguementsValid(arguements)) {

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("The specified values are invalid.");
            stringBuilder.append(OS_INDEPENDENT_CARRIAGE_RETURN);
            stringBuilder.append(formatArguements(arguements));
            stringBuilder.append(OS_INDEPENDENT_CARRIAGE_RETURN);
            stringBuilder.append(formatUsage());

            throw new InvalidArguementsException(stringBuilder.toString());
        }

        List<Double> values = new ArrayList<Double>();

        for (int i = 0; i < arguements.length; i++) {
            values.add((double) Double.parseDouble(arguements[i]));
        }

        String classification = getTriangleClassification(values);

        logger.info(classification);
    }

    protected String getTriangleClassification(List<Double> values) {

        int numberOfRepeatedValues = 0;

        for (Double value : values) {

            logger.debug("value = [" + value + "].");
            double totalOfOtherValues = 0;
            int currentNumberOfRepeatedValues = 0;

            for (Double otherValue : values) {

                // Make sure not to compare the object to itself

                if (otherValue != value) {

                    logger.debug("Other value = [" + otherValue + "].");
                    totalOfOtherValues += otherValue;

                    if (otherValue.doubleValue() == value.doubleValue()) {

                        logger.debug("Other value is equal.");
                        currentNumberOfRepeatedValues++;
                    }
                }
            }

            logger.debug("Total of other values = [" + totalOfOtherValues
                    + "].");

            logger.debug("Current number of repeated values = ["
                    + currentNumberOfRepeatedValues + "].");

            logger.debug("Number of repeated values = ["
                    + numberOfRepeatedValues + "].");

            if (currentNumberOfRepeatedValues > numberOfRepeatedValues) {

                numberOfRepeatedValues = currentNumberOfRepeatedValues;
            }

            // I've decided that a triangle with an angle of zero degrees
            // is still a triangle. It has an area of zero and on paper
            // it is a line segment, but the three angles add up to 180 degrees
            // and in the real world the connection of the three sides can be
            // made mechanically.

            if (value > totalOfOtherValues) {

                return TriangleClassificationEnum.NOT_A_TRIANGLE
                        .getClassification();
            }
        }

        if (numberOfRepeatedValues == (TriangleClassificationEnum.EQUILATERAL
                .getNumberOfEqualSides() - 1)) {

            return TriangleClassificationEnum.EQUILATERAL.getClassification();
        }

        if (numberOfRepeatedValues == (TriangleClassificationEnum.ISOCSCELES
                .getNumberOfEqualSides() - 1)) {

            return TriangleClassificationEnum.ISOCSCELES.getClassification();
        }

        return TriangleClassificationEnum.SCALENE.getClassification();
    }

    protected boolean areArguementsValid(String[] arguements) {

        if (arguements.length != NUMBER_OF_EXPECTED_ARGUEMENTS) {

            logger.error("Invalid number of values. Number of values specified = ["
                    + arguements.length
                    + "], number of values expected = ["
                    + NUMBER_OF_EXPECTED_ARGUEMENTS + "].");

            return false;

        }

        for (int i = 0; i < arguements.length; i++) {

            try {

                if (Double.parseDouble(arguements[i]) <= 0) {

                    logger.error("The specified value [" + arguements[i]
                            + "] for side #[" + (i + 1)
                            + "] must be greater than zero.");

                    return false;
                }
            }

            catch (NumberFormatException e) {

                logger.error("The specified value [" + arguements[i]
                        + "] for side #[" + (i + 1) + "] is not a number.");

                return false;
            }
        }

        return true;
    }

    protected String formatArguements(String[] arguements) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < arguements.length; i++) {

            if (stringBuilder.length() > 0) {

                stringBuilder.append(OS_INDEPENDENT_CARRIAGE_RETURN);
            }

            stringBuilder.append("Specified length for side #[" + (i + 1)
                    + "] = [" + arguements[i] + "].");
        }

        return stringBuilder.toString();
    }

    protected String formatUsage() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OS_INDEPENDENT_CARRIAGE_RETURN);

        stringBuilder
                .append("Usage: java -jar [path]triangle-classifier-0.0.1-SNAPSHOT-jar-with-dependencies.jar [length of side one] [length of side two] [length of side three]");

        stringBuilder.append(OS_INDEPENDENT_CARRIAGE_RETURN);
        stringBuilder.append(OS_INDEPENDENT_CARRIAGE_RETURN);

        stringBuilder
                .append("       NOTE: All three arguements for triangle side lengths are required and must be numbers greater than zero.");

        stringBuilder.append(OS_INDEPENDENT_CARRIAGE_RETURN);

        return stringBuilder.toString();
    }
}
