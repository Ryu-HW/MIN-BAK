package com.minbak.web.notice;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {
    int insertNotice(NoticeDto noticeDto);

    NoticeDto getNoticeById(int noticeId);
    void updateNotice(NoticeDto noticeDto);
    void deleteNotice(@Param("noticeId") int noticeId);


    // 공지사항 목록 조회 (페이징 적용)
    List<NoticeDto> getNoticeList(@Param("limit") int limit, @Param("offset") int offset);
    // 전체 공지사항 개수 조회 (총 페이지 계산용)
    int getNoticeCount();
}
