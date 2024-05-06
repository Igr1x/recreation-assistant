package ru.recreation.recreationassistant.utils;

import lombok.Getter;

@Getter
public enum CityButtons implements ButtonInfo {
    BUTTON_MSK("Москва","msk"),
    BUTTON_SPB("Санкт-Петербург","spb"),
    BUTTON_NVS("Новосибирск","nsk"),
    BUTTON_NN_("Нижний-Новгород","nnv"),
    BUTTON_KZN("Казань", "kzn"),
    BUTTON_VBR("Выборг", "vbg"),
    BUTTON_SMR("Самара", "smr"),
    BUTTON_KRS("Краснодар", "krd"),
    BUTTON_SCH("Сочи", "sochi"),
    BUTTON_UFA("Уфа", "ufa"),
    BUTTON_KRSNS("Красноярск","krasnoyarsk"),
    BUTTON_EKB("Екатеринбург","ekb");

    CityButtons(String text, String id) {
        buttonText = text;
        buttonId = id;
    }

    private final String buttonText;
    private final String buttonId;

    public static String getNameCityOnId(String cityId) {
        for (CityButtons cityButton : CityButtons.values()) {
            if (cityButton.getButtonId().equals(cityId)) {
                return cityButton.getButtonText();
            }
        }
        throw new IllegalArgumentException("Нет города с таким id");
    }
}
