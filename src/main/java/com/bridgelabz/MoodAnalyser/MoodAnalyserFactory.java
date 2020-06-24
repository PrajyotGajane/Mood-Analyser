package com.bridgelabz.MoodAnalyser;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
      public static MoodAnalyser createMoodAnalyzer() {
            try {
                  Constructor<?> constructor = Class.forName("com.bridgelabz.MoodAnalyser.MoodAnalyser").getConstructor();
                  Object myObject = constructor.newInstance();
                  return (MoodAnalyser) myObject;
            } catch (NoSuchMethodException | InstantiationException | ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
                  e.printStackTrace();
            }
            return null;
      }
}
