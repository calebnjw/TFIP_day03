package myapp;

import myapp.interfaces.CanHit;

public class Troll extends Monster implements CanHit {

  public Troll() {
    super.setName("Troll");
    super.setHp(10);
  }

  @Override
  public String toString() {
    return "Troll {name = %s, hp= %s} \n".formatted(super.getName(), super.getHp());
  }
}
