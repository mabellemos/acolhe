package io.github.mabellemos.acolheapi;

import io.github.mabellemos.acolheapi.core.domain.Adresses;
import io.github.mabellemos.acolheapi.core.domain.Clothes;
import io.github.mabellemos.acolheapi.core.domain.Responsible;
import io.github.mabellemos.acolheapi.core.domain.Shelters;

import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       UUID id = UUID.randomUUID();

       Clothes end = new Clothes(id);
       System.out.println(end.toString());
       end.alter(id);
       System.out.println(end.toString());
    }
}