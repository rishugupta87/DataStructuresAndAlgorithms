package robert;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a singleton in Java which offers a method of converting a state abbreviation
 * (CA, NY) to a full name (New York, California)
 */
public class StateAbbreviation {

    private final Map<String, String> STATE_MAP;

    private static final StateAbbreviation singleton = new StateAbbreviation();

    public static StateAbbreviation getInstance() {
        return singleton;
    }

    private StateAbbreviation() {
        STATE_MAP = new HashMap<String, String>();
        STATE_MAP.put("CA", "Califormia");
        STATE_MAP.put("NY", "New York");
        STATE_MAP.put("LA", "Los Angeles");
        STATE_MAP.put("KS", "Kansas State");
    }

    public String stateCodeToFullName(final String stateCode) {
        return STATE_MAP.get(stateCode);
    }
}
