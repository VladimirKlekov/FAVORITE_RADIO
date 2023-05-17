package radio.favoriteradio.ui.dto


data class Radio(
    val id: Int,
    val nameRadio: String,
    val img: Int,
    var isFavourite: Boolean = false
    //val artUri: String// Glide загрузка изображений иконки
)




