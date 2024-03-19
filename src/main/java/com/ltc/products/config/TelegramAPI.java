package com.ltc.products.config;

import com.ltc.products.dto.telegram.TelegramRootDto;
import com.ltc.products.dto.telegram.sendMessage.TelegramSendingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "telegramClient", url = "https://api.telegram.org/bot6608116078:AAGEEYnvAVZnYCakznp_i_hPBY_fPJjKvAc")
public interface TelegramAPI {

    @GetMapping("/getUpdates")
    TelegramRootDto getMessage();


    @PostMapping("/sendMessage")
    TelegramSendingDto sendMessage(@RequestBody TelegramSendingDto dto);
}
