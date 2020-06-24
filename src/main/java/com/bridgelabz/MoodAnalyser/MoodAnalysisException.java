package com.bridgelabz.MoodAnalyser;

public class MoodAnalysisException extends Exception{
      enum ExceptionType {
            ENTERED_NULL,ENTERED_EMPTY,Entered_CLASS_NOT_FOUND
      }
      ExceptionType type;
      /**
       * custom exception handling
       * @param type
       * @param message
       */
      public MoodAnalysisException(ExceptionType type, String message) {
            super(message);
            this.type = type;
      }
}