package com.minbak.web.notice;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/create-notice")
    public String showCreateForm(Model model) {
        model.addAttribute("noticeDto", new NoticeDto());
        return "notice/create-notice";
    }

    @PostMapping("/create-notice")
    public String createNotice(@Valid NoticeDto noticeDto, BindingResult result) {
        if (result.hasErrors()) {
            return "notice/create-notice";
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


}

