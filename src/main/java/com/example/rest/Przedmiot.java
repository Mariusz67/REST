package com.example.rest;
import lombok.Data;

@Data
public class Przedmiot {

    private int id;

    private String nazwa;

    private int punkty;

    private String sala;

    private Boolean czyEgzamin;
}
