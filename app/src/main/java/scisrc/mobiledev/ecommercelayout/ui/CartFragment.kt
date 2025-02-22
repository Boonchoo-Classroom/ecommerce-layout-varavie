package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.CartAdapter
import scisrc.mobiledev.ecommercelayout.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cartItems = mutableListOf(
            Item("สมุดปกแข็ง", 20.0, "p1","เครื่องเขียน"),
            Item("ไม้บรรทัด", 18.0, "p2", "เครื่องเขียน"),
            Item("ลิควิด", 50.0, "p3","อุปกรณ์สำนักงาน"),
            Item("กบเหลาดินสอ", 15.0, "p4", "เครื่องเขียน"),
            Item("ปากกาแดง", 10.0, "p1", "เครื่องเขียน")
        )

        cartAdapter = CartAdapter(cartItems)
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.cartRecyclerView.adapter = cartAdapter

        binding.checkoutButton.setOnClickListener {
            val selectedItems = cartAdapter.getSelectedItems()
            if (selectedItems.isNotEmpty()) {
                val itemNames = selectedItems.joinToString(", ") { it.name }
                Toast.makeText(context, "Selected items: $itemNames", Toast.LENGTH_SHORT).show()
                // เพิ่มโค้ดสำหรับชำระเงิน
            } else {
                Toast.makeText(context, "Please select items to checkout", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}