package controller;


import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller{

    @RequestMapping("/helloworld")
    public String helloworld(){
        return "helloworld";
    }

}
