package robert;

import org.junit.Test;

/**
 * Created by rg029761 on 8/13/15.
 */
public class StateAbbreviationTest {

    @Test
    public void testStateCodes() {
        System.out.println(StateAbbreviation.getInstance().stateCodeToFullName("nn"));
        System.out.println(StateAbbreviation.getInstance().stateCodeToFullName("NY"));
    }

    @Test
    public void testStateCodes2() {
        System.out.println(StateAbbreviationSingleton.SINGLETON.stateCodeToFullName("KS"));
    }


}
