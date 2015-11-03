package anagramTest;

import anagram.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.*;

public class WordsTest {
	public Words words;
	public HashMap<String, String> anagramMap;
	public Helper helper;

	@Before
	public void initilize() {
		helper = new Helper();
		words = new Words(helper);
		anagramMap = words.anagramMap;
	}

	@Test
	public void whenCreatingMapSuccessAllLinesFromURLByReaderContainMapKeys() throws IOException {
		BufferedReader reader = helper.createReaderFromURL();
		String line;

		while ((line = reader.readLine()) != null) {
			Boolean result = anagramMap.containsKey(line);
			Assert.assertTrue(result);
		}
		reader.close();
	}

	@Test
	public void whenInputValueHasMatchingKeysFromMapResultIsNotNull() {
		String input = "aah";
		ArrayList<String> result = words.getAnagramFromMapBy(input);

		Assert.assertTrue("The input includes map", anagramMap.containsValue(input));
		Assert.assertNotNull(result);
	}

	@Test
	public void whenInputValueDoesNotHaveMatchingKeysFromMapResultIsNull() {
		String input = "05136";
		ArrayList<String> result = words.getAnagramFromMapBy(input);

		Assert.assertFalse("The input does not includes map", anagramMap	.containsValue(input));
		Assert.assertEquals(0, result.size());
	}

	@Test
	public void whenInputHasMatchingKeysFromWordsMapReturnKeysExceptItself() {
		String input = "banana";
		ArrayList<String> result = words.getAnagramFromMapBy(input);

		Assert.assertTrue("The input includes map", anagramMap.containsKey(input));
		Assert.assertEquals(0, result.size());
	}
}
