package com.ltc.products.service.TelegramService;

import com.ltc.products.config.TelegramAPI;
import com.ltc.products.dto.telegram.TelegramRootDto;
import com.ltc.products.dto.telegram.sendMessage.TelegramSendingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TelegramService {
    private final TelegramAPI telegramAPI;

    public TelegramRootDto getMessage(){
       return telegramAPI.getMessage();
    }

    public TelegramSendingDto sendMessage(TelegramSendingDto dto){
        return telegramAPI.sendMessage(dto);
    }

}
