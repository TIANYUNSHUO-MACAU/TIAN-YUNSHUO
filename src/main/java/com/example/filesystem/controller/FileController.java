package com.example.filesystem.controller;

import com.example.filesystem.entity.FileInfo;
import com.example.filesystem.service.FileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/{id}")
    public FileInfo get(@PathVariable Long id) {
        return fileService.getFileInfo(id);
    }

    @PostMapping
    public String upload(@RequestBody FileInfo fileInfo) {
        fileService.saveFile(fileInfo);
        return "ok";
    }

    @GetMapping("/search")
    public List<FileInfo> search(@RequestParam String name) {
        return fileService.search(name);
    }
}
