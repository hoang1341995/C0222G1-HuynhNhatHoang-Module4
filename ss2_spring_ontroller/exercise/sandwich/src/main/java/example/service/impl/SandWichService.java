package example.service.impl;

import example.service.ISandWichService;

public class SandWichService implements ISandWichService {
    @Override
    public String returnYourChose(String[] condiment) {
        String mess = "";
        if (condiment.length == 0) {
            return  "you have not chosen !";
        } else {
            mess = "you chose: ";
            for (int i = 0; i < condiment.length; i++) {
                mess += condiment[i];
                if (i != (condiment.length - 1)) {
                    mess += ", ";
                }
            }
            return mess;
        }
    }
}
