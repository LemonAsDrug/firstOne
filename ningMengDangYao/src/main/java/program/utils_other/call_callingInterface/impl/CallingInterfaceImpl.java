package program.utils_other.call_callingInterface.impl;

import program.utils_other.call_callingInterface.CallingInterface;

public class CallingInterfaceImpl implements CallingInterface {

    @Override
    public String getName() {
        return "吴存洋";
    }

    @Override
    public Integer getAge() {
        return new Integer(22);
    }
}
