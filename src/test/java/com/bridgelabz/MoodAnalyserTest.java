package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMoodSad_ShouldReturn_Sad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("This is a Sad message");
        Assert.assertEquals("Sad",mood);
    }
    @Test
    public void givenMoodHappy_ShoudldReturn_Happy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("This is a Happy message");
        Assert.assertEquals("Happy",mood);
    }
}
