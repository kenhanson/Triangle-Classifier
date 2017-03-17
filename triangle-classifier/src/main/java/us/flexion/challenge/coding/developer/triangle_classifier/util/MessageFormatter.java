package us.flexion.challenge.coding.developer.triangle_classifier.util;

public class MessageFormatter {

	private static final String OS_INDEPENDENT_CARRIAGE_RETURN = String.format("%n", (Object[]) null);

	public static StringBuilder formatInvalidArguementsExceptionMessage(String[] arguements) {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("The specified values are invalid.");
		stringBuilder.append(OS_INDEPENDENT_CARRIAGE_RETURN);
		stringBuilder.append(MessageFormatter.formatSideLengthInformationFromArguements(arguements));
		stringBuilder.append(OS_INDEPENDENT_CARRIAGE_RETURN);
		stringBuilder.append(formatUsage());

		return stringBuilder;
	}

	public static String formatSideLengthInformationFromArguements(String[] arguements) {

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < arguements.length; i++) {

			if (stringBuilder.length() > 0) {

				stringBuilder.append(OS_INDEPENDENT_CARRIAGE_RETURN);
			}

			stringBuilder.append("Specified length for side #[" + (i + 1) + "] = [" + arguements[i] + "].");
		}

		return stringBuilder.toString();
	}

	public static String formatUsage() {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(OS_INDEPENDENT_CARRIAGE_RETURN);

		stringBuilder.append(
				"Usage: java -jar [path]triangle-classifier-0.0.1-SNAPSHOT-jar-with-dependencies.jar [length of side one] [length of side two] [length of side three]");

		stringBuilder.append(OS_INDEPENDENT_CARRIAGE_RETURN);
		stringBuilder.append(OS_INDEPENDENT_CARRIAGE_RETURN);

		stringBuilder.append(
				"       NOTE: All three arguements for triangle side lengths are required and must be numbers greater than zero.");

		stringBuilder.append(OS_INDEPENDENT_CARRIAGE_RETURN);

		return stringBuilder.toString();
	}
}
