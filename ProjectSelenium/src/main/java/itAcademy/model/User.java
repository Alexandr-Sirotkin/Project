package itAcademy.model;

public class User {

  private final String CORRECT_LOGIN = "aleksandarsirotk1n";
  private final String INVALID_LOGIN = "999999999";
  private final String CORRECT_PASSWORD = "arcanum13";
  private final String INVALID_PASSWORD = "123456";
  private final String EMAIL_ADDRESS = "aleksandarsirotk1n@yandex.by";
  private final String USER_NAME = "Александр Сироткин";

  public String getCORRECT_LOGIN() {
    return CORRECT_LOGIN;
  }

  public String getCORRECT_PASSWORD() {
    return CORRECT_PASSWORD;
  }

  public String getEMAIL_ADDRESS() {
    return EMAIL_ADDRESS;
  }

  public String getUSER_NAME() {
    return USER_NAME;
  }

  public String getINVALID_PASSWORD() {
    return INVALID_PASSWORD;
  }

  public String getINVALID_LOGIN() {
    return INVALID_LOGIN;
  }


}
