package io.github.yippee;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block {
    private int isVisible, width, height;
    private float XPos, YPos;

    public Block() {
        XPos = 0;
        YPos = 0;
        isVisible = 1;
        width = 32;
        height = 32;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
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

    public void draw(ShapeRenderer sR) {
        if (isVisible == 1) {
            sR.setColor(Color.GRAY);
            sR.rect(XPos, YPos, width, height);
        }
    }
}
