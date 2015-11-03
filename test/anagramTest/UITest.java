package anagramTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import anagram.Helper;
import anagram.UI;

public class UITest {
	public UI ui;

	public ArrayList<String> anagramResult() {
		ArrayList<String> anagramResult =  new ArrayList<String>();

		anagramResult.add(0, "APPLE");
		anagramResult.add(1, "banana");
		anagramResult.add(2, "Coconut");
		anagramResult.add(3, "OraNge");

		return anagramResult;
	}

	@Before
	public void initialize() {
		Helper helper = new Helper();
		ui = new UI(helper);
	}

	@Test
	public void valueConvertCapitalizeWhenInputCharcterCaseIsCapitalize() {
		String value = "APPLE";
		String input = "Banana";

		String expected = "Apple";
		String result = ui.convertCharCase(value, input);

		Assert.assertEquals(expected, result);

		value = "apple";

		result = ui.convertCharCase(value, input);
		Assert.assertEquals(expected, result);
	}

	@Test
	public void valueConvertUppercaseWhenInputCharcterCaseIsUppercase() {
		String value = "orange";
		String input = "DOG";

		String expected = "ORANGE";
		String result = ui.convertCharCase(value, input);

		Assert.assertEquals(expected, result);

		value = "Orange";

		result = ui.convertCharCase(value, input);
		Assert.assertEquals(expected, result);
	}

	@Test
	public void valueConvertLowerCaseWhenInputCharcterCaseIsLowercaseORCamelCase() {
		String value = "SKY";
		String input = "candy";

		String expected = "sky";
		String result = ui.convertCharCase(value, input);

		Assert.assertEquals(expected, result);

		value = "sKy";

		result = ui.convertCharCase(value, input);
		Assert.assertEquals(expected, result);
	}

	@Test
	public void whenInputCharacterCaseIsUppercaseAnagramResultStyleChangeToUppsercase() {
		String input = "FRUIT";

		String expected = "[APPLE, BANANA, COCONUT, ORANGE]";
		String result = ui.stylizeAnagramResult(anagramResult(), input).toString();

		Assert.assertEquals(expected, result);
	}

	@Test
	public void whenInputCharacterCaseIsCapitalizeAnagramResultStyleChangeToCapitalize() {
		String input = "Fruit";

		String expected = "[Apple, Banana, Coconut, Orange]";
		String result = ui.stylizeAnagramResult(anagramResult(), input).toString();

		Assert.assertEquals(expected, result);
	}

	@Test
	public void whenInputCharacterCaseIsLowercaseAnagramResultStyleChangeToLowercase() {
		String input = "fruit";

		String expected = "[apple, banana, coconut, orange]";
		String result = ui.stylizeAnagramResult(anagramResult(), input).toString();

		Assert.assertEquals(expected, result);
	}

	@Test
	public void whenInputCharacterCaseIsCamelcaseAnagramResultStyleChangeToLowercase() {
		String input = "FrUiT";

		String expected = "[apple, banana, coconut, orange]";
		String result = ui.stylizeAnagramResult(anagramResult(), input).toString();

		Assert.assertEquals(expected, result);
	}

	@Test
	public void whenInputIsEnterOREmptyReturnTrue() {
		String input = "enter";

		Boolean result = ui.requestExitService(input);

		Assert.assertTrue(result);

		input = "";

		result = ui.requestExitService(input);

		Assert.assertTrue(result);
	}
}
