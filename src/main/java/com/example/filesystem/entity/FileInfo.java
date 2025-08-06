package com.example.filesystem.entity;

import java.util.Date;

public class FileInfo {
    private Long id;
    private String fileName;
    private String filePath;
    private Long fileSize;
    private Date uploadTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    public Long getFileSize() { return fileSize; }
    public void setFileSize(Long fileSize) { this.fileSize = fileSize; }

    public Date getUploadTime() { return uploadTime; }
    public void setUploadTime(Date uploadTime) { this.uploadTime = uploadTime; }
}
