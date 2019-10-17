package org.com.raian.code.reachmobi.rest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datum {

    @SerializedName("gid")
    @Expose
    var gid: Int = 0
    @SerializedName("seas")
    @Expose
    var seas: Int = 0
    @SerializedName("wk")
    @Expose
    var wk: Int = 0
    @SerializedName("day")
    @Expose
    var day: String? = null
    @SerializedName("v")
    @Expose
    var v: String? = null
    @SerializedName("h")
    @Expose
    var h: String? = null
    @SerializedName("stad")
    @Expose
    var stad: String? = null
    @SerializedName("temp")
    @Expose
    var temp: String? = null
    @SerializedName("humd")
    @Expose
    var humd: String? = null
    @SerializedName("wspd")
    @Expose
    var wspd: String? = null
    @SerializedName("wdir")
    @Expose
    var wdir: String? = null
    @SerializedName("cond")
    @Expose
    var cond: String? = null
    @SerializedName("surf")
    @Expose
    var surf: String? = null
    @SerializedName("ou")
    @Expose
    var ou: String? = null
    @SerializedName("sprv")
    @Expose
    var sprv: String? = null
    @SerializedName("ptsv")
    @Expose
    var ptsv: Int = 0
    @SerializedName("ptsh")
    @Expose
    var ptsh: Int = 0

}
