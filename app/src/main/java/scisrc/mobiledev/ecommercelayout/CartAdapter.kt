package scisrc.mobiledev.ecommercelayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.ui.Item

class CartAdapter(private val cartItems: MutableList<Item>) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    private val selectedItems = mutableListOf<Item>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemCheckbox: CheckBox = itemView.findViewById(R.id.itemCheckbox)
        val itemImageView: ImageView = itemView.findViewById(R.id.itemImageView)
        val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
        val itemPriceTextView: TextView = itemView.findViewById(R.id.itemPriceTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartItem = cartItems[position]
        holder.itemNameTextView.text = cartItem.name
        holder.itemPriceTextView.text = "฿${cartItem.price}"
        holder.itemCheckbox.isChecked = selectedItems.contains(cartItem)

        val imageResId = holder.itemImageView.context.resources.getIdentifier(cartItem.imageResId, "drawable", holder.itemImageView.context.packageName)
        if (imageResId != 0) {
            holder.itemImageView.setImageResource(imageResId)
        }

        holder.itemCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedItems.add(cartItem)
            } else {
                selectedItems.remove(cartItem)
            }
        }
    }

    override fun getItemCount() = cartItems.size

    fun getSelectedItems(): List<Item> {
        return selectedItems
    }
}