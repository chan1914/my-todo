package com.example.UI;

import com.example.Models.Group;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@Route("")
public class MainView extends VerticalLayout {

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    Grid<Group> grid = new Grid<>(Group.class);

    Group[] responseBody = restTemplate.getForObject(
            "http://server.mikk149c.com:89/GetGoups", Group[].class);

    public MainView() {


        grid.setItems(responseBody);
        add(grid);

        MultiFileMemoryBuffer multiFileMemoryBuffer = new MultiFileMemoryBuffer();
        Upload upload = new Upload(multiFileMemoryBuffer);






        add(upload);





    }


}

