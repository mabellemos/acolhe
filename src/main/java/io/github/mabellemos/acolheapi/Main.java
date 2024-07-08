package io.github.mabellemos.acolheapi;

import io.github.mabellemos.acolheapi.core.domain.Adresses;

import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       UUID id = UUID.randomUUID();

       Adresses end = new Adresses(id);
       System.out.println(end.toString());
       end.alter(id);
       System.out.println(end.toString());
    }
}