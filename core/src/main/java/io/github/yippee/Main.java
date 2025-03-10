package io.github.yippee;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch sB;
    private ShapeRenderer sR;
    Player player;
    Block[] blocks;
    Spike[] spikes;
    int time;

    @Override
    public void create() {
        sB = new SpriteBatch();
        sR = new ShapeRenderer();
        player = new Player();
        blocks = new Block[5]; //creates i number of blocks
        spikes = new Spike[1];

        for (int i = 0; i < spikes.length; i++) {
            spikes[i] = new Spike();
        }

        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = new Block();
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        if (player.getIsAlive() == 1) {
            time = time + 1;
            if (time == 1) {
                player.setXPos(player.getXPos() + 3);
                time = 0;
            }
            player.debug();
            player.movement();

            for (int i = 0; i < blocks.length; i++) { //check if player is on top of block i think idk i cant remember
                if (player.getXPos() + player.getWidth() >= blocks[i].getXPos() && player.getYPos() >= blocks[i].getYPos() + blocks[i].getHeight() && player.getXPos() <= blocks[i].getXPos() + blocks[i].getWidth()) {
                    player.setGroundHeight(blocks[i].getYPos() + blocks[i].getHeight());
                }
            }

            blocks[0].setXPos(128);
            blocks[1].setXPos(128+64);
            blocks[1].setHeight(64);
            blocks[2].setIsVisible(0); blocks[3].setIsVisible(0); blocks[4].setIsVisible(0);
            player.falling(blocks);

            spikes[0].setXPos(360);

            if (player.getXPos() + player.getWidth() >= spikes[0].getXPos() + spikes[0].getHeight() && player.getXPos() < spikes[0].getXPos() + spikes[0].getWidth() && player.getYPos() <= spikes[0].getYPos() + spikes[0].getHeight()) {
                System.out.println("hit");
            }



        }



        sR.begin(ShapeRenderer.ShapeType.Filled);
        player.draw(sR);
        for (int i = 0; i < blocks.length; i++) { //drawing the blocks 1 by 1
            blocks[i].draw(sR);
        }
        for (int i = 0; i < spikes.length; i++) { //drawing the spikes 1 by 1
            spikes[i].draw(sR);
        }
        sR.end();
    }

    @Override
    public void dispose() {
        sB.dispose();
    }
}
