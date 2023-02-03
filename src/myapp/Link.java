package myapp;

import myapp.interfaces.CanHit;

public class Link {
  public Link() {}

  public void attack (CanHit objectCanHit) {
    if (objectCanHit.isDead()) {
      return;
    }
    System.out.printf("Die!! \n");
    objectCanHit.getHit(3);
  }

  public void attack (Tree tree) {

  }
}
