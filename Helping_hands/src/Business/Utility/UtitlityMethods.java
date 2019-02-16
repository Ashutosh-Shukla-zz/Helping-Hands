/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author shukl
 */
public class UtitlityMethods {

    public static String getStringFromDate(Date date) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        String reportDate = df.format(date);
        return reportDate;
    }

    public static Date getDateFromString(String s) {
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();;
        try {
            date = format.parse(s);
        } catch (ParseException ex) {
            System.err.println(ex.getStackTrace());
        }
        return date;
    }

}
