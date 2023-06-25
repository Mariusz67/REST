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

    public List<Przedmiot> getListaWyfiltrowanaPrzedmiotow(String sala, Boolean czyEgzamin ){
        if (sala==null && czyEgzamin==null){
            return przedmioty;
        }
        List<Przedmiot> wyfiltrowanePrzedmioty = new ArrayList<>();
        for (Przedmiot p : przedmioty){
            if((czyEgzamin==null) && p.getSala().equals(sala)){
                wyfiltrowanePrzedmioty.add(p);
            }else if (sala==null && p.getCzyEgzamin().equals(czyEgzamin)){
                wyfiltrowanePrzedmioty.add(p);
            } else if (p.getSala().equals(sala) && p.getCzyEgzamin().equals(czyEgzamin)) {
                wyfiltrowanePrzedmioty.add(p);
            }
        }
        return wyfiltrowanePrzedmioty;
    }

}
