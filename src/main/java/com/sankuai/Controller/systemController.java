package com.sankuai.Controller;

import com.sankuai.Model.AccountManager;
import com.sankuai.Model.loginInfo;
import com.sankuai.Model.registerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class systemController {
    @Autowired
    private AccountManager manager;

    @RequestMapping("login")
    public String login(loginInfo info) {
        if (info == null) {
            return "inputError";
        }
        if (manager.searchAccount(info)) {
            return "success";
        } else {
            return "loginFailed";
        }
    }

    @RequestMapping("/register")
    public String register(registerInfo info) {
        if (info == null) {
            return "inputError";
        } else {
            if (manager.isValidPara(info)) {
                manager.addNewAccount(info);
                return "success";
            } else
                return "registerFailed";
        }
    }

    public String registerV2(registerInfo info) {
        if (info == null) {
            return "inputError";
        }

        if (manager.isValidPara(info)) {
            manager.addNewAccount(info);
            return "success";
        }

        return "registerFailed";
    }

    public String registerV3(registerInfo info) {
        if (info == null || !manager.isValidPara(info)) {
            return "registerFailed";
        }

        try {
            manager.addNewAccount(info);
            return "success";
        } catch (Exception e) {
            // log
            return "registerFailed";
        }

    }


    @RequestMapping("/jumptoRegister")
    public String jumptoRegisterPage() {
        return "register";
    }

}
