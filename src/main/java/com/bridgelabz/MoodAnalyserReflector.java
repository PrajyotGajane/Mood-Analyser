package com.bridgelabz;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class MoodAnalyserReflector {
      public static Constructor<?> getConstructor(Class<?> ... param) throws MoodAnalysisException {
            try {
                  Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyser");
                  return moodAnalyserClass.getConstructor(param);
            } catch (ClassNotFoundException e) {
                  throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_CLASS_NOT_FOUND,"Class not found");
            } catch (NoSuchMethodException e) {
                  e.printStackTrace();
            }
            return null;
      }
      public static Object createMoodAnalyser(Constructor<?> constructor, Object ... message){
            try {
                  return constructor.newInstance(message);
            } catch (InstantiationException e) {
                  e.printStackTrace();
            } catch (IllegalAccessException e) {
                  e.printStackTrace();
            } catch (InvocationTargetException e) {
                  e.printStackTrace();
            }
            return null;
      }
      public static String invokeMethod(String className, String methodName, Class type, String mood) throws Exception {
            try {
                  Class<?> classChecker = Class.forName(className);
                  Constructor<?> constructor = classChecker.getConstructor();
                  Object object = constructor.newInstance();
                  Method method = classChecker.getDeclaredMethod(methodName, type);
                  return (String) method.invoke(object, mood);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException  | InvocationTargetException e) {
                  e.printStackTrace();
            } catch (NoSuchMethodException e) {
                  throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,"Method not found");
            }
            return null;
      }
      public static String setFieldValue(String className, String fieldName, String moodPassed) throws MoodAnalysisException {
            try {
                  Class<?> classChecker = Class.forName(className);
                  Constructor<?> constructor = classChecker.getConstructor();
                  Object object = constructor.newInstance();
                  Field field = classChecker.getDeclaredField(fieldName);
                  field.set(object, moodPassed);
                  return MoodAnalyserReflector.invokeMethod(className, "analyseMood", String.class, moodPassed);
            } catch (NoSuchFieldException e) {
                  throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, "No such field found");
            } catch (MoodAnalysisException e) {
                  e.printStackTrace();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                  e.printStackTrace();
            } catch (Exception e) {
                  e.printStackTrace();
            }
            return null;
      }
}