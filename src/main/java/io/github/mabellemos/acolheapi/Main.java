package io.github.mabellemos.acolheapi;

import io.github.mabellemos.acolheapi.core.domain.Adresses;
import io.github.mabellemos.acolheapi.core.domain.Responsible;

import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       UUID id = UUID.randomUUID();

       Responsible end = new Responsible(id, "Maria Júlia Silva", "82934568");
       System.out.println(end.toString());
       end.alter(id);
       System.out.println(end.toString());
    }
}