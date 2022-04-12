package bg.newhorizons.bankaccount;


import bg.newhorizons.exceptions.InsufficientFundsException;

/**
 * Following the API java doc provide implementation class of BankAccount interface
 */
public interface BankAccount {

    /**
     * Withdraw the amount from the balance in the bank account
     *
     * @param amount
     *      the amount of money requested to be withdrawn
     * @throws bg.newhorizons.exceptions.InsufficientFundsException
     *      in case the amount requested is higher than the available amount
     * @throws IllegalArgumentException in case amount is less or equals of 0
     */
    void withdraw(double amount) throws InsufficientFundsException;

    /**
     * Deposit the balance within the money provided as argument
     * @param amount
     *      the amount of money will be deposit
     * @throws IllegalArgumentException in case amount is less or equals of 0
     */
    void deposit(double amount);
}
