package us.flexion.challenge.coding.developer.triangle_classifier;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import us.flexion.challenge.coding.developer.triangle_classifier.util.MessageFormatter;

public class MessageFormatterTest {

	@Test
	public void testFormatInvalidArguementsExceptionMessage() {

		// Assign

		final String sideOne = "8";
		final String sideTwo = "9";
		final String sideThree = "0";

		String[] values = { sideOne, sideTwo, sideThree };
		MessageFormatter messageFormatter = new MessageFormatter();

		// Act

		StringBuilder shouldNotBeNullOrEmpty = messageFormatter.formatInvalidArguementsExceptionMessage(values);

		// Assert

		assertTrue(shouldNotBeNullOrEmpty != null);
		assertTrue(shouldNotBeNullOrEmpty.length() > 0);
	}

	@Test
	public void testFormatSideLengthInformationFromArguements() {

		// Assign

		final String sideOne = "8";
		final String sideTwo = "9";
		final String sideThree = "0";

		String[] values = { sideOne, sideTwo, sideThree };
		MessageFormatter messageFormatter = new MessageFormatter();

		// Act

		String shouldNotBeNullOrEmpty = messageFormatter.formatSideLengthInformationFromArguements(values);

		// Assert

		assertTrue(shouldNotBeNullOrEmpty != null);
		assertTrue(shouldNotBeNullOrEmpty.length() > 0);
	}

	@Test
	public void testFormatUsage() {

		// Assign

		MessageFormatter messageFormatter = new MessageFormatter();

		// Act

		String shouldNotBeNullOrEmpty = messageFormatter.formatUsage();

		// Assert

		assertTrue(shouldNotBeNullOrEmpty != null);
		assertTrue(shouldNotBeNullOrEmpty.length() > 0);
	}
}
