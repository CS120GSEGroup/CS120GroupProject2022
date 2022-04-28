package RPGGame.characters;

public interface Fightable {
    void attack(Character opponent, Character activePlayer);

    int takeDamage(Character activePlayer);

    int heal();

    void block();
}
