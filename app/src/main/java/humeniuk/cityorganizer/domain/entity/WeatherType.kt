package humeniuk.cityorganizer.domain.entity

enum class WeatherType(name : String) {

    CLEAR("Clear"),
    CLOUDS("Clouds"),
    RAIN("Rain"),
    SNOW("Snow"),
    UNDEFINED("Undefined");

    companion object {

        fun fromName(name: String): WeatherType {
            for (type: WeatherType in WeatherType.values()) {
                if (type.name.equals(name)) {
                    return type;
                }
            }
            return UNDEFINED;
        }
    }
}