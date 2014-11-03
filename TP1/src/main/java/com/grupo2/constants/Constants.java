package com.grupo2.constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author fibrizo
 */
public final class Constants {

    private static long TICK_TO_MILISECS = 1000;
    private static float INITIAL_VELOCITY = (float) 1.0;

    private static float PREY_LIMIT_TIME = 30;
    private static float DEAD_LIMIT_TIME = 20;

    private static float FIRST_RAGE_LIMIT_TIME = 5;
    private static float SECOND_RAGE_LIMIT_TIME = 10;
    private static float THIRD_RAGE_LIMIT_TIME = 15;

    private static float GHOST_RADIUS = 99;
    private static int TRACE_DURATION = 4;

    public static int VISION1 = 4;
    public static int VISION2 = 8;
    public static int VISION3 = 10;
    public static int VISION4 = 12;
    public static float RAGE_BONUS = (float) 0.25;

    private Constants() {
        //this prevents even the native class from
        //calling this ctor as well :
        throw new AssertionError();
    }

    public static void initializeConstants(final Path path) {

        try {
            File file = path.toFile();
            FileReader reader = new FileReader(file);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            long ticks = (long) jsonObject.get("TICK_TO_MILISECS");
            float preyTime = ((Number) jsonObject.get("PREY_LIMIT_TIME")).floatValue();
            float deadTime = ((Number) jsonObject.get("DEAD_LIMIT_TIME")).floatValue();
            float firstRageTime = ((Number) jsonObject.get("FIRST_RAGE_LIMIT_TIME")).floatValue();
            float secondRageTime = ((Number) jsonObject.get("SECOND_RAGE_LIMIT_TIME")).floatValue();
            float thirdRageTime = ((Number) jsonObject.get("THIRD_RAGE_LIMIT_TIME")).floatValue();
            float radius = ((Number) jsonObject.get("GHOST_RADIUS")).floatValue();

            setTickToMilisecs(ticks);
            setPreyLimitTime(preyTime);
            setDeadLimitTime(deadTime);
            setFirstRageLimitTime(firstRageTime);
            setSecondRageLimitTime(secondRageTime);
            setThirdRageLimitTime(thirdRageTime);
            setGhostRadius(radius);

        } catch (ParseException e) {
            System.out.println("ERROR WHILE PARSING");
        } catch (FileNotFoundException e) {
            System.out.println("ERROR FILE NOT FOUND");
        } catch (NullPointerException e) {
            System.out.println("ERROR NULL POINTER");
        } catch (IOException ex) {
            System.out.println("ERROR IO");
        }
    }

    /**
     *
     * @return the constant PREY_LIMIT_TIME
     */
    public static float getPreyLimitTime() {
        return PREY_LIMIT_TIME;
    }

    /**
     *
     * @return the constant DEAD_LIMIT_TIME
     */
    public static float getDeadLimitTime() {
        return DEAD_LIMIT_TIME;
    }

    /**
     * @return the constant INITIAL_VELOCITY
     */
    public static float getInitialVelocity() {
        return INITIAL_VELOCITY;
    }

    /**
     *
     * @return the constant FIRST_RAGE_LIMIT_TIME
     */
    public static float getFirstRageLimitTime() {
        return FIRST_RAGE_LIMIT_TIME;
    }

    /**
     *
     * @return the constant SECOND_RAGE_LIMIT_TIME
     */
    public static float getSecondRageLimitTime() {
        return SECOND_RAGE_LIMIT_TIME;
    }

    /**
     *
     * @return the constant THIRD_RAGE_LIMIT_TIME
     */
    public static float getThirdRageLimitTime() {
        return THIRD_RAGE_LIMIT_TIME;
    }

    /**
     *
     * @return the constant GHOST_RADIUS
     */
    public static float getGhostRadius() {
        return GHOST_RADIUS;
    }

    /**
     *
     * @return the constant TICK_TO_MILISECS
     */
    public static long getTickToMilisecs() {
        return TICK_TO_MILISECS;
    }

    public static int getTraceDuration() {
        return TRACE_DURATION;
    }

    public static void setPreyLimitTime(float timeLimit) {
        Constants.PREY_LIMIT_TIME = timeLimit;
    }

    public static void setPreyLimitTime(int velocity) {
        Constants.INITIAL_VELOCITY = velocity;
    }

    public static void setDeadLimitTime(float timeLimit) {
        Constants.DEAD_LIMIT_TIME = timeLimit;
    }

    public static void setInitialVelocity(float vel) {
        Constants.INITIAL_VELOCITY = vel;
    }

    public static void setFirstRageLimitTime(float timeLimit) {
        Constants.FIRST_RAGE_LIMIT_TIME = timeLimit;
    }

    public static void setSecondRageLimitTime(float timeLimit) {
        Constants.SECOND_RAGE_LIMIT_TIME = timeLimit;
    }

    public static void setThirdRageLimitTime(float timeLimit) {
        Constants.THIRD_RAGE_LIMIT_TIME = timeLimit;
    }

    public static void setGhostRadius(float radius) {
        Constants.GHOST_RADIUS = radius;
    }

    public static void setTickToMilisecs(long ticks) {
        Constants.TICK_TO_MILISECS = ticks;
    }

    public static void setTraceDuration(int ticks) {
        Constants.TRACE_DURATION = ticks;
    }

}
