package utilz;

public class Constants {

    public static class Directions {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }
    public static class PlayerConstants {
        public static final int Pirate = 0;
        public static final int Mage = 1;

        public static final String pirate_path = "/res/player_sprites.png";
        public static final String mage_path = "/res/mage_sprites.png";

        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int ATTACK_1 = 6;
        public static final int ATTACK_JUMP_1 = 7;
        public static final int ATTACK_JUMP_2 = 8;

        public static int GetSpriteAmounts(int player_action) {
            switch (player_action) {
                case RUNNING:
                    return 6;
                case IDLE:
                    return 5;
                case HIT:
                    return 4;
                case JUMP:
                case ATTACK_1:
                case ATTACK_JUMP_2:
                case ATTACK_JUMP_1:
                    return 3;
                case GROUND:
                    return 2;
                case FALLING:
                default:
                    return 1;
            }
        }
        public static int GetPlayerClass(int player_class) {
            switch (player_class) {
                case Mage:
                    return 1;
                default:
                    return 0;
            }
        }
    }
}
