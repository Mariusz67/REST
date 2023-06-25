package com.example.rest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class BazaDanychPrzedmiotow {
    private List<Przedmiot> przedmioty = new ArrayList<>();

    public List<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }

    public void addPrzedmiot (Przedmiot przedmiot) {
        przedmioty.add(przedmiot);
    }

    public void deleteWszystkie(){ przedmioty.clear();}
}
