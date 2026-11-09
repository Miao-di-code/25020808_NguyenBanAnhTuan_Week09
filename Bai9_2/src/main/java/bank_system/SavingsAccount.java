package bank_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tài khoản tiết kiệm.
 */
public class SavingsAccount extends Account {
    private static final Logger LOGGER = LoggerFactory.getLogger(SavingsAccount.class);

    public static final double MAX_WITHDRAWAL_AMOUNT = 1000.0;
    public static final double MIN_BALANCE_REQUIRED = 5000.0;

    /**
     * Khởi tạo tài khoản tiết kiệm.
     *
     * @param accountNumber Số tài khoản
     * @param balance Số dư ban đầu
     */
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        LOGGER.debug("Bắt đầu xử lý nạp tiền vào tài khoản tiết kiệm {}", getAccountNumber());
        double initialBalance = getBalance();
        try {
            doDepositing(amount);
            double finalBalance = getBalance();
            Transaction transaction = new Transaction(
                    Transaction.TYPE_DEPOSIT_SAVINGS,
                    amount,
                    initialBalance,
                    finalBalance
            );
            addTransaction(transaction);
            LOGGER.info("Nạp tiền vào tài khoản tiết kiệm {} thành công: +${}. Số dư mới: ${}",
                    getAccountNumber(), amount, finalBalance);
        } catch (BankException e) {
            LOGGER.error("Nạp tiền tài khoản tiết kiệm {} thất bại: {}", getAccountNumber(), e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        double initialBalance = getBalance();
        try {
            if (amount > MAX_WITHDRAWAL_AMOUNT) {
                throw new InvalidFundingAmountException(amount);
            }
            if (initialBalance - amount < MIN_BALANCE_REQUIRED) {
                throw new InsufficientFundsException(amount);
            }

            doWithdrawing(amount);
            double finalBalance = getBalance();

            Transaction transaction = new Transaction(
                    Transaction.TYPE_WITHDRAW_SAVINGS,
                    amount,
                    initialBalance,
                    finalBalance
            );
            addTransaction(transaction);

            LOGGER.info("Rút tiền từ tài khoản tiết kiệm {} thành công: -${}. Số dư còn lại: ${}",
                    getAccountNumber(), amount, finalBalance);
        } catch (BankException e) {
            LOGGER.error("Rút tiền từ tài khoản tiết kiệm {} thất bại: {}", getAccountNumber(), e.getMessage());
        }
    }
}