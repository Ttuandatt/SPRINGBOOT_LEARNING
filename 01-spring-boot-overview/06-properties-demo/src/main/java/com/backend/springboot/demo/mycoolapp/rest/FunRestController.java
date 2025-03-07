package com.backend.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cr7")
public class FunRestController {

    //inject properties for: coach.name & team.name
    @Value("${player.name}")
    private String playerName;
    @Value("${team.name}")
    private String teamName;
    @Value("${title.name}")
    private String titleName;

    @GetMapping("/teamInfo")
    private String teamInfo(){
        return "Team info: \n" + "Player name: " + playerName + "\n" + "Team name: " + teamName + "\n" + "Title name: " + titleName;
    }

    @GetMapping("/goat")    
    public String sayHello(){
        return "Hello World";
    }

    //expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

    //expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day<3";
    }
}
// Có 2 kiểu Mapping trong Controller
// Parent Mapping: là cái nằm ngay dưới @RestController, trong trường hợp này là @RequestMapping("/rest"). Túc là nó ở mức lớp (Class level)
// Child Mapping: là cái nằm ngay trên 1 phương thức, trong trường hợp này là @GetMapping("/"). Tức là nó ở mức phương thức (Method level)
// TH1: chỉ dùng Parent Mapping, ở đây là @RequestMapping("/cr7") thì bên trong Controller phải thêm @RequestMapping(method = RequestMethod.GET) mới chạy được, lúc này endpoint là: http://localhost:8080/cr7
// TH2: chỉ dùng @GetMapping("/goat") thì endpoint sẽ là: http://localhost:8080/goat
// TH3: dùng cà @RequestMapping("/cr7") & @GetMapping("/goat") thì endpoint sẽ là: http://localhost:8080/cr7/goat
// TH4: dùng cà @RequestMapping("/cr7") & @GetMapping("/workout") thì endpoint sẽ là: http://localhost:8080/cr7/workout
// TH5: dùng cà @RequestMapping("/cr7") & @GetMapping("/fortune") thì endpoint sẽ là: http://localhost:8080/cr7/fortune
