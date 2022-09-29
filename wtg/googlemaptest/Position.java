package com.wtg.googlemaptest;

import java.util.ArrayList;

public class Position {

// Properties of Position
// 위치 속성
    public String position;
    public String image;
    public ArrayList<String> players = new ArrayList<String>();

    public Position(String position) {
        this.position = position;
    }

    public String toString() {
        return position;
    }

}
