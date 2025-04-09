package main.java.com.service;
import main.java.com.util.AssetFactory;
import org.reflections.Reflections;

import javax.swing.*;
import java.awt.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReflectionService {

    // Функция для получения имен классов с аннотацией @AssetFactory
    public static String[] getAssetFactoryClasses() {

        // Инициализируем объект Reflections для сканирования пакета
        Reflections reflections = new Reflections("main.java.com.model");


        Set<Class<?>> assetFactoryClasses = reflections.getTypesAnnotatedWith(AssetFactory.class);

        // Преобразуем классы в массив строк, оставляя только имя класса
        return assetFactoryClasses.stream()
                .map(cls -> cls.getSimpleName()) // Получаем только имя класса без пакета
                .toArray(String[]::new);
    }
    public static String getFullClassNameBySimpleClassName(String simpleClassName) {
        // Сканируем пакет
        Reflections reflections = new Reflections("main.java.com.model");

        // Получаем все классы с аннотацией @AssetFactory
        Set<Class<?>> assetFactoryClasses = reflections.getTypesAnnotatedWith(AssetFactory.class);

        // Ищем нужный класс
        for (Class<?> clazz : assetFactoryClasses) {
            if (clazz.getSimpleName().equals(simpleClassName)) {
                return clazz.getName(); // Возвращает полное имя класса (с пакетом)
            }
        }

        throw new RuntimeException("Класс с именем " + simpleClassName + " не найден среди аннотированных @AssetFactory");
    }


    public static Object getObjectByClassNameWithGUI(String className) {
        try {
            // Получаем класс по имени
            Class<?> clazz = Class.forName(className);


            AssetFactory assetFactory = clazz.getAnnotation(AssetFactory.class);
            if (assetFactory == null) {
                throw new RuntimeException("Класс не имеет аннотации @AssetFactory");
            }


            String[] paramPrompts = assetFactory.paramPrompts();


            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(paramPrompts.length, 2));

            // Создаем массив для хранения текстовых полей
            JTextField[] textFields = new JTextField[paramPrompts.length];

            // Добавляем метки и текстовые поля для каждого параметра
            for (int i = 0; i < paramPrompts.length; i++) {
                JLabel label = new JLabel(paramPrompts[i]);
                JTextField textField = new JTextField();
                textFields[i] = textField;
                panel.add(label);
                panel.add(textField);
            }


            int option = JOptionPane.showConfirmDialog(null, panel, "Enter Asset Parameters", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.CANCEL_OPTION) {
                return null; // Если пользователь нажал Cancel, возвращаем null
            }


            List<Object> params = new ArrayList<>();
            for (JTextField textField : textFields) {
                String param = textField.getText();
                if (param.matches("\\d+(\\.\\d+)?")) {
                    params.add(Double.parseDouble(param));  // Если это число
                } else if (param.equalsIgnoreCase("true") || param.equalsIgnoreCase("false")) {
                    params.add(Boolean.parseBoolean(param));  // Если это boolean
                } else {
                    params.add(param);  // Если это строка
                }
            }

            // Преобразуем список параметров в массив
            Object[] typedParams = params.toArray();

            // Ищем метод "Create" с соответствующими параметрами
            Method factoryMethod = clazz.getMethod("Create", getParameterTypes(typedParams));



            return factoryMethod.invoke(null, typedParams);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при создании объекта: " + e.getMessage(), e);
        }
    }

    // Метод для получения типов параметров
    private static Class<?>[] getParameterTypes(Object[] params) {
        Class<?>[] types = new Class<?>[params.length];
        for (int i = 0; i < params.length; i++) {
            if (params[i] instanceof Double) {
                types[i] = double.class;
            } else if (params[i] instanceof Integer) {
                types[i] = int.class;
            } else if (params[i] instanceof Boolean) {
                types[i] = boolean.class;
            } else {
                types[i] = params[i].getClass();
            }
        }
        return types;
    }

}





