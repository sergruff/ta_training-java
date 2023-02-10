package com.epam.training.student_Sergei_Bespalov;

import java.util.regex.Pattern;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;
    public Battleship8x8(final long ships) {
        this.ships = ships;
    }
    public boolean shoot(String shot) {
        if (!Pattern.compile("[A-H][0-8]").matcher(shot).matches()) {
            throw new IllegalArgumentException();
        }
        int bitPosition = 63-(shot.charAt(0)-65)-(shot.charAt(1)-49)*8; //позиция бита для переключение в положение 1
        long attempt = 1L << bitPosition;// координата выстрела
        this.shots=this.shots|attempt; // побитовое или для обновления координат выстрелов
        return (ships & attempt) != 0;
    }
    public String state() {
        StringBuilder builder = new StringBuilder();
        for (int i=63;i>-1;i--){
            if((i+1)%8==0&&i!=0) {
                builder.append("\n");}
            if ((ships&(1L<<i))!=0){//Есть ли корабль
               if((shots&(1L<<i))!=0){//корабль есть, был ли выстрел?
                   builder.append('☒');// корабль подбит
                   System.out.print('☒');
               } else {
                   builder.append('☐'); //корабль цел
                   System.out.print('☐');
               }
            } else if ((shots&(1L<<i))!=0){ //корабля нет, был ли выстрел?
                builder.append('×');// сюда стреляли
                System.out.print('×');
            } else {
                builder.append('.'); //не стреляли
                System.out.print('.');
            }
            }
        return builder.toString();
    }
}
