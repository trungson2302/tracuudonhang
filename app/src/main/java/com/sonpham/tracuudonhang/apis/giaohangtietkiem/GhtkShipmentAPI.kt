package com.sonpham.tracuudonhang.apis.giaohangtietkiem

import com.sonpham.tracuudonhang.apis.BaseShipmentAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers


abstract interface GhtkShipmentAPI : BaseShipmentAPI {
    override fun getBaseUrl(): String {
        return "https://dev.ghtk.vn"
    }
    @Headers("Token: ee1a4BBcFa4301C4a7ae9956015E5bcc74419683")
    @GET("/services/shipment/v2/{shipmentID}")
    fun _getShipment(shipmentID: String): Call<String>

    fun getShipment(shipmentID: String) =
        (builder.create(GhtkShipmentAPI::class.java) as GhtkShipmentAPI)._getShipment(shipmentID)
}