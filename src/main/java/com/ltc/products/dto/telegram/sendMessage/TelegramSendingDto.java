package com.ltc.products.dto.telegram.sendMessage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TelegramSendingDto {
    @JsonProperty("chat_id")
    private Long chatId;
    private String text;
}
