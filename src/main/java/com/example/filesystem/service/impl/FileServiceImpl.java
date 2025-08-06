package com.example.filesystem.service.impl;

import com.example.filesystem.entity.FileInfo;
import com.example.filesystem.mapper.FileInfoMapper;
import com.example.filesystem.service.FileService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    private final FileInfoMapper mapper;
    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public FileServiceImpl(FileInfoMapper mapper, StringRedisTemplate redisTemplate) {
        this.mapper = mapper;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public FileInfo getFileInfo(Long id) {
        return mapper.findById(id);
    }

    @Override
    public void saveFile(FileInfo fileInfo) {
        fileInfo.setUploadTime(new Date());
        mapper.insert(fileInfo);
    }

    @Override
    public List<FileInfo> search(String name) {
        String key = "fileSearch::" + name;
        String cache = redisTemplate.opsForValue().get(key);
        try {
            if (cache != null) {
                return objectMapper.readValue(cache, new TypeReference<List<FileInfo>>(){});
            }
        } catch (Exception ignored) {}
        List<FileInfo> list = mapper.searchByName(name);
        try {
            redisTemplate.opsForValue().set(key, objectMapper.writeValueAsString(list), Duration.ofMinutes(5));
        } catch (Exception ignored) {}
        return list;
    }
}
