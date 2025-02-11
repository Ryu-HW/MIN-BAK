package com.minbak.web.notice;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NoticeDto {
    private Integer noticeId; // 공지사항 ID
    private Integer userId; // 작성자 ID
    private String title; // 공지사항 제목
    private String content; // 공지사항 내용
    private LocalDateTime createdAt; // 생성 시간
}
