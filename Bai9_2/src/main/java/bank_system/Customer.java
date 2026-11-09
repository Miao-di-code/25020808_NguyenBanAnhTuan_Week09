package bank_system;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp đại diện cho thông tin một khách hàng.
 */
public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList;

    /**
     * Khởi tạo mặc định cho khách hàng.
     */
    public Customer() {
        this(0L, "");
    }

    /**
     * Khởi tạo khách hàng với thông tin đầy đủ.
     *
     * @param idNumber Số CMND/CCCD
     * @param fullName Họ và tên khách hàng
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
        this.accountList = new ArrayList<>();
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    /**
     * Cập nhật danh sách tài khoản của khách hàng.
     *
     * @param accountList Danh sách tài khoản mới
     */
    public void setAccountList(List<Account> accountList) {
        if (accountList == null) {
            this.accountList = new ArrayList<>();
        } else {
            this.accountList = accountList;
        }
    }

    /**
     * Thêm một tài khoản cho khách hàng nếu chưa tồn tại.
     *
     * @param account Tài khoản cần thêm
     */
    public void addAccount(Account account) {
        if (account == null) {
            return;
        }
        if (!accountList.contains(account)) {
            accountList.add(account);
        }
    }

    /**
     * Xóa một tài khoản khỏi danh sách của khách hàng.
     *
     * @param account Tài khoản cần xóa
     */
    public void removeAccount(Account account) {
        if (account == null) {
            return;
        }
        accountList.remove(account);
    }

    /**
     * Trả về chuỗi thông tin của khách hàng.
     *
     * @return Thông tin khách hàng dạng văn bản
     */
    public String getCustomerInfo() {
        return "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
    }
}