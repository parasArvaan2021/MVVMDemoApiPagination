package com.app.mvvmdemowithapi.respone.main


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class PaginationResponse(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("message")
    val message: String?, // get feed data lsit
    @SerializedName("status_code")
    val statusCode: Int? // 200
) {
    @Keep
    data class Data(
        @SerializedName("current_page")
        val currentPage: Int?, // 1
        @SerializedName("data")
        val `data`: List<Data?>?,
        @SerializedName("first_page_url")
        val firstPageUrl: String?, // http://3.128.24.219/embie_testing/public/api/user-feed-bookmark-pagination?page=1
        @SerializedName("from")
        val from: Int?, // 1
        @SerializedName("last_page")
        val lastPage: Int?, // 1
        @SerializedName("last_page_url")
        val lastPageUrl: String?, // http://3.128.24.219/embie_testing/public/api/user-feed-bookmark-pagination?page=1
        @SerializedName("next_page_url")
        val nextPageUrl: Any?, // null
        @SerializedName("path")
        val path: String?, // http://3.128.24.219/embie_testing/public/api/user-feed-bookmark-pagination
        @SerializedName("per_page")
        val perPage: Int?, // 25
        @SerializedName("prev_page_url")
        val prevPageUrl: Any?, // null
        @SerializedName("to")
        val to: Int?, // 13
        @SerializedName("total")
        val total: Int? // 13
    ) {
        @Keep
        data class Data(
            @SerializedName("bookmark")
            val bookmark: String?, // exists
            @SerializedName("bookmarks")
            val bookmarks: String?, // 290
            @SerializedName("comment_count")
            val commentCount: String?, // 0
            @SerializedName("created_at")
            val createdAt: String?, // 36 Day
            @SerializedName("des")
            val des: String?, // ky
            @SerializedName("feed_image")
            val feedImage: String?, // d80eb738a2e5b6a4d912ab1abcfbfa0f1635925536616.jpg
            @SerializedName("feed_image_id")
            val feedImageId: String?, // d80eb738a2e5b6a4d912ab1abcfbfa0f1635925536616.jpg
            @SerializedName("feed_image_url")
            val feedImageUrl: String?, // https://embieapp.s3.us-east-2.amazonaws.com/UserFeedImage/d80eb738a2e5b6a4d912ab1abcfbfa0f1635925536616.jpg?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIA2VDIUPIUPDECSP5A%2F20211209%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20211209T100127Z&X-Amz-SignedHeaders=host&X-Amz-Expires=86400&X-Amz-Signature=9afd0d41fd083ad491d521391c17e3ee8359ff8323f3ffa6c7b4723f69be4cde
            @SerializedName("has_access")
            val hasAccess: String?, // YES
            @SerializedName("id")
            val id: Int?, // 494
            @SerializedName("is_block")
            val isBlock: String?, // 0
            @SerializedName("is_delete")
            val isDelete: String?, // 0
            @SerializedName("is_report")
            val isReport: String?, // 0
            @SerializedName("profile_image")
            val profileImage: String?, // 81baa88e0dc2e269979f8c0792583f4f1636374436463.jpg
            @SerializedName("profile_image_url")
            val profileImageUrl: String?, // https://embieapp.s3.us-east-2.amazonaws.com/UserProfile/81baa88e0dc2e269979f8c0792583f4f1636374436463.jpg?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIA2VDIUPIUPDECSP5A%2F20211209%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20211209T100127Z&X-Amz-SignedHeaders=host&X-Amz-Expires=86400&X-Amz-Signature=640adb85f83ae93ae057178578eb0602535037a32f3baf22f76093329ffb1a93
            @SerializedName("timediff")
            val timediff: String?, // 36 Day
            @SerializedName("title")
            val title: String?, // kv
            @SerializedName("totalcomment")
            val totalcomment: String?, // 0
            @SerializedName("updated_at")
            val updatedAt: String?, // 2021-11-03 07:45:36
            @SerializedName("user_id")
            val userId: String?, // 290
            @SerializedName("username")
            val username: String? // a21
        )
    }
}