package hello.hellospring.controller;

import hello.hellospring.mapper.UserProfileMapper;
import hello.hellospring.model.UserProfile;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserProfileController {

    private UserProfileMapper mapper;

    //2
    //생성자
    public UserProfileController(UserProfileMapper mapper){
        this.mapper = mapper;
    }

    //data 조회
    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        return mapper.getUserProfile(id);
    }

    //data 전체 조회
    @GetMapping("/user/all")
    public List<UserProfile> getUserProfile() {
        return mapper.getUserProfileList();
    }

    //data생성
    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        mapper.insertUserProfile(id, name, phone, address);

    }

    //data수정
    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        mapper.updateUserProfile(id, name, phone, address);
    }

    //data삭제
    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        mapper.deleteUserProfile(id);
    }
}