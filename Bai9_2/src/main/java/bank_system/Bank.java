package bank_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp đại diện cho ngân hàng chứa danh sách khách hàng.
 */
public class Bank {
    private static final Logger LOGGER = LoggerFactory.getLogger(Bank.class);
    private static final String ID_PATTERN = "\\d{9}";

    private List<Customer> customerList;

    public Bank() {
        this.customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * Thiết lập danh sách khách hàng.
     *
     * @param customerList danh sách khách hàng mới
     */
    public void setCustomerList(List<Customer> customerList) {
        if (customerList == null) {
            this.customerList = new ArrayList<>();
        } else {
            this.customerList = customerList;
        }
    }

    /**
     * Đọc danh sách khách hàng từ luồng đầu vào.
     *
     * @param inputStream luồng dữ liệu chứa thông tin khách hàng và tài khoản
     */
    public void readCustomerList(InputStream inputStream) {
        LOGGER.debug("Bắt đầu đọc dữ liệu danh sách khách hàng từ InputStream...");
        if (inputStream == null) {
            LOGGER.warn("InputStream đầu vào bị null.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            Customer currentCustomer = null;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                int lastSpaceIndex = line.lastIndexOf(' ');
                if (lastSpaceIndex <= 0) {
                    continue;
                }

                String token = line.substring(lastSpaceIndex + 1).trim();
                if (token.matches(ID_PATTERN)) {
                    String name = line.substring(0, lastSpaceIndex).trim();
                    currentCustomer = new Customer(Long.parseLong(token), name);
                    customerList.add(currentCustomer);
                    LOGGER.info("Thêm khách hàng thành công: {} (CMND: {})", name, token);
                } else if (currentCustomer != null) {
                    String[] parts = line.split("\\s+");
                    if (parts.length >= 3) {
                        long accountNumber = Long.parseLong(parts[0]);
                        String accountType = parts[1];
                        double balance = Double.parseDouble(parts[2]);

                        if (Account.CHECKING_TYPE.equals(accountType)) {
                            currentCustomer.addAccount(new CheckingAccount(accountNumber, balance));
                        } else if (Account.SAVINGS_TYPE.equals(accountType)) {
                            currentCustomer.addAccount(new SavingsAccount(accountNumber, balance));
                        }
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error("Lỗi khi đọc dữ liệu danh sách khách hàng", e);
        }
    }

    /**
     * Trả về thông tin khách hàng sắp xếp theo số CMND tăng dần.
     *
     * @return Chuỗi thông tin các khách hàng
     */
    public String getCustomersInfoByIdOrder() {
        customerList.sort(Comparator.comparingLong(Customer::getIdNumber));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < customerList.size(); i++) {
            builder.append(customerList.get(i).getCustomerInfo());
            if (i < customerList.size() - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    /**
     * Trả về thông tin khách hàng sắp xếp theo tên (và theo CMND nếu trùng tên).
     *
     * @return Chuỗi thông tin các khách hàng
     */
    public String getCustomersInfoByNameOrder() {
        List<Customer> sortedList = new ArrayList<>(customerList);
        sortedList.sort((c1, c2) -> {
            int compareName = c1.getFullName().compareTo(c2.getFullName());
            if (compareName != 0) {
                return compareName;
            }
            return Long.compare(c1.getIdNumber(), c2.getIdNumber());
        });

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sortedList.size(); i++) {
            builder.append(sortedList.get(i).getCustomerInfo());
            if (i < sortedList.size() - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}