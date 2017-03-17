package us.flexion.challenge.coding.developer.triangle_classifier.util;

import java.util.ArrayList;
import java.util.List;

import us.flexion.challenge.coding.developer.triangle_classifier.exception.InvalidArguementsException;
import us.flexion.challenge.coding.developer.triangle_classifier.shape.ShapeSide;
import us.flexion.challenge.coding.developer.triangle_classifier.shape.Triangle;

public class ConversionUtil {
	
	public static String[] convertShapeSideLengthsToArray(Triangle triangle) throws InvalidArguementsException {

		String[] convertedSideLengthValues = new String[triangle.getShapeSides().size()];

		int shapeSidesCounter = 0;

		for (ShapeSide shapeSide : triangle.getShapeSides()) {
			
			if ((shapeSide == null) || (shapeSide.getLength() == null)) {

				convertedSideLengthValues = ConversionUtil.convertShapeSideLengthsToArray(triangle);

				StringBuilder fomattedSideLengthValuesForExceptionMessage = MessageFormatter
						.formatInvalidArguementsExceptionMessage(convertedSideLengthValues);

				throw new InvalidArguementsException(fomattedSideLengthValuesForExceptionMessage.toString());
			}

			convertedSideLengthValues[shapeSidesCounter] = shapeSide.getLength().toString();
			shapeSidesCounter++;
		}

		return convertedSideLengthValues;
	}

	public static List<Double> convertShapeSidesToList(Triangle triangle) throws InvalidArguementsException {

		List<Double> sideLengthValues = new ArrayList<Double>();

		for (ShapeSide shapeSide : triangle.getShapeSides()) {
			
			if (shapeSide.getLength() == null) {

				String[] convertedSideLengthValues = ConversionUtil.convertShapeSideLengthsToArray(triangle);

				StringBuilder fomattedSideLengthValuesForExceptionMessage = MessageFormatter
						.formatInvalidArguementsExceptionMessage(convertedSideLengthValues);

				throw new InvalidArguementsException(fomattedSideLengthValuesForExceptionMessage.toString());
			}

			sideLengthValues.add(shapeSide.getLength());
		}
		
		return sideLengthValues;
	}
}
