package io.github.yippee;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player {
    private int isJump, isAlive, width, height, lastBlockTouched;
    private float XPos, YPos, XSpeed, YSpeed, groundHeight;

    public Player() {
        XPos = 0;
        YPos = 0;
        width = 32;
        height = 32;
        isJump = 0;
        isAlive = 1;
        groundHeight = 0;
    }

    public float getXPos() {
        return XPos;
    }

    public void setXPos(float XPos) {
        this.XPos = XPos;
    }

    public float getYPos() {
        return YPos;
    }

    public void setYPos(float YPos) {
        this.YPos = YPos;
    }

    public int getIsJump() {
        return isJump;
    }

    public void setIsJump(int isJump) {
        this.isJump = isJump;
    }

    public int getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(int isAlive) {
        this.isAlive = isAlive;
    }

    public float getGroundHeight() {
        return groundHeight;
    }

    public void setGroundHeight(float groundHeight) {
        this.groundHeight = groundHeight;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getYSpeed() {
        return YSpeed;
    }

    public void setYSpeed(float YSpeed) {
        this.YSpeed = YSpeed;
    }


    public void movement() {
        //System.out.println("Y Position: " + YPos + ", Ground: " + groundHeight);
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && isJump == 0) {
            isJump = 1;
            YSpeed = 12;
        }
        if (isJump == 1 && YPos >= groundHeight) {
            YSpeed = YSpeed -1;
            //System.out.println(YSpeed);
        }
        if (YPos + YSpeed >= groundHeight) {
            YPos = YPos + YSpeed;
        } else if (YPos + YSpeed < groundHeight) {
            YPos = groundHeight;
            isJump = 0;
        }
    }

    public void falling(Block[] blocks) {
        for (int i = 0; i < blocks.length; i++) {
            if (XPos + width >= blocks[i].getXPos() && XPos <= blocks[i].getXPos() + blocks[i].getWidth() && blocks[i].getIsVisible() == 1) {
                System.out.println("Player is on block: " + i);
                lastBlockTouched = i;
            } else if (XPos > blocks[lastBlockTouched].getXPos() + blocks[lastBlockTouched].getWidth() && blocks[lastBlockTouched].getIsVisible() == 1) {
                if (YPos == blocks[lastBlockTouched].getHeight()) {
                    groundHeight = 0;
                    System.out.println("not on block");
                }
            }
        }
    }

    public void debug() {
        Gdx.graphics.setTitle("Y: " + YPos + " X: " + XPos + " Y Speed: " + YSpeed + " Ground: " + groundHeight + " Last Block On: " + lastBlockTouched);
    }

    public void draw(ShapeRenderer sR) {
        sR.setColor(Color.WHITE);
        sR.rect(XPos, YPos, width, height);
    }
}
