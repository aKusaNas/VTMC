import java.math.BigDecimal;

import ibank.Account;

public class IAccount implements Account {

	private String holderName;
	private String holderNumber = "";
	private static int i = 0;

	private BigDecimal holderBalance;
	private BigDecimal holderLimit;
	private boolean credit;

	public IAccount(String accountHolderName) {

		this.holderName = accountHolderName;
		this.holderNumber = "LT1000" + i++;
		this.holderBalance = BigDecimal.ZERO;

		this.credit = false;

	}

	public IAccount(String accountHolderName, BigDecimal creditLimit) {

		this.holderName = accountHolderName;
		this.holderNumber = "LT1000" + i++;
		this.holderLimit = creditLimit;
		this.holderBalance = BigDecimal.ZERO;

		this.credit = true;

	}

	@Override
	public boolean deposit(BigDecimal amount) {

		if (BigDecimal.ZERO.compareTo(amount) > 0) {
			return false;
		}
		this.holderBalance = this.holderBalance.add(amount);
		return true;
	}

	@Override
	public BigDecimal getBalance() {

		return this.holderBalance;
	}

	@Override
	public String getHolderName() {

		return this.holderName;
	}

	@Override
	public String getNumber() {

		return this.holderNumber;
	}

	@Override
	public boolean withdraw(BigDecimal amount) {

		if (this.credit) {
			if (this.holderBalance.add(holderLimit).compareTo(amount) > 0) {

				this.holderBalance = this.holderBalance.subtract(amount);
				return true;

			} else {

				return false;
			}
		} else {
			if (this.holderBalance.compareTo(amount) >= 0) {

				this.holderBalance = this.holderBalance.subtract(amount);
				return true;

			} else {

				return false;
			}
		}
	}
}
