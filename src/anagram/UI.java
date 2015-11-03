package anagram;

import java.util.ArrayList;

public class UI {
	private Helper helper;

	public UI(Helper helper) {
		this.helper = helper;
	}

	public ArrayList<String> stylizeAnagramResult(ArrayList<String> result, String input) {
		int i = 0;

		for (String value : result) {
			result.set(i, convertCharCase(value, input));
			i++;
		}
		return result;
	}

	public String convertCharCase(String value, String input) {
		if (helper.isUpperCase(input))
			return value.toUpperCase();
		else if (helper.isCapitalize(input))
			return helper.convertCapitalize(value);
		else
			return value.toLowerCase();
	}

	public boolean requestExitService(String input) {
		return input.toLowerCase().equals("enter") || input.equals("");
	}

	public String questionMessage() {
		return "Enter a word or <Enter> to exit : ";
	}

	public String errorMessage(String input) {
		return "\nThe word [" + input + "] is not in the word list.";
	}

	public String exitMessage() {
		return "\nTerminated the anagram service.";
	}
}
