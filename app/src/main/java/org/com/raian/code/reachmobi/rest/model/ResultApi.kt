package org.com.raian.code.reachmobi.rest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultApi {

    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

}
