package bank_system;

/**
 * Ngoại lệ chung cho các lỗi phát sinh trong hệ thống ngân hàng.
 */
public class BankException extends Exception {

    /**
     * Khởi tạo ngoại lệ với thông điệp lỗi.
     *
     * @param message Thông điệp mô tả lỗi
     */
    public BankException(String message) {
        super(message);
    }
}