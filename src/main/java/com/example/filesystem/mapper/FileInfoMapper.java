package com.example.filesystem.mapper;

import com.example.filesystem.entity.FileInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface FileInfoMapper {
    @Insert("insert into file_info(file_name,file_path,file_size,upload_time) values(#{fileName},#{filePath},#{fileSize},#{uploadTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(FileInfo fileInfo);

    @Select("select * from file_info where id = #{id}")
    FileInfo findById(Long id);

    @Select("select * from file_info where file_name like concat('%',#{name},'%')")
    List<FileInfo> searchByName(String name);
}
