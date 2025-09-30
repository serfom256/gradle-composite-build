package org.myapp;

import org.sample.numberutils.Numbers;
import org.sample.stringutils.Strings;
import org.apache.commons.lang3.StringUtils;
import org.api.Api;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringUtils.containsAny("x123abc", 'x', 'y', 'z')); // dependency from ext-lib platform
        System.out.println(Numbers.getRandomNumber()); // dependency from :my-lib:number-utils
        System.out.println(Strings.getRandomNumber()); // dependency from :my-lib:string-utils
        System.out.println(new MyApiImpl().doSmth()); // dependency from :my-app:api
    }
}

class MyApiImpl implements Api {

    @Override
    public String doSmth() {
        return "Api implementation called";
    }
}
