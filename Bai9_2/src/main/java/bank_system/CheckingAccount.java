package bank_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tài khoản vãng lai.
 */
public class CheckingAccount extends Account {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckingAccount.class);

    /**
     * Khởi tạo tài khoản vãng lai.
     *
     * @param accountNumber Số tài khoản
     * @param balance Số dư ban đầu
     */
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        double initialBalance = getBalance();
        try {
            doDepositing(amount);
            double finalBalance = getBalance();
            Transaction transaction = new Transaction(
                    Transaction.TYPE_DEPOSIT_CHECKING,
                    amount,
                    initialBalance,
                    finalBalance
            );
            addTransaction(transaction);
            LOGGER.info("Nạp tiền vào tài khoản vãng lai {} thành công: +${}. Số dư mới: ${}",
                    getAccountNumber(), amount, finalBalance);
        } catch (BankException e) {
            LOGGER.error("Nạp tiền tài khoản vãng lai {} thất bại: {}", getAccountNumber(), e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        double initialBalance = getBalance();
        try {
            doWithdrawing(amount);
            double finalBalance = getBalance();
            Transaction transaction = new Transaction(
                    Transaction.TYPE_WITHDRAW_CHECKING,
                    amount,
                    initialBalance,
                    finalBalance
            );
            addTransaction(transaction);
            LOGGER.info("Rút tiền từ tài khoản vãng lai {} thành công: -${}. Số dư còn lại: ${}",
                    getAccountNumber(), amount, finalBalance);
        } catch (BankException e) {
            LOGGER.error("Rút tiền tài khoản vãng lai {} thất bại: {}", getAccountNumber(), e.getMessage());
        }
    }
}