package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api")
public class Test {
@Autowired
    private BazaDanychPrzedmiotow bazaDanychPrzedmiotow;

    //@GetMapping("test")
    //public String metodaTestowa(){return "sukces";}

//    @GetMapping(value="przedmioty", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Przedmiot> wczytajWszystkiePrzedmioty(){
//       return bazaDanychPrzedmiotow.getPrzedmioty();
//    }

    @PostMapping(value="przedmioty", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void dodajPrzedmiot(@RequestBody Przedmiot przedmiot){
        bazaDanychPrzedmiotow.addPrzedmiot(przedmiot);
    }

    @DeleteMapping(value="przedmioty", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteActivities(){
        bazaDanychPrzedmiotow.deleteWszystkie();
    }

    @GetMapping(value="przedmioty", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Przedmiot> wczytajWyfiltrowanePrzedmioty(
            @Nullable @RequestParam("sala") String sala,
            @Nullable @RequestParam("czyEgzamin") Boolean czyEgzamin) {
        return bazaDanychPrzedmiotow.getListaWyfiltrowanaPrzedmiotow(sala,czyEgzamin);
    }

    @GetMapping(value = "przedmioty/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getActivityById(@PathVariable("id") Integer id){
        Przedmiot przedmiot = bazaDanychPrzedmiotow.getPrzedmiotWgId(id);
        if (przedmiot == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(przedmiot);
    }

    @DeleteMapping(value="przedmioty/{id}")
    public ResponseEntity deleteActivitiesById(@PathVariable("id") Integer id){
        if (bazaDanychPrzedmiotow.deletePrzedmiotWgId(id)  ){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
