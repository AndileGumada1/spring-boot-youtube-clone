package com.andile.youtube.clone.api.service;

import com.andile.youtube.clone.api.dto.UploadVideoResponse;
import com.andile.youtube.clone.api.dto.VideoDto;
import com.andile.youtube.clone.model.Video;
import com.andile.youtube.clone.model.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final S3Service s3Service;
    private final VideoRepository videoRepository;

    /**
     * @param multipartFile
     * @return
     */
    public UploadVideoResponse uploadVideo(MultipartFile multipartFile) {
        String videoUrl = s3Service.uploadFile(multipartFile);
        var video = new Video();
        video.setUrl(videoUrl);
        var savedVideo = videoRepository.save(video);
        return new UploadVideoResponse(savedVideo.getId(), savedVideo.getUrl());
    }

    public VideoDto editVideo(VideoDto videoDto) {
        //find the video by id
        var saveVideo = getVideoById(videoDto.getId());
        //map videoDto fields to video
        saveVideo.setTitle(videoDto.getTitle());
        saveVideo.setDescription(videoDto.getDescription());
        saveVideo.setTags(videoDto.getTags());
        saveVideo.setThumbnailUrl(videoDto.getThumbnailUrl());
        saveVideo.setVideoStatus(videoDto.getVideoStatus());

        //save the video to mongodb
        videoRepository.save(saveVideo);
        return videoDto;
    }

    public String uploadThumbnail(MultipartFile file, String videoId) {
        var saveVideo = getVideoById(videoId);

        String thumbnailUrl = s3Service.uploadFile(file);
        saveVideo.setThumbnailUrl(thumbnailUrl);

        videoRepository.save(saveVideo);
        return thumbnailUrl;
    }
    public Video getVideoById(String videoId){
        return videoRepository.findById(videoId)
                .orElseThrow(() -> new IllegalArgumentException("Could not find Video with id:"+ videoId));
    }

    public VideoDto getVideoDetails(String videoId) {
        var saveVideo = getVideoById(videoId);

        VideoDto videoDto = new VideoDto();

        videoDto.setVideoUrl(saveVideo.getUrl());
        videoDto.setThumbnailUrl(saveVideo.getThumbnailUrl());
        videoDto.setId(saveVideo.getId());
        videoDto.setTitle(videoDto.getTitle());
        videoDto.setDescription(saveVideo.getDescription());
        videoDto.setTags(saveVideo.getTags());
        videoDto.setVideoStatus(saveVideo.getVideoStatus());
        return videoDto;
    }
}
