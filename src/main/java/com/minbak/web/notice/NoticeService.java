package com.minbak.web.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    public void createNotice(NoticeDto noticeDto) {
        noticeDto.setCreatedAt(LocalDateTime.now()); // 현재 시간 설정
        noticeMapper.insertNotice(noticeDto);
    }
    public List<NoticeDto> getNoticeList(){
        return noticeMapper.getNoticeList();
    };
    public NoticeDto getNoticeById(int noticeId) {
        return noticeMapper.getNoticeById(noticeId);
    }

}
