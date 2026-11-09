package bank_system;

import java.util.Locale;

/**
 * Ngoại lệ xảy ra khi số tiền giao dịch không hợp lệ (nhỏ hơn hoặc bằng 0).
 */
public class InvalidFundingAmountException extends BankException {

    /**
     * Khởi tạo ngoại lệ với số tiền không hợp lệ.
     *
     * @param amount Số tiền giao dịch không hợp lệ
     */
    public InvalidFundingAmountException(double amount) {
        super("Số tiền không hợp lệ: $" + String.format(Locale.US, "%.2f", amount));
    }
}