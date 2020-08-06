package com.company.homework.day7;

import java.util.Arrays;

/**
 * 아래 테스트 코드가 정상 동작하도록 클래스들을 완성하시오.
 *
 * getArea(): 사각형의 넓이를 반환한다.
 * getCenterOfMass(): 사각형의 질량중심을 반환한다.
 * GetAllPoints(): 사각형의 네 점을 배열로 반환한다.
 * rot90(): Pivot을 기준으로 사각형을 90도 회전시킨다.
 */

class Vector2D {
    public float x, y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class RectCore {
    protected Vector2D pos;
    protected float w, h;

    public RectCore(float x, float y, float w, float h) {
        this.pos = new Vector2D(x, y);
        this.w = w;
        this.h = h;
    }

    public String toString() {
        return "x : " + pos.x + ", y : " + pos.y + ", w : " + w + ", h : " + h;
    }
}

public class Rect extends RectCore {
    public Rect(float x, float y, float w, float h) {
        super(x, y, w, h);
    }

    public float getArea() {
        return w * h;
    }

    public Vector2D getCenterOfMass() {
        float centerX = pos.x + w / 2;
        float centerY = pos.y + h / 2;
        return new Vector2D(centerX, centerY);
    }

    public Vector2D [] getAllPoints() {
        Vector2D[] vector2DS = new Vector2D[4];
        vector2DS[0] = new Vector2D(pos.x, pos.y);
        vector2DS[1] = new Vector2D(pos.x + w, pos.y);
        vector2DS[2] = new Vector2D(pos.x, pos.y + h);
        vector2DS[3] = new Vector2D(pos.x + w, pos.y + h);

        return vector2DS;
    }

    public void rot90(Vector2D pivot) {
        float tempX = pos.x;
        float tempY = pos.y;

        float temp = w;
        w = h;
        h = temp;

        pos.x = tempY - pivot.y + pivot.x;
        pos.y = (tempX - pivot.x)*(-1) + pivot.y;

    }

    public void rot90LeftBottom(Vector2D pivot) {
        float tempX = pos.x;
        float tempY = pos.y;

        pos.x = tempY - pivot.y + pivot.x;
        pos.y = (tempX - pivot.x)*(-1) + pivot.y - w;

        float temp = w;
        w = h;
        h = temp;
    }

}

class RectTest {
    public static void main(String[] args) {
        Rect rect = new Rect(0.5f, 0.7f, 1.5f, 2.3f);
        System.out.println("Area: " + rect.getArea());
        System.out.println("CoM: " + rect.getCenterOfMass());
        System.out.println("All Points: " + Arrays.toString(rect.getAllPoints()));

        Rect rect2 = new Rect(0.5f, 0.7f, 1.5f, 2.3f);

        rect.rot90(new Vector2D(0.4f, 0.2f));
        System.out.println("Rotated rect: " + rect);

        rect2.rot90LeftBottom(new Vector2D(0.4f, 0.2f));
        System.out.println("Rotated rect: " + rect2);

//        rect.rot90(new Vector2D(0.4f, 0.2f));
//        System.out.println("Rotated rect: " + rect);
//
//        rect2.rot90LeftBottom(new Vector2D(0.4f, 0.2f));
//        System.out.println("Rotated rect: " + rect2);
//
//        rect.rot90(new Vector2D(0.4f, 0.2f));
//        System.out.println("Rotated rect: " + rect);
//
//        rect2.rot90LeftBottom(new Vector2D(0.4f, 0.2f));
//        System.out.println("Rotated rect: " + rect2);

    }
}
