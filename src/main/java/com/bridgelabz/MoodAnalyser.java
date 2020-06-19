package com.bridgelabz;
public class MoodAnalyser {
    String message;
    public MoodAnalyser(){
        message = "default";
    }
    public MoodAnalyser(String message){
        this.message = message;
    }
    public String analyseMood(String message){
        this.message = message;
        return analyseMood();
    }
    public String analyseMood(){
    if (message.contains("Sad")) {
            return "Sad";
        }
    else{
            return "Happy";
        }
    }
}
