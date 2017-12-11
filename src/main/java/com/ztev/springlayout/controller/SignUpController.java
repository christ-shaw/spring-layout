package com.ztev.springlayout.controller;

import com.ztev.springlayout.pojo.Account;
import com.ztev.springlayout.pojo.SignupForm;
import com.ztev.springlayout.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SignUpController
{
    @Autowired
    MessageSource messageSource;

    @Autowired
    private AccountService accountService;


    @GetMapping("/signup")
    String signUp(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith)
    {
        model.addAttribute("signupForm",new SignupForm());
        return "signup/signup";
    }

    @PostMapping("/signup")
    public String signUP(Model model,@Valid @ModelAttribute SignupForm signup, Errors errors, RedirectAttributes rs)
    {
        if (errors.hasErrors()) {
            return "signup/signup";
    }
        Account account = accountService.save(signup.createAccount());
        accountService.signin(account);
        // see /WEB-INF/message/messages_zh.properties and /WEB-INF/views/homeSignedIn.html
        //MessageHelper.addSuccessAttribute(ra, "signup.success");
        return "redirect:/";
    }
}
