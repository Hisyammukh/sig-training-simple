package eu.sig.training.ch04;

// tag::SavingsAccount[]
public class SavingsAccount extends Accounts {
    private static final float INTEREST_PERCENTAGE = 0.04f;
    private Money balance = new Money();
    private CheckingAccount registeredCounterAccount;

    public void addInterest() {
	Money interest = balance.multiply(INTEREST_PERCENTAGE);
	if (interest.greaterThan(0)) {
	    balance.add(interest);
	} else {
	    balance.substract(interest);
	}
    }
}
// end::SavingsAccount[]
