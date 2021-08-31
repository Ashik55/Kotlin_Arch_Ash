package com.aashiq.kotlin_arch_ash.model

import com.google.gson.annotations.SerializedName

data class CustomersResponse(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("status")
    val status: Int?
) {
    data class Data(
        @SerializedName("customers")
        val customers: Customers?,
        @SerializedName("due")
        val due: Int?,
        @SerializedName("paid")
        val paid: Int?,
        @SerializedName("total")
        val total: Int?
    ) {
        data class Customers(
            @SerializedName("current_page")
            val currentPage: Int?,
            @SerializedName("data")
            val `data`: List<Data?>?,
            @SerializedName("first_page_url")
            val firstPageUrl: String?,
            @SerializedName("from")
            val from: Int?,
            @SerializedName("last_page")
            val lastPage: Int?,
            @SerializedName("last_page_url")
            val lastPageUrl: String?,
            @SerializedName("links")
            val links: List<Link?>?,
            @SerializedName("next_page_url")
            val nextPageUrl: String?,
            @SerializedName("path")
            val path: String?,
            @SerializedName("per_page")
            val perPage: Int?,
            @SerializedName("prev_page_url")
            val prevPageUrl: Any?,
            @SerializedName("to")
            val to: Int?,
            @SerializedName("total")
            val total: Int?
        ) {
            data class Data(
                @SerializedName("address")
                val address: String?,
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("due")
                val due: Int?,
                @SerializedName("email")
                val email: String?,
                @SerializedName("file")
                val `file`: File?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("note")
                val note: String?,
                @SerializedName("paid")
                val paid: Int?,
                @SerializedName("phone")
                val phone: String?,
                @SerializedName("sindabad_id")
                val sindabadId: Any?,
                @SerializedName("store")
                val store: Store?,
                @SerializedName("store_id")
                val storeId: Int?,
                @SerializedName("total")
                val total: Int?,
                @SerializedName("updated_at")
                val updatedAt: String?
            ) {
                data class File(
                    @SerializedName("created_at")
                    val createdAt: String?,
                    @SerializedName("file_name")
                    val fileName: String?,
                    @SerializedName("file_url")
                    val fileUrl: String?,
                    @SerializedName("folder_name")
                    val folderName: String?,
                    @SerializedName("id")
                    val id: Int?,
                    @SerializedName("origin_id")
                    val originId: Int?,
                    @SerializedName("origin_type")
                    val originType: String?,
                    @SerializedName("updated_at")
                    val updatedAt: String?
                )

                data class Store(
                    @SerializedName("address")
                    val address: String?,
                    @SerializedName("created_at")
                    val createdAt: String?,
                    @SerializedName("file_attach")
                    val fileAttach: FileAttach?,
                    @SerializedName("id")
                    val id: Int?,
                    @SerializedName("image")
                    val image: String?,
                    @SerializedName("name")
                    val name: String?,
                    @SerializedName("owner_name")
                    val ownerName: String?,
                    @SerializedName("phone")
                    val phone: String?,
                    @SerializedName("sindabad_id")
                    val sindabadId: Any?,
                    @SerializedName("updated_at")
                    val updatedAt: String?
                ) {
                    data class FileAttach(
                        @SerializedName("created_at")
                        val createdAt: String?,
                        @SerializedName("file_name")
                        val fileName: String?,
                        @SerializedName("file_url")
                        val fileUrl: String?,
                        @SerializedName("folder_name")
                        val folderName: String?,
                        @SerializedName("id")
                        val id: Int?,
                        @SerializedName("origin_id")
                        val originId: Int?,
                        @SerializedName("origin_type")
                        val originType: String?,
                        @SerializedName("updated_at")
                        val updatedAt: String?
                    )
                }
            }

            data class Link(
                @SerializedName("active")
                val active: Boolean?,
                @SerializedName("label")
                val label: String?,
                @SerializedName("url")
                val url: Any?
            )
        }
    }
}