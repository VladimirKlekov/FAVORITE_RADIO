package radio.favoriteradio.ui.repository

import radio.favoriteradio.ui.dto.Radio


interface RadioRepository {

    val listRadio: ArrayList<Radio>
    val listFavoriteRadio: ArrayList<Radio>

    fun listRadio()
    fun addListFavouriteRadio()
    fun getRadioById(id:Int): Radio

}