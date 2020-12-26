package com.example.Controller;


import com.example.Models.Group;
import com.example.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GroupsController {

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    public Group[] getGroups() {

        Group[] responseBody = restTemplate.getForObject(
                "http://server.mikk149c.com:89/GetGoups", Group[].class);

        for (Group g : responseBody) {
            System.out.println(g.getGroup());
            System.out.println(responseBody);
        }

        return responseBody;
    }

    public User[] getUsers() {

        User[] users = restTemplate.getForObject(
                "http://server.mikk149c.com:89/analysis/get", User[].class);

        for (User u : users) {
            System.out.println(u.getId());

        }
        return users;
    }






}
