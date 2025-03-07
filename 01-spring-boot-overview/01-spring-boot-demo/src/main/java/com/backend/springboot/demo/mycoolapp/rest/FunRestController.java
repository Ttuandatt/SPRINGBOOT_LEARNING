package com.backend.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cr7")
public class FunRestController {
    @GetMapping("/goat")    
    public String sayHello(){
        return "Hello World";
    }
}
// Có 2 kiểu Mapping trong Controller
// Parent Mapping: là cái nằm ngay dưới @RestController, trong trường hợp này là @RequestMapping("/rest"). Túc là nó ở mức lớp (Class level)
// Child Mapping: là cái nằm ngay trên 1 phương thức, trong trường hợp này là @GetMapping("/"). Tức là nó ở mức phương thức (Method level)
// TH1: chỉ dùng Parent Mapping, ở đây là @RequestMapping("/cr7") thì bên trong Controller phải thêm @RequestMapping(method = RequestMethod.GET) mới chạy được, lúc này endpoint là: http://localhost:8080/cr7
// TH2: chỉ dùng @GetMapping("/goat") thì endpoint sẽ là: http://localhost:8080/goat
// TH2: dùng cà @RequestMapping("/cr7") & @GetMapping("/goat") thì endpoint sẽ là: http://localhost:8080/cr7/goat
//
