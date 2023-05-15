package radio.favoriteradio.ui.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import radio.favoriteradio.R
import radio.favoriteradio.databinding.FragmentFavouriteBinding
import radio.favoriteradio.ui.adapter.FavouriteAdapter
import radio.favoriteradio.ui.dto.Radio

class FavouriteRadio: Fragment(R.layout.fragment_favourite) {

    private lateinit var binding: FragmentFavouriteBinding
    private lateinit var favouriteAdapter: FavouriteAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouriteBinding.bind(view)

        val radio1 = Radio(1,"Русское радио",R.drawable.rusradio_icon)
        val radioList = ArrayList<Radio>()
        radioList.add(radio1)

        binding.favouriteRV.setHasFixedSize(true)
        binding.favouriteRV.setItemViewCacheSize(13)
        binding.favouriteRV.layoutManager = LinearLayoutManager(requireContext())
        favouriteAdapter = FavouriteAdapter(requireContext(),radioList)
        binding.favouriteRV.adapter = favouriteAdapter





    }
}