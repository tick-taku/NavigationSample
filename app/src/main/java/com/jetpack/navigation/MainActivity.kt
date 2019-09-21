package com.jetpack.navigation

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.jetpack.navigation.databinding.ActivityMainBinding
import com.jetpack.navigation.util.dataBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by dataBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupToolbar()
    }

    //------------------------------------------------------------------------------------------------------------------
    // MARK: Toolbar
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Toolbar のセットアップ
     */
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)

        // ステータスバーの背景色をアプリのテーマ色に合わせる
        // ステータスバーの色が白だからアイコンを黒で表示
        if (Build.VERSION_CODES.M <= Build.VERSION.SDK_INT) {
            binding.root.apply {
                systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        }
    }

}
