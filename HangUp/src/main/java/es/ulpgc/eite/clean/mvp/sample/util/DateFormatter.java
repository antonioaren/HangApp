package es.ulpgc.eite.clean.mvp.sample.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pedro Arenas on 27/5/17.
 */

public class DateFormatter {

    public static String convertDateToString(Date date) {
        String DATE_PATTERN = "dd/MM/yyyy";
        return new SimpleDateFormat(DATE_PATTERN).format(date);
    }
}
