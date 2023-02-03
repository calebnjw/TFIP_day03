package myapp;

import myapp.interfaces.CanHit;

public class Monster implements CanHit {
  // attributes
  private String name;
  private int hp;

  // constructor
  public Monster() {}

  // getters and setters
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public int getHp() {
    return this.hp;
  }
  public void setHp(int hp) {
    this.hp = Math.max(hp, 0);
  }

  // methods
  
  public void getHit(int damage) {
    int currentHP = this.getHp();
    this.setHp(currentHP - damage);
    this.isDead();
  }
  
  // public int attack() {

  // }

  public boolean isDead() {
    if (hp <= 0) {
      System.out.printf("Monster is dead. \n");
      return true;
    } else { return false; }
  }

  public String toString() {
    return "Monster {name = %s, hp= %s} \n".formatted(this.getName(), this.getHp());
  }

}