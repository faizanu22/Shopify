package com.example.shopify.utils

import com.example.shopify.ui.data.CommonDataClass

object MasterDataUtils {
    fun getCommonList(): ArrayList<CommonDataClass> {

        val dataset = ArrayList<CommonDataClass>()
        dataset.add(
            CommonDataClass(
                "https://content.jdmagicbox.com/comp/def_content/grocery-stores/shutterstock-518615659-grocery-stores-11-40gyk.jpg",
                "App_logo",
                "1kg , price",
                "$3.99"
            )
        )
        dataset.add(
            (CommonDataClass(
                "https://content.jdmagicbox.com/comp/def_content/grocery-stores/shutterstock-518615659-grocery-stores-11-40gyk.jpg",
                "White logo",
                "1kg , price",
                "$3.99"
            ))
        )
        dataset.add(
            (CommonDataClass(
                "https://content.jdmagicbox.com/comp/def_content/grocery-stores/shutterstock-518615659-grocery-stores-11-40gyk.jpg",
                "Foreground",
                "1kg , price",
                "$3.99"
            ))
        )

        return dataset
    }

    fun getViewPagerImage(): ArrayList<String> {

        val imageList = ArrayList<String>()
        imageList.add("https://content.jdmagicbox.com/comp/def_content/grocery-stores/shutterstock-518615659-grocery-stores-11-40gyk.jpg")
        imageList.add("https://content.jdmagicbox.com/comp/def_content/grocery-stores/shutterstock-518615659-grocery-stores-11-40gyk.jpg")
        imageList.add("https://content.jdmagicbox.com/comp/def_content/grocery-stores/shutterstock-518615659-grocery-stores-11-40gyk.jpg")

        return imageList
    }

}