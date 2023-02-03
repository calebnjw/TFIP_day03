package myapp;

import myapp.interfaces.CanHit;

public class Gnome extends Monster implements CanHit {
  public Gnome() {
    setName("Gnome");
    setHp(5);
  }

  @Override
  public String toString() {
    return "Gnome {name = %s, hp= %s} \n".formatted(super.getName(), super.getHp());
  }
}
