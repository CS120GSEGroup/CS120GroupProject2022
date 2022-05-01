package RPGGame.characters;

public class Boss extends NPC {

    public Boss() {
    }

//    public Boss(int health, int attackPoints, int level, int potions) {
//        super(health, attackPoints, level, potions);
//    }



    @Override
    public int takeDamage(GameCharacter activePlayer) {
        return 0;
    }


}
