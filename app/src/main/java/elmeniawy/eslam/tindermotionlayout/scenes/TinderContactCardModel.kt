package elmeniawy.eslam.tindermotionlayout.scenes

import androidx.annotation.ColorInt

/**
 * TinderContactCardModel
 *
 * Created by Eslam El-Meniawy on 24-Jun-2020 3:03 PM.
 * Roqay
 */
data class TinderContactCardModel(
    val name: String,
    val age: Int,
    val description: String,
    @ColorInt val backgroundColor: Int
)