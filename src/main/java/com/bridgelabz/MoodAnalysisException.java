package com.bridgelabz;

public class MoodAnalysisException extends Exception{
      enum ExceptionType {
            ENTERED_NULL,ENTERED_EMPTY,ENTERED_CLASS_NOT_FOUND,NO_SUCH_METHOD,ENTERED_FIELD_NOT_FOUND
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