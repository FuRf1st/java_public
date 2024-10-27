package com;

public class OneMoreExtraException {

    public String[][] processOneMoreExtraException(String input, int sortOption) throws InvalidSortOptionException, InvalidSensorDataException {
        // Проверка на правильность выбора поля для сортировки
        if (sortOption != 1 && sortOption != 2) {
            throw new InvalidSortOptionException("Недопустимая опция сортировки: " + sortOption + ". Выберите 1 или 2.");
        }

        // Проверка на корректность данных датчиков
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidSensorDataException("Данные датчиков не могут быть пустыми.");
        }

        String[] entries = input.split("@");
        String[] sensorIds = new String[entries.length];
        double[] totalTemperatures = new double[entries.length];
        int[] readingsCount = new int[entries.length];

        // Проход по всем показаниям
        for (int i = 0; i < entries.length; i++) {
            String entry = entries[i];
            if (entry.length() < 3) { // Проверка на валидность длины записи
                throw new InvalidSensorDataException("Неверный формат данных датчиков: " + entry);
            }

            String sensorId = entry.substring(0, 2); // первые два символа — id датчика
            int temperature;
            try {
                temperature = Integer.parseInt(entry.substring(2)); // остальные символы — температура
            } catch (NumberFormatException e) {
                throw new InvalidSensorDataException("Температура должна быть числом: " + entry.substring(2));
            }

            boolean sensorExists = false;
            for (int j = 0; j < i; j++) {
                if (sensorIds[j] != null && sensorIds[j].equals(sensorId)) {
                    totalTemperatures[j] += temperature;
                    readingsCount[j]++;
                    sensorExists = true;
                    break;
                }
            }

            if (!sensorExists) {
                sensorIds[i] = sensorId;
                totalTemperatures[i] = temperature;
                readingsCount[i] = 1;
            }
        }

        double[] avgTemperatures = new double[entries.length];
        int sensorCount = 0;

        for (int i = 0; i < entries.length; i++) {
            if (sensorIds[i] != null) {
                avgTemperatures[sensorCount] = totalTemperatures[i] / readingsCount[i];
                sensorIds[sensorCount] = sensorIds[i];
                sensorCount++;
            }
        }

        sortData(sensorIds, avgTemperatures, sensorCount, sortOption);

        String[][] results = new String[sensorCount][2];
        for (int i = 0; i < sensorCount; i++) {
            results[i][0] = sensorIds[i];
            results[i][1] = String.format("%.1f", avgTemperatures[i]);
        }

        return results;
    }

    private void sortData(String[] sensorIds, double[] avgTemperatures, int sensorCount, int sortOption) {
        for (int i = 0; i < sensorCount - 1; i++) {
            for (int j = i + 1; j < sensorCount; j++) {
                boolean shouldSwap = false;
                if (sortOption == 1) {
                    if (Integer.parseInt(sensorIds[i]) > Integer.parseInt(sensorIds[j])) {
                        shouldSwap = true;
                    }
                } else if (sortOption == 2) {
                    if (avgTemperatures[i] > avgTemperatures[j]) {
                        shouldSwap = true;
                    }
                }

                if (shouldSwap) {
                    String tempId = sensorIds[i];
                    sensorIds[i] = sensorIds[j];
                    sensorIds[j] = tempId;

                    double tempAvg = avgTemperatures[i];
                    avgTemperatures[i] = avgTemperatures[j];
                    avgTemperatures[j] = tempAvg;
                }
            }
        }
    }
}

// Создаем собственное исключение для неверной опции сортировки
class InvalidSortOptionException extends Exception {
    public InvalidSortOptionException(String message) {
        super(message);
    }
}

// Создаем собственное исключение для неверных данных датчиков
class InvalidSensorDataException extends Exception {
    public InvalidSensorDataException(String message) {
        super(message);
    }
}