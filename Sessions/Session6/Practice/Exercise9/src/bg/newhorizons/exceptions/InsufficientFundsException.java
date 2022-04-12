package bg.newhorizons.exceptions;

public class InsufficientFundsException extends Exception {

    private double fundAmount;

    public InsufficientFundsException(final String message, final double fundAmount) {
        super(message);
        this.fundAmount = fundAmount;
    }

    public double getFundAmount() {
        return fundAmount;
    }
}
