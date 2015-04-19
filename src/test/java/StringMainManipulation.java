

public class StringMainManipulation {

	public static void main(String[] args) {

		String text1 = "abcdaabcdeabaaacbfaaaabcab";
		String text2 = "123aabcaabca35aa";
		StringMainManipulation smm = new StringMainManipulation();

		System.out.println(text1 + " = " + smm.stringManipulation(text1));
		System.out.println(text2 + " = " + smm.stringManipulation(text2));

	}

	private String stringManipulation(String stringContaint) {
		String result = null;
		if (stringContaint != null) {
			StringBuilder resultBuilder = new StringBuilder(stringContaint);
			for (int i = 0; i < stringContaint.length(); i++) {
				if (Character.toString(stringContaint.charAt(i)).equals("a")) {
					if (i > 1) {
						if (Character.toString(stringContaint.charAt(i - 1))
								.equals("a")) {
							resultBuilder.setCharAt(i, '$');
						} else if (!Character.toString(
								stringContaint.charAt(i + 1)).equals("a")) {
							resultBuilder.setCharAt(i, '#');
						}
					} else {
						resultBuilder.setCharAt(i, '#');
					}
				}
			}
			result = resultBuilder.toString();

		}
		return result;
	}
}
