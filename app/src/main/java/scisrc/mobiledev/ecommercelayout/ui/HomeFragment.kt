package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.ProductAdapter
import scisrc.mobiledev.ecommercelayout.databinding.FragmentHomeBinding
import scisrc.mobiledev.ecommercelayout.ui.Item

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val products = listOf(
            Item("ดินสอกด 2B", 5.0, "p1", "เครื่องเขียน"),
            Item("ปากกาลูกลื่น 0.5 มม.", 10.0, "p2", "เครื่องเขียน"),
            Item("ยางลบ แพ็ค 6 ชิ้น", 20.0, "p3", "เครื่องเขียน"),
            Item("ไส้ดินสอ 2B 0.5 มม.", 35.0, "p4", "เครื่องเขียน")
        )

        // Recommended Item RecyclerView
        val recommendedAdapter = ProductAdapter(products)
        binding.recommendedRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recommendedRecyclerView.adapter = recommendedAdapter

        // Promotion RecyclerView
        val promotionAdapter = ProductAdapter(products)
        binding.promotionRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.promotionRecyclerView.adapter = promotionAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}