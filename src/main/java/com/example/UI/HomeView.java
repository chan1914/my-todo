package com.example.UI;

import com.example.Models.Group;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@PageTitle("Data Quality - Homepage")
@Route("home")
public class HomeView extends VerticalLayout{

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    Grid<Group> grid = new Grid<>(Group.class);

    Group[] responseBody = restTemplate.getForObject(
            "http://server.mikk149c.com:89/GetGoups", Group[].class);


    public HomeView() {

        H1 logo = new H1("Data quality framework");
        logo.addClassName("logo");
        DrawerToggle drawerToggle = new DrawerToggle();
        add(drawerToggle);


        ListBox<String> list = new ListBox<>();
        grid.setItems(responseBody);
        grid.setWidth("50%");

        add(logo);
        add(grid);

    }
}

