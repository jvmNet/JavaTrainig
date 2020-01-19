package com.javarush.task.task13.task1328;

public abstract class AbstractRobot implements Attackable, Defensable {

    private static int hitCount;

    public abstract String getName();

    public abstract BodyPart attack();

    public abstract BodyPart defense();

}
