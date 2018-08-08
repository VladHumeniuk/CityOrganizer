package humeniuk.cityorganizer.domain.entity

class Weather() {

    var temperature : Int = 0

    var maxTemperature : Int = 0

    var minTemperature : Int = 0

    var humidity : Int = 0

    var pressure : Int = 0

    var windSpeed : Int = 0

    var type : WeatherType = WeatherType.CLEAR
}