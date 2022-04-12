package bg.newhorizons.exceptions;

public class GiugaInsufficientAmountexception extends InsufficientFundsException {
    public GiugaInsufficientAmountexception(String message, double fundAmount) {
        super(message, fundAmount);
    }
}
