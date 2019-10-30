package org.com.raian.code.reachmobi.utility

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.text.TextUtils
import org.com.raian.code.reachmobi.application.CustomApp
import java.util.logging.Logger

private const val TAG = "Util"
private val logger: Logger = Logger.getLogger(TAG)

//TODO: Improve this gotta be less lines of code
fun getDrawableByName(name: String): Drawable {
    val drawableIdentifier =
        CustomApp.instance.resources.getIdentifier(name, "drawable", CustomApp.instance.packageName)
    try {
        val drawable = CustomApp.instance.getDrawable(drawableIdentifier)
        if (drawable == null) {
            throw Resources.NotFoundException("Resource not found")
        } else {
            return drawable
        }
    } catch (nfe: Resources.NotFoundException) {
        logger.severe("$TAG::getDrawableByName::${nfe.message}")
        throw Resources.NotFoundException("Resource not found")
    }
}

fun <T1 : Any, T2 : Any, R : Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}

fun <T1 : Any, T2 : Any, T3: Any, R : Any> safeLet(p1: T1?, p2: T2?, p3: T3?, block: (T1, T2, T3) -> R?): R? {
    return if (p1 != null && p2 != null && p3 != null) block(p1, p2, p3) else null
}

fun isNullOrEmpty(string: CharSequence?): Boolean {
    return string == null || string.isEmpty()
}

fun isNullOrBlank(text: CharSequence?): Boolean {
    return text == null || TextUtils.getTrimmedLength(text) <= 0
}