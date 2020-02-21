package itAcademy.model;

public class Letter {

  private final String TOPIC_CORRECT_RECIPIENT = "this is a test letter";
  private final String BODY_CORRECT_RECIPIENT = "this is the text of the test letter";
  private final String INVALID_RECIPIENT = "aleksandarsirotk1n";
  private final String TOPIC_INVALID_RECIPIENT = "this is a test letter with the invalid recipient";
  private final String BODY_INVALID_RECIPIENT = "this is the text of the test letter with the invalid recipient";
  private final String TOPIC_TEST_LETTER = "this is a test letter to check the draft";
  private final String BODY_TEST_LETTER = "this is a test letter to check the draft";

  public String getTOPIC_CORRECT_RECIPIENT() {
    return TOPIC_CORRECT_RECIPIENT;
  }

  public String getBODY_CORRECT_RECIPIENT() {
    return BODY_CORRECT_RECIPIENT;
  }

  public String getINVALID_RECIPIENT() {
    return INVALID_RECIPIENT;
  }

  public String getTOPIC_INVALID_RECIPIENT() {
    return TOPIC_INVALID_RECIPIENT;
  }

  public String getBODY_INVALID_RECIPIENT() {
    return BODY_INVALID_RECIPIENT;
  }

  public String getTOPIC_TEST_LETTER() {
    return TOPIC_TEST_LETTER;
  }

  public String getBODY_TEST_LETTER() {
    return BODY_TEST_LETTER;
  }
}
