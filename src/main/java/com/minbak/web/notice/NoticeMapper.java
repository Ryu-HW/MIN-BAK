package com.minbak.web.notice;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {
    int insertNotice(NoticeDto noticeDto);
    List<NoticeDto> getNoticeList();
    NoticeDto getNoticeById(int noticeId);
    void updateNotice(NoticeDto noticeDto);
    void deleteNotice(@Param("noticeId") int noticeId);

}
