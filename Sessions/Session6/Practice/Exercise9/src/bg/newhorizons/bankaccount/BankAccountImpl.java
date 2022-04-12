package bg.newhorizons.bankaccount;

import bg.newhorizons.exceptions.GiugaInsufficientAmountexception;
import bg.newhorizons.exceptions.InsufficientFundsException;

public class BankAccountImpl implements BankAccount {

    private double availableAmount;

    public BankAccountImpl(double availableAmount) {
        this.availableAmount = availableAmount;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > this.availableAmount) {
            throw  new GiugaInsufficientAmountexception("Not enough money to widrwo",
                    (this.availableAmount - amount));
        }

        this.availableAmount-=amount;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The amount ofmoney should be greater than 0");
        }
        this.availableAmount+=amount;
    }
}
