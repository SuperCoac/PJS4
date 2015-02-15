package com.gamefactory.components;

import com.gamefactory.displayable.Component;
import com.gamefactory.displayable.ComponentManager;
import com.gamefactory.game.Game;
import com.gamefactory.utils.events.Event;
import com.gamefactory.utils.events.Notifier;
import java.awt.event.AWTEventListener;
import java.util.Objects;

/**
 * Component permettant de gérer la position d'une unité et ses déplacements
 * basiques.
 *
 * @author Pascal Luttgens
 *
 * @version 1.0
 *
 * @since 1.0
 */
public class Position extends Component {

    private final static int WINDOW_BORDER_SIZE = 20;

    public enum Orientation {

        UP,
        DOWN,
        LEFT,
        RIGHT

    }

    private float x;
    private float y;

    private float xVelocity;
    private float yVelocity;

    private Orientation orientation;

    private int height;
    private int width;

    public Position() {
        this.x = 0;
        this.y = 520;
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.height = 0;
        this.width = 0;
        this.orientation = Orientation.DOWN;
    }

    @Override
    public void init(ComponentManager owner) {
        super.init(owner);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(float xVelocity) {
        this.xVelocity = xVelocity;
    }

    public float getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(float yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public float distanceWith(Position position) {
        return (float) Math.hypot(this.x - position.x, this.y - position.y);
    }

    @Override
    public void update() {
        this.x += (this.x + this.xVelocity > 0 && this.x + this.xVelocity < Game.WIDTH - this.width) ? this.xVelocity : 0;
        this.y += (this.y + this.yVelocity > 0 && this.y + this.yVelocity < Game.HEIGHT - this.height - Position.WINDOW_BORDER_SIZE) ? this.yVelocity : 0;
    }

    @Override
    protected int getUpdatePriority() {
        return Integer.MAX_VALUE;
    }

    public Position deepClone() {
        Position ret = new Position();
        ret.setX(this.x);
        ret.setY(this.y);
        ret.setOrientation(this.getOrientation());
        ret.setxVelocity(this.xVelocity);
        ret.setyVelocity(this.yVelocity);
        ret.setHeight(this.height);
        ret.setWidth(this.width);
        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Float.floatToIntBits(this.x);
        hash = 43 * hash + Float.floatToIntBits(this.y);
        hash = 43 * hash + Float.floatToIntBits(this.xVelocity);
        hash = 43 * hash + Float.floatToIntBits(this.yVelocity);
        hash = 43 * hash + Objects.hashCode(this.orientation);
        hash = 43 * hash + this.height;
        hash = 43 * hash + this.width;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
            return false;
        }
        if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y)) {
            return false;
        }
        if (Float.floatToIntBits(this.xVelocity) != Float.floatToIntBits(other.xVelocity)) {
            return false;
        }
        if (Float.floatToIntBits(this.yVelocity) != Float.floatToIntBits(other.yVelocity)) {
            return false;
        }
        if (this.orientation != other.orientation) {
            return false;
        }
        if (this.height != other.height) {
            return false;
        }
        if (this.width != other.width) {
            return false;
        }
        return true;
    }

    
    
}
