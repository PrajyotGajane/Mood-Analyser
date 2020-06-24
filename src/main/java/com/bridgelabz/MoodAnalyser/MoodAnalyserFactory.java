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
      public static MoodAnalyser createMoodAnalyzer(String message, String className, Class aClass) throws MoodAnalysisException {
            try {
                  Constructor<?> constructor = Class.forName(className).getConstructor(aClass);
                  Object myObject = constructor.newInstance(message);
                  return (MoodAnalyser) myObject;
            } catch (NoSuchMethodException e) {
                  throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.Entered_CLASS_NOT_FOUND,"Class not found");
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                  e.printStackTrace();
            } catch (ClassNotFoundException e) {
                  e.printStackTrace();
            }
            return null;
      }
}
