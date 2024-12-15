package com.example.navigationview1

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.navigationview1.adapters.ViewPagerAdapter
import com.example.navigationview1.databinding.ActivityMainBinding
import com.example.navigationview1.utils.ImageModel
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        val drawerLayout1 = binding.drawerLayout
        val navigationView = binding.navView
        val viewPager3 = binding.viewPager

        // NavigationView orqali ViewPager sahifasini boshqarish
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> viewPager3.currentItem = 0
                R.id.popular -> viewPager3.currentItem = 1
                R.id.random -> viewPager3.currentItem = 2
                R.id.like -> viewPager3.currentItem = 3
            }
            drawerLayout1.closeDrawers() // DrawerLayoutni yopish
            true
        }

        // ViewPager va BottomNavigationViewni bog'lash
        val viewPager1 = binding.viewPager
        val bottomNavigationView = binding.btnNav

        // BottomNavigationView orqali ViewPager sahifasini boshqarish
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> viewPager1.currentItem = 0
                R.id.nav_popular -> viewPager1.currentItem = 1
                R.id.nav_random -> viewPager1.currentItem = 2
                R.id.nav_favorites -> viewPager1.currentItem = 3
            }
            true
        }

        // ViewPager orqali BottomNavigationViewni yangilash
        viewPager1.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
            }
        })

        // DrawerLayout va ImageView-ni bog'lash
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val menuImageView: ImageView = findViewById(R.id.img_xml)

// ImageView bosilganda NavigationView ochiladi
        menuImageView.setOnClickListener {
            toggleDrawer(drawerLayout)
        }


        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        // Har bir sahifa uchun yozuvlar
        val pageTitles = listOf("All", "New", "Animals", "Texnology")
        // Har bir sahifa uchun rasmlar ro'yxati
        val pages = listOf(
            listOf(
                ImageModel(R.drawable.img_1),
                ImageModel(R.drawable.img_2),
                ImageModel(R.drawable.img_3),
                ImageModel(R.drawable.img_4),
                ImageModel(R.drawable.img_5),
                ImageModel(R.drawable.img_6),
                ImageModel(R.drawable.img_7),
                ImageModel(R.drawable.img_8),
                ImageModel(R.drawable.img_9),
                ImageModel(R.drawable.img_10),
                ImageModel(R.drawable.img_11),
                ImageModel(R.drawable.img_12),
                ImageModel(R.drawable.img_13),
                ImageModel(R.drawable.img_14),
                ImageModel(R.drawable.img_15),
                ImageModel(R.drawable.img_16),
                ImageModel(R.drawable.img_17),
                ImageModel(R.drawable.img_18),
                ImageModel(R.drawable.img_19),
                ImageModel(R.drawable.img_20)
            ),
            listOf(
                ImageModel(R.drawable.img_6),
                ImageModel(R.drawable.img_7),
                ImageModel(R.drawable.img_8),
                ImageModel(R.drawable.img_9),
                ImageModel(R.drawable.img_10),
                ImageModel(R.drawable.img_1),
                ImageModel(R.drawable.img_2),
                ImageModel(R.drawable.img_3),
                ImageModel(R.drawable.img_4),
                ImageModel(R.drawable.img_5),
                ImageModel(R.drawable.img_16),
                ImageModel(R.drawable.img_17),
                ImageModel(R.drawable.img_18),
                ImageModel(R.drawable.img_19),
                ImageModel(R.drawable.img_20),
                ImageModel(R.drawable.img_11),
                ImageModel(R.drawable.img_12),
                ImageModel(R.drawable.img_13),
                ImageModel(R.drawable.img_14),
                ImageModel(R.drawable.img_15)
            ),
            listOf(
                ImageModel(R.drawable.img_11),
                ImageModel(R.drawable.img_12),
                ImageModel(R.drawable.img_13),
                ImageModel(R.drawable.img_14),
                ImageModel(R.drawable.img_15),
                ImageModel(R.drawable.img_16),
                ImageModel(R.drawable.img_17),
                ImageModel(R.drawable.img_18),
                ImageModel(R.drawable.img_19),
                ImageModel(R.drawable.img_20),
                ImageModel(R.drawable.img_1),
                ImageModel(R.drawable.img_2),
                ImageModel(R.drawable.img_3),
                ImageModel(R.drawable.img_4),
                ImageModel(R.drawable.img_5),
                ImageModel(R.drawable.img_6),
                ImageModel(R.drawable.img_7),
                ImageModel(R.drawable.img_8),
                ImageModel(R.drawable.img_9),
                ImageModel(R.drawable.img_10)
            ),
            listOf(
                ImageModel(R.drawable.img_16),
                ImageModel(R.drawable.img_17),
                ImageModel(R.drawable.img_18),
                ImageModel(R.drawable.img_19),
                ImageModel(R.drawable.img_20),
                ImageModel(R.drawable.img_1),
                ImageModel(R.drawable.img_2),
                ImageModel(R.drawable.img_3),
                ImageModel(R.drawable.img_4),
                ImageModel(R.drawable.img_5),
                ImageModel(R.drawable.img_6),
                ImageModel(R.drawable.img_7),
                ImageModel(R.drawable.img_8),
                ImageModel(R.drawable.img_9),
                ImageModel(R.drawable.img_10),
                ImageModel(R.drawable.img_11),
                ImageModel(R.drawable.img_12),
                ImageModel(R.drawable.img_13),
                ImageModel(R.drawable.img_14),
                ImageModel(R.drawable.img_15)
            )
        )
        // ViewPagerAdapter
        val adapter = ViewPagerAdapter(pages) { imageResId ->
            showImage(imageResId)
        }
        viewPager.adapter = adapter

        // TabLayout va ViewPager2 ni bog'lash
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.customView = createCustomTab(pageTitles[position], position == 0)
        }.attach()

        // Tanlangan tabni boshqarish
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                updateTab(tab, true) // Tanlangan tabni oq rangda va indikator bilan sozlash
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                updateTab(tab, false) // Tanlanmagan tabni xira rangda sozlash
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Qo‘shimcha o‘zgarishlar kiritilishi mumkin
            }
        })
    }

    fun toggleDrawer(drawerLayout: DrawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START) // Agar ochiq bo'lsa, yopiladi
        } else {
            drawerLayout.openDrawer(GravityCompat.START) // Agar yopiq bo'lsa, ochiladi
        }
    }

    private fun createCustomTab(text: String, isSelected: Boolean): View {
        val view = LayoutInflater.from(this).inflate(R.layout.custom_tab, null)
        val tabTextView = view.findViewById<TextView>(R.id.tabTextView)
        val indicator = view.findViewById<View>(R.id.indicator)

        tabTextView.text = text
        tabTextView.setTextColor(if (isSelected) Color.WHITE else Color.GRAY)
        indicator.visibility = if (isSelected) View.VISIBLE else View.INVISIBLE

        return view
    }

    private fun updateTab(tab: TabLayout.Tab, isSelected: Boolean) {
        val customView = tab.customView ?: return
        val tabTextView = customView.findViewById<TextView>(R.id.tabTextView)
        val indicator = customView.findViewById<View>(R.id.indicator)

        tabTextView.setTextColor(if (isSelected) Color.WHITE else Color.GRAY)
        indicator.visibility = if (isSelected) View.VISIBLE else View.INVISIBLE
    }

    private fun showImage(imageResId: Int) {
        val dialog = Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        dialog.setContentView(R.layout.dialog_image)

        val imageView: ImageView = dialog.findViewById(R.id.dialogImageView)
        imageView.setImageResource(imageResId)

        imageView.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}