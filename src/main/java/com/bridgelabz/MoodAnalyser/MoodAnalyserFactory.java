package com.bridgelabz.MoodAnalyser;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
      public static MoodAnalyser createMoodAnalyzer(String message, String className, Class classChecker) throws MoodAnalysisException {
            try {
                  Constructor<?> constructor = Class.forName(className).getConstructor(classChecker);
                  Object myObject = constructor.newInstance(message);
                  return (MoodAnalyser) myObject;
            } catch (NoSuchMethodException e) {
                  throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_CONSTRUCTOR_NOT_FOUND,"Constructor not found");
            } catch (ClassNotFoundException e) {
                  throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_CLASS_NOT_FOUND,"Class not found");
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                  e.printStackTrace();
            }
            return null;
      }
      public static String invokeMethod(String classname, String methodName, Class type, String mood) throws MoodAnalysisException {
            try {
                  Class<?> aClass1 = Class.forName(classname);
                  Constructor<?> constructor = aClass1.getConstructor();
                  Object object = constructor.newInstance();
                  Method method1 = aClass1.getDeclaredMethod(methodName, type);
                  method1.setAccessible(true);
                  return (String) method1.invoke(object, mood);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                  e.printStackTrace();
            } catch (NoSuchMethodException e) {
                  throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_CONSTRUCTOR_NOT_FOUND,"Method not found");
            } catch (InvocationTargetException e) {
                  throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_INVOCATION_NOT_FOUND,"Invocation issue");

            }
            return null;
      }
}
