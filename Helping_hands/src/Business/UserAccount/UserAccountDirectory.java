/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.Role.UserRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class UserAccountDirectory {

    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public UserAccount authenticateUser(String username, String password) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)) {
                if (ua.getRole() instanceof UserRole) {
                    if (ua.getStatus().equalsIgnoreCase("Active")) {
                        return ua;
                    } else {
                        return null;
                    }
                } else {
                    return ua;
                }
            }
        }
        return null;
    }

    public UserAccount createUserAccount(String username, String password, String name, String address, String registerationNumber, int ssn, String state, int phone, Role role) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
//     userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccount.setName(name);
        userAccount.setAddress(address);
        userAccount.setSsn(ssn);
        userAccount.setState(state);
        userAccount.setRegisterationNumber(registerationNumber);

        userAccount.setPhone(phone);
        userAccount.setStatus("PENDING");
        userAccountList.add(userAccount);
        return userAccount;
    }

    public UserAccount createUserAccount(String username, String password, Employee employee, Role role) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }

    public boolean checkIfUsernameIsUnique(String username) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
}
