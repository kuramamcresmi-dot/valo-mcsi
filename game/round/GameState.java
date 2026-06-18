package com.kuramamc.valorant.game.round;

public enum GameState {
    WAITING,      // Lobbide oyuncu bekleniyor
    STARTING,     // Geri sayım başladı (Ajan seçimi / Satın alma evresi)
    IN_GAME,      // Tur başladı, bariyerler kalktı, çatışma aktif
    ROUND_END,    // Tur bitti (Spike patladı/çözüldü veya bir takım elendi)
    GAME_END      // Maç bitti (Bir takım 13 tura ulaştı), lobiye dönüş
}
