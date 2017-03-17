package us.flexion.challenge.coding.developer.triangle_classifier;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import us.flexion.challenge.coding.developer.triangle_classifier.exception.InvalidArguementsException;
import us.flexion.challenge.coding.developer.triangle_classifier.shape.ShapeSide;
import us.flexion.challenge.coding.developer.triangle_classifier.shape.Triangle;
import us.flexion.challenge.coding.developer.triangle_classifier.shape.TriangleClassificationEnum;
import us.flexion.challenge.coding.developer.triangle_classifier.util.ConversionUtil;
import us.flexion.challenge.coding.developer.triangle_classifier.util.MessageFormatter;

public class TriangleClassifier {

	private static Logger logger = LogManager.getLogger(TriangleClassifier.class);
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

	protected void runMain(String[] arguements) throws InvalidArguementsException {

		// Validate the arguments.

		if (!areArguementsValid(arguements)) {

			StringBuilder stringBuilder = MessageFormatter.formatInvalidArguementsExceptionMessage(arguements);

			throw new InvalidArguementsException(stringBuilder.toString());
		}

		// The arguments cannot be null at this point.

		Triangle triangle = new Triangle((double) Double.parseDouble(arguements[0]),
				(double) Double.parseDouble(arguements[1]), (double) Double.parseDouble(arguements[2]));

		triangle.setTriangleClassificationEnum(this.generateTriangleClassificationEnum(triangle));

		// This is the program output.

		logger.info(triangle.getTriangleClassificationEnum().getClassification());
	}

	protected TriangleClassificationEnum generateTriangleClassificationEnum(Triangle triangle)
			throws InvalidArguementsException {

		List<Double> sideLengthValues = ConversionUtil.convertShapeSidesToList(triangle);
		int numberOfRepeatedValues = 0;

		for (Double sideLengthValue : sideLengthValues) {

			// Validate that the side length value is not null.

			if (sideLengthValue == null) {

				String[] convertedSideLengthValues = ConversionUtil.convertShapeSideLengthsToArray(triangle);

				StringBuilder fomattedSideLengthValuesForExceptionMessage = MessageFormatter
						.formatInvalidArguementsExceptionMessage(convertedSideLengthValues);

				throw new InvalidArguementsException(fomattedSideLengthValuesForExceptionMessage.toString());
			}

			logger.debug("side length value = [" + sideLengthValue + "].");
			double totalOfOtherValues = 0;
			int currentNumberOfRepeatedValues = 0;

			// The side length value cannot be null at this point.

			for (Double otherValue : sideLengthValues) {

				// Make sure not to compare the object to itself, and if it is
				// the same object skip it.

				if (otherValue != sideLengthValue) {

					logger.debug("Other side length value = [" + otherValue + "].");
					totalOfOtherValues += otherValue;

					if (otherValue.doubleValue() == sideLengthValue.doubleValue()) {

						logger.debug("The other side length value is equal.");
						currentNumberOfRepeatedValues++;
					}
				}
			}

			logger.debug("Total of other side length values = [" + totalOfOtherValues + "].");

			logger.debug("Current number of repeated values = [" + currentNumberOfRepeatedValues + "].");

			logger.debug("Number of repeated values = [" + numberOfRepeatedValues + "].");

			if (currentNumberOfRepeatedValues > numberOfRepeatedValues) {

				numberOfRepeatedValues = currentNumberOfRepeatedValues;
			}

			// I've decided that for this iteration, a triangle with an angle of
			// zero degrees is still a triangle. It has an area of zero and on
			// paper it is a line segment, but the three angles add up to 180
			// degrees and in the real world the connection of the three sides
			// can be made mechanically. From research it seems that this is an
			// assumption so a decision needs to be made by the stakeholders.

			if (sideLengthValue > totalOfOtherValues) {

				return TriangleClassificationEnum.NOT_A_TRIANGLE;
			}
		}

		if (numberOfRepeatedValues == (TriangleClassificationEnum.EQUILATERAL.getNumberOfEqualSides() - 1)) {

			return TriangleClassificationEnum.EQUILATERAL;
		}

		if (numberOfRepeatedValues == (TriangleClassificationEnum.ISOCSCELES.getNumberOfEqualSides() - 1)) {

			return TriangleClassificationEnum.ISOCSCELES;
		}

		return TriangleClassificationEnum.SCALENE;
	}

	protected boolean areArguementsValid(String[] arguements) {

		if (arguements.length != NUMBER_OF_EXPECTED_ARGUEMENTS) {

			logger.error("Invalid number of values. Number of values specified = [" + arguements.length
					+ "], number of values expected = [" + NUMBER_OF_EXPECTED_ARGUEMENTS + "].");

			return false;

		}

		for (int i = 0; i < arguements.length; i++) {

			try {

				if (Double.parseDouble(arguements[i]) <= 0) {

					logger.error("The specified value [" + arguements[i] + "] for side #[" + (i + 1)
							+ "] must be greater than zero.");

					return false;
				}
			}

			catch (NumberFormatException e) {

				logger.error(
						"The specified value [" + arguements[i] + "] for side #[" + (i + 1) + "] is not a number.");

				return false;
			}
		}

		return true;
	}
}
