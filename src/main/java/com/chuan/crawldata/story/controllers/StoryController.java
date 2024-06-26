package com.chuan.crawldata.story.controllers;

import com.chuan.crawldata.story.crawl.JsoupCrawler;
import com.chuan.crawldata.story.models.requests.StoryLoadRequest;
import com.chuan.crawldata.story.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping("/story")
    public String story(){
        return "story/story";
    }

    @PostMapping("/story-load")
    public ResponseEntity<?> storyLoad(@RequestBody StoryLoadRequest request) {
        return storyService.loadStory(request);
    }

    @GetMapping("/chapter")
    public String chapter(@RequestParam(name = "name", defaultValue = "vu than chua te") String name,
                                     @RequestParam(name = "chapter", defaultValue = "1") int chapter){
        return storyService.getChapter(name, chapter);
    }
}
