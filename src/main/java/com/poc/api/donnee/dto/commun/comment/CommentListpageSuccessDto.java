package com.poc.api.donnee.dto.commun.comment;

import java.util.List;

import com.poc.api.donnee.dto.commun.CommunErrorDTO;
import com.poc.api.donnee.dto.data.comment.CommentDTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CommentListpageSuccessDto extends CommunErrorDTO {
	
	private long totalitems ;
    private long items ;
    private int currentPage ;
    private int totalPage;
    private List<CommentDTO> data;
    private String code;
    private String message;
    private String success;
    
    public CommentListpageSuccessDto(long items,long totalitems, int currentPage, int totalPage,List<CommentDTO> vehiculeDTOS, String code, String message, String success) {
        this.setCode(code);
        this.setSuccess(success);
        this.setMessage(message);
        this.setData(vehiculeDTOS);
        this.setCurrentPage(currentPage);
        this.setTotalPage(totalPage);
        this.setTotalitems(totalitems);
        this.setItems(items);
    }
    
    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

}
