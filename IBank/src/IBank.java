import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import ibank.Account;
import ibank.Bank;

public class IBank implements Bank {

	private Collection<Account> accList = new ArrayList<>();

	@Override
	public void closeAccount(Account account) {

		this.accList.remove(account);
	}

	@Override
	public Account getAccountByHolderName(String accountHolderName) {

		return accList.stream().filter(n -> n.getHolderName().equals(accountHolderName)).findFirst().orElse(null);
	}

	@Override
	public Account getAccountByNumber(String accountNumber) {

		return accList.stream().filter(n -> n.getNumber().equals(accountNumber)).findFirst().orElse(null);
	}

	@Override
	public Collection<Account> getAllAccounts() {

		return accList;
	}

	@Override
	public int getNumberOfAccounts() {

		return this.accList.size();
	}

	@Override
	public BigDecimal getTotalReserves() {

		return accList.stream().map(Account::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Override
	public Account openCreditAccount(String accountHolderName, BigDecimal creditLimit) {
		if (getAccountByHolderName(accountHolderName) != null) {
			return null;
			
		} else {
			Account openCredit = new IAccount(accountHolderName, creditLimit);
			this.accList.add(openCredit);

			return openCredit;
		}
	}

	@Override
	public Account openDebitAccount(String accountHolderName) {
		if (getAccountByHolderName(accountHolderName) != null) {
			return null;
			
		} else {
			Account opdenDebit = new IAccount(accountHolderName);
			this.accList.add(opdenDebit);

			return opdenDebit;
		}
	}
}
