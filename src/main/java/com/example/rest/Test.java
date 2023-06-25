package com.example.rest;

import com.example.rest.BazaDanychPrzedmiotow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class Test {
@Autowired
    private BazaDanychPrzedmiotow bazaDanychPrzedmiotow;

    @GetMapping("test")
    public String metodaTestowa(){return "sukces";}

    @GetMapping(value="przedmioty", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Przedmiot> wczytajWszystkiePrzedmioty(){
       return bazaDanychPrzedmiotow.getPrzedmioty();
    }

    @PostMapping(value="przedmioty", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void dodajPrzedmiot(@RequestBody Przedmiot przedmiot){
        bazaDanychPrzedmiotow.addPrzedmiot(przedmiot);
    }

    @DeleteMapping(value="przedmioty", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteActivities(){
        bazaDanychPrzedmiotow.deleteWszystkie();
    }

}
