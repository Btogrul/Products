package com.ltc.products.controller;

import com.ltc.products.dto.telegram.TelegramRootDto;
import com.ltc.products.dto.telegram.sendMessage.TelegramSendingDto;
import com.ltc.products.service.TelegramService.TelegramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telegram")
@RequiredArgsConstructor
public class TelegramController {
    private final TelegramService telegramService;
    @GetMapping
    public TelegramRootDto getAll(){
        return telegramService.getMessage();
    }
    @PostMapping
    public TelegramSendingDto sendMessage(@RequestBody TelegramSendingDto dto){
        return telegramService.sendMessage(dto);
    }
}
