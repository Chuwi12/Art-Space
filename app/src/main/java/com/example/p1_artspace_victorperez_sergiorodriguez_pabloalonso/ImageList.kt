package com.example.p1_artspace_victorperez_sergiorodriguez_pabloalonso

class ImageList(val images: List<Image>) {
    fun count(): Int {
        return images.size;
    }

    fun getImage(index: Int): Image? {
        return images[index];
    }
}