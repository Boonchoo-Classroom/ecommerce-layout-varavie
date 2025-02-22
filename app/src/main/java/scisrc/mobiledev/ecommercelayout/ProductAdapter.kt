package scisrc.mobiledev.ecommercelayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.ui.Item

class ProductAdapter(private var products: List<Item>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImageView: ImageView = itemView.findViewById(R.id.product_image)
        val productNameTextView: TextView = itemView.findViewById(R.id.product_name)
        val productPriceTextView: TextView = itemView.findViewById(R.id.product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.productNameTextView.text = product.name
        holder.productPriceTextView.text = "฿${product.price}"

        val imageResId = holder.productImageView.context.resources.getIdentifier(product.imageResId, "drawable", holder.productImageView.context.packageName)
        if (imageResId != 0) {
            holder.productImageView.setImageResource(imageResId)
        }
    }

    override fun getItemCount() = products.size

    fun updateProducts(newProducts: List<Item>) { // เพิ่มฟังก์ชัน updateProducts
        products = newProducts
        notifyDataSetChanged()
    }
}