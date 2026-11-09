package bank_system;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp đại diện cho một giao dịch tài chính trong hệ thống.
 */
public class Transaction {
    private static final Logger LOGGER = LoggerFactory.getLogger(Transaction.class);

    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_WITHDRAW_CHECKING = 2;
    public static final int TYPE_DEPOSIT_SAVINGS = 3;
    public static final int TYPE_WITHDRAW_SAVINGS = 4;

    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /**
     * Khởi tạo thông tin giao dịch.
     *
     * @param type Loại giao dịch
     * @param amount Số tiền giao dịch
     * @param initialBalance Số dư trước giao dịch
     * @param finalBalance Số dư sau giao dịch
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public double getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(double finalBalance) {
        this.finalBalance = finalBalance;
    }

    /**
     * Trả về tên mô tả loại giao dịch dưới dạng chuỗi.
     *
     * @param type Mã loại giao dịch
     * @return Tên loại giao dịch
     */
    public static String getTypeString(int type) {
        switch (type) {
            case TYPE_DEPOSIT_CHECKING:
                return "Nạp tiền vãng lai";
            case TYPE_WITHDRAW_CHECKING:
                return "Rút tiền vãng lai";
            case TYPE_DEPOSIT_SAVINGS:
                return "Nạp tiền tiết kiệm";
            case TYPE_WITHDRAW_SAVINGS:
                return "Rút tiền tiết kiệm";
            default:
                return "Không rõ";
        }
    }

    /**
     * Phương thức cũ để đảm bảo tương thích với các test case có sẵn.
     *
     * @param type Mã loại giao dịch
     * @return Tên loại giao dịch
     */
    public static String get_type_string(int type) {
        return getTypeString(type);
    }

    /**
     * Trả về chuỗi tóm tắt giao dịch.
     *
     * @return Tóm tắt giao dịch dạng văn bản
     */
    public String getTransactionSummary() {
        LOGGER.debug("Bắt đầu xử lý tóm tắt giao dịch cho loại giao dịch: {}", this.type);

        String initialStr = String.format(Locale.US, "%.2f", initialBalance);
        String amountStr = String.format(Locale.US, "%.2f", amount);
        String finalStr = String.format(Locale.US, "%.2f", finalBalance);

        return String.format(
                "- Kiểu giao dịch: %s. Số dư ban đầu: $%s. Số tiền: $%s. Số dư cuối: $%s.",
                getTypeString(type),
                initialStr,
                amountStr,
                finalStr
        );
    }
}