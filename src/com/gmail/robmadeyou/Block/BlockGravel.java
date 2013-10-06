package com.gmail.robmadeyou.Block;

import com.gmail.robmadeyou.Draw.ABCollector;
import com.gmail.robmadeyou.Draw.ABCollector.DrawParameters;
import com.gmail.robmadeyou.Effects.ABColor;
import com.gmail.robmadeyou.Effects.ABTextures;
import com.gmail.robmadeyou.Entity.ABEntity;
import com.gmail.robmadeyou.World.ABWorld;

public class BlockGravel implements ABBlock, Comparable<ABBlock> {

    private int x, y;
    private int id = 0;
    private boolean isSolid = false;
    private boolean isWalkable = true;
    private int texture;
    private ABColor color;

    public double g_score = Double.MAX_VALUE;
    public double h_score = Double.MAX_VALUE;
    private ABBlock parent = null;
    private boolean isConsidered;
    private boolean isVisited = false;

    public BlockGravel(int x, int y) {
        this.x = x;
        this.y = y;
        this.texture = ABTextures.Block_Gravel;
        this.color = ABColor.White;
    }

    public int getID() {
        return id;
    }


    public boolean isSolid() {
        return isSolid;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void onUpdate() {
        draw();
    }

    public void draw() {
    	DrawParameters p = new DrawParameters("box", x * ABWorld.BLOCK_SIZE(), y * ABWorld.BLOCK_SIZE(), ABWorld.BLOCK_SIZE(), ABWorld.BLOCK_SIZE());
			p.setTextureID(texture);
			p.setColor(color);
			p.setLayer(0);
			p.setUseTranslate(true);
		ABCollector.add(p);
    }

    public void doEffect(ABEntity e) {
        //Air gives no effect. How sad :(
    }

    public void removeEffect(ABEntity e) {
        //Air gives no effect!
    }

    @Override
    public double getG_Score() {
        return g_score;
    }

    @Override
    public void setG_Score(Double score) {
        this.g_score = score;
    }

    @Override
    public double get_hscore() {
        return this.h_score;
    }

    @Override
    public void setHscore(Double score) {
        this.h_score = score;
    }

    @Override
    public ABBlock getParent() {
        return parent;
    }

    @Override
    public void setParent(ABBlock block) {
        this.parent = block;
    }

    @Override
    public void visit() {
        isVisited = true;
    }

    @Override
    public boolean isVisited() {
        return isVisited;
    }

    @Override
    public boolean isConsidered() {
        return isConsidered;
    }


    @Override
    public void consider() {
        isConsidered = true;

    }

    @Override
    public boolean isWalkable() {
        return isWalkable;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getTexture() {
        return texture;
    }

    public void setTexture(int tex) {
        this.texture = tex;
    }

    public ABBlock getType() {
        return this;
    }

    @Override
    public String toString() {
        return "BlockGravel:" + "\nCoordinates: (" + this.x + ", " + this.y + ")";
    }

    @Override
    public int compareTo(ABBlock o) {
        if (g_score + h_score < o.getG_Score() + o.get_hscore()) {
            return -1;
        }
        if (g_score + h_score > o.getG_Score() + o.get_hscore()) {
            return 1;
        }
        return 0;
    }
}
