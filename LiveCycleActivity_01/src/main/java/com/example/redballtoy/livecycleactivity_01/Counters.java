package com.example.redballtoy.livecycleactivity_01;


import java.io.Serializable;

//Выведенный в отдельный класс логика приложения
public class Counters implements Serializable {
    private int counter=0;

   public Counters() {
       counter = 0;
   }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String increaseCuunter() {
       return String.valueOf(++counter);
    }

}
