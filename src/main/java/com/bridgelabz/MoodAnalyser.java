package com.bridgelabz;
public class MoodAnalyser {
    String message;
    /**
     * non parametrized constructor
     */
    public MoodAnalyser() {
        message = null;
    }
    /**
     * parameterised constructor
     * @param message
     */
    public MoodAnalyser(String message) {
        this.message = message;
    }
    /**
     *
     * @param message
     * @return  mood from no parameter analyse method
     * @throws MoodAnalysisException
     */
    public String analyseMood(String message) throws MoodAnalysisException {
        this.message = message;
        return analyseMood();
    }
    /**
     *
     * @return mood of the user
     * @throws MoodAnalysisException
     */
    public String analyseMood() throws MoodAnalysisException {
        try {
            if (message.length() == 0)
            {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,"Please enter proper mood");
            }
            if (message.contains("Sad")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL,"Please enter proper message");
        }
    }

}