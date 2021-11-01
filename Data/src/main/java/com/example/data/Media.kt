package com.example.data

data class Media(
    val caption: String,
    val comments_count: String,
    val id: String,
    val ig_id: String,
    val is_comment_enabled:String,
    val like_count:String,
    val media_product_type:String,
    val media_type:String,
    val media_url:String,
    val owner:String,
    val permalink:String,
    val shortcode:String,
    val thumbnail_url:String,
    val timestamp:String,
    val username:String,
    val video_title:String,
    val comments:List<IGComment>,
    val insights:IGMediaInsights,

    )
