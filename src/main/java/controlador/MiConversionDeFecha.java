package controlador;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class MiConversionDeFecha extends StrutsTypeConverter{
	// WARNING not safe in multi-threaded environments
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @SuppressWarnings("rawtypes")
	@Override
    public Object convertFromString(Map context, String[] strings, Class toClass) {     
        if (strings == null || strings.length == 0 || strings[0].trim().length() == 0) {
            return null;
        }

        try {
            return DATE_FORMAT.parse(strings[0]);
        } catch (ParseException e) {
            throw new TypeConversionException("Unable to convert given object to date: " + strings[0]);
        }
    }

    @SuppressWarnings("rawtypes")
	@Override
    public String convertToString(Map context, Object date) {
        if (date != null && date instanceof Date) {         
            return DATE_FORMAT.format(date);
        } else {
            return null;
        }
    }
}
