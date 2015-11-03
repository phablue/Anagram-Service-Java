package anagramTest;

import anagram.Helper;

import org.junit.*;

public class HelperTest {
	public Helper helper;

	@Before
	public void initilize() {
		helper = new Helper();
	}

	@Test
	public void whenActualInputStringIsAResultIsEqualedExpectedReturnValueIsA() {
		String actual = "a";
		String expected = "a";

		String result = helper.sort(actual);

		Assert.assertEquals(expected,result);
	}

	@Test
	public void whenActualInputStringIsAhhResultIsEqualedExpectedReturnValueIsAah() {
		String actual = "aah";
		String expected = "aah";

		String result = helper.sort(actual);

		Assert.assertEquals(expected,result);
	}

	@Test
	public void whenActualInputStringIsZooResultIsEqualedExpectedReturnValueIsOoz() {
		String actual = "zoo";
		String expected = "ooz";

		String result = helper.sort(actual);

		Assert.assertEquals(expected,result);
	}

	@Test
	public void whenActualIsCapitalizeOrangeExpectedResultIsTrue() {
		String actual = "Orange";

		Boolean result = helper.isCapitalize(actual);

		Assert.assertTrue(result);
	}

	@Test
	public void whenActualIsLowercaseHouseExpectedResultIsFalse() {
		String actual = "house";

		Boolean result = helper.isCapitalize(actual);

		Assert.assertFalse(result);
	}
}
