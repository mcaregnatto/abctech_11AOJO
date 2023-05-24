package br.com.fiap.abctechapi.application;

import br.com.fiap.abctechapi.application.dto.AssistResponseDto;
import java.util.List;

public interface AssistanceApplication {
    List<AssistResponseDto> getAssists();
}
