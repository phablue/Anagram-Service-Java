package anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class Helper {
	public BufferedReader createReaderFromURL() throws IOException {
		String url = "http://www-01.sil.org/linguistics/wordlists/english/wordlist/wordsEn.txt";
		URL wordsList = new URL(url);

		BufferedReader reader = new BufferedReader(new InputStreamReader(wordsList.openStream()));

		return reader;
	}

	public String sort(String original) {
		char[] chars = original.toCharArray();

        Arrays.sort(chars);
        String sorted = new String(chars);

        return sorted;
	}

	public boolean isCapitalize(String string) {
		char firstChar = string.charAt(0);
		String theRestChars = string.substring(1, string.length());

		return Character.isUpperCase(firstChar) && isLowerCase(theRestChars);
	}

	public boolean isUpperCase(String string) {
		return StringUtils.isAllUpperCase(string);
	}

	public String convertCapitalize(String string) {
    return StringUtils.capitalize(string.toLowerCase());
	}

	private boolean isLowerCase(String string) {
		return StringUtils.isAllLowerCase(string);
	}
}
