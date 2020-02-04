import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CarNumberPricingCalculator {

	/**
	 * Naudojam TDD Kursime programą Regitrai, kuri turi paskaičiuoti kainą pagal
	 * pageidautiną automobilio numerį. Kainą politika yra tokia: Jeigu visos
	 * trys raidės yra vienodos, arba jeigu visi trys skaičiai vienodi arba
	 * "001","666" - numerio kaina 1000 eur. Jeigu trys raidės vienodos IR trys
	 * skaičiai vienodi - numerio kaina 5000 EUR. Jeigu raidžių rinkinys yra
	 * vienas iš "GOD", "KLR", "BOS" numerio kaina 2000 EUR. Jeigu prie aukščiau
	 * minėto raidžių rinkinio pridėsime tris vienodus skaičius - 7000 EUR.
	 * Jeigu numeris yra ne iš trijų simbolių ir trijų skaičių (1-6 simboliai)
	 * jis yra vardinis - kaina 10 000 EUR. Jei skaičiuoklei paduodamas blogo
	 * formato numeris - turi mesti IllegalArgumentException su pranešimu -
	 * "Incorrect plate number format. Must be 1-6 symbols latin letters and number
	 * combination" mažosiomis ir d P.S. NIEKADA realiose sistemose nenaudokite
	 * float/double pinigų ir kitoms tikslioms operacijoms tam naudokite BigDecimal
	 * tipą!
	 */

	@Test
	public void testAllNumbersAndLettersAreTheSameCost5000() {
		assertEquals(new Double(5000.0), priceCalc.calculatePrice("AAA333"));
		assertEquals(new Double(5000.0), priceCalc.calculatePrice("BBB222"));
		assertEquals(new Double(5000.0), priceCalc.calculatePrice("KKK777"));
	}

	@Test
	public void testLettersOrDigitsSameCost1000() {
		assertEquals(new Double(1000.0), priceCalc.calculatePrice("KBA111"));
		assertEquals(new Double(1000.0), priceCalc.calculatePrice("CKO222"));

		assertEquals(new Double(1000.0), priceCalc.calculatePrice("TTT456"));
		assertEquals(new Double(1000.0), priceCalc.calculatePrice("VVV953"));
	}

	@Test
	public void testSameLettersAndIncreasingDigitsCost1000() {
		assertEquals(new Double(1000.0), priceCalc.calculatePrice("VVV002"));
		assertEquals(new Double(1000.0), priceCalc.calculatePrice("KKK009"));
	}

	@Test
	public void testOneOfThreeCost2000() {
		assertEquals(new Double(2000.0), priceCalc.calculatePrice("GOD259"));
		assertEquals(new Double(2000.0), priceCalc.calculatePrice("KLR357"));
		assertEquals(new Double(2000.0), priceCalc.calculatePrice("BOS156"));
		assertEquals(new Double(2000.0), priceCalc.calculatePrice("GOD327"));
		assertEquals(new Double(2000.0), priceCalc.calculatePrice("KLR582"));
	}

	@Test
	public void testOneOfThreeWithSameDigitsCost7000() {
		assertEquals(new Double(7000.0), priceCalc.calculatePrice("GOD777"));
		assertEquals(new Double(7000.0), priceCalc.calculatePrice("KLR333"));
		assertEquals(new Double(7000.0), priceCalc.calculatePrice("BOS999"));
		assertEquals(new Double(7000.0), priceCalc.calculatePrice("GOD666"));
		assertEquals(new Double(7000.0), priceCalc.calculatePrice("KLR000"));
	}

	@Test
	public void testNamePlateCost10000() {
		assertEquals(new Double(10000.0), priceCalc.calculatePrice("5TEB3K"));
		assertEquals(new Double(10000.0), priceCalc.calculatePrice("VVV"));
		assertEquals(new Double(10000.0), priceCalc.calculatePrice("B0SS"));
		assertEquals(new Double(10000.0), priceCalc.calculatePrice("ANUB1S"));
		assertEquals(new Double(10000.0), priceCalc.calculatePrice("AKU5AN"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void isNamePlateHasCorrectCharacters() {
		priceCalc.calculatePrice("aKu5aN");// expect an IllegalArgumentException}
		priceCalc.calculatePrice("kkk009");// expect an IllegalArgumentException}
	}

}