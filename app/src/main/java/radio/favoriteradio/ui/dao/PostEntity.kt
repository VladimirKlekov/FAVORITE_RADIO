package ru.netology.nmedia.dao

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.netology.nmedia.dto.Post


//аннотацией указали что библиотека Room будет автоматически генерировать из класса
@Entity
data class PostEntity(
//аннотацией указали что id будет генерироваться автоматически
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val radioAvatar: String,
    val content: String,
    val likedByMe: Boolean,

    val likes: Long,
    val share:Long
) {
    companion object {
        fun fromDto(dto: Post) =
            PostEntity(dto.id, dto.author, dto.authorAvatar,  dto.published, dto.content, dto.likedByMe, dto.likes, dto.share, dto.eye)

    }
}