package io.github.yippee;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Spike {
    private int isVisible, width, height, isHit;
    private float XPos, YPos;

    public Spike() {
        XPos = 0;
        YPos = -8;
        isVisible = 1;
        width = 16;
        height = 16;
        isHit = 0;
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

    public int getIsHit() {
        return isHit;
    }

    public void setIsHit(int isHit) {
        this.isHit = isHit;
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
            sR.setColor(Color.ORANGE);
            sR.identity();
            sR.translate(XPos + width / 2, YPos + height / 2, 0);
            sR.rotate(0, 0, 1, 45);
            sR.rect(-width / 2, -height / 2, width, height);
            sR.identity(); // Reset transformations
        }
    }
}
