package com.example.p1_artspace_victorperez_sergiorodriguez_pabloalonso

class ImageList(val images: List<Art>) {
    fun count(): Int {
        return images.size;
    }

    fun getImage(index: Int): Art? {
        return images[index];
    }
}