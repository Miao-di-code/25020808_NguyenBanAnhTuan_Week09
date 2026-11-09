package bank_system;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp trừu tượng đại diện cho một tài khoản ngân hàng.
 */
public abstract class Account {
    private static final Logger LOGGER = LoggerFactory.getLogger(Account.class);

    public static final String CHECKING_TYPE = "CHECKING";
    public static final String SAVINGS_TYPE = "SAVINGS";

    // Hằng số cũ để đảm bảo tương thích ngược
    public static final String checking_type = CHECKING_TYPE;
    public static final String savings_type = SAVINGS_TYPE;

    private long accountNumber;
    private double balance;
    protected List<Transaction> transactionList;

    /**
     * Khởi tạo tài khoản ngân hàng.
     *
     * @param accountNumber số tài khoản
     * @param balance số dư ban đầu
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionList = new ArrayList<>();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    /**
     * Cập nhật danh sách giao dịch.
     *
     * @param transactionList danh sách giao dịch mới
     */
    public void setTransactionList(List<Transaction> transactionList) {
        if (transactionList == null) {
            this.transactionList = new ArrayList<>();
        } else {
            this.transactionList = transactionList;
        }
    }

    /**
     * Nạp tiền vào tài khoản.
     *
     * @param amount số tiền nạp
     */
    public abstract void deposit(double amount);

    /**
     * Rút tiền khỏi tài khoản.
     *
     * @param amount số tiền rút
     */
    public abstract void withdraw(double amount);

    protected void doDepositing(double amount) throws InvalidFundingAmountException {
        if (amount <= 0) {
            throw new InvalidFundingAmountException(amount);
        }
        this.balance += amount;
    }

    protected void doWithdrawing(double amount)
            throws InvalidFundingAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidFundingAmountException(amount);
        }
        if (amount > balance) {
            throw new InsufficientFundsException(amount);
        }
        this.balance -= amount;
    }

    /**
     * Thêm một giao dịch vào danh sách.
     *
     * @param transaction giao dịch cần thêm
     */
    public void addTransaction(Transaction transaction) {
        if (transaction != null) {
            transactionList.add(transaction);
        }
    }

    /**
     * Trả về chuỗi lịch sử giao dịch.
     *
     * @return Lịch sử giao dịch dạng chuỗi
     */
    public String getTransactionHistory() {
        StringBuilder builder = new StringBuilder();
        builder.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":\n");
        for (int i = 0; i < transactionList.size(); i++) {
            builder.append(transactionList.get(i).getTransactionSummary());
            if (i < transactionList.size() - 1) {
                builder.append("\n");
            }
        }
        LOGGER.debug("Đã trích xuất lịch sử giao dịch cho tài khoản: {}", accountNumber);
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Account)) {
            return false;
        }
        Account other = (Account) obj;
        return this.accountNumber == other.accountNumber;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(accountNumber);
    }
}