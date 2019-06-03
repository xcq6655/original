package com.xcq.original.myTest;

public class ImgColorRGb {
    private int pointX;
    private int pointY;
    private int colorR;
    private int colorG;
    private int colorB;

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    public int getColorR() {
        return colorR;
    }

    public void setColorR(int colorR) {
        this.colorR = colorR;
    }

    public int getColorG() {
        return colorG;
    }

    public void setColorG(int colorG) {
        this.colorG = colorG;
    }

    public int getColorB() {
        return colorB;
    }

    public void setColorB(int colorB) {
        this.colorB = colorB;
    }

    @Override
    public String toString() {
        return "ImgColorRGb{" +
                "pointX=" + pointX +
                ", pointY=" + pointY +
                ", colorR=" + colorR +
                ", colorG=" + colorG +
                ", colorB=" + colorB +
                '}';
    }
}
