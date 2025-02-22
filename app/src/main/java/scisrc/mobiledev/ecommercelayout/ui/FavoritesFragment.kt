package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.FavoriteAdapter
import scisrc.mobiledev.ecommercelayout.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!
    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var favoriteItems: MutableList<Item>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteItems = mutableListOf(
            Item("สมุดปกแข็ง", 20.0, "p1", "เครื่องเขียน"),
            Item("ไม้บรรทัด", 18.0, "p2", "เครื่องเขียน"),
            Item("ปากกาแดง", 10.0, "p1", "เครื่องเขียน")
        )

        favoriteAdapter = FavoriteAdapter(favoriteItems)
        binding.favoritesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.favoritesRecyclerView.adapter = favoriteAdapter

        val sortOptions = arrayOf("เรียงจากราคา: ต่ำไปสูง", "เรียงจากราคา: สูงไปต่ำ")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, sortOptions)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> favoriteItems.sortBy { it.price }
                    1 -> favoriteItems.sortByDescending { it.price }
                }
                favoriteAdapter.notifyDataSetChanged()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}