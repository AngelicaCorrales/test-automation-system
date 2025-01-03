package com.endava.training.gui.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UIMessage {
    private String mainMessage;
    private String secondaryMessage;
}
