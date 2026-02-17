package com.learn.compose.basics.home

class PlaceData {
    fun getPlaceDetails(): List<PlaceDetailsModel> {
        return listOf(
            PlaceDetailsModel(
                name = "Mount Everest",
                altitude = 8848.86,
                description = "The highest peak in the world, located in the Himalayas.",
                cityName = "Kathmandu"
            ),
            PlaceDetailsModel(
                name = "Eiffel Tower",
                altitude = 330.0,
                description = "Iconic iron lattice tower located on the Champ de Mars in Paris.",
                cityName = "Paris"
            ),
            PlaceDetailsModel(
                name = "Statue of Liberty",
                altitude = 93.0,
                description = "A neoclassical sculpture on Liberty Island in New York Harbor.",
                cityName = "New York"
            ),
            PlaceDetailsModel(
                name = "Great Wall of China",
                altitude = 1015.0,
                description = "Ancient fortification system built along the historical northern borders of China.",
                cityName = "Beijing"
            ),
            PlaceDetailsModel(
                name = "Machu Picchu",
                altitude = 2430.0,
                description = "15th-century Inca citadel located in the Eastern Cordillera of southern Peru.",
                cityName = "Cusco"
            ),
            PlaceDetailsModel(
                name = "Taj Mahal",
                altitude = 171.0,
                description = "Ivory-white marble mausoleum on the right bank of the Yamuna river.",
                cityName = "Agra"
            ),
            PlaceDetailsModel(
                name = "Grand Canyon",
                altitude = 2134.0,
                description = "Steep-sided canyon carved by the Colorado River in Arizona.",
                cityName = "Flagstaff"
            ),
            PlaceDetailsModel(
                name = "Sagrada Familia",
                altitude = 170.0,
                description = "Large unfinished Roman Catholic minor basilica designed by Antoni Gaudí.",
                cityName = "Barcelona"
            )
        )
    }
}


