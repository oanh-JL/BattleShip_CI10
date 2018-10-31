package base.player;

import base.physics.BoxCollider;
import base.GameObject;
import base.physics.Physics;
import base.Vector2D;
import base.enemy.Enemy;
import base.renderer.AnimationRenderer;
import base.tank.Tank;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject implements Physics {
    public Vector2D velocity;
    BoxCollider collider;
    int damage;

    public PlayerBullet() {
        super();
        this.position = new Vector2D(0, 0);
        this.velocity = new Vector2D(0, 0);
    }

    @Override
    public void run() {
        Enemy enemy = GameObject.intersect(Enemy.class, this);
        Tank tank =GameObject.intersect(Tank.class,this);
        if(tank!=null){
            tank.takeDamage(this.damage);
            this.hitTank();
            return;
        }
        if(enemy != null) {
            enemy.takeDamage(this.damage);
            this.hitEnemy();
            return;
        }
        if(this.position.y < 0) {
            this.destroy();
            return;
        }
        this.position.addThis(velocity);
    }
    public void hitTank(){

    }
    public void hitEnemy() {
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
