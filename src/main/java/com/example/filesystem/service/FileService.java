package com.example.filesystem.service;

import com.example.filesystem.entity.FileInfo;
import java.util.List;

public interface FileService {
    FileInfo getFileInfo(Long id);
    void saveFile(FileInfo fileInfo);
    List<FileInfo> search(String name);
}
