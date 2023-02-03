package myapp;

import java.util.List;

import myapp.interfaces.CanHit;

import java.util.ArrayList;

public class GameMain {
  public static void main(String[] args) {
    List<Troll> enemies = new ArrayList<>();
    
    Link link = new Link();
    CanHit fir = new Tree();

    if (fir instanceof Tree) {
      Tree t = (Tree) fir;

      System.out.printf(fir.toString());
      link.attack(t);
      System.out.printf(fir.toString());
      link.attack(t);
      System.out.printf(fir.toString());
    }

    for (int i = 0; i < 3; i ++) {
      enemies.add(new Troll());
    }

    // can be simplified from: 
    // for (int i = 0; i < 3; i ++) {
    //   System.out.printf(enemies.get(i).toString());
    // }
    // to this: 
    for (CanHit e: enemies) {
      System.out.printf(e.toString());
      link.attack(e);
      link.attack(e);
      link.attack(e);
      link.attack(e);
      System.out.printf(e.toString());
    }
  }
}
