package RPGGame.characters;

public class Soldier extends NPC {
    public Soldier() {
        this.setLevel((int) (Math.random() * 3) + 5);
        this.setHealth((this.getLevel() + 10));
        this.setDamage((this.getLevel() + 3));
        this.setName("Soldier");
    }

    @Override
    public void printImage() {
        System.out.println("""
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⢋⣿⠁⠉⠻⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣷⣾⣿⢳⡖⢤⣃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⣿⠀⠁⠀⣹⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⣸⣿⣀⣀⢀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡤⠿⠟⠛⠛⠋⠉⠙⣒⣶⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡖⠉⢠⠏⠀⠀⠀⠀⠀⠘⣩⠔⣏⠌⠓⠤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⢾⠀⡠⠃⡖⠂⡝⠀⢀⠈⡎⠀⣸⠘⣄⠀⠀⠘⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣟⣺⢸⡧⠤⠼⠀⠷⠒⢹⠘⢇⠼⢹⡴⡩⢦⠀⠀⠈⢦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣟⡒⢾⣏⣧⠔⡺⠸⡉⠑⠺⠀⠈⢢⠊⢻⣵⣻⠷⠤⠤⣼⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣏⣀⠈⠑⡟⠁⠴⣥⠄⠑⠀⠀⣀⡴⠺⡯⣥⠴⠖⠒⠛⢋⣉⡏⡆⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⢫⠃⡸⢙⣆⡇⢸⢰⠃⠀⠀⡰⠟⠁⠀⠀⣱⠗⠒⣛⣛⣋⣉⣩⡷⠁⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⡎⢠⠃⣼⣽⢱⣈⣾⣠⣒⡟⠀⠀⠀⣠⣾⠿⢿⠉⠉⠉⠉⠉⠊⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠟⠉⠫⣺⠋⢈⣯⠼⣬⠷⢤⣽⣤⣀⡜⠻⣿⣖⢞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⢀⠞⠀⢀⣀⡘⢦⢸⣅⣀⠀⠙⠫⣽⠀⠀⠈⠉⠹⣿⡞⣢⣴⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⣜⠀⠀⡜⠫⣌⢳⣼⡡⢴⡍⡖⡖⠉⢩⠙⡍⠉⢒⡞⡫⢿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⣧⣀⣴⡕⠀⠀⠉⠣⣝⢾⡄⡇⡇⠀⢸⠀⢳⠰⠯⠚⢣⣾⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⢸⢹⡽⡭⡆⠀⠀⠀⠀⠈⢿⢳⡇⢧⠀⢠⠀⠘⡄⠀⠀⠀⢻⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⢸⣎⠧⢧⡄⠀⠀⠀⠀⠀⠘⡆⡇⢸⠀⢸⠀⠀⡇⠀⠀⠀⠀⢿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⢸⡟⠀⢈⣧⠀⠀⠀⠀⠀⠀⣇⣸⢸⠀⠈⠂⠀⢡⠀⠀⠀⠀⠘⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⢸⣧⣤⡀⣵⠀⠀⠀⠀⠀⠀⡏⢹⢸⠀⠀⠀⠀⢸⡀⠀⠀⠀⠀⢏⢿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⣨⡏⢀⡡⠰⠆⠀⠀⠀⠀⠀⡇⢸⠸⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡎⢿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⣇⠛⠞⠃⠀⠀⠀⠀⠀⠀⢠⠷⡏⡏⠐⠒⠒⠒⡒⠲⠶⢒⣖⣒⠶⡇⠘⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⡜⢠⠃⡇⠀⠀⠀⠀⢃⠀⠀⠀⠀⠀⡇⠀⠀⠘⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⢠⡃⡜⠀⡇⠀⠀⠀⠀⠸⡀⠀⠀⠀⠀⢱⠀⠀⠀⠘⡇⣧⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢠⠁⠀⠀⠀⠀⠀⠀⠀⠀⡎⢩⠃⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠸⡀⠀⠀⠀⠘⡼⣧⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⣸⠀⡎⠀⢠⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠹⡙⣧⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⢠⣧⡜⠀⠀⢸⠀⠀⠀⠀⠀⠀⠈⡆⠀⠀⠀⠀⢡⠀⠀⠀⠀⠀⠱⣈⡇⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⢀⠏⡼⠁⠀⢀⡇⠀⠀⠀⠀⠀⠀⠀⢳⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠈⠃⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢻⠀⠀⠀⠀⠀⢀⣞⡼⠁⠀⠀⠸⠀⠀⠀⠀⠀⠀⠀⠀⠘⡀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⢀⠎⣼⠁⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠈⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢻⠀⠀⠀⢠⡎⡜⡆⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠀⠀⠀⠀⢇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢸⠀⠀⣠⢫⡿⠛⢲⣦⣄⣀⣀⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣠⡤⣤⣀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢸⣆⡰⢻⠎⠀⣀⣀⣿⣿⡭⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠁⠀⠀⠙⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠛⠷⠋⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠧⢤⡤⠤⠴⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠰⠲⠀⠆⠦⠶⠆⠶⠲⠖⠰⠰⠄⠶⠞⠲⠆⠠⠲⠆⠲⠳⠀⠲⠦⠠⠆⠶⠰⠖⠖⠖⠶⠲⠒⠆⠶⠠⠂⠆⠲⠲⠢⠂⠤""");
    }
}
