/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utility;

/**
 *
 * @author shukl
 */
public class SsnValidator {

    public static Boolean validateSsn(String ssnNumber) {

        int length = ssnNumber.length();
        if (length < 9) {
            return Boolean.FALSE;
        }

        if (ssnNumber.matches("^(\\d{3}-?\\d{2}-?\\d{4})$")) {
            return Boolean.TRUE;

        }
        return Boolean.FALSE;
    }
}
