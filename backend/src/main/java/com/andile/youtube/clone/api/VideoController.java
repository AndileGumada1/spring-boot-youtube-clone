package com.andile.youtube.clone.api;

import com.andile.youtube.clone.api.dto.UploadVideoResponse;
import com.andile.youtube.clone.api.dto.VideoDto;
import com.andile.youtube.clone.api.service.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

    /**
     * @param file
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UploadVideoResponse uploadVideo(@RequestParam("file") MultipartFile file) {
        log.info("Uploading a file: {}",file);
        return videoService.uploadVideo(file);
    }

    @PostMapping("/thumbnail")
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadThumbnail(@RequestParam("file") MultipartFile file, @RequestParam("videoId") String videoId) {
        log.info("Uploading a thumbnail: {}",file);
        return videoService.uploadThumbnail(file,videoId);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public VideoDto editMetadata(@RequestBody VideoDto videoDto){
        log.info("Request for editing the file:{}",videoDto);
        return videoService.editVideo(videoDto);
    }
    @GetMapping("/{videoId}")
    @ResponseStatus(HttpStatus.OK)
    public VideoDto getVideoDetails(@PathVariable String videoId){
        return videoService.getVideoDetails(videoId);
    }
}
