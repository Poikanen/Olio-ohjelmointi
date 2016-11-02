/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OlioOhjelmointi;

/**
 *
 * @author tommi
 */
abstract class Character {
    protected WeaponBehavior weapon;
    public void fight()
    {
        System.out.println(this.getClass().getSimpleName()+" tappelee aseella "+weapon.getClass().getSimpleName());
    }
}
abstract class WeaponBehavior {
    public void useWeapon()
    {
        System.out.println(' ');
    }
}
class Knight extends Character{
    public Knight ()
    {
        weapon = new Knife();
    }
}
class King extends Character{
    public King ()
    {
        weapon = new Knife();
    }
}
class Queen extends Character{
    public Queen ()
    {
        weapon = new Knife();
    }
}
class Troll extends Character{
    public Troll ()
    {
        weapon = new Knife();
    }
}
class Knife extends WeaponBehavior {
    public Knife ()
    { 
    }
}
class Sword extends WeaponBehavior {
    public Sword ()
    { 
    }
}
class Club extends WeaponBehavior {
    public Club ()
    { 
    }
}
class Axe extends WeaponBehavior {
    public Axe ()
    { 
    }
}