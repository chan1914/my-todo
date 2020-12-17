package com.example.UI;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route("Login")
public class Login extends VerticalLayout {



    public Login(){

        add(new TextField("Firstname"));
        add(new TextField("Lastname"));


    }
}
