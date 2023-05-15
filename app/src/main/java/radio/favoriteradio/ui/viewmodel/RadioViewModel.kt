package radio.favoriteradio.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import radio.favoriteradio.ui.dto.Radio
import radio.favoriteradio.ui.repository.RadioRepository
import radio.favoriteradio.ui.repository.RadioRepositoryImpl


class RadioViewModel() : ViewModel() {
    private val radioRepository: RadioRepository = RadioRepositoryImpl()
    val radioOpenEvent = MutableSharedFlow<Radio>()

    val dataRadio: ArrayList<Radio>
        get() = radioRepository.listRadio

    fun listRadio() {
        radioRepository.listRadio()
    }

    fun addListFavoriteRadio(radio: Radio){
        radioRepository.addListFavouriteRadio(radio)
    }

    fun onCard(radio: Radio) {
        viewModelScope.launch {
            try {
                radioOpenEvent.emit(radio)
                radio.id?.let {
                    radioRepository.getRadioById(it) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}

