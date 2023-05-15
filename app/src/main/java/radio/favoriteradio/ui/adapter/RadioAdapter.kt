package radio.favoriteradio.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import radio.favoriteradio.R
import radio.favoriteradio.databinding.ItemNameRadioBinding
import radio.favoriteradio.ui.dto.Radio
import radio.favoriteradio.ui.ui.MainFragment



class RadioAdapter(
    private val context: Context,
    private var radioList: ArrayList<Radio>
) : RecyclerView.Adapter<RadioAdapter.MyHolder>() {


    class MyHolder(binding: ItemNameRadioBinding) : RecyclerView.ViewHolder(binding.root) {
        val nameRadio = binding.nameRadioTextView
        val image = binding.labelRadioImageView
        val root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioAdapter.MyHolder {

        return MyHolder(ItemNameRadioBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: RadioAdapter.MyHolder, position: Int) {

        holder.nameRadio.text = radioList[position].nameRadio
        //подгрузка иконок
        Glide.with(context)
            .load(radioList[position].img)
            //.apply (RequestOptions().placeholder(R.drawable.music_player_icon_slash_screen).centerCrop())
            .into(holder.image)
        holder.root.setOnClickListener {
            sendIntent(ref = "PlayRadio", pos = position)

        }
    }



    override fun getItemCount(): Int {
        return radioList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateMusicList(searchList: ArrayList<Radio>) {
        radioList = ArrayList()
        radioList.addAll(searchList)
        notifyDataSetChanged()
    }
    private fun sendIntent(ref : String, pos: Int){
        val intent = Intent(context, MainFragment::class.java)
        //для class PlayerActivity
        intent.putExtra("index", pos)
        intent.putExtra("class",ref)
        //________
        ContextCompat.startActivity(context, intent, null)
    }
}