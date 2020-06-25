package com.bridgelabz;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserReflector {
      /*public static MoodAnalyser createMoodAnalyzer() {
            try {
                  Constructor<?> constructor = Class.forName("com.bridgelabz.MoodAnalyser").getConstructor();
                  Object myObject = constructor.newInstance();
                  return (MoodAnalyser) myObject;
            } catch (NoSuchMethodException | InstantiationException | ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
                  e.printStackTrace();
            }
            return null;
      }*/
      public static Constructor<?> getConstructor(Class<?> ... param) throws MoodAnalysisException {

            try {
                  Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyser");
                  return moodAnalyserClass.getConstructor(param);
            } catch (ClassNotFoundException e) {
                  e.printStackTrace();
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
      /*public static MoodAnalyser createMoodAnalyzer(String message, String className, Class classChecker) throws MoodAnalysisException {
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
      }*/
      public static String invokeMethod(String className, String methodName, Class type, String mood) throws Exception {
            try {
                  Class<?> classChecker = Class.forName(className);
                  Constructor<?> constructor = classChecker.getConstructor();
                  Object object = constructor.newInstance();
                  Method method = classChecker.getDeclaredMethod(methodName, type);
                  method.setAccessible(true);
                  return (String) method.invoke(object, mood);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException  | InvocationTargetException e) {
                  e.printStackTrace();
            } catch (NoSuchMethodException e) {
                  throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,"Method not found");
            }
            return null;
      }
      public static String settingFieldValue(String className, String fieldName, String mood) throws MoodAnalysisException {
            try {
                  Class<?> aClass = Class.forName(className);
                  Constructor<?> constructor = aClass.getConstructor();
                  Object object = constructor.newInstance();
                  Field field = aClass.getDeclaredField(fieldName);
                  field.setAccessible(true);
                  field.set(object, mood);
                  return MoodAnalyserReflector.invokeMethod(className, "analyseMood", String.class, mood);

            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                  e.printStackTrace();
            } catch (NoSuchFieldException e) {
                  throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_FIELD_NOT_FOUND, "No such field found");
            } catch (MoodAnalysisException moodAnalysisException) {
                  moodAnalysisException.printStackTrace();
            } catch (Exception e) {
                  e.printStackTrace();
            }
            return null;
      }
}