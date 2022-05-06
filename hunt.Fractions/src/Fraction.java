/**
 *A class that creates a fraction when given a numerator and denominator 
 */
public class Fraction {
	private int numerator;
	private int denom;
	private boolean isReduced;
	
	Fraction(int n, int d) throws Exception{
		if (d==0) {
			throw new Exception("Denominator can't be zero");
		}
		
		numerator = n;
		denom = d;
		isReduced = false;
	}
	/**
	 * Give Numerator of fraction
	 */
	public int getNumerator() {
		return numerator;
	}
	/**
	 * Give Denominator of fraction
	 */
	public int getDenominator() {
		return denom;
	}
	
	/**
	 * add two fractions and returns a new fraction
	 * @param b
	 * @return
	 * @throws Exception
	 */
	public Fraction add(Fraction b) throws Exception {
		// get both denominators and numerators
		int numer1 = getNumerator();
		int denom1 = getDenominator();
		int numer2 = b.getNumerator();
		int denom2 = b.getDenominator();
		
		int tDenom;
		int tNumer;
		//learn if the two denominators are the same
		if(denom2!=denom1) {
			numer1 = numer1 * denom2;
			numer2 = numer2 * denom1;
			//multiply denominators
			tDenom = denom1 * denom2;
		}
		else {
			tDenom = denom1;
		}
		// add numerators
		tNumer = numer1 + numer2;
		return new Fraction (tNumer,tDenom);
	}
	
	/**
	 * Multiplies 2 fractions and returns a new fraction
	 * @param b fraction
	 * @return a new fraction that is the product of 2 fractions
	 * @throws Exception
	 */
	public Fraction multiply(Fraction b) throws Exception {
		//find both fractions' numerators and denominators
		int numer1 = getNumerator();
		int denom1 = getDenominator();
		int numer2 = b.getNumerator();
		int denom2 = b.getDenominator();
		
		//multiply numerators and denominators
		int aNum = numer1 * numer2;
		int aDen = denom2 * denom1;
		return new Fraction (aNum,aDen);
	}
	/**
	 * reduce a fraction based on a greatest common divisor
	 */
	public void reduce() {
		int gcdValue = gcd(numerator, denom);
		numerator = numerator/gcdValue;
		denom = denom/gcdValue;
	}
	/**
	 * change the status of the boolean isReduced to true or false based on the gcd
	 */
	private void setReducedStatus() {
		if (gcd(numerator,denom)==1) {
			isReduced = true;
		}
		else {
			isReduced = false;
		}
	}
	/**
	 * learn if a fraction is reduced or not 
	 * @return isReduced
	 */
	public boolean isReduced() {
		setReducedStatus();
		return isReduced;
	}
	/**
	 * find the greatest common divisor of a fraction
	 * @param a
	 * @param b
	 * @return gcd
	 */
	private int gcd (int a, int b) {
		if (b == 0)
		    return a;
		  else
		    return gcd(b, (a % b));
		}
	/**
	 * turn a fraction object into a string
	 */
	@Override
	public String toString() {
		String out = String.format("%d\n---\n%d\n", numerator, denom);
		return out;
	}
	
}
