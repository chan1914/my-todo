package com.example.Controller;

import com.example.Models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GroupsController {

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    public Group[] getGroups() {

        Group[] responseBody = restTemplate.getForObject(
                "http://DQF-Analysis-Repo/GetGoups", Group[].class);

        for (Group g : responseBody) {
            System.out.println(g.getGroup());
            System.out.println(responseBody);
        }

        return responseBody;
    }







}
