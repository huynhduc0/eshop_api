package com.thduc.eshop.controller

import com.thduc.eshop.utilities.FileUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable

import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.io.File
import java.io.IOException


@RestController
@RequestMapping("media")
class MediaController(
    @Autowired val fileUtil: FileUtil
) {
    @GetMapping("{folder}/{filename}")
    @Throws(IOException::class)
    fun loadFile(
        @PathVariable("folder") folder: String?,
        @PathVariable("filename") filename: String?
    ): ResponseEntity<*>? {
        return fileUtil.loadImage(folder,filename!!)
//        return new ResponseEntity(filename, HttpStatus.OK);
    }
}