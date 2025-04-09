package main.java.com.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AssetFactory {
    String[] paramPrompts();  // Подсказки для ввода параметров
}
