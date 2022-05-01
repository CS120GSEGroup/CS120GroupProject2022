package RPGGame.characters;

public class Fighter extends PlayableCharacter {

    public Fighter() {
        this.setHealth(40);
        this.setDamage(20);
        this.setLevel(1);
    }



    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {

    }

    @Override
    public int takeDamage(GameCharacter activePlayer) {
        return 0;
    }

    @Override
    public void useSpecialAbility(GameCharacter opponent, GameCharacter activePlayer) {

    }




    @Override
    public String toString() {
        return this.getName() + " the Warrior";
    }
}
