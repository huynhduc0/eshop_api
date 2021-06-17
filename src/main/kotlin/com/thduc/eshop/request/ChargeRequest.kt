package com.thduc.eshop.request

class ChargeRequest(
     val description: String? = null,
     val amount: Int? = 0,
//     val currency: Currency? = null,
     val stripeEmail: String? = null,
     val stripeToken: String? = null
) {

}