package bank_system;

import java.util.Locale;

/**
 * Ngoại lệ xảy ra khi số dư tài khoản không đủ để thực hiện giao dịch.
 */
public class InsufficientFundsException extends BankException {

    /**
     * Khởi tạo ngoại lệ với số tiền yêu cầu.
     *
     * @param amount Số tiền giao dịch vượt quá số dư
     */
    public InsufficientFundsException(double amount) {
        super("Số dư tài khoản không đủ $"
                + String.format(Locale.US, "%.2f", amount)
                + " để thực hiện giao dịch");
    }
}