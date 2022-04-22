package com.andile.youtube.clone.api.dto;

import com.andile.youtube.clone.model.VideoStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDto {
    private String id;
    private String title;
    private String description;
    private String userId;
    private AtomicInteger likes = new AtomicInteger(0);
    private AtomicInteger disLikes = new AtomicInteger(0);
    private List<String> tags;
    private String videoUrl;
    private VideoStatus videoStatus;
    private AtomicInteger viewCount = new AtomicInteger(0);
    private String thumbnailUrl;
}
