package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import scisrc.mobiledev.ecommercelayout.ProductAdapter
import scisrc.mobiledev.ecommercelayout.databinding.FragmentProductBinding

class ProductListFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val products = listOf(
            Item("Product 1", 100.0, "https://via.placeholder.com/150"),
            Item("Product 2", 200.0, "https://via.placeholder.com/150"),
            Item("Product 3", 300.0, "https://via.placeholder.com/150"),
        )

        val productAdapter = ProductAdapter(products)
        binding.productRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.productRecyclerView.adapter = productAdapter
    }
}