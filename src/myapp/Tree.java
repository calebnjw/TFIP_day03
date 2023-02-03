package myapp;

import myapp.interfaces.CanHit;

public class Tree implements CanHit {
  private int hp;
  private String name;
  
  public Tree() {};

  public int getHp() {
    return hp;
  }
  public void setHp(int hp) {
    this.hp = hp;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public boolean isDead() {
    if (hp <= 0) {
      System.out.printf("Tree destroyed. \n");
      return true;
    } else { return false; }
  }

  public void getHit(int damage) {
    int currentHP = this.getHp();
    this.setHp(currentHP - damage);
    this.isDead();
  }

  public String toString() {
    return "Tree {name = %s, hp= %s} \n".formatted(this.getName(), this.getHp());
  }
  
}
