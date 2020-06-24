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
        try {
            MoodAnalyserFactory.createMoodAnalyzer("Class not found","com.bridgelabz.MoodAnalysis",String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_CLASS_NOT_FOUND, e.type);
        }
    }

    @Test
    public void givenClassConstructorWrong_ShouldThrow_MoodAnalysisException() {
        try {
            MoodAnalyserFactory.createMoodAnalyzer("Constructor not found", "com.bridgelabz.MoodAnalyser", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_CONSTRUCTOR_NOT_FOUND, e.type);
        }
    }

    @Test
    public void givenMoodAnalyser_WhenProperShouldReturn_MooddAnalyserObject() {
        try{
            Assert.assertEquals("Proper",MoodAnalyserFactory.createMoodAnalyzer("Proper","com.bridgelabz.MoodAnalysis", String.class));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenImproperClassName_ShouldThrow_MoodAnalysisException() {
        try{
            MoodAnalyserFactory.createMoodAnalyzer("Proper","com.bridgelabz.MoodAnalys", String.class);
        } catch (MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_CLASS_NOT_FOUND, e.type);
        }
    }
}