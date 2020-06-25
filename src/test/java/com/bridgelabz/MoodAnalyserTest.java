package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {
    MoodAnalyser moodAnalyser = new MoodAnalyser();
    @Test
    public void givenMoodSad_ShouldReturn_Sad() {
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood("I am in Sad Mood");
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD",mood);
    }
    @Test
    public void givenMoodHappy_ShouldReturn_Happy() {
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood("I am in Any Mood");
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY",mood);
    }
    @Test
    public void givenNullMood_ShouldReturn_Happy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(MoodAnalysisException.class);
            moodAnalyser.analyseMood(null);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenNullMood_ShouldThrow_Exception() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        try{
            moodAnalyser.analyseMood(null);
        }catch (MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
        }
    }
    @Test
    public void givenEmptyMood_ShouldThrow_Exception() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try{
            moodAnalyser.analyseMood();
        }catch (MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClass_ShouldReturn_MoodAnalyserObject() {
        try {
            Constructor constructor = MoodAnalyserReflector.getConstructor(String.class);
            Object myObject = MoodAnalyserReflector.createMoodAnalyser(constructor,"I am Happy");
            Assert.assertEquals(new MoodAnalyser("I am Happy"),myObject);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenClassNameWrong_ShouldThrow_MoodAnalysisException() {
        try {
            MoodAnalyserReflector.invokeMethod("com.bridgelabz.MoodAnalysi","moodAnalyse", String.class, "I am Happy");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_CLASS_NOT_FOUND, e.type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenClassConstructorWrong_ShouldThrow_MoodAnalysisException() {
        try {
            MoodAnalyserReflector.invokeMethod("com.bridgelabz.MoodAnalyser", "mood" , String.class, "I a, Happy");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenHappyMessageWithReflection_ShouldReturn_HappyMood() throws Exception {
        Assert.assertEquals("HAPPY", MoodAnalyserReflector.invokeMethod("com.bridgelabz.MoodAnalyser","analyseMood",String.class,"I am Happy"));
    }

    @Test
    public void givenImproperHappyMessage_ShouldReturn_MoodAnalysisException() {
        try{
            MoodAnalyserReflector.invokeMethod("com.bridgelabz.MoodAnalyser","analyseMoo",String.class,"Happy");
        } catch (MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenFieldNameUsingReflector_ShouldSetMoodDynamically() {
        String mood = null;
        try {
            mood = MoodAnalyserReflector.setFieldValue("com.bridgelabz.MoodAnalyser", "message", "I am in happy mood");
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY", mood);
    }
    @Test
    public void givenFieldNameUsingReflector_WhenImproper_ShouldThrowException() {
        try {
            MoodAnalyserReflector.setFieldValue("com.bridgelabz.MoodAnalyser", "messag", "I am in happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, e.type);
        }
    }
    @Test
    public void givenFieldNameUsingReflector_WhenNull_ShouldThrowException() {
        try {
            MoodAnalyserReflector.setFieldValue("com.bridgelabz.MoodAnalyser", "message", null);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NULL_INVOCATION, e.type);
        }
    }
}