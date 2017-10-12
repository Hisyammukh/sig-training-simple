package eu.sig.training.ch04;

public class Accounts {
    @SuppressWarnings("unused")
    public static CheckingAccount findAcctByNumber(String number) {
	return new CheckingAccount();
    }

    // tag::isValid[]
    public static boolean isValid(String number) {
	int sum = 0;
	for (int i = 0; i < number.length(); i++) {
	    sum = sum + (9 - i) * Character.getNumericValue(number.charAt(i));
	}
	return sum % 11 == 0;
    }

    // end::isValid[]
    public Transfer makeTransfer(String counterAccount, Money amount)
	    throws BusinessException {
	// 1. Check withdrawal limit:
	if (amount.greaterThan(this.transferLimit)) {
	    throw new BusinessException("Limit exceeded!");
	}
	// 2. Assuming result is 9-digit bank account number, validate 11-test:
	int sum = 0;
	for (int i = 0; i < counterAccount.length(); i++) {
	    char character = counterAccount.charAt(i);
	    int characterValue = Character.getNumericValue(character);
	    sum = sum + (9 - i) * characterValue;
	}
	if (sum % 11 == 0) {
	    // 3. Look up counter account and make transfer object:
	    CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
	    Transfer result = new Transfer(this, acct, amount);
	    return result;
	} else {
	    throw new BusinessException("Invalid account number!");
	}
    }
}
