package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import scisrc.mobiledev.ecommercelayout.ProductAdapter
import scisrc.mobiledev.ecommercelayout.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categories = arrayOf("สินค้าทั้งหมด", "เครื่องเขียน", "อุปกรณ์สำนักงาน", "อื่นๆ")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, categories)
        binding.categorySpinner.adapter = adapter // แก้ไข typo

        val allProducts = listOf(
            Item("สมุดปกแข็ง", 20.0, "p1", "เครื่องเขียน"),
            Item("ไม้บรรทัด", 18.0, "p2", "เครื่องเขียน"),
            Item("ลิควิด", 50.0, "p3", "อุปกรณ์สำนักงาน"),
            Item("กบเหลาดินสอ", 15.0, "p4", "เครื่องเขียน"),
            Item("ปากกาแดง", 10.0, "p1", "เครื่องเขียน"),
            Item("แฟ้ม", 30.0, "p2", "อุปกรณ์สำนักงาน"),
            Item("กระดาษ A4", 100.0, "p3", "อุปกรณ์สำนักงาน"),
            Item("อื่นๆ", 5.0, "p4", "อื่นๆ")
        )

        productAdapter = ProductAdapter(allProducts)
        binding.productRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.productRecyclerView.adapter = productAdapter

        binding.categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedCategory = categories[position]
                val filteredProducts = if (selectedCategory == "สินค้าทั้งหมด") {
                    allProducts
                } else {
                    allProducts.filter { it.category == selectedCategory }
                }
                productAdapter.updateProducts(filteredProducts) // แก้ไข unresolved reference
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}