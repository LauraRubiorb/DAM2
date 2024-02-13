package com.example.laura_rubio_damii.ui.model

class Post(
    var body: String ? = null,
    var id: Int ? = null,
    var reactions: Int ? = null,
    var tags: ArrayList<String?> ? = null,
    var title: String ? = null,
    var userId: Int ? = null
) {
}