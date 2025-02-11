package com.minbak.web.notice;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notice-create")
    public String showCreateForm(Model model) {
        model.addAttribute("noticeDto", new NoticeDto());
        return "notice/notice-create";
    }

    @PostMapping("/notice-create")
    public String createNotice(@Valid NoticeDto noticeDto, BindingResult result) {
        if (result.hasErrors()) {
            return "notice/notice-create";
        }
        noticeService.createNotice(noticeDto);
        return "redirect:/notice/list";
    }

    @GetMapping("/list")
    public String getNoticeList(Model model){
        List<NoticeDto> notices = noticeService.getNoticeList();
        model.addAttribute("notices", notices);
        return "notice/notice-list";
    }
    @GetMapping("/detail/{id}")
    public String getNoticeDetail(@PathVariable("id") int noticeId, Model model) {
        NoticeDto notice = noticeService.getNoticeById(noticeId);
        model.addAttribute("notice", notice);
        return "notice/notice-detail"; // 상세 페이지
    }


    @GetMapping("/update/{noticeId}")
    public String showUpdateForm(@PathVariable Integer noticeId, Model model) {
        NoticeDto noticeDto = noticeService.getNoticeById(noticeId);
        model.addAttribute("noticeDto", noticeDto);
        return "notice/notice-update"; // 파일 경로 확인
    }

    @PostMapping("/update")
    public String updateNotice(@ModelAttribute NoticeDto noticeDto) {
        noticeService.updateNotice(noticeDto);
        return "redirect:/notice/list"; // 수정 후 공지사항 목록 페이지로 이동    }
    }

    @PostMapping("/delete/{id}")
    public String deleteNotice(@PathVariable("id") int noticeId) {
        noticeService.deleteNotice(noticeId);
        return "redirect:/notice/list"; // 삭제 후 목록으로 이동
    }
}

