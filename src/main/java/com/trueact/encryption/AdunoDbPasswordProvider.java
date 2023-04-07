package com.trueact.encryption;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Preconditions;
import org.springframework.stereotype.Component;

@Component
public class AdunoDbPasswordProvider {
  public static final String KEY = "!xx&T7dO-2834kA;";

  private final DbPasswordCipher passwordCipher = new DbPasswordCipher();

  public String getPassword(String encryptedPassword) {

    Preconditions.checkArgument(StringUtils.isNotBlank(encryptedPassword), "Password is empty.");

    return passwordCipher.decrypt(encryptedPassword);
  }
}
