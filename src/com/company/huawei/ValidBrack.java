package com.company.huawei;

import java.util.Objects;

/**
 * @author Administrator
 */
public class ValidBrack {
    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        while(true){
            int l=s.length();
            s=s.replace("()","");
            s=s.replace("{}","");
            s=s.replace("[]","");
            if(s.length()==l)
            {
                return l==0;
            }
        }
    }
}
