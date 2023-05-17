package radio.favoriteradio.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import radio.favoriteradio.databinding.ItemNameFavoiuriteRadioBinding
import radio.favoriteradio.ui.dto.Radio
import radio.favoriteradio.ui.viewmodel.RadioViewModel

class FavouriteAdapter (private val context: Context,
private var radioFavoriteList: ArrayList<Radio>
) : RecyclerView.Adapter<FavouriteAdapter.MyHolder>() {

    class MyHolder(binding: ItemNameFavoiuriteRadioBinding) : RecyclerView.ViewHolder(binding.root) {
        val nameRadio = binding.nameRadioTextView
        val image = binding.labelRadioImageView
        val root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteAdapter.MyHolder {

        return MyHolder(ItemNameFavoiuriteRadioBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: FavouriteAdapter.MyHolder, position: Int) {

        holder.nameRadio.text = radioFavoriteList[position].nameRadio
        //подгрузка иконок
        Glide.with(context)
            .load(radioFavoriteList[position].img)
            //.apply (RequestOptions().placeholder(R.drawable.music_player_icon_slash_screen).centerCrop())
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return radioFavoriteList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateMusicList(searchList: ArrayList<Radio>) {
        radioFavoriteList = ArrayList()
        radioFavoriteList.addAll(searchList)
        notifyDataSetChanged()
    }
}