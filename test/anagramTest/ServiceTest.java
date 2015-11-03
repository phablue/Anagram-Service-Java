package anagramTest;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import anagram.*;

public class ServiceTest {
	public UI ui;
	public Writer writer;

	@Before
	public void initialize() {
		Helper helper = new Helper();
		writer = new Writer();
		ui = new UI(helper);
	}

	@Test
	public void whenUserInpuDoesNotIncludeAnagramMapReturnErrorMessage() {
		String userInput = "12345";

		Scanner scan = new Scanner(userInput);
		Reader reader = new Reader(scan);
		Service service = new Service(reader, writer);

		String expected = ui.errorMessage(userInput);
		String result = service.getResult(userInput);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void whenUserInpuIncludeAnagramMapAndHasAnagramsReturnMatchingList() {
		String userInput = "aah";

		Scanner scan = new Scanner(userInput);
		Reader reader = new Reader(scan);
		Service service = new Service(reader, writer);

		String expected = "[aha]";
		String result = service.getResult(userInput);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void whenUserInpuIncludeAnagramMapAndDoesNotHaveAnagramsReturnEmpty() {
		String userInput = "banana";

		Scanner scan = new Scanner(userInput);
		Reader reader = new Reader(scan);
		Service service = new Service(reader, writer);

		String expected = "[]";
		String result = service.getResult(userInput);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void whenUserInputCharcterCaseIsUpperCaseReturnResultStyleIsUppserCase() {
		String userInput = "AAH";

		Scanner scan = new Scanner(userInput);
		Reader reader = new Reader(scan);
		Service service = new Service(reader, writer);

		String expected = "[AHA]";
		String result = service.getResult(userInput);

		Assert.assertEquals(expected, result);
		Assert.assertNotEquals("[aha]", result);
		Assert.assertNotEquals("[Aha]", result);
	}

	@Test
	public void whenUserInputCharcterCaseIsCapitalizeReturnResultStyleIsCapitalize() {
		String userInput = "Aah";

		Scanner scan = new Scanner(userInput);
		Reader reader = new Reader(scan);
		Service service = new Service(reader, writer);

		String expected = "[Aha]";
		String result = service.getResult(userInput);

		Assert.assertEquals(expected, result);
		Assert.assertNotEquals("[aha]", result);
		Assert.assertNotEquals("[AHA]", result);
	}

	@Test
	public void whenUserInputCharcterCaseIsNotUpperCaseOrCapitalizeReturnResultStyleIsLowerCase() {
		String userInput = "aah";

		Scanner scan = new Scanner(userInput);
		Reader reader = new Reader(scan);
		Service service = new Service(reader, writer);

		String expected = "[aha]";
		String result = service.getResult(userInput);

		Assert.assertEquals(expected, result);
		Assert.assertNotEquals("[AHA]", result);
		Assert.assertNotEquals("[Aha]", result);
	}

	@Test
	public void whenUserInputCharcterCaseIsNotCamelCaseReturnResultStyleIsLowerCase() {
		String userInput = "aAh";

		Scanner scan = new Scanner(userInput);
		Reader reader = new Reader(scan);
		Service service = new Service(reader, writer);

		String expected = "[aha]";
		String result = service.getResult(userInput);

		Assert.assertEquals(expected, result);
		Assert.assertNotEquals("[AHA]", result);
		Assert.assertNotEquals("[Aha]", result);
	}
}
