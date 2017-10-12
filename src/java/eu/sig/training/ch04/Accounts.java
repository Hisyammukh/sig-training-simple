package eu.sig.training.ch04;

public class Accounts {

    public static CheckingAccount findAcctByNumber(String number) {
	return new CheckingAccount();
    }

    public static boolean isValid(String number) {
	int sum = 0;
	for (int i = 0; i < number.length(); i++) {
	    sum = sum + (9 - i) * Character.getNumericValue(number.charAt(i));
	}
	return sum % 11 == 0;
    }

    public static int sumAcc(String cc) {

	int sum = 0; // <1>
	for (int i = 0; i < cc.length(); i++) {
	    char character = cc.charAt(i);
	    int characterValue = Character.getNumericValue(character);
	    sum = sum + (9 - i) * characterValue;
	}

	return sum;
    }

}
