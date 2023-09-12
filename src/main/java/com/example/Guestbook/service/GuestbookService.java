package com.example.Guestbook.service;

import com.example.Guestbook.dto.GuestbookDTO;
import com.example.Guestbook.dto.PageRequestDTO;
import com.example.Guestbook.dto.PageResultDTO;
import com.example.Guestbook.entity.Guestbook;

public interface GuestbookService {

    Long register(GuestbookDTO guestbookDTO);

    PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);

    default Guestbook dtoToEntity(GuestbookDTO guestbookDTO){
        Guestbook entity = Guestbook.builder()
                .gno(guestbookDTO.getGno())
                .title(guestbookDTO.getTitle())
                .content(guestbookDTO.getContent())
                .writer(guestbookDTO.getWriter())
                .build();
        return entity;
    }

    default GuestbookDTO entityToDto(Guestbook entity){
        GuestbookDTO dto = GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .build();

        return dto;
    }
}
