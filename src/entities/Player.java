package entities;

import utilz.LoadSave;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.Directions.*;
import static utilz.Constants.Directions.DOWN;
import static utilz.Constants.PlayerConstants.*;

public class Player extends Entity{

    private static int playerClass = Pirate;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int playerAction = IDLE;
    private boolean moving = false;
    private boolean attacking = false;
    private boolean left, up, right, down;
    private float playerSpeed = 2.0f;

    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        loadAnimations();
    }

    private String setClass(int setClass) {
        switch(GetPlayerClass(playerClass)) {
            case Mage:
                return mage_path;
            default:
                return pirate_path;
        }
    }

    public void update() {
        loadAnimations();
        updatePos();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex],(int)x,(int)y,width,height,null);
    }

    private void updateAnimationTick() {
        aniTick++;
        if(aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmounts(playerAction)) {
                aniIndex = 0; //resetowanie animacji
                attacking = false;
            }
        }
    }

    private void setAnimation() {
        int startAnimation = playerAction;

        if(moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;

        if(attacking)
            playerAction = ATTACK_1;

        if(startAnimation != playerAction) {
            restAniTick();
        }
    }

    private void restAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    public void updatePos() {

        moving = false;

        if(left && !right) {
            x-=playerSpeed;
            moving = true;
        }else if(right && !left) {
            x += playerSpeed;
            moving = true;
        }

        if(up && !down) {
            y-=playerSpeed;
            moving = true;
        }else if(down && !up) {
            y += playerSpeed;
            moving = true;
        }

    }

    private void loadAnimations() {

            BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);

            animations = new BufferedImage[9][6];
            for (int j = 0; j < animations.length; j++)
                for (int i = 0; i<animations[j].length; i++)
                    animations[j][i] = img.getSubimage(i*64, j * 40, 64, 40);
    }

    public void resetDirBooleans() {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setPlayerClass(int playerClass) {
        this.playerClass = playerClass;
    }

    public static int getPlayerClass() {
        return playerClass;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
