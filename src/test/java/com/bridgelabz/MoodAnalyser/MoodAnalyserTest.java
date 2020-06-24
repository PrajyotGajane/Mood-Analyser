package com.bridgelabz.MoodAnalyser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
        MoodAnalyser moodAnalyzer = new MoodAnalyser();
        MoodAnalyser factoryConstructor = null;
            try {
                factoryConstructor = MoodAnalyserFactory.createMoodAnalyzer();

            } catch (Exception e){
                e.printStackTrace();
            }
        Assert.assertEquals(moodAnalyzer, factoryConstructor);
    }

    @Test
    public void givenClassNameWrong_ShouldThrow_MoodAnalysisException() {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyzer();
        Assert.assertEquals(new MoodAnalyser(), moodAnalyser);
    }
}