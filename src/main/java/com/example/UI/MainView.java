package com.example.UI;

import com.example.Models.Group;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Route("")
public class MainView extends VerticalLayout {

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    public MainView() {

        Group[] responseBody = restTemplate.getForObject(
                "http://server.mikk149c.com:89/GetGoups", Group[].class);

        for(Group g : responseBody){
            System.out.println(g.getGroup());
        }

        Grid<Group> grid = new Grid<>(Group.class);

        add(grid);

        ListBox<Group> list = new ListBox<>();
        list.setItems(responseBody);
        add(list);

        MultiFileMemoryBuffer multiFileMemoryBuffer = new MultiFileMemoryBuffer();
        Upload upload = new Upload(multiFileMemoryBuffer);

        ListBox<String> groups = new ListBox<>();
        groups.setItems("Bankery Transaction", "Bank data", "DashBoardDataCSV");
        groups.setValue("Bankery Transaction");


        add(upload);
        add(groups);










    }


}

