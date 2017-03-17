package us.flexion.challenge.coding.developer.triangle_classifier;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import us.flexion.challenge.coding.developer.triangle_classifier.exception.InvalidArguementsException;
import us.flexion.challenge.coding.developer.triangle_classifier.shape.Triangle;
import us.flexion.challenge.coding.developer.triangle_classifier.shape.TriangleClassificationEnum;

public class TriangleClassifierTest {
	
	private static Logger logger = LogManager.getLogger(TriangleClassifierTest.class);

	@Test
	public void testEquilateral() {

		// Assign

		double sideLengthA = 10;
		double sideLengthB = 10;
		double sideLengthC = 10;

		Triangle triangle = new Triangle(sideLengthA, sideLengthB, sideLengthC);
		TriangleClassifier triangleClassifier = new TriangleClassifier();

		// Act

		String shouldBeEquilateral = null;

		try {

			shouldBeEquilateral = triangleClassifier.generateTriangleClassificationEnum(triangle).getClassification();
		}

		catch (InvalidArguementsException e) {

			boolean shouldBeTrueAndFail = true;
			assertFalse(shouldBeTrueAndFail);
		}

		// Assert

		assertTrue(shouldBeEquilateral.equals(TriangleClassificationEnum.EQUILATERAL.getClassification()));
	}

	@Test
	public void testIsoscelesOne() {

		// Assign

		double sideLengthA = 8;
		double sideLengthB = 10;
		double sideLengthC = 10;

		Triangle triangle = new Triangle(sideLengthA, sideLengthB, sideLengthC);
		TriangleClassifier triangleClassifier = new TriangleClassifier();

		// Act

		String shouldBeIsocsceles = null;

		try {

			shouldBeIsocsceles = triangleClassifier.generateTriangleClassificationEnum(triangle).getClassification();
		}

		catch (InvalidArguementsException e) {

			boolean shouldBeTrueAndFail = true;
			assertFalse(shouldBeTrueAndFail);
		}

		// Assert

		assertTrue(shouldBeIsocsceles.equals(TriangleClassificationEnum.ISOCSCELES.getClassification()));
	}

	@Test
	public void testIsoscelesTwo() {

		// Assign

		double sideLengthA = 10;
		double sideLengthB = 0.8;
		double sideLengthC = 10.0;

		Triangle triangle = new Triangle(sideLengthA, sideLengthB, sideLengthC);
		TriangleClassifier triangleClassifier = new TriangleClassifier();

		// Act

		String shouldBeIsocsceles = null;

		try {

			shouldBeIsocsceles = triangleClassifier.generateTriangleClassificationEnum(triangle).getClassification();
		}

		catch (InvalidArguementsException e) {

			boolean shouldBeTrueAndFail = true;
			assertFalse(shouldBeTrueAndFail);
		}

		// Assert

		assertTrue(shouldBeIsocsceles.equals(TriangleClassificationEnum.ISOCSCELES.getClassification()));
	}

	@Test
	public void testIsoscelesThree() {

		// Assign

		double sideLengthA = 10;
		double sideLengthB = 10;
		double sideLengthC = 8;

		Triangle triangle = new Triangle(sideLengthA, sideLengthB, sideLengthC);
		TriangleClassifier triangleClassifier = new TriangleClassifier();

		// Act

		String shouldBeIsocsceles = null;

		try {

			shouldBeIsocsceles = triangleClassifier.generateTriangleClassificationEnum(triangle).getClassification();
		}

		catch (InvalidArguementsException e) {

			boolean shouldBeTrueAndFail = true;
			assertFalse(shouldBeTrueAndFail);
		}

		// Assert

		assertTrue(shouldBeIsocsceles.equals(TriangleClassificationEnum.ISOCSCELES.getClassification()));
	}

	@Test
	public void testScalene() {

		// Assign

		double sideLengthA = 8;
		double sideLengthB = 9;
		double sideLengthC = 10;

		Triangle triangle = new Triangle(sideLengthA, sideLengthB, sideLengthC);
		TriangleClassifier triangleClassifier = new TriangleClassifier();

		// Act

		String shouldBeScalene = null;

		try {

			shouldBeScalene = triangleClassifier.generateTriangleClassificationEnum(triangle).getClassification();
		}

		catch (InvalidArguementsException e) {

			boolean shouldBeTrueAndFail = true;
			assertFalse(shouldBeTrueAndFail);
		}

		// Assert

		assertTrue(shouldBeScalene.equals(TriangleClassificationEnum.SCALENE.getClassification()));
	}

	@Test
	public void testNotATriangle() {

		// Assign

		double sideLengthA = 8;
		double sideLengthB = 9;
		double sideLengthC = 100;

		Triangle triangle = new Triangle(sideLengthA, sideLengthB, sideLengthC);
		TriangleClassifier triangleClassifier = new TriangleClassifier();

		// Act

		String shouldBeNotATriangle = null;

		try {

			shouldBeNotATriangle = triangleClassifier.generateTriangleClassificationEnum(triangle).getClassification();
		}

		catch (InvalidArguementsException e) {

			boolean shouldBeTrue = true;
			assertFalse(shouldBeTrue);
		}

		// Assert

		assertTrue(shouldBeNotATriangle.equals(TriangleClassificationEnum.NOT_A_TRIANGLE.getClassification()));
	}

	@Test
	public void testAreaOfZeroIsATriangle() {

		// Assign

		double sideLengthA = 1;
		double sideLengthB = 2;
		double sideLengthC = 3;

		Triangle triangle = new Triangle(sideLengthA, sideLengthB, sideLengthC);
		TriangleClassifier triangleClassifier = new TriangleClassifier();

		// Act

		String shouldBeScalene = null;

		try {

			shouldBeScalene = triangleClassifier.generateTriangleClassificationEnum(triangle).getClassification();
		}

		catch (InvalidArguementsException e) {

			boolean shouldBeTrue = true;
			assertFalse(shouldBeTrue);
		}

		// Assert

		assertTrue(shouldBeScalene.equals(TriangleClassificationEnum.SCALENE.getClassification()));
	}

	@Test
	public void testZeroShouldNotBeATriangle() {

		// Assign

		double sideLengthA = 8;
		double sideLengthB = 9;
		double sideLengthC = 0.0;

		Triangle triangle = new Triangle(sideLengthA, sideLengthB, sideLengthC);
		TriangleClassifier triangleClassifier = new TriangleClassifier();

		// Act

		String shouldBeNotATriangle = null;

		try {

			shouldBeNotATriangle = triangleClassifier.generateTriangleClassificationEnum(triangle).getClassification();
		}

		catch (InvalidArguementsException e) {

			boolean shouldBeTrue = true;
			assertFalse(shouldBeTrue);
		}

		// Assert

		assertTrue(shouldBeNotATriangle.equals(TriangleClassificationEnum.NOT_A_TRIANGLE.getClassification()));
	}
	
	// Needs to be fixed

	/*@Test(expected = InvalidArguementsException.class)
	public void testIncorrectNumberOfValuesShouldNotBeATriangle() {

		// Assign

		double sideLengthA = 8;
		double sideLengthB = 9;
		Double sideLengthC = null;

		Triangle triangle = new Triangle(sideLengthA, sideLengthB, sideLengthC);
		TriangleClassifier triangleClassifier = new TriangleClassifier();
		
		logger.warn("got here 1");

		// Act

		String shouldBeNotATriangle = null;

		try {

			TriangleClassificationEnum triangleClassificationEnum = null;

			triangleClassificationEnum = triangleClassifier.generateTriangleClassificationEnum(triangle);

			shouldBeNotATriangle = triangleClassificationEnum.getClassification();
		}

		catch (InvalidArguementsException e) {

			boolean shouldBeTrueAndFail = true;
			assertFalse(shouldBeTrueAndFail);
		}

		// Assert

		// This should not execute because an exception was thrown.

		boolean shouldBeTrueAndFail = true;
		assertFalse(shouldBeTrueAndFail);
	}*/

	@Test
	public void testValidatorSuccess() {

		// Assign

		final String sideOne = "8";
		final String sideTwo = "9";
		final String sideThree = "10";

		String[] values = { sideOne, sideTwo, sideThree };
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

		String[] values = { sideOne, sideTwo, sideThree };
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

		String[] values = { sideOne, sideTwo };
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

		String[] values = { sideOne, sideTwo, sideThree };
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

		String[] values = { sideOne, sideTwo };
		TriangleClassifier triangleClassifier = new TriangleClassifier();

		// Act

		triangleClassifier.runMain(values);

		// Assert

		// This should not execute because an exception was thrown.

		boolean shouldBeTrueAndFail = true;
		assertFalse(shouldBeTrueAndFail);
	}
}
