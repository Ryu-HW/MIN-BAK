package com.minbak.web.notice;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    int insertNotice(NoticeDto noticeDto);
    List<NoticeDto> getNoticeList();
    NoticeDto getNoticeById(int noticeId);

}
