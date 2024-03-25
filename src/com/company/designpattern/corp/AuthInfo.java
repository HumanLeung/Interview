package com.company.designpattern.corp;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Administrator
 */
@Setter
@Getter
public class AuthInfo {
    private String code;
    private String info = "";
    public AuthInfo(String code, String... infos) {
        this.code = code;
        for (String str : infos) {
            info = this.info.concat(str + " ");
        }
    }
}
