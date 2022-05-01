package RPGGame.characters;


public class PlayableCharacter extends GameCharacter {

    int potions;
    int specialCounter;


    public int getPotions() {
        return potions;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }

    public int getSpecialCounter() {
        return specialCounter;
    }

    public void setSpecialCounter(int specialCounter) {
        this.specialCounter = specialCounter;
    }

    public final void heal() {
        if (this.getPotions() > 0) {
            this.setHealth(this.getHealth() + 10);
            this.setPotions(this.getPotions() - 1);
        }else
        System.out.println("No potions left");
    }

    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {

    }

    @Override
    public int takeDamage(GameCharacter activePlayer) {
        return 0;
    }
}
