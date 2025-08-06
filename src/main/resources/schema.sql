CREATE TABLE file_info (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  file_name VARCHAR(200),
  file_path VARCHAR(300),
  file_size BIGINT,
  upload_time TIMESTAMP
);
