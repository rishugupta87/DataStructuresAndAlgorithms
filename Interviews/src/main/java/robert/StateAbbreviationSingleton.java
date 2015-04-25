package robert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rg029761 on 8/13/15.
 */
public enum StateAbbreviationSingleton {
    SINGLETON;

    private final Map<String, String> STATE_MAP;

    StateAbbreviationSingleton() {
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
