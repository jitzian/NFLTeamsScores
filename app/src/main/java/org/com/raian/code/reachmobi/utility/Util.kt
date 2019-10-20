package org.com.raian.code.reachmobi.utility

import android.content.res.Resources
import android.graphics.drawable.Drawable
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