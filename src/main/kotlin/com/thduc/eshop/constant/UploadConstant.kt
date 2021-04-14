package com.thduc.eshop.constant

import org.springframework.stereotype.Component


@Component
object UploadConstant {
//    const val UPLOAD_PATH =  "~/eshop/src/main/resources/static/uploads/"
 val UPLOAD_PATH =  System.getProperty("user.dir")+ "/src/main/resources/static/uploads/"
}
