package com.depromeet.coquality.inner.rank.port.driving;

public interface RankUseCase {
    void achieveEditor(Long userId);
    void achieveSpecialEditor(Long userId);
    void achieveProfessionalEditor(Long userId);
}
